public class DLOutputStream extends ASN1OutputStream {
    public DLOutputStream(java.io.OutputStream a) {
        super(a);
    }
    
    public void writeObject(ASN1Encodable a) {
        if (a == null) {
            throw new java.io.IOException((String)None);
        }
        a.toASN1Primitive().toDLObject().encode((ASN1OutputStream)this);
    }
}
