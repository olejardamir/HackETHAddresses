import java.io.ByteArrayOutputStream;


class Hex
{
    private static final Encoder encoder = new HexEncoder();





    
    public static byte[] encode(
            byte[]    data) throws Exception {
        return encode(data, data.length);
    }

    
    private static byte[] encode(
            byte[] data,
            int length) throws Exception {
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();


            encoder.encode(data, 0, length, bOut);


        return bOut.toByteArray();
    }

    
    public static byte[] decode(
            String    data) throws Exception {
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();


            encoder.decode(data, bOut);


        return bOut.toByteArray();
    }

}
