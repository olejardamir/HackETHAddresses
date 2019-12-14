
import java.io.IOException;


public class DERPrintableString
        extends ASN1Primitive {
    private final byte[]  string;


    /**
     * Basic constructor - byte encoded string.
     */
    DERPrintableString(
            byte[]   string)
    {
        this.string = string;
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
        out.writeEncoded(ASN1InputStream.PRINTABLE_STRING, string);
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

}
