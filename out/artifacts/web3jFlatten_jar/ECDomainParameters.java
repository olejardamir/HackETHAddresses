class ECDomainParameters {
   private ECPoint G;

   public ECDomainParameters(ECCurve curve, ECPoint G) {
      super();
      this.G = validate(curve, G);
   }

   private static ECPoint validate(ECCurve c, ECPoint q) {
      q = ECAlgorithms.importPoint(c, q).normalize();
      return q;
   }

   public ECPoint getG() {
      return this.G;
   }
}
