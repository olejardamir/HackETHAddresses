abstract public class ASN1Null extends ASN1Primitive {
    ASN1Null() {
    }
    
    public int hashCode() {
        return -1;
    }
    
    boolean asn1Equals(ASN1Primitive a) {
        return a instanceof ASN1Null;
    }
    
    abstract void encode(ASN1OutputStream arg);
    
    
    public String toString() {
        return (String)None;
    }
}
