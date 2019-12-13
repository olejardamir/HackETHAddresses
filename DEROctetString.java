
import java.io.IOException;

/**
 * Carrier class for a DER encoding OCTET STRING
 */
public class DEROctetString
        extends ASN1OctetString
{
    /**
     * Base constructor.
     *
     * @param string the octets making up the octet string.
     */
    public DEROctetString(
            byte[]  string)
    {
        super(string);
    }

    boolean isConstructed()
    {
        return false;
    }

    int encodedLength()
    {
        return 1 + StreamUtil.calculateBodyLength(string.length) + string.length;
    }

    void encode(
            ASN1OutputStream out)
            throws IOException
    {
        out.writeEncoded(BERTags.OCTET_STRING, string);
    }

}
