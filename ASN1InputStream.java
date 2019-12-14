import java.io.*;

/**
 * A general purpose ASN.1 decoder - note: this class differs from the
 * others in that it returns null after it has read the last object in
 * the stream. If an ASN.1 NULL is encountered a DER/BER Null object is
 * returned.
 */
class ASN1InputStream
        extends FilterInputStream {
     public static final int INTEGER             = 0x02;//
    public static final int BIT_STRING          = 0x03;
    public static final int OCTET_STRING        = 0x04;//
    public static final int NULL                = 0x05;
    public static final int OBJECT_IDENTIFIER   = 0x06;//
    public static final int EXTERNAL            = 0x08;//
     public static final int SEQUENCE            = 0x10; // decimal 16
    public static final int SET                 = 0x11; // decimal 17
     public static final int PRINTABLE_STRING    = 0x13; // decimal 19

    public static final int VISIBLE_STRING      = 0x1a; // decimal 26

    public static final int CONSTRUCTED         = 0x20; // decimal 32
    public static final int APPLICATION         = 0x40; // decimal 64
    public static final int TAGGED              = 0x80; // decimal 128
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
                default:
                    throw new IOException("unknown tag " + tagNo + " encountered");
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
            if (tag == 0)
            {
                throw new IOException("unexpected end-of-contents marker");
            }

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
            if (!isConstructed)
            {
                throw new IOException("indefinite-length primitive encoding encountered");
            }


            if ((tag & APPLICATION) != 0)
            {
                return new BERApplicationSpecificParser().getLoadedObject();
            }

            if ((tag & TAGGED) != 0)
            {
                return new BERTaggedObjectParser(true).getLoadedObject();
            }


        }
        else
        {
            try
            {
                return buildObject(tag, tagNo, length);
            }
            catch (IllegalArgumentException e)
            {
              //  throw new ASN1Exception("corrupted stream detected", e);
            }
        }
        return null;
    }

    static int readTagNumber(InputStream s, int tag)
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

            // X.690-0207 8.1.2.4.2
            // "c) bits 7 to 1 of the first subsequent octet shall not all be zero."
            if ((b & 0x7f) == 0) // Note: -1 will pass
            {
                throw new IOException("corrupted stream - invalid high tag number found");
            }

            while ((b >= 0) && ((b & 0x80) != 0))
            {
                tagNo |= (b & 0x7f);
                tagNo <<= 7;
                b = s.read();
            }

            if (b < 0)
            {
                throw new EOFException("EOF found inside tag value.");
            }

            tagNo |= (b & 0x7f);
        }

        return tagNo;
    }

    static int readLength(InputStream s, int limit)
            throws IOException
    {
        int length = s.read();
        if (length < 0)
        {
            throw new EOFException("EOF found when length expected");
        }

        if (length == 0x80)
        {
            return -1;      // indefinite-length encoding
        }

        if (length > 127)
        {
            int size = length & 0x7f;

            // Note: The invalid long form "0xff" (see X.690 8.1.3.5c) will be caught here
            if (size > 4)
            {
                throw new IOException("DER length more than 4 bytes: " + size);
            }

            length = 0;
            for (int i = 0; i < size; i++)
            {
                int next = s.read();

                if (next < 0)
                {
                    throw new EOFException("EOF found reading length");
                }

                length = (length << 8) + next;
            }

            if (length < 0)
            {
                throw new IOException("corrupted stream - negative length found");
            }

            if (length >= limit)   // after all we must have read at least 1 byte
            {
                throw new IOException("corrupted stream - out of bounds length found");
            }
        }

        return length;
    }


}
