package Keys;

import java.math.BigInteger;

class X9ECPoint {

    private ECPoint p;



    X9ECPoint(ECCurve c, byte[] encoding) {

        byte[] copy = new byte[encoding.length];
        System.arraycopy(encoding, 0, copy, 0, encoding.length);
        ECPoint p1;
        byte[] mag1 = new byte[32];
        System.arraycopy(copy, 1, mag1, 0, 32);
        BigInteger X = new BigInteger(1, mag1);
        byte[] mag = new byte[32];
        System.arraycopy(copy, 33, mag, 0, 32);
        p1 = c.createRawPoint(c.fromBigInteger(X), c.fromBigInteger(new BigInteger(1, mag)), false);
        p = p1.normalize(p1.zs[0].invert());
    }

    ECPoint getPoint(){return p;}
}
