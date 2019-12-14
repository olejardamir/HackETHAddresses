class DLApplicationSpecific extends ASN1ApplicationSpecific {
    DLApplicationSpecific(boolean b, int i, byte[] a) {
        super(b, i, a);
    }
    
    int encodedLength() {
        return 0;
    }
    
    void encode(ASN1OutputStream a) {
    }
    
    boolean asn1Equals(ASN1Primitive a) {
        return false;
    }
}
