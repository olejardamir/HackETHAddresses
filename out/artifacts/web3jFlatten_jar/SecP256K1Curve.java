import java.math.BigInteger;

public class SecP256K1Curve extends ECCurve {
   public static BigInteger q;
   private SecP256K1Point infinity = new SecP256K1Point(this, (ECFieldElement)null, (ECFieldElement)null);

   public SecP256K1Curve() throws Exception {
      super(FiniteFields.getPrimeField(q));
      this.a = this.fromBigInteger(ECFieldElement.ZERO);
      this.b = this.fromBigInteger(BigInteger.valueOf(7L));
      this.order = new BigInteger(1, Hex.decode("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
      this.coord = 2;
   }

   protected ECCurve cloneCurve() throws Exception {
      return new SecP256K1Curve();
   }

   public int getFieldSize() {
      return q.bitLength();
   }

   public ECFieldElement fromBigInteger(BigInteger x) {
      return new SecP256K1FieldElement(x);
   }

   protected ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, boolean withCompression) {
      return new SecP256K1Point(this, x, y, withCompression);
   }

   public ECPoint getInfinity() {
      return this.infinity;
   }

   public ECLookupTable createCacheSafeLookupTable(ECPoint[] points, int off, final int len) {
      final int[] table = new int[len * 8 * 2];
      int pos = 0;

      for(int i = 0; i < len; ++i) {
         ECPoint p = points[off + i];
         Nat256.copy(((SecP256K1FieldElement)p.getRawXCoord()).x, 0, table, pos);
         pos += 8;
         Nat256.copy(((SecP256K1FieldElement)p.getRawYCoord()).x, 0, table, pos);
         pos += 8;
      }

      return new ECLookupTable() {
         public int getSize() {
            return len;
         }

         public ECPoint lookup(int index) {
            int[] x = Nat256.create();
            int[] y = Nat256.create();
            int pos = 0;

            for(int i = 0; i < len; ++i) {
               int MASK = (i ^ index) - 1 >> 31;

               for(int j = 0; j < 8; ++j) {
                  x[j] ^= table[pos + j] & MASK;
                  y[j] ^= table[pos + 8 + j] & MASK;
               }

               pos += 16;
            }

            return SecP256K1Curve.this.createRawPoint(new SecP256K1FieldElement(x), new SecP256K1FieldElement(y), false);
         }
      };
   }

   protected ECPoint decompressPoint(int yTilde, BigInteger X1) {
      ECFieldElement x = this.fromBigInteger(X1);
      ECFieldElement rhs = x.square().multiply(x);
      ECFieldElement y = rhs.sqrt();
      if (y.testBitZero() != (yTilde == 1)) {
         y = y.negate();
      }

      return this.createRawPoint(x, y, true);
   }

   static {
      try {
         q = new BigInteger(1, Hex.decode("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));
      } catch (Exception var1) {
         var1.printStackTrace();
      }

   }
}
