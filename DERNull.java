
public class DERNull
        extends ASN1Primitive {
    public static final DERNull INSTANCE = new DERNull();

    private static final byte[]  zeroBytes = new byte[0];

    
    public DERNull()
    {

    }

    int encodedLength()
    {
        return 2;
    }

    void encode(
            ASN1OutputStream out)
            throws Exception
    {
        out.writeEncoded(ASN1InputStream.NULL, zeroBytes);
    }

    public int hashCode()
    {
        return -1;
    }

    boolean asn1Equals(
            ASN1Primitive o)
    {
        return o instanceof DERNull;
    }

    public String toString()
    {
        return "NULL";
    }
}
