import java.io.IOException;

/**
 * DER VisibleString object encoding ISO 646 (ASCII) character code points 32 to 126.
 * <p>
 * Explicit character set escape sequences are not allowed.
 * </p>
 */
public class DERVisibleString
        extends ASN1Primitive
        implements ASN1String
{
    private final byte[]  string;

    /*
     * Basic constructor - byte encoded string.
     */
    DERVisibleString(
            byte[]   string)
    {
        this.string = string;
    }

    private String getString()
    {
        return Strings.fromByteArray(string);
    }

    public String toString()
    {
        return getString();
    }

    int encodedLength()
    {
        return 1 + StreamUtil.calculateBodyLength(string.length) + string.length;
    }

    void encode(
            ASN1OutputStream out)
            throws IOException
    {
        out.writeEncoded(BERTags.VISIBLE_STRING, this.string);
    }

    boolean asn1Equals(
            ASN1Primitive o)
    {
        if (!(o instanceof DERVisibleString))
        {
            return false;
        }

        return Arrays.areEqual(string, ((DERVisibleString)o).string);
    }

    public int hashCode()
    {
        return Arrays.hashCode(string);
    }
}
