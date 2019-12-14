
import java.io.OutputStream;

/**
 * Stream that outputs encoding based on distinguished encoding rules.
 */
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

    ASN1OutputStream getDLSubStream()
    {
        return this;
    }
}
