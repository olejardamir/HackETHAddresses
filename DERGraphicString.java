import java.io.IOException;

public class DERGraphicString
        extends ASN1Primitive
        implements ASN1String
{
    private final byte[] string;

    /**
     * basic constructor - with bytes.
     * @param string the byte encoding of the characters making up the string.
     */
    public DERGraphicString(
            byte[]   string)
    {
        this.string = Arrays.clone(string);
    }

    int encodedLength()
    {
        return 1 + StreamUtil.calculateBodyLength(string.length) + string.length;
    }

    void encode(
            ASN1OutputStream out)
            throws IOException
    {
        out.writeEncoded(BERTags.GRAPHIC_STRING, string);
    }

    public int hashCode()
    {
        return Arrays.hashCode(string);
    }

    boolean asn1Equals(
            ASN1Primitive o)
    {
        if (!(o instanceof DERGraphicString))
        {
            return false;
        }

        DERGraphicString  s = (DERGraphicString)o;

        return Arrays.areEqual(string, s.string);
    }

}
