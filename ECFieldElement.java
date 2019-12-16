import java.math.BigInteger;

public abstract class ECFieldElement {
    public static final BigInteger ZERO = BigInteger.valueOf(0);
    public static final BigInteger ONE = BigInteger.valueOf(1);

    ECFieldElement() {

    }

    public abstract BigInteger toBigInteger();

    protected abstract int getFieldSize();

    public abstract ECFieldElement add(ECFieldElement b);

    public abstract ECFieldElement multiply(ECFieldElement b);

    public abstract ECFieldElement negate();

    public abstract ECFieldElement square();

    public abstract ECFieldElement invert();

    public abstract ECFieldElement sqrt();

    private int bitLength() {
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
        int length = (getFieldSize() + 7) / 8;
        byte[] bytes = toBigInteger().toByteArray();
        if (bytes.length == length)
        {
            return bytes;
        }

        int start = bytes[0] == 0 ? 1 : 0;
        int count = bytes.length - start;


        byte[] tmp = new byte[length];
        System.arraycopy(bytes, start, tmp, tmp.length - count, count);
        return tmp;
    }

    static abstract class AbstractFp extends ECFieldElement {
    }


}
