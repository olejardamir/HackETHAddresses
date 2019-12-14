class Hex {
    final private static Encoder encoder;
    
    Hex() {
    }
    
    public static String toHexString(byte[] a) {
        return Hex.toHexString(a, a.length);
    }
    
    private static String toHexString(byte[] a, int i) {
        return Strings.fromByteArray(Hex.encode(a, i));
    }
    
    public static byte[] encode(byte[] a) {
        return Hex.encode(a, a.length);
    }
    
    private static byte[] encode(byte[] a, int i) {
        java.io.ByteArrayOutputStream a0 = new java.io.ByteArrayOutputStream();
        encoder.encode(a, 0, i, (java.io.OutputStream)a0);
        return a0.toByteArray();
    }
    
    public static byte[] decode(String s) {
        java.io.ByteArrayOutputStream a = new java.io.ByteArrayOutputStream();
        encoder.decode(s, (java.io.OutputStream)a);
        return a.toByteArray();
    }
    
    static {
        encoder = (Encoder)(Object)new HexEncoder();
    }
}
