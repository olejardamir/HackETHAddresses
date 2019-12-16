import java.math.BigInteger;

class ECDomainParameters {
    private final ECCurve curve;
    private final ECPoint G;
    private final BigInteger n;
    private final BigInteger h;


    public ECDomainParameters(
            ECCurve curve,
            ECPoint G,
            BigInteger n,
            BigInteger h
    ) {



        this.curve = curve;
        this.G = validate(curve, G);
        this.n = n;
        this.h = h;
    }

    private static ECPoint validate(ECCurve c, ECPoint q) {

        q = ECAlgorithms.importPoint(c, q).normalize();



        return q;
    }

    public ECPoint getG() {
        return G;
    }



    public boolean equals(
            Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj instanceof ECDomainParameters)) {
            ECDomainParameters other = (ECDomainParameters) obj;


            return this.curve.equals(other.curve) && this.G.equals(other.G) && this.n.equals(other.n) && this.h.equals(other.h);

        }

        return false;
    }

    public int hashCode() {
        int hc = curve.hashCode();
        hc *= 37;
        hc ^= G.hashCode();
        hc *= 37;
        hc ^= n.hashCode();
        hc *= 37;
        hc ^= h.hashCode();
        return hc;
    }
}
