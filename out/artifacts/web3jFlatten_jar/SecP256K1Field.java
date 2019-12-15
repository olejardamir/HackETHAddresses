import java.math.BigInteger;

class SecP256K1Field {
   static final int[] P = new int[]{-977, -2, -1, -1, -1, -1, -1, -1};
   private static final int[] PExt = new int[]{954529, 1954, 1, 0, 0, 0, 0, 0, -1954, -3, -1, -1, -1, -1, -1, -1};
   private static final int[] PExtInv = new int[]{-954529, -1955, -2, -1, -1, -1, -1, -1, 1953, 2};

   SecP256K1Field() {
      super();
   }

   public static int[] fromBigInteger(BigInteger x) {
      int[] z = Nat256.fromBigInteger(x);
      if (z[7] == -1 && Nat256.gte(z, P)) {
         Nat256.subFrom(P, z);
      }

      return z;
   }

   public static void multiply(int[] a, int[] a0, int[] a1) {
      int[] a2 = Nat256.createExt();
      Nat256.mul(a, a0, a2);
      reduce(a2, a1);
   }

   public static void multiplyAddToExt(int[] x, int[] y, int[] zz) {
      int c = Nat256.mulAddTo(x, y, zz);
      if ((c != 0 || zz[15] == -1 && Nat.gte(16, zz, PExt)) && Nat.addTo(PExtInv.length, PExtInv, zz) != 0) {
         Nat.incAt(16, zz, PExtInv.length);
      }

   }

   public static void negate(int[] a, int[] a0) {
      if (Nat256.isZero(a)) {
         Nat256.zero(a0);
      } else {
         Nat256.sub(P, a, a0);
      }

   }

   public static void reduce(int[] xx, int[] z) {
      long cc = Nat256.mul33Add(977, xx, 8, xx, 0, z, 0);
      int c = Nat256.mul33DWordAdd(977, cc, z, 0);
      if (c != 0 || z[7] == -1 && Nat256.gte(z, P)) {
         Nat.add33To(8, 977, z);
      }

   }

   public static void reduce32(int x, int[] z) {
      if (x != 0 && Nat256.mul33WordAdd(977, x, z, 0) != 0 || z[7] == -1 && Nat256.gte(z, P)) {
         Nat.add33To(8, 977, z);
      }

   }

   public static void square(int[] a, int[] a0) {
      int[] a2 = Nat256.createExt();
      Nat256.square(a, a2);
      reduce(a2, a0);
   }

   public static void subtract(int[] a, int[] a0, int[] a1) {
      if (Nat256.sub(a, a0, a1) != 0) {
         Nat.sub33From(8, 977, a1);
      }

   }

   public static void twice(int[] x, int[] z) {
      int c = Nat.shiftUpBit(8, x, 0, z);
      if (c != 0 || z[7] == -1 && Nat256.gte(z, P)) {
         Nat.add33To(8, 977, z);
      }

   }
}
