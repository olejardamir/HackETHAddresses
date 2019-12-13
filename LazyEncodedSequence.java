
import java.io.IOException;
import java.util.Enumeration;

/**
 * Note: this class is for processing DER/DL encoded sequences only.
 */
class LazyEncodedSequence
        extends ASN1Sequence
{
    private byte[] encoded;

    LazyEncodedSequence(
            byte[] encoded) {
        this.encoded = encoded;
    }

    private void parse()
    {
        Enumeration en = new LazyConstructionEnumeration(encoded);

        while (en.hasMoreElements())
        {
            seq.addElement(en.nextElement());
        }

        encoded = null;
    }

    ASN1Primitive toDLObject()
    {
        if (encoded != null)
        {
            parse();
        }

        return super.toDLObject();
    }

    int encodedLength()
            throws IOException
    {
        if (encoded != null)
        {
            return 1 + StreamUtil.calculateBodyLength(encoded.length) + encoded.length;
        }
        else
        {
            return super.toDLObject().encodedLength();
        }
    }

    void encode(
            ASN1OutputStream out)
            throws IOException
    {
        if (encoded != null)
        {
            out.writeEncoded(BERTags.SEQUENCE | BERTags.CONSTRUCTED, encoded);
        }
        else
        {
            super.toDLObject().encode(out);
        }
    }
}
