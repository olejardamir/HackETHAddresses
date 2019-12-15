import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

// 
// Decompiled by Procyon v0.5.36
// 

class Hex
{
    private static final HexEncoder encoder;
    
    public static byte[] decode(final String data) throws Exception {
        final ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        Hex.encoder.decode(data, bOut);
        return bOut.toByteArray();
    }
    
    static {
        encoder = new HexEncoder();
    }
}
