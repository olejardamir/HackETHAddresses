
import java.util.Enumeration;

/**
 * Definite length SEQUENCE, encoding tells explicit number of bytes
 * that the content of this sequence occupies.
 * <p>
 * For X.690 syntax rules, see {@link ASN1Sequence}.
 */
class DERSequence
        extends ASN1Sequence
{
    private int bodyLength = -1;

    /**
     * Create an empty sequence
     */
    public DERSequence()
    {
    }

    /**
     * Create a sequence containing a vector of objects.
     * @param v the vector of objects to make up the sequence.
     */
    public DERSequence(
            ASN1EncodableVector v)
    {
        super(v);
    }

    private int getBodyLength()
            throws Exception
    {
        if (bodyLength < 0)
        {
            int length = 0;

            for (Enumeration e = this.getObjects(); e.hasMoreElements();)
            {

                length += ((ASN1Encodable) e.nextElement()).toASN1Primitive().toDERObject().encodedLength();
            }

            bodyLength = length;
        }

        return bodyLength;
    }

    int encodedLength()
            throws Exception
    {

        return 1 + StreamUtil.calculateBodyLength(getBodyLength()) + getBodyLength();
    }

    /*
     * A note on the implementation:
     * <p>
     * As DER requires the constructed, definite-length model to
     * be used for structured types, this varies slightly from the
     * ASN.1 descriptions given. Rather than just outputting SEQUENCE,
     * we also have to specify CONSTRUCTED, and the objects length.
     */
    void encode(
            ASN1OutputStream out)
            throws Exception
    {

        out.write(ASN1InputStream.SEQUENCE | ASN1InputStream.CONSTRUCTED);
        out.writeLength(getBodyLength());

        for (Enumeration e = this.getObjects(); e.hasMoreElements();)
        {

            out.getDERSubStream().writeObject((ASN1Encodable) e.nextElement());
        }
    }
}
