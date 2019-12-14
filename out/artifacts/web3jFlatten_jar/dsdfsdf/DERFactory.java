class DERFactory {
    final private static ASN1Sequence EMPTY_SEQUENCE;
    final private static ASN1Set EMPTY_SET;
    
    DERFactory() {
    }
    
    static ASN1Sequence createSequence(ASN1EncodableVector a) {
        ASN1Sequence a0 = (a.size() >= 1) ? new DLSequence(a) : EMPTY_SEQUENCE;
        return a0;
    }
    
    static ASN1Set createSet(ASN1EncodableVector a) {
        ASN1Set a0 = (a.size() >= 1) ? new DLSet(a) : EMPTY_SET;
        return a0;
    }
    
    static {
        EMPTY_SEQUENCE = new DERSequence();
        EMPTY_SET = new DERSet();
    }
}
