import java.util.Enumeration;
import java.util.Vector;


public abstract class ASN1Sequence
        extends ASN1Primitive

{
    Vector seq = new Vector();



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


    private ASN1Object getNext(Enumeration e)
    {

        return (ASN1Object)e.nextElement();
    }





    public String toString()
    {
        return seq.toString();
    }

}
