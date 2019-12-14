import java.util.Enumeration;
import java.util.Vector;


public abstract class ASN1Sequence
        extends ASN1Primitive

{
    Vector seq = new Vector();

    
    ASN1Sequence()
    {
    }

    
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

    
    ASN1Primitive toDERObject()
    {
        ASN1Sequence derSeq = new DERSequence();

        derSeq.seq = this.seq;

        return derSeq;
    }



    abstract void encode(ASN1OutputStream out)
            throws Exception;

    public String toString()
    {
        return seq.toString();
    }

}
