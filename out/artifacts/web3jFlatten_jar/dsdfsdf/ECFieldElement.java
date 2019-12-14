abstract public class ECFieldElement implements ECConstants {
    abstract public java.math.BigInteger toBigInteger();
    
    
    abstract public int getFieldSize();
    
    
    abstract public ECFieldElement add(ECFieldElement arg);
    
    
    abstract public ECFieldElement addOne();
    
    
    abstract public ECFieldElement subtract(ECFieldElement arg);
    
    
    abstract public ECFieldElement multiply(ECFieldElement arg);
    
    
    abstract public ECFieldElement divide(ECFieldElement arg);
    
    
    abstract public ECFieldElement negate();
    
    
    abstract public ECFieldElement square();
    
    
    abstract public ECFieldElement invert();
    
    
    abstract public ECFieldElement sqrt();
    
    
    ECFieldElement() {
    }
    
    public int bitLength() {
        return this.toBigInteger().bitLength();
    }
    
    public boolean isOne() {
        return this.bitLength() == 1;
    }
    
    public boolean isZero() {
        return 0 == this.toBigInteger().signum();
    }
    
    public ECFieldElement multiplyMinusProduct(ECFieldElement a, ECFieldElement a0, ECFieldElement a1) {
        return this.multiply(a).subtract(a0.multiply(a1));
    }
    
    public ECFieldElement multiplyPlusProduct(ECFieldElement a, ECFieldElement a0, ECFieldElement a1) {
        return this.multiply(a).add(a0.multiply(a1));
    }
    
    public ECFieldElement squarePlusProduct(ECFieldElement a, ECFieldElement a0) {
        return this.square().add(a.multiply(a0));
    }
    
    public boolean testBitZero() {
        return this.toBigInteger().testBit(0);
    }
    
    public String toString() {
        return this.toBigInteger().toString(16);
    }
    
    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray((this.getFieldSize() + 7) / 8, this.toBigInteger());
    }
}
