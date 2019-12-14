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

     int encodedLength() throws Exception {
        return 0;
    }

     void encode(ASN1OutputStream out) throws Exception {

    }

     boolean asn1Equals(ASN1Primitive o) {
        return false;
    }
}
