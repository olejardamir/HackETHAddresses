
import java.io.IOException;
import java.io.InputStream;

/**
 * A parser for ASN.1 streams which also returns, where possible, parsers for the objects it encounters.
 */
class ASN1StreamParser
{
    private final InputStream _in;
    private final int         _limit;
    private final byte[][] tmpBuffers;

    public ASN1StreamParser(
            InputStream in)
    {
        this(in, StreamUtil.findLimit(in));
    }

    public ASN1StreamParser(
            InputStream in,
            int         limit)
    {
        this._in = in;
        this._limit = limit;

        this.tmpBuffers = new byte[11][];
    }

    private ASN1Encodable readIndef(int tagValue) {
        // Note: INDEF => CONSTRUCTED

        // TODO There are other tags that may be constructed (e.g. BIT_STRING)
        switch (tagValue)
        {
            case BERTags.EXTERNAL:
                return new DERExternalParser(this);
            case BERTags.OCTET_STRING:
                return new BEROctetStringParser(this);
            case BERTags.SEQUENCE:
                return new BERSequenceParser(this);
            case BERTags.SET:
                return new BERSetParser(this);
            default:
               // throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(tagValue));
        }
        return null;
    }

    ASN1Primitive readTaggedObject(boolean constructed, int tag) throws IOException
    {
        if (!constructed)
        {
            // Note: !CONSTRUCTED => IMPLICIT
            DefiniteLengthInputStream defIn = (DefiniteLengthInputStream)_in;
            return new DERTaggedObject(false, tag, new DEROctetString(defIn.toByteArray()));
        }

        ASN1EncodableVector v = readVector();

        if (_in instanceof IndefiniteLengthInputStream)
        {
            return v.size() == 1
                    ?   new BERTaggedObject(true, tag, v.get(0))
                    :   new BERTaggedObject(false, tag, BERFactory.createSequence(v));
        }

        return v.size() == 1
                ?   new DERTaggedObject(true, tag, v.get(0))
                :   new DERTaggedObject(false, tag, DERFactory.createSequence(v));
    }

    public ASN1Encodable readObject()
            throws IOException
    {
        int tag = _in.read();
        if (tag == -1)
        {
            return null;
        }

        //
        // turn of looking for "00" while we resolve the tag
        //
        set00Check();

        //
        // calculate tag number
        //
        int tagNo = ASN1InputStream.readTagNumber(_in, tag);

        boolean isConstructed = (tag & BERTags.CONSTRUCTED) != 0;

        //
        // calculate length
        //
        int length = ASN1InputStream.readLength(_in, _limit);

        if (length < 0) // indefinite-length method
        {
            if (!isConstructed)
            {
                throw new IOException("indefinite-length primitive encoding encountered");
            }

            IndefiniteLengthInputStream indIn = new IndefiniteLengthInputStream(_in);
            ASN1StreamParser sp = new ASN1StreamParser(indIn, _limit);

            if ((tag & BERTags.APPLICATION) != 0)
            {
                return new BERApplicationSpecificParser(tagNo, sp);
            }

            if ((tag & BERTags.TAGGED) != 0)
            {
                return new BERTaggedObjectParser(true, tagNo, sp);
            }

            return sp.readIndef(tagNo);
        }
        else
        {
            DefiniteLengthInputStream defIn = new DefiniteLengthInputStream(_in, length);

            if ((tag & BERTags.APPLICATION) != 0)
            {
                return new DLApplicationSpecific(isConstructed, tagNo, defIn.toByteArray());
            }

            if ((tag & BERTags.TAGGED) != 0)
            {
                return new BERTaggedObjectParser(isConstructed, tagNo, new ASN1StreamParser(defIn));
            }

            if (isConstructed)
            {
                // TODO There are other tags that may be constructed (e.g. BIT_STRING)
                switch (tagNo)
                {
                    case BERTags.OCTET_STRING:
                        //
                        // yes, people actually do this...
                        //
                        return new BEROctetStringParser(new ASN1StreamParser(defIn));
                    case BERTags.SEQUENCE:
                        return new DERSequenceParser(new ASN1StreamParser(defIn));
                    case BERTags.SET:
                        return new DERSetParser(new ASN1StreamParser(defIn));
                    case BERTags.EXTERNAL:
                        return new DERExternalParser(new ASN1StreamParser(defIn));
                    default:
                        throw new IOException("unknown tag " + tagNo + " encountered");
                }
            }

            // Some primitive encodings can be handled by parsers too...
            if (tagNo == BERTags.OCTET_STRING) {
                return new DEROctetStringParser(defIn);
            }

            try
            {
                return ASN1InputStream.createPrimitiveDERObject(tagNo, defIn, tmpBuffers);
            }
            catch (IllegalArgumentException e)
            {
                //throw new ASN1Exception("corrupted stream detected", e);
            }
        }
        return null;
    }

    private void set00Check()
    {
        if (_in instanceof IndefiniteLengthInputStream)
        {
            ((IndefiniteLengthInputStream)_in).setEofOn00(false);
        }
    }

    ASN1EncodableVector readVector() throws IOException
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        ASN1Encodable obj;
        while ((obj = readObject()) != null)
        {
            if (obj instanceof InMemoryRepresentable)
            {
                v.add(((InMemoryRepresentable)obj).getLoadedObject());
            }
            else
            {
                v.add(obj.toASN1Primitive());
            }
        }

        return v;
    }
}
