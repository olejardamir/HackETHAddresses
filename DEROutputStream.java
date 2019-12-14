
import java.io.OutputStream;


public class DEROutputStream
        extends ASN1OutputStream
{
    public DEROutputStream(
            OutputStream    os)
    {
        super(os);
    }

    public void writeObject(
            ASN1Encodable obj)
            throws Exception
    {

            obj.toASN1Primitive().toDERObject().encode(this);


    }

    ASN1OutputStream getDERSubStream()
    {
        return this;
    }

}
