class X9ECPoint {
    private final ASN1OctetString encoding;

    private final ECCurve c;
    private ECPoint p;


    public X9ECPoint(
            ECCurve c,
            byte[] encoding) {

        this.c = c;
        this.encoding = new ASN1OctetString(Arrays.clone(encoding));
    }


    public synchronized ECPoint getPoint() {
        if (p == null) {
            p = c.decodePoint(encoding.getOctets()).normalize();
        }

        return p;
    }


    private ASN1OctetString toASN1Primitive() {
        return encoding;
    }

    public int hashCode() {
        return (this.toASN1Primitive()).toASN1Primitive().hashCode();
    }


    public boolean equals(
            Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof X9ECPoint)) {
            return false;
        }

        X9ECPoint other = (X9ECPoint) o;

        return this.toASN1Primitive().equals(other.toASN1Primitive());
    }
}
