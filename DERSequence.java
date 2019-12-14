
import java.util.Enumeration;


class DERSequence
        extends ASN1Sequence
{
    private int bodyLength = -1;

    
    public DERSequence()
    {
    }

    
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
