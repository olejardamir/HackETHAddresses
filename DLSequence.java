import java.io.IOException;
import java.util.Enumeration;


class DLSequence
        extends ASN1Sequence
{
    private int bodyLength = -1;

    /**
     * Create an empty sequence
     */
    public DLSequence()
    {
    }

    /**
     * create a sequence containing a vector of objects.
     * @param v the vector of objects to make up the sequence.
     */
    public DLSequence(
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
                Object obj = e.nextElement();

                length += ((ASN1Encodable)obj).toASN1Primitive().toDLObject().encodedLength();
            }

            bodyLength = length;
        }

        return bodyLength;
    }

    int encodedLength()
            throws Exception
    {
        int length = getBodyLength();

        return 1 + StreamUtil.calculateBodyLength(length) + length;
    }


    void encode(
            ASN1OutputStream out)
            throws Exception
    {
        ASN1OutputStream dOut = out.getDLSubStream();
        int length = getBodyLength();

        out.write(ASN1InputStream.SEQUENCE | ASN1InputStream.CONSTRUCTED);
        out.writeLength(length);

        for (Enumeration e = this.getObjects(); e.hasMoreElements();)
        {
            Object obj = e.nextElement();

            dOut.writeObject((ASN1Encodable)obj);
        }
    }
}