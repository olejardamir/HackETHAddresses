package Keys;

class Nat256 {
    private static final long M = 0xFFFFFFFFL;

    //------------------------------------------------------------------
    static int addBothTo(int[] x, int[] y, int[] z) {
        long c = 0;
        for (int t = 0; t < 8; t++) {
            c += (x[t] & M) + (y[t] & M) + (z[t] & M);
            z[t] = (int) c;
            c >>>= 32;
        }
        return (int) c;
    }
//------------------------------------------------------------------

    static boolean gte(int[] x) {
        for (int i = 7; i >= 0; --i) {
            int x_i = x[i] ^ Integer.MIN_VALUE, y_i = SecP256K1Field.P[i] ^ Integer.MIN_VALUE;
            if (x_i < y_i)
                return false;
            if (x_i > y_i)
                return true;
        }
        return true;
    }

    static boolean isOne(int[] x) {
        if (x[0] != 1)
            return false;
        for (int i = 1; i < 8; ++i)
            if (x[i] != 0)
                return false;
        return true;
    }

    static boolean isZero(int[] x) {
        for (int i = 0; i < 8; ++i) {
            if (x[i] != 0) {
                return false;
            }
        }
        return true;
    }

    //------------------------------------------------------------------
    static int mulAddTo(int[] x, int[] y, int[] zz) {
        long zc = 0;
        for (int i = 0; i < 8; ++i) {
            long c = 0;
            long x_i = x[i] & M;
            for (int t = 0; t < 8; t++) {
                c += x_i * (y[t] & M) + (zz[i + t] & M);
                zz[i + t] = (int) c;
                c >>>= 32;
            }
            c += zc + (zz[i + 8] & M);
            zz[i + 8] = (int) c;
            zc = c >>> 32;
        }
        return (int) zc;
    }
//------------------------------------------------------------------

    static long mul33Add(int[] x, int[] y, int[] z) {


        long c = 0, wVal = 977 & M, x0 = x[8] & M;
        c += x0 * wVal + (y[0] & M);
        z[0] = (int) c;
        c >>>= 32;
        long x1 = x[8 + 1] & M;
        c += x0 + x1 * wVal + (y[1] & M);
        z[1] = (int) c;
        c >>>= 32;
        long x2 = x[8 + 2] & M;
        c += x1 + x2 * wVal + (y[2] & M);
        z[2] = (int) c;
        c >>>= 32;
        long x3 = x[8 + 3] & M;
        c += x2 + x3 * wVal + (y[3] & M);
        z[3] = (int) c;
        c >>>= 32;
        long x4 = x[8 + 4] & M;
        c += x3 + x4 * wVal + (y[4] & M);
        z[4] = (int) c;
        c >>>= 32;
        long x5 = x[8 + 5] & M;
        c += x4 + x5 * wVal + (y[5] & M);
        z[5] = (int) c;
        c >>>= 32;
        long x6 = x[8 + 6] & M;
        c += x5 + x6 * wVal + (y[6] & M);
        z[6] = (int) c;
        c >>>= 32;
        long x7 = x[8 + 7] & M;
        c += x6 + x7 * wVal + (y[7] & M);
        z[7] = (int) c;
        c >>>= 32;
        return c + x7;
    }

    static void mul33DWordAdd(long y, int[] z) {
        long c = 0, xVal = 977 & M, y00 = y & M;
        c += y00 * xVal + (z[0] & M);
        z[0] = (int) c;
        c >>>= 32;
        long y01 = y >>> 32;
        c += y00 + y01 * xVal + (z[1] & M);
        z[1] = (int) c;
        c >>>= 32;
        c += y01 + (z[2] & M);
        z[2] = (int) c;
        c >>>= 32;
        c += (z[3] & M);
        z[3] = (int) c;
    }

    static int mul33WordAdd(int y, int[] z) {
        long c = 0, xVal = 977 & M, yVal = y & M;
        c += yVal * xVal + (z[0] & M);
        z[0] = (int) c;
        c >>>= 32;
        c += yVal + (z[1] & M);
        z[1] = (int) c;
        c >>>= 32;
        c += (z[2] & M);
        z[2] = (int) c;
        return 0;
    }

    static int sub(int[] x, int[] y, int[] z) {
        long c = (x[0] & M) - (y[0] & M);
        z[0] = (int) c;
        c >>= 32;
        c += (x[1] & M) - (y[1] & M);
        z[1] = (int) c;
        c >>= 32;
        c += (x[2] & M) - (y[2] & M);
        z[2] = (int) c;
        c >>= 32;
        c += (x[3] & M) - (y[3] & M);
        z[3] = (int) c;
        c >>= 32;
        c += (x[4] & M) - (y[4] & M);
        z[4] = (int) c;
        c >>= 32;
        c += (x[5] & M) - (y[5] & M);
        z[5] = (int) c;
        c >>= 32;
        c += (x[6] & M) - (y[6] & M);
        z[6] = (int) c;
        c >>= 32;
        c += (x[7] & M) - (y[7] & M);
        z[7] = (int) c;
        c >>= 32;
        return (int) c;
    }

    static void subFrom(int[] z) {
        long c = (z[0] & M) - (SecP256K1Field.P[0] & M);
        z[0] = (int) c;
        c >>= 32;
        c += (z[1] & M) - (SecP256K1Field.P[1] & M);
        z[1] = (int) c;
        c >>= 32;
        c += (z[2] & M) - (SecP256K1Field.P[2] & M);
        z[2] = (int) c;
        c >>= 32;
        c += (z[3] & M) - (SecP256K1Field.P[3] & M);
        z[3] = (int) c;
        c >>= 32;
        c += (z[4] & M) - (SecP256K1Field.P[4] & M);
        z[4] = (int) c;
        c >>= 32;
        c += (z[5] & M) - (SecP256K1Field.P[5] & M);
        z[5] = (int) c;
        c >>= 32;
        c += (z[6] & M) - (SecP256K1Field.P[6] & M);
        z[6] = (int) c;
        c >>= 32;
        c += (z[7] & M) - (SecP256K1Field.P[7] & M);
        z[7] = (int) c;
    }

}
