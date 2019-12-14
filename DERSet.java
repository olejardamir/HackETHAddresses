
import java.io.IOException;
import java.util.Enumeration;

/**
 * A DER encoded SET object
 * <p>
 * For X.690 syntax rules, see {@link ASN1Set}.
 * </p><p>
 * For short: Constructing this form does sort the supplied elements,
 * and the sorting happens also before serialization (if necesssary).
 * This is different from the way {@link BERSet},{@link DLSet} does things.
 * </p>
 */
class DERSet
        extends ASN1Set
{
    private int bodyLength = -1;


    public DERSet() {

    }


    private int getBodyLength()
            throws IOException
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
            throws IOException
    {
        int length = getBodyLength();

        return 1 + StreamUtil.calculateBodyLength(length) + length;
    }

    @Override
    void encode(ASN1OutputStream out) {

    }

    @Override
    boolean asn1Equals(ASN1Primitive o) {
        return false;
    }
}
