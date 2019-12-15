import java.io.ByteArrayOutputStream;


class Hex
{
    private static final Encoder encoder = new HexEncoder();




    
    public static byte[] decode(
            String    data) throws Exception {
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();


            encoder.decode(data, bOut);


        return bOut.toByteArray();
    }

}
