import java.io.IOException;

/**
 * DER UTF8String object.
 */
public class DERUTF8String
        extends ASN1Primitive
        implements ASN1String
{
    private final byte[]  string;

    /*
     * Basic constructor - byte encoded string.
     */
    DERUTF8String(byte[] string)
    {
        this.string = string;
    }


//    public DERUTF8String(String string)
//    {
//        this.string = Strings.toUTF8ByteArray(string);
//    }

// public String getString()
//    {
//        return Strings.fromUTF8ByteArray(string);
//    }

    public String toString()
    {
        return getString();
    }

    public int hashCode()
    {
        return Arrays.hashCode(string);
    }

    boolean asn1Equals(ASN1Primitive o)
    {
        if (!(o instanceof DERUTF8String))
        {
            return false;
        }

        DERUTF8String s = (DERUTF8String)o;

        return Arrays.areEqual(string, s.string);
    }

    int encodedLength() {
        return 1 + StreamUtil.calculateBodyLength(string.length) + string.length;
    }

    void encode(ASN1OutputStream out)
            throws IOException
    {
        out.writeEncoded(BERTags.UTF8_STRING, string);
    }

    private String getString() {
        return null;
    }
}
