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
        this.encoding = new ASN1OctetString(Arrays.clone(encoding));
    }



    public synchronized ECPoint getPoint() {
        if (p == null)
        {
            p = c.decodePoint(encoding.string).normalize();
        }

        return p;
    }







}