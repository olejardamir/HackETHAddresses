package Keys;

import java.math.BigInteger;

/** Done checkpoint clean. */
public abstract class ECFieldElement {
    static final BigInteger ONE = BigInteger.ONE;

    public abstract BigInteger toBigInteger();

    public abstract ECFieldElement multiply(ECFieldElement b);

    public abstract ECFieldElement negate();

    public abstract ECFieldElement square();

    public abstract ECFieldElement invert();

    byte[] getEncoded() {
        int length = 32;
        byte[] bytes = toBigInteger().toByteArray();
        if (bytes.length == length) {
			return bytes;
		}

        int start = bytes[0] == 0 ? 1 : 0, count = bytes.length - start;
        byte[] tmp = new byte[length];
        System.arraycopy(bytes, start, tmp, tmp.length - count, count);
        return tmp;
    }
}
