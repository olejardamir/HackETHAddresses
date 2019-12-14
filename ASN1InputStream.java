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
    private static final int APPLICATION         = 0x40; 
    private static final int TAGGED              = 0x80;


    protected ASN1InputStream(InputStream in) {
        super(in);
    }


    private int readLength()
            throws Exception
    {
        return readLength(this);
    }


    public ASN1Primitive readObject()
            throws Exception
    {
        int tag = read();
        if (tag <= 0)
        {


            return null;
        }

        
        int length = readLength();

        if (length < 0) 
        {



            if ((tag & APPLICATION) != 0)
            {
                return null;
            }

            if ((tag & TAGGED) != 0)
            {
                return null;
            }


        }

        return null;
    }

    private static int readLength(InputStream s)
            throws Exception
    {
        int length = s.read();

        if (length == 0x80)
        {
            return -1;      
        }

        if (length > 127)
        {
            int size = length & 0x7f;



            length = 0;
            for (int i = 0; i < size; i++)
            {
                int next = s.read();



                length = (length << 8) + next;
            }




        }

        return length;
    }


}
