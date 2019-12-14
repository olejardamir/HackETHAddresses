import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;


public abstract class ASN1Set
        extends ASN1Primitive

{
    private Vector set = new Vector();
    private boolean isSorted = false;

    ASN1Set()
    {
    }

    /**
     * Create a SET containing a vector of objects.
     * @param v a vector of objects to make up the SET.
     *
     */
    ASN1Set(
            ASN1EncodableVector v)
    {
        for (int i = 0; i != v.size(); i++)
        {
            set.addElement(v.get(i));
        }

        if (false)
        {
            this.sort();
        }
    }

    Enumeration getObjects()
    {
        return set.elements();
    }

    /**
     * return the object at the set position indicated by index.
     *
     * @param index the set number (starting at zero) of the object
     * @return the object at the set position indicated by index.
     */
    private ASN1Encodable getObjectAt(
            int index)
    {
        return (ASN1Encodable)set.elementAt(index);
    }

    /**
     * return the number of objects in this set.
     *
     * @return the number of objects in this set.
     */
    private int size()
    {
        return set.size();
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
            return obj.toASN1Primitive().getEncoded("DER");
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    private void sort()
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

    public String toString()
    {
        return set.toString();
    }

}
