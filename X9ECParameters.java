public class X9ECParameters {

    private final ECCurve curve;
    private final X9ECPoint g;


    public X9ECParameters(
            ECCurve curve,
            X9ECPoint g) {
        this.curve = curve;
        this.g = g;
    }

    public ECCurve getCurve() {
        return curve;
    }

    public ECPoint getG() {
            if (g.p == null) {
                g.p = g.c.decodePoint(g.string).normalize();
            }
            return g.p;
    }


}
