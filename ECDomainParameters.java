class ECDomainParameters {

    public ECPoint G;

    public ECDomainParameters(
            ECCurve curve,
            ECPoint G
    ) {

        this.G = curve.importPoint(G).normalize();
    }


}
