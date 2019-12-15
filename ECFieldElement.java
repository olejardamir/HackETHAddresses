import java.math.BigInteger;

// 
// Decompiled by Procyon v0.5.36
// 

public abstract class ECFieldElement
{
    public static final BigInteger ZERO;
    public static final BigInteger ONE;
    
    ECFieldElement() {
    }
    
    public abstract BigInteger toBigInteger();
    
    public abstract ECFieldElement multiply(final ECFieldElement p0);
    
    public abstract ECFieldElement negate();
    
    public abstract ECFieldElement square();
    
    public abstract ECFieldElement invert();
    
    public abstract ECFieldElement sqrt();
    
    public int bitLength() {
        return this.toBigInteger().bitLength();
    }
    
    public boolean isOne() {
        return this.bitLength() == 1;
    }
    
    public boolean isZero() {
        return 0 == this.toBigInteger().signum();
    }
    
    public boolean testBitZero() {
        return this.toBigInteger().testBit(0);
    }
    
    @Override
    public String toString() {
        return this.toBigInteger().toString(16);
    }
    
    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray(this.toBigInteger());
    }
    
    static {
        ZERO = BigInteger.valueOf(0L);
        ONE = BigInteger.valueOf(1L);
    }
}
