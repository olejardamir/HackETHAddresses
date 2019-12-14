import java.util.Enumeration;
import java.util.Vector;


public abstract class ASN1Sequence
        extends ASN1Primitive

{
    Vector seq = new Vector();

    /**
     * Create an empty SEQUENCE
     */
    ASN1Sequence()
    {
    }

    /**
     * Create a SEQUENCE containing a vector of objects.
     * @param v the vector of objects to be put in the SEQUENCE.
     */
    ASN1Sequence(
            ASN1EncodableVector v)
    {
        for (int i = 0; i != v.size(); i++)
        {
            seq.addElement(v.get(i));
        }
    }

    Enumeration getObjects()
    {
        return seq.elements();
    }

    /**
     * Return the object at the sequence position indicated by index.
     *
     * @param index the sequence number (starting at zero) of the object
     * @return the object at the sequence position indicated by index.
     */
    private ASN1Encodable getObjectAt(
            int index)
    {
        return (ASN1Encodable)seq.elementAt(index);
    }

    /**
     * Return the number of objects in this sequence.
     *
     * @return the number of objects in this sequence.
     */
    private int size()
    {
        return seq.size();
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

    boolean asn1Equals(
            ASN1Primitive o)
    {
        if (!(o instanceof ASN1Sequence))
        {
            return false;
        }

        ASN1Sequence   other = (ASN1Sequence)o;

        if (this.size() != other.size())
        {
            return false;
        }

        Enumeration s1 = this.getObjects();
        Enumeration s2 = other.getObjects();

        while (s1.hasMoreElements())
        {
            ASN1Encodable obj1 = getNext(s1);
            ASN1Encodable obj2 = getNext(s2);

            ASN1Primitive o1 = obj1.toASN1Primitive();
            ASN1Primitive o2 = obj2.toASN1Primitive();

            if (o1 == o2 || o1.equals(o2))
            {
                continue;
            }

            return false;
        }

        return true;
    }

    private ASN1Encodable getNext(Enumeration e)
    {

        return (ASN1Encodable)e.nextElement();
    }

    /**
     * Change current SEQUENCE object to be encoded as {@link DERSequence}.
     * This is part of Distinguished Encoding Rules form serialization.
     */
    ASN1Primitive toDERObject()
    {
        ASN1Sequence derSeq = new DERSequence();

        derSeq.seq = this.seq;

        return derSeq;
    }

    /**
     * Change current SEQUENCE object to be encoded as {@link DLSequence}.
     * This is part of Direct Length form serialization.
     */
    ASN1Primitive toDLObject()
    {
        ASN1Sequence dlSeq = new DLSequence();

        dlSeq.seq = this.seq;

        return dlSeq;
    }

    abstract void encode(ASN1OutputStream out)
            throws Exception;

    public String toString()
    {
        return seq.toString();
    }

}
