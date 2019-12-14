public class DEROutputStream extends ASN1OutputStream {
    public DEROutputStream(java.io.OutputStream a) {
        super(a);
    }
    
    public void writeObject(ASN1Encodable a) {
        a.toASN1Primitive().toDERObject().encode((ASN1OutputStream)this);
    }
    
    ASN1OutputStream getDERSubStream() {
        return this;
    }
    
    ASN1OutputStream getDLSubStream() {
        return this;
    }
}
