
class DLTaggedObject
        extends ASN1TaggedObject
{

    
    public DLTaggedObject(
            boolean explicit,
            int tagNo,
            ASN1Encodable obj)
    {
        super(explicit, tagNo, obj);
    }

     int encodedLength() {
        return 0;
    }

     void encode(ASN1OutputStream out) {

    }

     boolean asn1Equals(ASN1Primitive o) {
        return false;
    }
}
