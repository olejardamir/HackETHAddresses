
import java.io.IOException;


public class DERPrintableString
        extends ASN1Primitive
        implements ASN1String
{
    private final byte[]  string;


    /**
     * Basic constructor - byte encoded string.
     */
    DERPrintableString(
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
     * contains characters that should not be in a PrintableString.
     */
    private DERPrintableString(
            String string,
            boolean validate)
    {
        if (validate && !isPrintableString(string))
        {
            throw new IllegalArgumentException("string contains illegal characters");
        }

        this.string = Strings.toByteArray(string);
    }

    private String getString()
    {
        return Strings.fromByteArray(string);
    }

    int encodedLength()
    {
        return 1 + StreamUtil.calculateBodyLength(string.length) + string.length;
    }

    void encode(
            ASN1OutputStream out)
            throws IOException
    {
        out.writeEncoded(BERTags.PRINTABLE_STRING, string);
    }

    public int hashCode()
    {
        return Arrays.hashCode(string);
    }

    boolean asn1Equals(
            ASN1Primitive o)
    {
        if (!(o instanceof DERPrintableString))
        {
            return false;
        }

        DERPrintableString  s = (DERPrintableString)o;

        return Arrays.areEqual(string, s.string);
    }

    public String toString()
    {
        return getString();
    }

    /**
     * return true if the passed in String can be represented without
     * loss as a PrintableString, false otherwise.
     *
     * @return true if in printable set, false otherwise.
     */
    private static boolean isPrintableString(
            String str)
    {
        for (int i = str.length() - 1; i >= 0; i--)
        {
            char    ch = str.charAt(i);

            if (ch > 0x007f)
            {
                return false;
            }

            if ('a' <= ch && ch <= 'z')
            {
                continue;
            }

            if ('A' <= ch && ch <= 'Z')
            {
                continue;
            }

            if ('0' <= ch && ch <= '9')
            {
                continue;
            }

            switch (ch)
            {
                case ' ':
                case '\'':
                case '(':
                case ')':
                case '+':
                case '-':
                case '.':
                case ':':
                case '=':
                case '?':
                case '/':
                case ',':
                    continue;
            }

            return false;
        }

        return true;
    }
}
