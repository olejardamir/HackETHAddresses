public class X9ECParameters {
   private final ECCurve curve;
   private final X9ECPoint g;

   public X9ECParameters(ECCurve curve, X9ECPoint g) {
      super();
      this.curve = curve;
      this.g = g;
   }

   public ECCurve getCurve() {
      return this.curve;
   }

   public ECPoint getG() {
      return this.g.getPoint();
   }
}
