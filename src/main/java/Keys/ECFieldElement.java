package Keys;

import java.math.BigInteger;

//done checkpoint clean
public abstract class ECFieldElement {
    static final BigInteger ONE = BigInteger.valueOf(1);


    public abstract BigInteger toBigInteger();

    protected abstract int getFieldSize();

    public abstract ECFieldElement multiply(ECFieldElement b);

    public abstract ECFieldElement negate();

    public abstract ECFieldElement square();

    public abstract ECFieldElement invert();


    byte[] getEncoded() {
        int length = (getFieldSize() + 7) / 8;
        byte[] bytes = toBigInteger().toByteArray();
        if (bytes.length == length)
            return bytes;

        int start = bytes[0] == 0 ? 1 : 0, count = bytes.length - start;
        byte[] tmp = new byte[length];
        System.arraycopy(bytes, start, tmp, tmp.length - count, count);
        return tmp;
    }


}
