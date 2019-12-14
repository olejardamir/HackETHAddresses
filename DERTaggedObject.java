
import java.io.IOException;

class DERTaggedObject
        extends ASN1TaggedObject
{

    public DERTaggedObject(
            boolean       explicit,
            int           tagNo,
            ASN1Encodable obj)
    {
        super(explicit, tagNo, obj);
    }

    int encodedLength()
            throws Exception
    {
        if (!empty)
        {
            ASN1Primitive primitive = obj.toASN1Primitive().toDERObject();
            int length = primitive.encodedLength();

            if (explicit)
            {
                return StreamUtil.calculateTagLength(tagNo) + StreamUtil.calculateBodyLength(length) + length;
            }
            else
            {
                 length = length - 1;
                return StreamUtil.calculateTagLength(tagNo) + length;
            }
        }
        else
        {
            return StreamUtil.calculateTagLength(tagNo) + 1;
        }
    }

     void encode(ASN1OutputStream out) {

    }

     boolean asn1Equals(ASN1Primitive o) {
        return false;
    }
}
