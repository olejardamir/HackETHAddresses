package Keys;
class ECDomainParameters {

    private ECPoint G;



    public ECDomainParameters(
            ECCurve curve,
            ECPoint G
    ) {
        this.G = validate(curve, G);
    }

    private static ECPoint validate(ECCurve c, ECPoint q) {

        return c.importPoint(q).normalize();
    }

    public ECPoint getG() {
        return G;
    }





}
