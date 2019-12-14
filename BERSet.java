
import java.io.IOException;
import java.util.Enumeration;

/**
 * Indefinite length <code>SET</code> and <code>SET OF</code> constructs.
 * <p>
 * Note: This does not know which syntax the set is!
 * </p><p>
 * Length field has value 0x80, and the set ends with two bytes of: 0x00, 0x00.
 * </p><p>
 * For X.690 syntax rules, see {@link ASN1Set}.
 * </p><p>
 * In brief: Constructing this form does not sort the supplied elements,
 * nor does the sorting happen before serialization. This is different
 * </p>
 */
class BERSet
        extends ASN1Set
{

    /**
     * Create a SET containing multiple objects.
     * @param v a vector of objects making up the set.
     */
    public BERSet(
            ASN1EncodableVector v)
    {
        super(v);
    }

    int encodedLength()
            throws IOException
    {
        int length = 0;
        for (Enumeration e = getObjects(); e.hasMoreElements();)
        {
            length += ((ASN1Encodable)e.nextElement()).toASN1Primitive().encodedLength();
        }

        return 2 + length + 2;
    }


    void encode(ASN1OutputStream out) {

    }

     boolean asn1Equals(ASN1Primitive o) {
        return false;
    }
}