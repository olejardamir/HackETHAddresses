import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Utility class for converting hex data to bytes and back again.
 */
class Hex
{
    private static final Encoder encoder = new HexEncoder();

    public static String toHexString(
            byte[] data) throws IOException {
        return toHexString(data, data.length);
    }

    private static String toHexString(
            byte[] data,
            int length) throws IOException {
        byte[] encoded = encode(data, length);
        return  Strings.fromByteArray(encoded);
    }

    /**
     * encode the input data producing a Hex encoded byte array.
     *
     * @return a byte array containing the Hex encoded data.
     */
    public static byte[] encode(
            byte[]    data) throws IOException {
        return encode(data, data.length);
    }

    /**
     * encode the input data producing a Hex encoded byte array.
     *
     * @return a byte array containing the Hex encoded data.
     */
    private static byte[] encode(
            byte[] data,
            int length) throws IOException {
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();


            encoder.encode(data, 0, length, bOut);


        return bOut.toByteArray();
    }

    /**
     * decode the Hex encoded String data - whitespace will be ignored.
     *
     * @return a byte array representing the decoded data.
     */
    public static byte[] decode(
            String    data) throws IOException {
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();


            encoder.decode(data, bOut);


        return bOut.toByteArray();
    }

}
