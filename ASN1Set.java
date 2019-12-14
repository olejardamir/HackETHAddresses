import java.util.Enumeration;
import java.util.Vector;


public abstract class ASN1Set
        extends ASN1Primitive

{
    private Vector set = new Vector();

    ASN1Set()
    {
    }


    Enumeration getObjects()
    {
        return set.elements();
    }

    
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

    
    ASN1Primitive toDLObject()
    {
        ASN1Set derSet = new DLSet();

        derSet.set = this.set;

        return derSet;
    }

    private ASN1Encodable getNext(Enumeration e)
    {
        ASN1Encodable encObj = (ASN1Encodable)e.nextElement();

        
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
