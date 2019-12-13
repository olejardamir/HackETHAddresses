import java.io.IOException;

public class DERVideotexString
        extends ASN1Primitive
        implements ASN1String
{
    private final byte[] string;

    /**
     * basic constructor - with bytes.
     * @param string the byte encoding of the characters making up the string.
     */
    public DERVideotexString(
            byte[]   string)
    {
        this.string = Arrays.clone(string);
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
        out.writeEncoded(BERTags.VIDEOTEX_STRING, string);
    }

    public int hashCode()
    {
        return Arrays.hashCode(string);
    }

    boolean asn1Equals(
            ASN1Primitive o)
    {
        if (!(o instanceof DERVideotexString))
        {
            return false;
        }

        DERVideotexString  s = (DERVideotexString)o;

        return Arrays.areEqual(string, s.string);
    }

    public String getString()
    {
        return Strings.fromByteArray(string);
    }
}
