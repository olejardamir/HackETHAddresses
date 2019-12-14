
import java.io.IOException;

/**
 * An ASN.1 DER NULL object.
 * <p>
 * Preferably use the constant:  DERNull.INSTANCE.
 */
public class DERNull
        extends ASN1Null
{
    public static final DERNull INSTANCE = new DERNull();

    private static final byte[]  zeroBytes = new byte[0];

    /**
     * @deprecated use DERNull.INSTANCE
     */
    public DERNull()
    {
    }

    int encodedLength()
    {
        return 2;
    }

    void encode(
            ASN1OutputStream out)
            throws Exception
    {
        out.writeEncoded(ASN1InputStream.NULL, zeroBytes);
    }
}
