package Keys;

import java.math.BigInteger;

class X9ECPoint {
    private final byte[]  string;

    private final ECCurve c;
    private ECPoint p;

    X9ECPoint(
            ECCurve c,
            byte[] encoding)
    {
        this.c = c;
        byte[] copy = new byte[encoding.length];

        System.arraycopy(encoding, 0, copy, 0, encoding.length);

        this.string = copy;
    }

    synchronized ECPoint getPoint() {
        if (p != null)
			return p;
		ECPoint p1 = null;
		int expectedLength = (c.getFieldSize() + 7) / 8;
		byte type = string[0];
		switch (type) {
		case 0x00:
		case 0x02:
		case 0x03:
		case 0x04:
		case 0x06:
		case 0x07: {
			byte[] mag1 = new byte[expectedLength];
			System.arraycopy(string, 1, mag1, 0, expectedLength);
			BigInteger X = new BigInteger(1, mag1);
			byte[] mag = new byte[expectedLength];
			System.arraycopy(string, expectedLength + 1, mag, 0, expectedLength);
			p1 = c.createRawPoint(c.fromBigInteger(X), c.fromBigInteger(new BigInteger(1, mag)), false);
			break;
		}
		default:
		}
		ECPoint ecPoint = p1;
		ECFieldElement Z1 = ((ecPoint == null ? 0 : ecPoint.zs.length) <= 0) ? null : ecPoint.zs[0];
		return p = (Z1 == null ? 0 : Z1.toBigInteger().bitLength()) == 1 ? ecPoint
				: ecPoint == null ? null : ecPoint.normalize(Z1 == null ? null : Z1.invert());
    }
}
