package Keys;

class X9ECPoint {
    private final byte[]  string;

    private final ECCurve c;
    private ECPoint p;



    public X9ECPoint(
            ECCurve c,
            byte[] encoding)
    {

        this.c = c;
        byte[] copy = new byte[encoding.length];

        System.arraycopy(encoding, 0, copy, 0, encoding.length);

        this.string = copy;
    }



    public synchronized ECPoint getPoint() {
        if (p == null)
        {
            ECPoint ecPoint = c.decodePoint(string);


            ECFieldElement Z1 = ecPoint.getZCoord(0);
            p = Z1.toBigInteger().bitLength() == 1 ? ecPoint : ecPoint.normalize(Z1.invert());
        }

        return p;
    }







}
