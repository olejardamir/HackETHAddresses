
import java.io.IOException;

/**
 * A Definite length BIT STRING
 */
class DLBitString
        extends ASN1BitString
{

    /**
     * @param data the octets making up the bit string.
     * @param padBits the number of extra bits at the end of the string.
     */
    public DLBitString(
            byte[]  data,
            int     padBits)
    {
        super(data, padBits);
    }

    int encodedLength()
    {
        return 1 + StreamUtil.calculateBodyLength(data.length + 1) + data.length + 1;
    }

    void encode(
            ASN1OutputStream out)
            throws Exception
    {
        byte[] string = data;
        byte[] bytes = new byte[string.length + 1];

        bytes[0] = (byte)getPadBits();
        System.arraycopy(string, 0, bytes, 1, bytes.length - 1);

        out.writeEncoded(ASN1InputStream.BIT_STRING, bytes);
    }

}
