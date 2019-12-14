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


    
    public ASN1InputStream(
            byte[] input,
            boolean lazyEvaluate)
    {
        this(new ByteArrayInputStream(input), input.length);
    }

    
    private ASN1InputStream(
            InputStream input,
            int limit)
    {
        super(input);
    }

    private int readLength()
            throws Exception
    {
        return readLength(this);
    }

    
    private ASN1Primitive buildObject(
            int tag,
            int tagNo) {
        boolean isConstructed = (tag & CONSTRUCTED) != 0;




        if (isConstructed)
        {
            
            switch (tagNo)
            {





















              }
        }

        return null;
    }

    public ASN1Primitive readObject()
            throws Exception
    {
        int tag = read();
        if (tag <= 0)
        {


            return null;
        }

        
        
        
        int tagNo = readTagNumber(this, tag);

        
        
        
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
        else
        {

                return buildObject(tag, tagNo);

        }
        return null;
    }

    private static int readTagNumber(InputStream s, int tag)
            throws Exception
    {
        int tagNo = tag & 0x1f;

        
        
        
        if (tagNo == 0x1f)
        {
            tagNo = 0;

            int b = s.read();



            while ((b >= 0) && ((b & 0x80) != 0))
            {
                tagNo |= (b & 0x7f);
                tagNo <<= 7;
                b = s.read();
            }



            tagNo |= (b & 0x7f);
        }

        return tagNo;
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
