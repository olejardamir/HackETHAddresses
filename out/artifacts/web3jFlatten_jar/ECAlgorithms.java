class ECAlgorithms {
   ECAlgorithms() {
      super();
   }

   public static ECPoint importPoint(ECCurve c, ECPoint p) {
      return c.importPoint(p);
   }

   public static void montgomeryTrick(ECFieldElement[] zs, int off, int len) {
      ECFieldElement[] c = new ECFieldElement[len];
      c[0] = zs[off];
      int i = 0;

      while(true) {
         ++i;
         if (i >= len) {
            --i;

            ECFieldElement u;
            ECFieldElement tmp;
            for(u = c[i].invert(); i > 0; u = u.multiply(tmp)) {
               int j = off + i--;
               tmp = zs[j];
               zs[j] = c[i].multiply(u);
            }

            zs[off] = u;
            return;
         }

         c[i] = c[i - 1].multiply(zs[off + i]);
      }
   }

   static ECPoint implCheckResult(ECPoint p) {
      return p;
   }
}
