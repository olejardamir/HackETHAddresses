
import java.io.IOException;


public class DERNumericString
        extends ASN1Primitive
        implements ASN1String
{
    private final byte[]  string;

    /**
     * Basic constructor - with bytes.
     */
    DERNumericString(
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
        out.writeEncoded(BERTags.NUMERIC_STRING, string);
    }

    public int hashCode()
    {
        return Arrays.hashCode(string);
    }

    boolean asn1Equals(
            ASN1Primitive o)
    {
        if (!(o instanceof DERNumericString))
        {
            return false;
        }

        DERNumericString  s = (DERNumericString)o;

        return Arrays.areEqual(string, s.string);
    }

    /**
     * Return true if the string can be represented as a NumericString ('0'..'9', ' ')
     *
     * @param str string to validate.
     * @return true if numeric, fale otherwise.
     */
    private static boolean isNumericString(
            String str)
    {
        for (int i = str.length() - 1; i >= 0; i--)
        {
            char    ch = str.charAt(i);

            if (ch > 0x007f)
            {
                return false;
            }

            if (('0' <= ch && ch <= '9') || ch == ' ')
            {
                continue;
            }

            return false;
        }

        return true;
    }
}
