
import java.io.IOException;


/**
 * DER IA5String object - this is a ISO 646 (ASCII) string encoding code points 0 to 127.
 * <p>
 * Explicit character set escape sequences are not allowed.
 * </p>
 */
public class DERIA5String
        extends ASN1Primitive
        implements ASN1String
{
    private final byte[]  string;

    /**
     * Basic constructor - with bytes.
     * @param string the byte encoding of the characters making up the string.
     */
    DERIA5String(
            byte[]   string)
    {
        this.string = string;
    }

    /**
     * Constructor with optional validation.
     *
     * @param string the base string to wrap.
     * @param validate whether or not to check the string.
     * @throws IllegalArgumentException if validate is true and the string
     * contains characters that should not be in an IA5String.
     */
    private DERIA5String(
            String string,
            boolean validate)
    {
        if (string == null)
        {
            throw new NullPointerException("string cannot be null");
        }
        if (validate && !isIA5String(string))
        {
            throw new IllegalArgumentException("string contains illegal characters");
        }

        this.string = Strings.toByteArray(string);
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
        out.writeEncoded(BERTags.IA5_STRING, string);
    }

    public int hashCode()
    {
        return Arrays.hashCode(string);
    }

    boolean asn1Equals(
            ASN1Primitive o)
    {
        if (!(o instanceof DERIA5String))
        {
            return false;
        }

        DERIA5String  s = (DERIA5String)o;

        return Arrays.areEqual(string, s.string);
    }

    /**
     * return true if the passed in String can be represented without
     * loss as an IA5String, false otherwise.
     *
     * @param str the string to check.
     * @return true if character set in IA5String set, false otherwise.
     */
    private static boolean isIA5String(
            String str)
    {
        for (int i = str.length() - 1; i >= 0; i--)
        {
            char    ch = str.charAt(i);

            if (ch > 0x007f)
            {
                return false;
            }
        }

        return true;
    }
}
