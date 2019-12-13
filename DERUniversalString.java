
import java.io.ByteArrayOutputStream;
import java.io.IOException;


/**
 * DER UniversalString object - encodes UNICODE (ISO 10646) characters using 32-bit format. In Java we
 * have no way of representing this directly so we rely on byte arrays to carry these.
 */
public class DERUniversalString
        extends ASN1Primitive
        implements ASN1String
{
    private static final char[]  table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    private final byte[] string;

    /**
     * Basic constructor - byte encoded string.
     *
     * @param string the byte encoding of the string to be carried in the UniversalString object,
     */
    public DERUniversalString(
            byte[]   string)
    {
        this.string = Arrays.clone(string);
    }

    private String getString()
    {
        StringBuilder buf = new StringBuilder("#");
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();
        ASN1OutputStream            aOut = new ASN1OutputStream(bOut);

        try
        {
            aOut.writeObject(this);
        }
        catch (IOException e)
        {
         //   throw new ASN1ParsingException("internal error encoding UniversalString");
        }

        byte[]    string = bOut.toByteArray();

        for (int i = 0; i != string.length; i++)
        {
            buf.append(table[(string[i] >>> 4) & 0xf]);
            buf.append(table[string[i] & 0xf]);
        }

        return buf.toString();
    }

    public String toString()
    {
        return getString();
    }

    private byte[] getOctets()
    {
        return Arrays.clone(string);
    }

    int encodedLength()
    {
        return 1 + StreamUtil.calculateBodyLength(string.length) + string.length;
    }

    void encode(
            ASN1OutputStream out)
            throws IOException
    {
        out.writeEncoded(BERTags.UNIVERSAL_STRING, this.getOctets());
    }

    boolean asn1Equals(
            ASN1Primitive o)
    {
        if (!(o instanceof DERUniversalString))
        {
            return false;
        }

        return Arrays.areEqual(string, ((DERUniversalString)o).string);
    }

    public int hashCode()
    {
        return Arrays.hashCode(string);
    }
}
