
import java.io.IOException;


/**
 * DER T61String (also the teletex string), try not to use this if you don't need to. The standard support the encoding for
 * this has been withdrawn.
 */
public class DERT61String
        extends ASN1Primitive
        implements ASN1String
{
    private final byte[] string;

    /**
     * Basic constructor - string encoded as a sequence of bytes.
     *
     * @param string the byte encoding of the string to be wrapped.
     */
    public DERT61String(
            byte[]   string)
    {
        this.string = Arrays.clone(string);
    }

    /**
     * Decode the encoded string and return it, 8 bit encoding assumed.
     * @return the decoded String
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

    void encode(
            ASN1OutputStream out)
            throws IOException
    {
        out.writeEncoded(BERTags.T61_STRING, string);
    }

    boolean asn1Equals(
            ASN1Primitive o)
    {
        if (!(o instanceof DERT61String))
        {
            return false;
        }

        return Arrays.areEqual(string, ((DERT61String)o).string);
    }

    public int hashCode()
    {
        return Arrays.hashCode(string);
    }
}
