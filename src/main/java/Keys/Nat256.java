package Keys;
import java.math.BigInteger;

abstract class Nat256 extends Eureqa
{
    private static final long M = 0xFFFFFFFFL;

    //------------------------------------------------------------------
    public static int add(int[] x, int[] y, int[] z)
    {
        long c = 0;
        for(int t=0;t<8;t++){
            c += (x[t] & M) + (y[t] & M);
            z[t] = (int)c;
            c >>>= 32;
        }
        return (int)c;
    }

//------------------------------------------------------------------
    public static int addBothTo(int[] x, int[] y, int[] z)
    {
        long c = 0;
        for(int t=0;t<8;t++) {
            c += (x[t] & M) + (y[t] & M) + (z[t] & M);
            z[t] = (int) c;
            c >>>= 32;
        }
        return (int)c;
    }
//------------------------------------------------------------------


    public static void copy(int[] x, int xOff, int[] z, int zOff)
    {
        for(int t=0;t<8;t++){
            z[zOff + t] = x[xOff + t];
        }

    }
//------------------------------------------------------------------

    public static boolean eq(int[] x, int[] y)
    {
        for (int i = 7; i >= 0; --i)
			if (x[i] != y[i])
				return false;
        return true;
    }
//------------------------------------------------------------------

    public static int[] fromBigInteger(BigInteger x)
    {
        int[] z = new int[8];
        for (int i = 0; x.signum() != 0;) {
			z[i++] = x.intValue();
			x = x.shiftRight(32);
		}
        return z;
    }
//------------------------------------------------------------------

    public static int getBit(int[] x, int bit)
    {
		return bit == 0 ? x[0] & 1 : (bit & 255) != bit ? 0 : (x[(bit >>> 5)] >>> (bit & 31)) & 1;
	}
//------------------------------------------------------------------

    public static boolean gte(int[] x, int[] y)
    {
        for (int i = 7; i >= 0; --i)
        {
            int x_i = x[i] ^ Integer.MIN_VALUE, y_i = y[i] ^ Integer.MIN_VALUE;
            if (x_i < y_i)
                return false;
            if (x_i > y_i)
                return true;
        }
        return true;
    }

    public static boolean isOne(int[] x)
    {
        if (x[0] != 1)
			return false;
        for (int i = 1; i < 8; ++i)
			if (x[i] != 0)
				return false;
        return true;
    }

    public static boolean isZero(int[] x)
    {
        for (int i = 0; i < 8; ++i) {
            if (x[i] != 0) {
                return false;
            }
        }
        return true;
    }
//------------------------------------------------------------------
    public static int mulAddTo(int[] x, int[] y, int[] zz)
    {
        long zc = 0;
        for (int i = 0; i < 8; ++i)
        {
            long c = 0;
            long x_i = x[i] & M;
            for(int t=0;t<8;t++) {
                c += x_i * (y[t] & M) + (zz[i+t] & M);
                zz[i+t] = (int) c;
                c >>>= 32;
            }
            c += zc + (zz[i + 8] & M);
            zz[i + 8] = (int)c;
            zc = c >>> 32;
        }
        return (int)zc;
    }
//------------------------------------------------------------------

    public static long mul33Add(int w, int[] x, int xOff, int[] y, int yOff, int[] z, int zOff)
    {
        

        long c = 0, wVal = w & M, x0 = x[xOff] & M;
        c += x0 * wVal + (y[yOff] & M);
        z[zOff] = (int)c;
        c >>>= 32;
        long x1 = x[xOff + 1] & M;
        c += x0 + x1 * wVal + (y[yOff + 1] & M);
        z[zOff + 1] = (int)c;
        c >>>= 32;
        long x2 = x[xOff + 2] & M;
        c += x1 + x2 * wVal + (y[yOff + 2] & M);
        z[zOff + 2] = (int)c;
        c >>>= 32;
        long x3 = x[xOff + 3] & M;
        c += x2 + x3 * wVal + (y[yOff + 3] & M);
        z[zOff + 3] = (int)c;
        c >>>= 32;
        long x4 = x[xOff + 4] & M;
        c += x3 + x4 * wVal + (y[yOff + 4] & M);
        z[zOff + 4] = (int)c;
        c >>>= 32;
        long x5 = x[xOff + 5] & M;
        c += x4 + x5 * wVal + (y[yOff + 5] & M);
        z[zOff + 5] = (int)c;
        c >>>= 32;
        long x6 = x[xOff + 6] & M;
        c += x5 + x6 * wVal + (y[yOff + 6] & M);
        z[zOff + 6] = (int)c;
        c >>>= 32;
        long x7 = x[xOff + 7] & M;
        c += x6 + x7 * wVal + (y[yOff + 7] & M);
        z[zOff + 7] = (int)c;
        c >>>= 32;
        return c + x7;
    }

    public static void mul33DWordAdd(int x, long y, int[] z, int zOff)
    {
        long c = 0, xVal = x & M, y00 = y & M;
        c += y00 * xVal + (z[zOff] & M);
        z[zOff] = (int)c;
        c >>>= 32;
        long y01 = y >>> 32;
        c += y00 + y01 * xVal + (z[zOff + 1] & M);
        z[zOff + 1] = (int)c;
        c >>>= 32;
        c += y01 + (z[zOff + 2] & M);
        z[zOff + 2] = (int)c;
        c >>>= 32;
        c += (z[zOff + 3] & M);
        z[zOff + 3] = (int)c;
    }

    public static int mul33WordAdd(int x, int y, int[] z, int zOff)
    {
        long c = 0, xVal = x & M, yVal = y & M;
        c += yVal * xVal + (z[zOff] & M);
        z[zOff] = (int)c;
        c >>>= 32;
        c += yVal + (z[zOff + 1] & M);
        z[zOff + 1] = (int)c;
        c >>>= 32;
        c += (z[zOff + 2] & M);
        z[zOff + 2] = (int)c;
         return 0;
    }

    public static void square(int[] x, int[] zz)
    {
		long x_0 = x[0] & M;
		long zz_1;
		int c = 0, w;
		int i = 7, j = 16;
		do {
			long xVal = (x[i--] & M);
			long p = xVal * xVal;
			zz[--j] = (c << 31) | (int) (p >>> 33);
			zz[--j] = (int) (p >>> 1);
			c = (int) p;
		} while (i > 0);
		long p = x_0 * x_0;
		zz_1 = ((c << 31) & M) | (p >>> 33);
		zz[0] = (int) p;
		c = (int) (p >>> 32) & 1;
		long x_1 = x[1] & M;
		long zz_2 = zz[2] & M;
		zz_1 += x_1 * x_0;
		w = (int) zz_1;
		zz[1] = (w << 1) | c;
		c = w >>> 31;
		zz_2 += zz_1 >>> 32;
		long x_2 = x[2] & M;
		long zz_3 = zz[3] & M;
		long zz_4 = zz[4] & M;
		zz_2 += x_2 * x_0;
		w = (int) zz_2;
		zz[2] = (w << 1) | c;
		c = w >>> 31;
		zz_3 += (zz_2 >>> 32) + x_2 * x_1;
		zz_4 += zz_3 >>> 32;
		zz_3 &= 0xFFFFFFFFL;
		long x_3 = x[3] & M;
		long zz_5 = (zz[5] & M) + (zz_4 >>> 32);
		zz_4 &= 0xFFFFFFFFL;
		long zz_6 = (zz[6] & M) + (zz_5 >>> 32);
		zz_5 &= 0xFFFFFFFFL;
		zz_3 += x_3 * x_0;
		w = (int) zz_3;
		zz[3] = (w << 1) | c;
		c = w >>> 31;
		zz_4 += (zz_3 >>> 32) + x_3 * x_1;
		zz_5 += (zz_4 >>> 32) + x_3 * x_2;
		zz_4 &= 0xFFFFFFFFL;
		zz_6 += zz_5 >>> 32;
		zz_5 &= 0xFFFFFFFFL;
		long x_4 = x[4] & M;
		long zz_7 = (zz[7] & M) + (zz_6 >>> 32);
		zz_6 &= 0xFFFFFFFFL;
		long zz_8 = (zz[8] & M) + (zz_7 >>> 32);
		zz_7 &= 0xFFFFFFFFL;
		zz_4 += x_4 * x_0;
		w = (int) zz_4;
		zz[4] = (w << 1) | c;
		c = w >>> 31;
		zz_5 += (zz_4 >>> 32) + x_4 * x_1;
		zz_6 += (zz_5 >>> 32) + x_4 * x_2;
		zz_5 &= 0xFFFFFFFFL;
		zz_7 += (zz_6 >>> 32) + x_4 * x_3;
		zz_6 &= 0xFFFFFFFFL;
		zz_8 += zz_7 >>> 32;
		zz_7 &= 0xFFFFFFFFL;
		long x_5 = x[5] & M;
		long zz_9 = (zz[9] & M) + (zz_8 >>> 32);
		zz_8 &= 0xFFFFFFFFL;
		long zz_10 = (zz[10] & M) + (zz_9 >>> 32);
		zz_9 &= 0xFFFFFFFFL;
		zz_5 += x_5 * x_0;
		w = (int) zz_5;
		zz[5] = (w << 1) | c;
		c = w >>> 31;
		zz_6 += (zz_5 >>> 32) + x_5 * x_1;
		zz_7 += (zz_6 >>> 32) + x_5 * x_2;
		zz_6 &= 0xFFFFFFFFL;
		zz_8 += (zz_7 >>> 32) + x_5 * x_3;
		zz_7 &= 0xFFFFFFFFL;
		zz_9 += (zz_8 >>> 32) + x_5 * x_4;
		zz_8 &= 0xFFFFFFFFL;
		zz_10 += zz_9 >>> 32;
		zz_9 &= 0xFFFFFFFFL;
		long x_6 = x[6] & M;
		long zz_11 = (zz[11] & M) + (zz_10 >>> 32);
		zz_10 &= 0xFFFFFFFFL;
		long zz_12 = (zz[12] & M) + (zz_11 >>> 32);
		zz_11 &= 0xFFFFFFFFL;
		zz_6 += x_6 * x_0;
		w = (int) zz_6;
		zz[6] = (w << 1) | c;
		c = w >>> 31;
		zz_7 += (zz_6 >>> 32) + x_6 * x_1;
		zz_8 += (zz_7 >>> 32) + x_6 * x_2;
		zz_7 &= 0xFFFFFFFFL;
		zz_9 += (zz_8 >>> 32) + x_6 * x_3;
		zz_8 &= 0xFFFFFFFFL;
		zz_10 += (zz_9 >>> 32) + x_6 * x_4;
		zz_9 &= 0xFFFFFFFFL;
		zz_11 += (zz_10 >>> 32) + x_6 * x_5;
		zz_10 &= 0xFFFFFFFFL;
		zz_12 += zz_11 >>> 32;
		zz_11 &= 0xFFFFFFFFL;
		long x_7 = x[7] & M;
		long zz_13 = (zz[13] & M) + (zz_12 >>> 32);
		zz_12 &= 0xFFFFFFFFL;
		long zz_14 = (zz[14] & M) + (zz_13 >>> 32);
		zz_13 &= 0xFFFFFFFFL;
		zz_7 += x_7 * x_0;
		w = (int) zz_7;
		zz[7] = (w << 1) | c;
		c = w >>> 31;
		zz_8 += (zz_7 >>> 32) + x_7 * x_1;
		zz_9 += (zz_8 >>> 32) + x_7 * x_2;
		zz_10 += (zz_9 >>> 32) + x_7 * x_3;
		zz_11 += (zz_10 >>> 32) + x_7 * x_4;
		zz_12 += (zz_11 >>> 32) + x_7 * x_5;
		zz_13 += (zz_12 >>> 32) + x_7 * x_6;
		zz_14 += zz_13 >>> 32;
		w = (int) zz_8;
		zz[8] = (w << 1) | c;
		c = w >>> 31;
		w = (int) zz_9;
		zz[9] = (w << 1) | c;
		c = w >>> 31;
		w = (int) zz_10;
		zz[10] = (w << 1) | c;
		c = w >>> 31;
		w = (int) zz_11;
		zz[11] = (w << 1) | c;
		c = w >>> 31;
		w = (int) zz_12;
		zz[12] = (w << 1) | c;
		c = w >>> 31;
		w = (int) zz_13;
		zz[13] = (w << 1) | c;
		c = w >>> 31;
		w = (int) zz_14;
		zz[14] = (w << 1) | c;
		c = w >>> 31;
		w = zz[15] + (int) (zz_14 >>> 32);
		zz[15] = (w << 1) | c;
	}

    public static int sub(int[] x, int[] y, int[] z)
    {
        long c = 0 + (x[0] & M) - (y[0] & M);
        z[0] = (int)c;
        c >>= 32;
        c += (x[1] & M) - (y[1] & M);
        z[1] = (int)c;
        c >>= 32;
        c += (x[2] & M) - (y[2] & M);
        z[2] = (int)c;
        c >>= 32;
        c += (x[3] & M) - (y[3] & M);
        z[3] = (int)c;
        c >>= 32;
        c += (x[4] & M) - (y[4] & M);
        z[4] = (int)c;
        c >>= 32;
        c += (x[5] & M) - (y[5] & M);
        z[5] = (int)c;
        c >>= 32;
        c += (x[6] & M) - (y[6] & M);
        z[6] = (int)c;
        c >>= 32;
        c += (x[7] & M) - (y[7] & M);
        z[7] = (int)c;
        c >>= 32;
        return (int)c;
    }

    public static void subFrom(int[] x, int[] z)
    {
        long c = (z[0] & M) - (x[0] & M);
        z[0] = (int)c;
        c >>= 32;
        c += (z[1] & M) - (x[1] & M);
        z[1] = (int)c;
        c >>= 32;
        c += (z[2] & M) - (x[2] & M);
        z[2] = (int)c;
        c >>= 32;
        c += (z[3] & M) - (x[3] & M);
        z[3] = (int)c;
        c >>= 32;
        c += (z[4] & M) - (x[4] & M);
        z[4] = (int)c;
        c >>= 32;
        c += (z[5] & M) - (x[5] & M);
        z[5] = (int)c;
        c >>= 32;
        c += (z[6] & M) - (x[6] & M);
        z[6] = (int)c;
        c >>= 32;
        c += (z[7] & M) - (x[7] & M);
        z[7] = (int)c;
    }

    public static BigInteger toBigInteger(int[] x)
    {
        byte[] bs = new byte[32];
        for (int i = 0; i < 8; ++i)
			if (x[i] != 0)
				Pack.intToBigEndian(x[i], bs, (7 - i) << 2);
        return new BigInteger(1, bs);
    }

    public static void zero(int[] z)
    {
        z[7] = z[6] = 0;
    }
}
