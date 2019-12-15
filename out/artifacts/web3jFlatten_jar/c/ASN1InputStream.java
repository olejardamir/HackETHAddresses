class ASN1InputStream extends java.io.FilterInputStream {
    final public static int INTEGER = 2;
    final public static int BIT_STRING = 3;
    final public static int OCTET_STRING = 4;
    final public static int OBJECT_IDENTIFIER = 6;
    final public static int SEQUENCE = 16;
    final public static int CONSTRUCTED = 32;
    
    protected ASN1InputStream(java.io.InputStream a) {
        super(a);
    }
}
