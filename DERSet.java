
import java.io.IOException;
import java.util.Enumeration;


class DERSet
        extends ASN1Set
{
    private int bodyLength = -1;




    private int getBodyLength()
            throws Exception
    {
        if (bodyLength < 0)
        {
            int length = 0;

            for (Enumeration e = this.getObjects(); e.hasMoreElements();)
            {
                Object    obj = e.nextElement();

                length += ((ASN1Encodable)obj).toASN1Primitive().toDERObject().encodedLength();
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

     void encode(ASN1OutputStream out) {

    }

     boolean asn1Equals(ASN1Primitive o) {
        return false;
    }
}
