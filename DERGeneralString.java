
import java.io.IOException;



/**
 * ASN.1 GENERAL-STRING data type.
 * <p>
 * This is an 8-bit encoded ISO 646 (ASCII) character set
 * with optional escapes to other character sets.
 * </p>
 */
public class DERGeneralString
        extends ASN1Primitive
        implements ASN1String
{
    private final byte[] string;

    DERGeneralString(byte[] string)
    {
        this.string = string;
    }

    /**
     * Return a Java String representation of our contained String.
     *
     * @return a Java String representing our contents.
     */
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

    void encode(ASN1OutputStream out)
            throws IOException
    {
        out.writeEncoded(BERTags.GENERAL_STRING, string);
    }

    public int hashCode()
    {
        return Arrays.hashCode(string);
    }

    boolean asn1Equals(ASN1Primitive o)
    {
        if (!(o instanceof DERGeneralString))
        {
            return false;
        }
        DERGeneralString s = (DERGeneralString)o;

        return Arrays.areEqual(string, s.string);
    }
}
