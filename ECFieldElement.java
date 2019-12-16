import java.math.BigInteger;

public abstract class ECFieldElement {
    public static final BigInteger ZERO = BigInteger.valueOf(0);
    public static final BigInteger ONE = BigInteger.valueOf(1);

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
        return toBigInteger().signum() == 0;
    }


    public boolean testBitZero() {
        return toBigInteger().testBit(0);
    }



    public byte[] getEncoded() {
        int length;
		length = (getFieldSize() + 7) / 8;
		byte[] bytes;
		bytes = toBigInteger().toByteArray();
		if (bytes.length == length) {
			return bytes;
		}

        int start;
		if (bytes[0] == 0) {
			start = 1;
		} else {
			start = 0;
		}
		int count;
		count = bytes.length - start;
		byte[] tmp;
		tmp = new byte[length];
		System.arraycopy(bytes, start, tmp, tmp.length - count, count);
        return tmp;
    }


}
