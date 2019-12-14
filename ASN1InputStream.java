import java.io.*;


class ASN1InputStream
        extends FilterInputStream {
     public static final int INTEGER             = 0x02;
    public static final int BIT_STRING          = 0x03;
    public static final int OCTET_STRING        = 0x04;
    public static final int NULL                = 0x05;
    public static final int OBJECT_IDENTIFIER   = 0x06;
      public static final int SEQUENCE            = 0x10; 


    public static final int CONSTRUCTED         = 0x20; 



    protected ASN1InputStream(InputStream in) {
        super(in);
    }






}
