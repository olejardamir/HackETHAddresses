
import java.util.Vector;


class ASN1EncodableVector
{
    private final Vector<ASN1Encodable> v = new Vector<ASN1Encodable>();

    
    public ASN1EncodableVector()
    {
    }

    
    public void add(ASN1Encodable obj)
    {
        v.addElement(obj);
    }

    
    public ASN1Encodable get(int i)
    {
        return v.elementAt(i);
    }

    
    public int size()
    {
        return v.size();
    }
}
