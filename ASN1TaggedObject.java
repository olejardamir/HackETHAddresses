public abstract class ASN1TaggedObject
        extends ASN1Primitive
        implements ASN1Encodable {
    final int tagNo;
    final boolean explicit;
    final ASN1Encodable obj;


    ASN1TaggedObject(
            boolean explicit,
            int tagNo,
            ASN1Encodable obj) {
        this.explicit = explicit;
        this.tagNo = tagNo;
        this.obj = obj;


    }

    public int hashCode() {
        int code = tagNo;


        if (obj != null) {
            code ^= obj.hashCode();
        }

        return code;
    }



    public String toString() {
        return "[" + tagNo + "]" + obj;
    }
}
