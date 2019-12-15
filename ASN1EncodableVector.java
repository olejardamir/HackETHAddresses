
import java.util.Vector;


class ASN1EncodableVector
{
    private final Vector<ASN1Object> v = new Vector<>();

    
    public ASN1EncodableVector()
    {
    }

    
    public void add(ASN1Object obj)
    {
        v.addElement(obj);
    }

    
    public ASN1Object get(int i)
    {
        return v.elementAt(i);
    }

    
    public int size()
    {
        return v.size();
    }
}
