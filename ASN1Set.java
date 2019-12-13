import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;


public abstract class ASN1Set
        extends ASN1Primitive
        implements  Iterable<ASN1Encodable>
{
    private Vector set = new Vector();
    private boolean isSorted = false;

    /**
     * Return an ASN1 set from a tagged object. There is a special
     * case here, if an object appears to have been explicitly tagged on
     * reading but we were expecting it to be implicitly tagged in the
     * normal course of events it indicates that we lost the surrounding
     * set - so we need to add it back (this will happen if the tagged
     * object is a sequence that contains other sequences). If you are
     * dealing with implicitly tagged sets you really <b>should</b>
     * be using this method.
     *
     * @param obj the tagged object.
     * @param explicit true if the object is meant to be explicitly tagged
     *          false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *          be converted.
     * @return an ASN1Set instance.
     */
    public static ASN1Set getInstance(
            ASN1TaggedObject    obj,
            boolean             explicit)
    {
        if (explicit)
        {
            if (!obj.isExplicit())
            {
                throw new IllegalArgumentException("object implicit - explicit expected.");
            }

            return (ASN1Set)obj.getObject();
        }
        else
        {
            ASN1Primitive o = obj.getObject();

            //
            // constructed object which appears to be explicitly tagged
            // and it's really implicit means we have to add the
            // surrounding set.
            //
            if (obj.isExplicit())
            {
                if (obj instanceof BERTaggedObject)
                {
                    return new BERSet(o);
                }
                else
                {
                    return new DLSet(o);
                }
            }
            else
            {
                if (o instanceof ASN1Set)
                {
                    return (ASN1Set)o;
                }

                //
                // in this case the parser returns a sequence, convert it
                // into a set.
                //
                if (o instanceof ASN1Sequence)
                {
                    ASN1Sequence s = (ASN1Sequence)o;

                    if (obj instanceof BERTaggedObject)
                    {
                        return new BERSet(s.toArray());
                    }
                    else
                    {
                        return new DLSet(s.toArray());
                    }
                }
            }
        }

        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    protected ASN1Set()
    {
    }

    /**
     * Create a SET containing one object
     * @param obj object to be added to the SET.
     */
    protected ASN1Set(
            ASN1Encodable obj)
    {
        set.addElement(obj);
    }

    /**
     * Create a SET containing a vector of objects.
     * @param v a vector of objects to make up the SET.
     * @param doSort true if should be sorted DER style, false otherwise.
     */
    protected ASN1Set(
            ASN1EncodableVector v,
            boolean                  doSort)
    {
        for (int i = 0; i != v.size(); i++)
        {
            set.addElement(v.get(i));
        }

        if (doSort)
        {
            this.sort();
        }
    }

    /**
     * Create a SET containing an array of objects.
     * @param array an array of objects to make up the SET.
     * @param doSort true if should be sorted DER style, false otherwise.
     */
    protected ASN1Set(
            ASN1Encodable[]   array,
            boolean doSort)
    {
        for (int i = 0; i != array.length; i++)
        {
            set.addElement(array[i]);
        }

        if (doSort)
        {
            this.sort();
        }
    }

    public Enumeration getObjects()
    {
        return set.elements();
    }

    /**
     * return the object at the set position indicated by index.
     *
     * @param index the set number (starting at zero) of the object
     * @return the object at the set position indicated by index.
     */
    public ASN1Encodable getObjectAt(
            int index)
    {
        return (ASN1Encodable)set.elementAt(index);
    }

    /**
     * return the number of objects in this set.
     *
     * @return the number of objects in this set.
     */
    public int size()
    {
        return set.size();
    }

    public ASN1Encodable[] toArray()
    {
        ASN1Encodable[] values = new ASN1Encodable[this.size()];

        for (int i = 0; i != this.size(); i++)
        {
            values[i] = this.getObjectAt(i);
        }

        return values;
    }

    public ASN1SetParser parser()
    {
        final ASN1Set outer = this;

        return new ASN1SetParser()
        {
            private final int max = size();

            private int index;

            public ASN1Encodable readObject() {
                if (index == max)
                {
                    return null;
                }

                ASN1Encodable obj = getObjectAt(index++);
                if (obj instanceof ASN1Sequence)
                {
                    return ((ASN1Sequence)obj).parser();
                }
                if (obj instanceof ASN1Set)
                {
                    return ((ASN1Set)obj).parser();
                }

                return obj;
            }

            public ASN1Primitive getLoadedObject()
            {
                return outer;
            }

            public ASN1Primitive toASN1Primitive()
            {
                return outer;
            }
        };
    }

    public int hashCode()
    {
        Enumeration             e = this.getObjects();
        int                     hashCode = size();

        while (e.hasMoreElements())
        {
            Object o = getNext(e);
            hashCode *= 17;

            hashCode ^= o.hashCode();
        }

        return hashCode;
    }

    /**
     * Change current SET object to be encoded as {@link DLSet}.
     * This is part of Direct Length form serialization.
     */
    ASN1Primitive toDLObject()
    {
        ASN1Set derSet = new DLSet();

        derSet.set = this.set;

        return derSet;
    }

    private ASN1Encodable getNext(Enumeration e)
    {
        ASN1Encodable encObj = (ASN1Encodable)e.nextElement();

        // unfortunately null was allowed as a substitute for DER null
        if (encObj == null)
        {
            return DERNull.INSTANCE;
        }

        return encObj;
    }

    /**
     * return true if a <= b (arrays are assumed padded with zeros).
     */
    private boolean lessThanOrEqual(
            byte[] a,
            byte[] b)
    {
        int len = Math.min(a.length, b.length);
        for (int i = 0; i != len; ++i)
        {
            if (a[i] != b[i])
            {
                return (a[i] & 0xff) < (b[i] & 0xff);
            }
        }
        return len == a.length;
    }

    private byte[] getDEREncoded(
            ASN1Encodable obj)
    {
        try
        {
            return obj.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    protected void sort()
    {
        if (!isSorted)
        {
            isSorted = true;
            if (set.size() > 1)
            {
                boolean    swapped = true;
                int        lastSwap = set.size() - 1;

                while (swapped)
                {
                    int    index = 0;
                    int    swapIndex = 0;
                    byte[] a = getDEREncoded((ASN1Encodable)set.elementAt(0));

                    swapped = false;

                    while (index != lastSwap)
                    {
                        byte[] b = getDEREncoded((ASN1Encodable)set.elementAt(index + 1));

                        if (lessThanOrEqual(a, b))
                        {
                            a = b;
                        }
                        else
                        {
                            Object  o = set.elementAt(index);

                            set.setElementAt(set.elementAt(index + 1), index);
                            set.setElementAt(o, index + 1);

                            swapped = true;
                            swapIndex = index;
                        }

                        index++;
                    }

                    lastSwap = swapIndex;
                }
            }
        }
    }

    boolean isConstructed()
    {
        return true;
    }

    abstract void encode(ASN1OutputStream out)
            throws IOException;

    public String toString()
    {
        return set.toString();
    }

    public Iterator<ASN1Encodable> iterator()
    {
        return new Arrays.Iterator<ASN1Encodable>(toArray());
    }
}
