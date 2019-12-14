
import java.io.IOException;

/**
 * A BIT STRING with DER encoding - the first byte contains the count of padding bits included in the byte array's last byte.
 */
class DERBitString
        extends ASN1BitString
{

    /**
     * @param data the octets making up the bit string.
     * @param padBits the number of extra bits at the end of the string.
     */
    public DERBitString(
            byte[]  data,
            int     padBits)
    {
        super(data, padBits);
    }

    public DERBitString(
            byte[]  data)
    {
        this(data, 0);
    }

    int encodedLength()
    {
        return 1 + StreamUtil.calculateBodyLength(data.length + 1) + data.length + 1;
    }

    void encode(
            ASN1OutputStream out)
            throws IOException
    {
        byte[] string = derForm(data, padBits);
        byte[] bytes = new byte[string.length + 1];

        bytes[0] = (byte)getPadBits();
        System.arraycopy(string, 0, bytes, 1, bytes.length - 1);

        out.writeEncoded(ASN1InputStream.BIT_STRING, bytes);
    }

}
