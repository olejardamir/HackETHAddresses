
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
            throws Exception
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
            throws Exception
    {
        if (encoded != null)
        {
            out.writeEncoded(ASN1InputStream.SEQUENCE | ASN1InputStream.CONSTRUCTED, encoded);
        }
        else
        {
            super.toDLObject().encode(out);
        }
    }
}
