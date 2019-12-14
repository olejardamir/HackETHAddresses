public class DERNull extends ASN1Null {
    final public static DERNull INSTANCE;
    final private static byte[] zeroBytes;
    
    public DERNull() {
    }
    
    int encodedLength() {
        return 2;
    }
    
    void encode(ASN1OutputStream a) {
        a.writeEncoded(5, zeroBytes);
    }
    
    static {
        INSTANCE = new DERNull();
        zeroBytes = new byte[0];
    }
}
