package Keys;

class X9ECPoint {
    private final ASN1OctetString encoding;

    private final ECCurve c;
    private ECPoint p;



    public X9ECPoint(
            ECCurve          c,
            byte[]           encoding)
    {

        this.c = c;
        byte[] copy = new byte[encoding.length];

        System.arraycopy(encoding, 0, copy, 0, encoding.length);

        this.encoding = new ASN1OctetString(copy);
    }



    public synchronized ECPoint getPoint() {
        if (p == null)
        {
            p = c.decodePoint(encoding.string).normalize();
        }

        return p;
    }







}
