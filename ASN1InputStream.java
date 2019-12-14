import java.io.*;


class ASN1InputStream
        extends FilterInputStream {
     public static final int INTEGER             = 0x02;//
    public static final int BIT_STRING          = 0x03;
    public static final int OCTET_STRING        = 0x04;//
    public static final int NULL                = 0x05;
    public static final int OBJECT_IDENTIFIER   = 0x06;//
    public static final int EXTERNAL            = 0x08;//
     public static final int SEQUENCE            = 0x10; // decimal 16
    private static final int SET                 = 0x11; // decimal 17


    public static final int CONSTRUCTED         = 0x20; // decimal 32
    private static final int APPLICATION         = 0x40; // decimal 64
    private static final int TAGGED              = 0x80; // decimal 128
    private final int limit;
    private final boolean lazyEvaluate;


    private ASN1InputStream(
            InputStream is)
    {
        this(is, StreamUtil.findLimit(is));
    }

    /**
     * Create an ASN1InputStream based on the input byte array. The length of DER objects in
     * the stream is automatically limited to the length of the input array.
     *
     * @param input array containing ASN.1 encoded data.
     */
    public ASN1InputStream(
            byte[] input)
    {
        this(new ByteArrayInputStream(input), input.length);
    }

    /**
     * Create an ASN1InputStream based on the input byte array. The length of DER objects in
     * the stream is automatically limited to the length of the input array.
     *
     * @param input array containing ASN.1 encoded data.
     * @param lazyEvaluate true if parsing inside constructed objects can be delayed.
     */
    public ASN1InputStream(
            byte[] input,
            boolean lazyEvaluate)
    {
        this(new ByteArrayInputStream(input), input.length, lazyEvaluate);
    }

    /**
     * Create an ASN1InputStream where no DER object will be longer than limit.
     *
     * @param input stream containing ASN.1 encoded data.
     * @param limit maximum size of a DER encoded object.
     */
    private ASN1InputStream(
            InputStream input,
            int limit)
    {
        this(input, limit, false);
    }

    /**
     * Create an ASN1InputStream where no DER object will be longer than limit, and constructed
     * objects such as sequences will be parsed lazily.
     *
     * @param input stream containing ASN.1 encoded data.
     * @param limit maximum size of a DER encoded object.
     * @param lazyEvaluate true if parsing inside constructed objects can be delayed.
     */
    private ASN1InputStream(
            InputStream input,
            int limit,
            boolean lazyEvaluate)
    {
        super(input);
        this.limit = limit;
        this.lazyEvaluate = lazyEvaluate;
     }

    int getLimit()
    {
        return limit;
    }

    private int readLength()
            throws IOException
    {
        return readLength(this, limit);
    }

    /**
     * build an object given its tag and the number of bytes to construct it from.
     *
     * @param tag the full tag details.
     * @param tagNo the tagNo defined.
     * @param length the length of the object.
     * @return the resulting primitive.
     * @throws java.io.IOException on processing exception.
     */
    private ASN1Primitive buildObject(
            int tag,
            int tagNo,
            int length)
            throws IOException
    {
        boolean isConstructed = (tag & CONSTRUCTED) != 0;

        DefiniteLengthInputStream defIn = new DefiniteLengthInputStream(length);

        if ((tag & APPLICATION) != 0)
        {
            return new DLApplicationSpecific(isConstructed, tagNo, defIn.toByteArray());
        }



        if (isConstructed)
        {
            // TODO There are other tags that may be constructed (e.g. BIT_STRING)
            switch (tagNo)
            {
                case OCTET_STRING:
                    //
                    // yes, people actually do this...
                    //
                    ASN1EncodableVector v = buildDEREncodableVector(defIn);
                    ASN1OctetString[] strings = new ASN1OctetString[v.size()];

                    for (int i = 0; i != strings.length; i++)
                    {
                        strings[i] = (ASN1OctetString)v.get(i);
                    }

                    return new BEROctetString(strings);
                case SEQUENCE:
                    if (lazyEvaluate)
                    {
                        return new LazyEncodedSequence(defIn.toByteArray());
                    }
                    else
                    {
                        return DERFactory.createSequence(buildDEREncodableVector(defIn));
                    }
                case SET:
                    return DERFactory.createSet(buildDEREncodableVector(defIn));
                case EXTERNAL:
                    return new DLExternal(buildDEREncodableVector(defIn));
              }
        }

        return null;
    }

    private ASN1EncodableVector buildEncodableVector()
            throws IOException
    {
        ASN1EncodableVector v = new ASN1EncodableVector();
        ASN1Primitive o;

        while ((o = readObject()) != null)
        {
            v.add(o);
        }

        return v;
    }

    private ASN1EncodableVector buildDEREncodableVector(
            DefiniteLengthInputStream dIn) throws IOException
    {
        return new ASN1InputStream(dIn).buildEncodableVector();
    }

    public ASN1Primitive readObject()
            throws IOException
    {
        int tag = read();
        if (tag <= 0)
        {


            return null;
        }

        //
        // calculate tag number
        //
        int tagNo = readTagNumber(this, tag);

        boolean isConstructed = (tag & CONSTRUCTED) != 0;

        //
        // calculate length
        //
        int length = readLength();

        if (length < 0) // indefinite-length method
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

                return buildObject(tag, tagNo, length);

        }
        return null;
    }

    private static int readTagNumber(InputStream s, int tag)
            throws IOException
    {
        int tagNo = tag & 0x1f;

        //
        // with tagged object tag number is bottom 5 bits, or stored at the start of the content
        //
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

    private static int readLength(InputStream s, int limit)
            throws IOException
    {
        int length = s.read();

        if (length == 0x80)
        {
            return -1;      // indefinite-length encoding
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
