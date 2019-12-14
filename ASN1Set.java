import java.util.Enumeration;
import java.util.Vector;


public abstract class ASN1Set
        extends ASN1Primitive

{
    private Vector set = new Vector();

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

    }

    Enumeration getObjects()
    {
        return set.elements();
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

    public String toString()
    {
        return set.toString();
    }

}
