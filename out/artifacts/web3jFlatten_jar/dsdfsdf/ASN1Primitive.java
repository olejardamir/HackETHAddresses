abstract public class ASN1Primitive extends ASN1Object {
    ASN1Primitive() {
    }
    
    final public boolean equals(Object a) {
        boolean b = false;
        if (this == a) {
            return true;
        }
        boolean b0 = a instanceof ASN1Encodable;
        label2: {
            label0: {
                label1: {
                    if (!b0) {
                        break label1;
                    }
                    if (this.asn1Equals(((ASN1Encodable)a).toASN1Primitive())) {
                        break label0;
                    }
                }
                b = false;
                break label2;
            }
            b = true;
        }
        return b;
    }
    
    public ASN1Primitive toASN1Primitive() {
        return this;
    }
    
    ASN1Primitive toDERObject() {
        return this;
    }
    
    ASN1Primitive toDLObject() {
        return this;
    }
    
    abstract public int hashCode();
    
    
    abstract int encodedLength();
    
    
    abstract void encode(ASN1OutputStream arg);
    
    
    abstract boolean asn1Equals(ASN1Primitive arg);
}
