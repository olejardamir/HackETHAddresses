import java.math.BigInteger;

public class Nat256 {


   public static int addBothTo(int[] x, int[] y, int[] z) {
      long c = 0L;
      c += ((long)x[0] & 4294967295L) + ((long)y[0] & 4294967295L) + ((long)z[0] & 4294967295L);
      z[0] = (int)c;
      c >>>= 32;
      c += ((long)x[1] & 4294967295L) + ((long)y[1] & 4294967295L) + ((long)z[1] & 4294967295L);
      z[1] = (int)c;
      c >>>= 32;
      c += ((long)x[2] & 4294967295L) + ((long)y[2] & 4294967295L) + ((long)z[2] & 4294967295L);
      z[2] = (int)c;
      c >>>= 32;
      c += ((long)x[3] & 4294967295L) + ((long)y[3] & 4294967295L) + ((long)z[3] & 4294967295L);
      z[3] = (int)c;
      c >>>= 32;
      c += ((long)x[4] & 4294967295L) + ((long)y[4] & 4294967295L) + ((long)z[4] & 4294967295L);
      z[4] = (int)c;
      c >>>= 32;
      c += ((long)x[5] & 4294967295L) + ((long)y[5] & 4294967295L) + ((long)z[5] & 4294967295L);
      z[5] = (int)c;
      c >>>= 32;
      c += ((long)x[6] & 4294967295L) + ((long)y[6] & 4294967295L) + ((long)z[6] & 4294967295L);
      z[6] = (int)c;
      c >>>= 32;
      c += ((long)x[7] & 4294967295L) + ((long)y[7] & 4294967295L) + ((long)z[7] & 4294967295L);
      z[7] = (int)c;
      c >>>= 32;
      return (int)c;
   }

   public static void copy(int[] x, int xOff, int[] z, int zOff) {
      z[zOff] = x[xOff];
      z[zOff + 1] = x[xOff + 1];
      z[zOff + 2] = x[xOff + 2];
      z[zOff + 3] = x[xOff + 3];
      z[zOff + 4] = x[xOff + 4];
      z[zOff + 5] = x[xOff + 5];
      z[zOff + 6] = x[xOff + 6];
      z[zOff + 7] = x[xOff + 7];
   }

   public static int[] create() {
      return new int[8];
   }

   public static int[] createExt() {
      return new int[16];
   }

   public static boolean eq(int[] x, int[] y) {
      for(int i = 7; i >= 0; --i) {
         if (x[i] != y[i]) {
            return false;
         }
      }

      return true;
   }

   public static int[] fromBigInteger(BigInteger x) {
      int[] z = create();

      for(int var2 = 0; x.signum() != 0; x = x.shiftRight(32)) {
         z[var2++] = x.intValue();
      }

      return z;
   }

   public static int getBit(int[] x, int bit) {
      if (bit == 0) {
         return x[0] & 1;
      } else if ((bit & 255) != bit) {
         return 0;
      } else {
         int w = bit >>> 5;
         int b = bit & 31;
         return x[w] >>> b & 1;
      }
   }

   public static boolean gte(int[] x, int[] y) {
      for(int i = 7; i >= 0; --i) {
         int x_i = x[i] ^ Integer.MIN_VALUE;
         int y_i = y[i] ^ Integer.MIN_VALUE;
         if (x_i < y_i) {
            return false;
         }

         if (x_i > y_i) {
            return true;
         }
      }

      return true;
   }

   public static boolean isOne(int[] x) {
      if (x[0] != 1) {
         return false;
      } else {
         for(int i = 1; i < 8; ++i) {
            if (x[i] != 0) {
               return false;
            }
         }

         return true;
      }
   }

   public static boolean isZero(int[] x) {
      for(int i = 0; i < 8; ++i) {
         if (x[i] != 0) {
            return false;
         }
      }

      return true;
   }

   public static void mul(int[] x, int[] y, int[] zz) {
      long y_0 = (long)y[0] & 4294967295L;
      long y_2 = (long)y[1] & 4294967295L;
      long y_3 = (long)y[2] & 4294967295L;
      long y_4 = (long)y[3] & 4294967295L;
      long y_5 = (long)y[4] & 4294967295L;
      long y_6 = (long)y[5] & 4294967295L;
      long y_7 = (long)y[6] & 4294967295L;
      long y_8 = (long)y[7] & 4294967295L;
      long c = 0L;
      long x_0 = (long)x[0] & 4294967295L;
      c += x_0 * y_0;
      zz[0] = (int)c;
      c >>>= 32;
      c += x_0 * y_2;
      zz[1] = (int)c;
      c >>>= 32;
      c += x_0 * y_3;
      zz[2] = (int)c;
      c >>>= 32;
      c += x_0 * y_4;
      zz[3] = (int)c;
      c >>>= 32;
      c += x_0 * y_5;
      zz[4] = (int)c;
      c >>>= 32;
      c += x_0 * y_6;
      zz[5] = (int)c;
      c >>>= 32;
      c += x_0 * y_7;
      zz[6] = (int)c;
      c >>>= 32;
      c += x_0 * y_8;
      zz[7] = (int)c;
      c >>>= 32;
      zz[8] = (int)c;

      for(int i = 1; i < 8; ++i) {
         long c2 = 0L;
         long x_i = (long)x[i] & 4294967295L;
         c2 += x_i * y_0 + ((long)zz[i] & 4294967295L);
         zz[i] = (int)c2;
         c2 >>>= 32;
         c2 += x_i * y_2 + ((long)zz[i + 1] & 4294967295L);
         zz[i + 1] = (int)c2;
         c2 >>>= 32;
         c2 += x_i * y_3 + ((long)zz[i + 2] & 4294967295L);
         zz[i + 2] = (int)c2;
         c2 >>>= 32;
         c2 += x_i * y_4 + ((long)zz[i + 3] & 4294967295L);
         zz[i + 3] = (int)c2;
         c2 >>>= 32;
         c2 += x_i * y_5 + ((long)zz[i + 4] & 4294967295L);
         zz[i + 4] = (int)c2;
         c2 >>>= 32;
         c2 += x_i * y_6 + ((long)zz[i + 5] & 4294967295L);
         zz[i + 5] = (int)c2;
         c2 >>>= 32;
         c2 += x_i * y_7 + ((long)zz[i + 6] & 4294967295L);
         zz[i + 6] = (int)c2;
         c2 >>>= 32;
         c2 += x_i * y_8 + ((long)zz[i + 7] & 4294967295L);
         zz[i + 7] = (int)c2;
         c2 >>>= 32;
         zz[i + 8] = (int)c2;
      }

   }

   public static int mulAddTo(int[] x, int[] y, int[] zz) {
      long y_0 = (long)y[0] & 4294967295L;
      long y_2 = (long)y[1] & 4294967295L;
      long y_3 = (long)y[2] & 4294967295L;
      long y_4 = (long)y[3] & 4294967295L;
      long y_5 = (long)y[4] & 4294967295L;
      long y_6 = (long)y[5] & 4294967295L;
      long y_7 = (long)y[6] & 4294967295L;
      long y_8 = (long)y[7] & 4294967295L;
      long zc = 0L;

      for(int i = 0; i < 8; ++i) {
         long c = 0L;
         long x_i = (long)x[i] & 4294967295L;
         c += x_i * y_0 + ((long)zz[i] & 4294967295L);
         zz[i] = (int)c;
         c >>>= 32;
         c += x_i * y_2 + ((long)zz[i + 1] & 4294967295L);
         zz[i + 1] = (int)c;
         c >>>= 32;
         c += x_i * y_3 + ((long)zz[i + 2] & 4294967295L);
         zz[i + 2] = (int)c;
         c >>>= 32;
         c += x_i * y_4 + ((long)zz[i + 3] & 4294967295L);
         zz[i + 3] = (int)c;
         c >>>= 32;
         c += x_i * y_5 + ((long)zz[i + 4] & 4294967295L);
         zz[i + 4] = (int)c;
         c >>>= 32;
         c += x_i * y_6 + ((long)zz[i + 5] & 4294967295L);
         zz[i + 5] = (int)c;
         c >>>= 32;
         c += x_i * y_7 + ((long)zz[i + 6] & 4294967295L);
         zz[i + 6] = (int)c;
         c >>>= 32;
         c += x_i * y_8 + ((long)zz[i + 7] & 4294967295L);
         zz[i + 7] = (int)c;
         c >>>= 32;
         c += zc + ((long)zz[i + 8] & 4294967295L);
         zz[i + 8] = (int)c;
         zc = c >>> 32;
      }

      return (int)zc;
   }

   public static long mul33Add(int w, int[] x, int xOff, int[] y, int yOff, int[] z, int zOff) {
      long c = 0L;
      long wVal = (long)w & 4294967295L;
      long x2 = (long)x[xOff] & 4294967295L;
      c += wVal * x2 + ((long)y[yOff] & 4294967295L);
      z[zOff] = (int)c;
      c >>>= 32;
      long x3 = (long)x[xOff + 1] & 4294967295L;
      c += wVal * x3 + x2 + ((long)y[yOff + 1] & 4294967295L);
      z[zOff + 1] = (int)c;
      c >>>= 32;
      long x4 = (long)x[xOff + 2] & 4294967295L;
      c += wVal * x4 + x3 + ((long)y[yOff + 2] & 4294967295L);
      z[zOff + 2] = (int)c;
      c >>>= 32;
      long x5 = (long)x[xOff + 3] & 4294967295L;
      c += wVal * x5 + x4 + ((long)y[yOff + 3] & 4294967295L);
      z[zOff + 3] = (int)c;
      c >>>= 32;
      long x6 = (long)x[xOff + 4] & 4294967295L;
      c += wVal * x6 + x5 + ((long)y[yOff + 4] & 4294967295L);
      z[zOff + 4] = (int)c;
      c >>>= 32;
      long x7 = (long)x[xOff + 5] & 4294967295L;
      c += wVal * x7 + x6 + ((long)y[yOff + 5] & 4294967295L);
      z[zOff + 5] = (int)c;
      c >>>= 32;
      long x8 = (long)x[xOff + 6] & 4294967295L;
      c += wVal * x8 + x7 + ((long)y[yOff + 6] & 4294967295L);
      z[zOff + 6] = (int)c;
      c >>>= 32;
      long x9 = (long)x[xOff + 7] & 4294967295L;
      c += wVal * x9 + x8 + ((long)y[yOff + 7] & 4294967295L);
      z[zOff + 7] = (int)c;
      c >>>= 32;
      c += x9;
      return c;
   }

   public static int mul33DWordAdd(int x, long y, int[] z, int zOff) {
      long c = 0L;
      long xVal = (long)x & 4294967295L;
      long y2 = y & 4294967295L;
      c += xVal * y2 + ((long)z[zOff] & 4294967295L);
      z[zOff] = (int)c;
      c >>>= 32;
      long y3 = y >>> 32;
      c += xVal * y3 + y2 + ((long)z[zOff + 1] & 4294967295L);
      z[zOff + 1] = (int)c;
      c >>>= 32;
      c += y3 + ((long)z[zOff + 2] & 4294967295L);
      z[zOff + 2] = (int)c;
      c >>>= 32;
      c += (long)z[zOff + 3] & 4294967295L;
      z[zOff + 3] = (int)c;
      c >>>= 32;
      return c == 0L ? 0 : Nat.incAt(8, z, zOff, 4);
   }

   public static int mul33WordAdd(int x, int y, int[] z, int zOff) {
      long c = 0L;
      long xVal = (long)x & 4294967295L;
      long yVal = (long)y & 4294967295L;
      c += yVal * xVal + ((long)z[zOff] & 4294967295L);
      z[zOff] = (int)c;
      c >>>= 32;
      c += yVal + ((long)z[zOff + 1] & 4294967295L);
      z[zOff + 1] = (int)c;
      c >>>= 32;
      c += (long)z[zOff + 2] & 4294967295L;
      z[zOff + 2] = (int)c;
      c >>>= 32;
      return c == 0L ? 0 : Nat.incAt(8, z, zOff, 3);
   }

   public static void square(int[] x, int[] zz) {
      long x_0 = (long)x[0] & 4294967295L;
      int c = 0;
      int i = 7;
      int j = 16;

      long p2;
      long zz_1;
      do {
         p2 = (long)x[i--] & 4294967295L;
         zz_1 = p2 * p2;
         --j;
         zz[j] = c << 31 | (int)(zz_1 >>> 33);
         --j;
         zz[j] = (int)(zz_1 >>> 1);
         c = (int)zz_1;
      } while(i > 0);

      p2 = x_0 * x_0;
      zz_1 = (long)(c << 31) & 4294967295L | p2 >>> 33;
      zz[0] = (int)p2;
      c = (int)(p2 >>> 32) & 1;
      long x_2 = (long)x[1] & 4294967295L;
      long zz_2 = (long)zz[2] & 4294967295L;
      zz_1 += x_2 * x_0;
      int w = (int)zz_1;
      zz[1] = w << 1 | c;
      c = w >>> 31;
      zz_2 += zz_1 >>> 32;
      long x_3 = (long)x[2] & 4294967295L;
      long zz_3 = (long)zz[3] & 4294967295L;
      long zz_4 = (long)zz[4] & 4294967295L;
      zz_2 += x_3 * x_0;
      w = (int)zz_2;
      zz[2] = w << 1 | c;
      c = w >>> 31;
      zz_3 += (zz_2 >>> 32) + x_3 * x_2;
      zz_4 += zz_3 >>> 32;
      zz_3 &= 4294967295L;
      long x_4 = (long)x[3] & 4294967295L;
      long zz_5 = ((long)zz[5] & 4294967295L) + (zz_4 >>> 32);
      zz_4 &= 4294967295L;
      long zz_6 = ((long)zz[6] & 4294967295L) + (zz_5 >>> 32);
      zz_5 &= 4294967295L;
      zz_3 += x_4 * x_0;
      w = (int)zz_3;
      zz[3] = w << 1 | c;
      c = w >>> 31;
      zz_4 += (zz_3 >>> 32) + x_4 * x_2;
      zz_5 += (zz_4 >>> 32) + x_4 * x_3;
      zz_4 &= 4294967295L;
      zz_6 += zz_5 >>> 32;
      zz_5 &= 4294967295L;
      long x_5 = (long)x[4] & 4294967295L;
      long zz_7 = ((long)zz[7] & 4294967295L) + (zz_6 >>> 32);
      zz_6 &= 4294967295L;
      long zz_8 = ((long)zz[8] & 4294967295L) + (zz_7 >>> 32);
      zz_7 &= 4294967295L;
      zz_4 += x_5 * x_0;
      w = (int)zz_4;
      zz[4] = w << 1 | c;
      c = w >>> 31;
      zz_5 += (zz_4 >>> 32) + x_5 * x_2;
      zz_6 += (zz_5 >>> 32) + x_5 * x_3;
      zz_5 &= 4294967295L;
      zz_7 += (zz_6 >>> 32) + x_5 * x_4;
      zz_6 &= 4294967295L;
      zz_8 += zz_7 >>> 32;
      zz_7 &= 4294967295L;
      long x_6 = (long)x[5] & 4294967295L;
      long zz_9 = ((long)zz[9] & 4294967295L) + (zz_8 >>> 32);
      zz_8 &= 4294967295L;
      long zz_10 = ((long)zz[10] & 4294967295L) + (zz_9 >>> 32);
      zz_9 &= 4294967295L;
      zz_5 += x_6 * x_0;
      w = (int)zz_5;
      zz[5] = w << 1 | c;
      c = w >>> 31;
      zz_6 += (zz_5 >>> 32) + x_6 * x_2;
      zz_7 += (zz_6 >>> 32) + x_6 * x_3;
      zz_6 &= 4294967295L;
      zz_8 += (zz_7 >>> 32) + x_6 * x_4;
      zz_7 &= 4294967295L;
      zz_9 += (zz_8 >>> 32) + x_6 * x_5;
      zz_8 &= 4294967295L;
      zz_10 += zz_9 >>> 32;
      zz_9 &= 4294967295L;
      long x_7 = (long)x[6] & 4294967295L;
      long zz_11 = ((long)zz[11] & 4294967295L) + (zz_10 >>> 32);
      zz_10 &= 4294967295L;
      long zz_12 = ((long)zz[12] & 4294967295L) + (zz_11 >>> 32);
      zz_11 &= 4294967295L;
      zz_6 += x_7 * x_0;
      w = (int)zz_6;
      zz[6] = w << 1 | c;
      c = w >>> 31;
      zz_7 += (zz_6 >>> 32) + x_7 * x_2;
      zz_8 += (zz_7 >>> 32) + x_7 * x_3;
      zz_7 &= 4294967295L;
      zz_9 += (zz_8 >>> 32) + x_7 * x_4;
      zz_8 &= 4294967295L;
      zz_10 += (zz_9 >>> 32) + x_7 * x_5;
      zz_9 &= 4294967295L;
      zz_11 += (zz_10 >>> 32) + x_7 * x_6;
      zz_10 &= 4294967295L;
      zz_12 += zz_11 >>> 32;
      zz_11 &= 4294967295L;
      long x_8 = (long)x[7] & 4294967295L;
      long zz_13 = ((long)zz[13] & 4294967295L) + (zz_12 >>> 32);
      zz_12 &= 4294967295L;
      long zz_14 = ((long)zz[14] & 4294967295L) + (zz_13 >>> 32);
      zz_13 &= 4294967295L;
      zz_7 += x_8 * x_0;
      w = (int)zz_7;
      zz[7] = w << 1 | c;
      c = w >>> 31;
      zz_8 += (zz_7 >>> 32) + x_8 * x_2;
      zz_9 += (zz_8 >>> 32) + x_8 * x_3;
      zz_10 += (zz_9 >>> 32) + x_8 * x_4;
      zz_11 += (zz_10 >>> 32) + x_8 * x_5;
      zz_12 += (zz_11 >>> 32) + x_8 * x_6;
      zz_13 += (zz_12 >>> 32) + x_8 * x_7;
      zz_14 += zz_13 >>> 32;
      w = (int)zz_8;
      zz[8] = w << 1 | c;
      c = w >>> 31;
      w = (int)zz_9;
      zz[9] = w << 1 | c;
      c = w >>> 31;
      w = (int)zz_10;
      zz[10] = w << 1 | c;
      c = w >>> 31;
      w = (int)zz_11;
      zz[11] = w << 1 | c;
      c = w >>> 31;
      w = (int)zz_12;
      zz[12] = w << 1 | c;
      c = w >>> 31;
      w = (int)zz_13;
      zz[13] = w << 1 | c;
      c = w >>> 31;
      w = (int)zz_14;
      zz[14] = w << 1 | c;
      c = w >>> 31;
      w = zz[15] + (int)(zz_14 >>> 32);
      zz[15] = w << 1 | c;
   }

   public static int sub(int[] x, int[] y, int[] z) {
      long c = 0L;
      c += ((long)x[0] & 4294967295L) - ((long)y[0] & 4294967295L);
      z[0] = (int)c;
      c >>= 32;
      c += ((long)x[1] & 4294967295L) - ((long)y[1] & 4294967295L);
      z[1] = (int)c;
      c >>= 32;
      c += ((long)x[2] & 4294967295L) - ((long)y[2] & 4294967295L);
      z[2] = (int)c;
      c >>= 32;
      c += ((long)x[3] & 4294967295L) - ((long)y[3] & 4294967295L);
      z[3] = (int)c;
      c >>= 32;
      c += ((long)x[4] & 4294967295L) - ((long)y[4] & 4294967295L);
      z[4] = (int)c;
      c >>= 32;
      c += ((long)x[5] & 4294967295L) - ((long)y[5] & 4294967295L);
      z[5] = (int)c;
      c >>= 32;
      c += ((long)x[6] & 4294967295L) - ((long)y[6] & 4294967295L);
      z[6] = (int)c;
      c >>= 32;
      c += ((long)x[7] & 4294967295L) - ((long)y[7] & 4294967295L);
      z[7] = (int)c;
      c >>= 32;
      return (int)c;
   }

   public static void subFrom(int[] x, int[] z) {
      long c = 0L;
      c += ((long)z[0] & 4294967295L) - ((long)x[0] & 4294967295L);
      z[0] = (int)c;
      c >>= 32;
      c += ((long)z[1] & 4294967295L) - ((long)x[1] & 4294967295L);
      z[1] = (int)c;
      c >>= 32;
      c += ((long)z[2] & 4294967295L) - ((long)x[2] & 4294967295L);
      z[2] = (int)c;
      c >>= 32;
      c += ((long)z[3] & 4294967295L) - ((long)x[3] & 4294967295L);
      z[3] = (int)c;
      c >>= 32;
      c += ((long)z[4] & 4294967295L) - ((long)x[4] & 4294967295L);
      z[4] = (int)c;
      c >>= 32;
      c += ((long)z[5] & 4294967295L) - ((long)x[5] & 4294967295L);
      z[5] = (int)c;
      c >>= 32;
      c += ((long)z[6] & 4294967295L) - ((long)x[6] & 4294967295L);
      z[6] = (int)c;
      c >>= 32;
      c += ((long)z[7] & 4294967295L) - ((long)x[7] & 4294967295L);
      z[7] = (int)c;
   }

   public static BigInteger toBigInteger(int[] x) {
      byte[] bs = new byte[32];

      for(int i = 0; i < 8; ++i) {
         int x_i = x[i];
         if (x_i != 0) {
            Pack.intToBigEndian(x_i, bs, 7 - i << 2);
         }
      }

      return new BigInteger(1, bs);
   }

   public static void zero(int[] z) {
      z[1] = z[0] = 0;
      z[3] = z[2] = 0;
      z[5] = z[4] = 0;
      z[7] = z[6] = 0;
   }
}
