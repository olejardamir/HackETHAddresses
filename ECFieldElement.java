import java.math.BigInteger;

public abstract class ECFieldElement
        implements ECConstants {
    ECFieldElement() {

    }

    public abstract BigInteger toBigInteger();

    public abstract int getFieldSize();

    public abstract ECFieldElement add(ECFieldElement b);

    public abstract ECFieldElement multiply(ECFieldElement b);

    public abstract ECFieldElement negate();

    public abstract ECFieldElement square();

    public abstract ECFieldElement invert();

    public abstract ECFieldElement sqrt();

    public int bitLength() {
        return toBigInteger().bitLength();
    }

    public boolean isOne() {
        return bitLength() == 1;
    }

    public boolean isZero() {
        return 0 == toBigInteger().signum();
    }


    public boolean testBitZero() {
        return toBigInteger().testBit(0);
    }

    public String toString() {
        return this.toBigInteger().toString(16);
    }

    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray((getFieldSize() + 7) / 8, toBigInteger());
    }

    static abstract class AbstractFp extends ECFieldElement {
    }


}
