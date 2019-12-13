
import java.io.IOException;

/**
 * Definite Length TaggedObject - in ASN.1 notation this is any object preceded by
 * a [n] where n is some number - these are assumed to follow the construction
 * rules (as with sequences).
 */
class DLTaggedObject
        extends ASN1TaggedObject
{

    /**
     * @param explicit true if an explicitly tagged object.
     * @param tagNo the tag number for this object.
     * @param obj the tagged object.
     */
    public DLTaggedObject(
            boolean explicit,
            int tagNo,
            ASN1Encodable obj)
    {
        super(explicit, tagNo, obj);
    }

    int encodedLength()
            throws IOException
    {
        if (!empty)
        {
            int length = obj.toASN1Primitive().toDLObject().encodedLength();

            if (explicit)
            {
                return  StreamUtil.calculateTagLength(tagNo) + StreamUtil.calculateBodyLength(length) + length;
            }
            else
            {
                // header length already in calculation
                length = length - 1;

                return StreamUtil.calculateTagLength(tagNo) + length;
            }
        }
        else
        {
            return StreamUtil.calculateTagLength(tagNo) + 1;
        }
    }

    @Override
    void encode(ASN1OutputStream out) {

    }

    @Override
    boolean asn1Equals(ASN1Primitive o) {
        return false;
    }
}
