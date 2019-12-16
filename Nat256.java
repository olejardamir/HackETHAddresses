import java.math.BigInteger;

@SuppressWarnings("ALL")
abstract class Nat256
{
    private static final long M = 0xFFFFFFFFL;

    public static int add(int[] x, int[] y, int[] z)
    {
        long c = 0;
        c += (x[0] & 0xFFFFFFFFL) + (y[0] & 0xFFFFFFFFL);
        z[0] = (int)c;
        c >>>= 32;
        c += (x[1] & 0xFFFFFFFFL) + (y[1] & 0xFFFFFFFFL);
        z[1] = (int)c;
        c >>>= 32;
        c += (x[2] & 0xFFFFFFFFL) + (y[2] & 0xFFFFFFFFL);
        z[2] = (int)c;
        c >>>= 32;
        c += (x[3] & 0xFFFFFFFFL) + (y[3] & 0xFFFFFFFFL);
        z[3] = (int)c;
        c >>>= 32;
        c += (x[4] & 0xFFFFFFFFL) + (y[4] & 0xFFFFFFFFL);
        z[4] = (int)c;
        c >>>= 32;
        c += (x[5] & 0xFFFFFFFFL) + (y[5] & 0xFFFFFFFFL);
        z[5] = (int)c;
        c >>>= 32;
        c += (x[6] & 0xFFFFFFFFL) + (y[6] & 0xFFFFFFFFL);
        z[6] = (int)c;
        c >>>= 32;
        c += (x[7] & 0xFFFFFFFFL) + (y[7] & 0xFFFFFFFFL);
        z[7] = (int)c;
        c >>>= 32;
        return (int)c;
    }

    public static int addBothTo(int[] x, int[] y, int[] z)
    {
        long c = 0;
        c += (x[0] & 0xFFFFFFFFL) + (y[0] & 0xFFFFFFFFL) + (z[0] & 0xFFFFFFFFL);
        z[0] = (int)c;
        c >>>= 32;
        c += (x[1] & 0xFFFFFFFFL) + (y[1] & 0xFFFFFFFFL) + (z[1] & 0xFFFFFFFFL);
        z[1] = (int)c;
        c >>>= 32;
        c += (x[2] & 0xFFFFFFFFL) + (y[2] & 0xFFFFFFFFL) + (z[2] & 0xFFFFFFFFL);
        z[2] = (int)c;
        c >>>= 32;
        c += (x[3] & 0xFFFFFFFFL) + (y[3] & 0xFFFFFFFFL) + (z[3] & 0xFFFFFFFFL);
        z[3] = (int)c;
        c >>>= 32;
        c += (x[4] & 0xFFFFFFFFL) + (y[4] & 0xFFFFFFFFL) + (z[4] & 0xFFFFFFFFL);
        z[4] = (int)c;
        c >>>= 32;
        c += (x[5] & 0xFFFFFFFFL) + (y[5] & 0xFFFFFFFFL) + (z[5] & 0xFFFFFFFFL);
        z[5] = (int)c;
        c >>>= 32;
        c += (x[6] & 0xFFFFFFFFL) + (y[6] & 0xFFFFFFFFL) + (z[6] & 0xFFFFFFFFL);
        z[6] = (int)c;
        c >>>= 32;
        c += (x[7] & 0xFFFFFFFFL) + (y[7] & 0xFFFFFFFFL) + (z[7] & 0xFFFFFFFFL);
        z[7] = (int)c;
        c >>>= 32;
        return (int)c;
    }

    public static void copy(int[] x, int xOff, int[] z, int zOff)
    {
        z[zOff] = x[xOff];
        z[zOff + 1] = x[xOff + 1];
        z[zOff + 2] = x[xOff + 2];
        z[zOff + 3] = x[xOff + 3];
        z[zOff + 4] = x[xOff + 4];
        z[zOff + 5] = x[xOff + 5];
        z[zOff + 6] = x[xOff + 6];
        z[zOff + 7] = x[xOff + 7];
    }

    public static boolean eq(int[] x, int[] y)
    {
        for (int i = 7; i >= 0; --i)
        {
            if (x[i] != y[i])
            {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger x)
    {


        int[] z = new int[8];
        int i = 0;
        while (x.signum() != 0)
        {
            z[i++] = x.intValue();
            x = x.shiftRight(32);
        }
        return z;
    }

    public static int getBit(int[] x, int bit)
    {
        if (bit == 0)
        {
            return x[0] & 1;
        }
        if ((bit & 255) != bit)
        {
            return 0;
        }
        int w = bit >>> 5;
        int b = bit & 31;
        return (x[w] >>> b) & 1;
    }

    public static boolean gte(int[] x, int[] y)
    {
        for (int i = 7; i >= 0; --i)
        {
            int x_i = x[i] ^ Integer.MIN_VALUE;
            int y_i = y[i] ^ Integer.MIN_VALUE;
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
        {
            return false;
        }
        for (int i = 1; i < 8; ++i)
        {
            if (x[i] != 0)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] x)
    {
        for (int i = 0; i < 8; ++i)
        {
            if (x[i] != 0)
            {
                return false;
            }
        }
        return true;
    }

    public static int mulAddTo(int[] x, int[] y, int[] zz)
    {
        long y_0 = y[0] & 0xFFFFFFFFL;
        long y_1 = y[1] & 0xFFFFFFFFL;
        long y_2 = y[2] & 0xFFFFFFFFL;
        long y_3 = y[3] & 0xFFFFFFFFL;
        long y_4 = y[4] & 0xFFFFFFFFL;
        long y_5 = y[5] & 0xFFFFFFFFL;
        long y_6 = y[6] & 0xFFFFFFFFL;
        long y_7 = y[7] & 0xFFFFFFFFL;

        long zc = 0;
        for (int i = 0; i < 8; ++i)
        {
            long c = 0, x_i = x[i] & 0xFFFFFFFFL;
            c += x_i * y_0 + (zz[i] & 0xFFFFFFFFL);
            zz[i] = (int)c;
            c >>>= 32;
            c += x_i * y_1 + (zz[i + 1] & 0xFFFFFFFFL);
            zz[i + 1] = (int)c;
            c >>>= 32;
            c += x_i * y_2 + (zz[i + 2] & 0xFFFFFFFFL);
            zz[i + 2] = (int)c;
            c >>>= 32;
            c += x_i * y_3 + (zz[i + 3] & 0xFFFFFFFFL);
            zz[i + 3] = (int)c;
            c >>>= 32;
            c += x_i * y_4 + (zz[i + 4] & 0xFFFFFFFFL);
            zz[i + 4] = (int)c;
            c >>>= 32;
            c += x_i * y_5 + (zz[i + 5] & 0xFFFFFFFFL);
            zz[i + 5] = (int)c;
            c >>>= 32;
            c += x_i * y_6 + (zz[i + 6] & 0xFFFFFFFFL);
            zz[i + 6] = (int)c;
            c >>>= 32;
            c += x_i * y_7 + (zz[i + 7] & 0xFFFFFFFFL);
            zz[i + 7] = (int)c;
            c >>>= 32;
            c += zc + (zz[i + 8] & 0xFFFFFFFFL);
            zz[i + 8] = (int)c;
            zc = c >>> 32;
        }
        return (int)zc;
    }

    public static long mul33Add(int w, int[] x, int xOff, int[] y, int yOff, int[] z, int zOff)
    {
        

        long c = 0, wVal = w & 0xFFFFFFFFL;
        long x0 = x[xOff] & 0xFFFFFFFFL;
        c += wVal * x0 + (y[yOff] & 0xFFFFFFFFL);
        z[zOff] = (int)c;
        c >>>= 32;
        long x1 = x[xOff + 1] & 0xFFFFFFFFL;
        c += wVal * x1 + x0 + (y[yOff + 1] & 0xFFFFFFFFL);
        z[zOff + 1] = (int)c;
        c >>>= 32;
        long x2 = x[xOff + 2] & 0xFFFFFFFFL;
        c += wVal * x2 + x1 + (y[yOff + 2] & 0xFFFFFFFFL);
        z[zOff + 2] = (int)c;
        c >>>= 32;
        long x3 = x[xOff + 3] & 0xFFFFFFFFL;
        c += wVal * x3 + x2 + (y[yOff + 3] & 0xFFFFFFFFL);
        z[zOff + 3] = (int)c;
        c >>>= 32;
        long x4 = x[xOff + 4] & 0xFFFFFFFFL;
        c += wVal * x4 + x3 + (y[yOff + 4] & 0xFFFFFFFFL);
        z[zOff + 4] = (int)c;
        c >>>= 32;
        long x5 = x[xOff + 5] & 0xFFFFFFFFL;
        c += wVal * x5 + x4 + (y[yOff + 5] & 0xFFFFFFFFL);
        z[zOff + 5] = (int)c;
        c >>>= 32;
        long x6 = x[xOff + 6] & 0xFFFFFFFFL;
        c += wVal * x6 + x5 + (y[yOff + 6] & 0xFFFFFFFFL);
        z[zOff + 6] = (int)c;
        c >>>= 32;
        long x7 = x[xOff + 7] & 0xFFFFFFFFL;
        c += wVal * x7 + x6 + (y[yOff + 7] & 0xFFFFFFFFL);
        z[zOff + 7] = (int)c;
        c >>>= 32;
        c += x7;
        return c;
    }

    public static void mul33DWordAdd(int x, long y, int[] z, int zOff)
    {
        long c = 0, xVal = x & 0xFFFFFFFFL;
        long y00 = y & 0xFFFFFFFFL;
        c += xVal * y00 + (z[zOff] & 0xFFFFFFFFL);
        z[zOff] = (int)c;
        c >>>= 32;
        long y01 = y >>> 32;
        c += xVal * y01 + y00 + (z[zOff + 1] & 0xFFFFFFFFL);
        z[zOff + 1] = (int)c;
        c >>>= 32;
        c += y01 + (z[zOff + 2] & 0xFFFFFFFFL);
        z[zOff + 2] = (int)c;
        c >>>= 32;
        c += (z[zOff + 3] & 0xFFFFFFFFL);
        z[zOff + 3] = (int)c;
    }

    public static int mul33WordAdd(int x, int y, int[] z, int zOff)
    {
        long c = 0, xVal = x & 0xFFFFFFFFL, yVal = y & 0xFFFFFFFFL;
        c += yVal * xVal + (z[zOff] & 0xFFFFFFFFL);
        z[zOff] = (int)c;
        c >>>= 32;
        c += yVal + (z[zOff + 1] & 0xFFFFFFFFL);
        z[zOff + 1] = (int)c;
        c >>>= 32;
        c += (z[zOff + 2] & 0xFFFFFFFFL);
        z[zOff + 2] = (int)c;
         return 0;
    }

    public static void square(int[] x, int[] zz)
    {
        long x_0 = x[0] & 0xFFFFFFFFL;
        long zz_1;

        int c = 0, w;
        {
            int i = 7, j = 16;
            do
            {
                long xVal = (x[i--] & 0xFFFFFFFFL);
                long p = xVal * xVal;
                zz[--j] = (c << 31) | (int)(p >>> 33);
                zz[--j] = (int)(p >>> 1);
                c = (int)p;
            }
            while (i > 0);

            {
                long p = x_0 * x_0;
                zz_1 = ((c << 31) & 0xFFFFFFFFL) | (p >>> 33);
                zz[0] = (int)p;
                c = (int)(p >>> 32) & 1;
            }
        }

        long x_1 = x[1] & 0xFFFFFFFFL;
        long zz_2 = zz[2] & 0xFFFFFFFFL;

        {
            zz_1 += x_1 * x_0;
            w = (int)zz_1;
            zz[1] = (w << 1) | c;
            c = w >>> 31;
            zz_2 += zz_1 >>> 32;
        }

        long x_2 = x[2] & 0xFFFFFFFFL;
        long zz_3 = zz[3] & 0xFFFFFFFFL;
        long zz_4 = zz[4] & 0xFFFFFFFFL;
        {
            zz_2 += x_2 * x_0;
            w = (int)zz_2;
            zz[2] = (w << 1) | c;
            c = w >>> 31;
            zz_3 += (zz_2 >>> 32) + x_2 * x_1;
            zz_4 += zz_3 >>> 32;
            zz_3 &= 0xFFFFFFFFL;
        }

        long x_3 = x[3] & 0xFFFFFFFFL;
        long zz_5 = (zz[5] & 0xFFFFFFFFL) + (zz_4 >>> 32); zz_4 &= 0xFFFFFFFFL;
        long zz_6 = (zz[6] & 0xFFFFFFFFL) + (zz_5 >>> 32); zz_5 &= 0xFFFFFFFFL;
        {
            zz_3 += x_3 * x_0;
            w = (int)zz_3;
            zz[3] = (w << 1) | c;
            c = w >>> 31;
            zz_4 += (zz_3 >>> 32) + x_3 * x_1;
            zz_5 += (zz_4 >>> 32) + x_3 * x_2;
            zz_4 &= 0xFFFFFFFFL;
            zz_6 += zz_5 >>> 32;
            zz_5 &= 0xFFFFFFFFL;
        }

        long x_4 = x[4] & 0xFFFFFFFFL;
        long zz_7 = (zz[7] & 0xFFFFFFFFL) + (zz_6 >>> 32); zz_6 &= 0xFFFFFFFFL;
        long zz_8 = (zz[8] & 0xFFFFFFFFL) + (zz_7 >>> 32); zz_7 &= 0xFFFFFFFFL;
        {
            zz_4 += x_4 * x_0;
            w = (int)zz_4;
            zz[4] = (w << 1) | c;
            c = w >>> 31;
            zz_5 += (zz_4 >>> 32) + x_4 * x_1;
            zz_6 += (zz_5 >>> 32) + x_4 * x_2;
            zz_5 &= 0xFFFFFFFFL;
            zz_7 += (zz_6 >>> 32) + x_4 * x_3;
            zz_6 &= 0xFFFFFFFFL;
            zz_8 += zz_7 >>> 32;
            zz_7 &= 0xFFFFFFFFL;
        }

        long x_5 = x[5] & 0xFFFFFFFFL;
        long zz_9 = (zz[9] & 0xFFFFFFFFL) + (zz_8 >>> 32); zz_8 &= 0xFFFFFFFFL;
        long zz_10 = (zz[10] & 0xFFFFFFFFL) + (zz_9 >>> 32); zz_9 &= 0xFFFFFFFFL;
        {
            zz_5 += x_5 * x_0;
            w = (int)zz_5;
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
        }

        long x_6 = x[6] & 0xFFFFFFFFL;
        long zz_11 = (zz[11] & 0xFFFFFFFFL) + (zz_10 >>> 32); zz_10 &= 0xFFFFFFFFL;
        long zz_12 = (zz[12] & 0xFFFFFFFFL) + (zz_11 >>> 32); zz_11 &= 0xFFFFFFFFL;
        {
            zz_6 += x_6 * x_0;
            w = (int)zz_6;
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
        }

        long x_7 = x[7] & 0xFFFFFFFFL;
        long zz_13 = (zz[13] & 0xFFFFFFFFL) + (zz_12 >>> 32); zz_12 &= 0xFFFFFFFFL;
        long zz_14 = (zz[14] & 0xFFFFFFFFL) + (zz_13 >>> 32); zz_13 &= 0xFFFFFFFFL;
        {
            zz_7 += x_7 * x_0;
            w = (int)zz_7;
            zz[7] = (w << 1) | c;
            c = w >>> 31;
            zz_8 += (zz_7 >>> 32) + x_7 * x_1;
            zz_9 += (zz_8 >>> 32) + x_7 * x_2;
            zz_10 += (zz_9 >>> 32) + x_7 * x_3;
            zz_11 += (zz_10 >>> 32) + x_7 * x_4;
            zz_12 += (zz_11 >>> 32) + x_7 * x_5;
            zz_13 += (zz_12 >>> 32) + x_7 * x_6;
            zz_14 += zz_13 >>> 32;
        }

        w = (int)zz_8;
        zz[8] = (w << 1) | c;
        c = w >>> 31;
        w = (int)zz_9;
        zz[9] = (w << 1) | c;
        c = w >>> 31;
        w = (int)zz_10;
        zz[10] = (w << 1) | c;
        c = w >>> 31;
        w = (int)zz_11;
        zz[11] = (w << 1) | c;
        c = w >>> 31;
        w = (int)zz_12;
        zz[12] = (w << 1) | c;
        c = w >>> 31;
        w = (int)zz_13;
        zz[13] = (w << 1) | c;
        c = w >>> 31;
        w = (int)zz_14;
        zz[14] = (w << 1) | c;
        c = w >>> 31;
        w = zz[15] + (int)(zz_14 >>> 32);
        zz[15] = (w << 1) | c;
    }

    public static int sub(int[] x, int[] y, int[] z)
    {
        long c = 0;
        c += (x[0] & 0xFFFFFFFFL) - (y[0] & 0xFFFFFFFFL);
        z[0] = (int)c;
        c >>= 32;
        c += (x[1] & 0xFFFFFFFFL) - (y[1] & 0xFFFFFFFFL);
        z[1] = (int)c;
        c >>= 32;
        c += (x[2] & 0xFFFFFFFFL) - (y[2] & 0xFFFFFFFFL);
        z[2] = (int)c;
        c >>= 32;
        c += (x[3] & 0xFFFFFFFFL) - (y[3] & 0xFFFFFFFFL);
        z[3] = (int)c;
        c >>= 32;
        c += (x[4] & 0xFFFFFFFFL) - (y[4] & 0xFFFFFFFFL);
        z[4] = (int)c;
        c >>= 32;
        c += (x[5] & 0xFFFFFFFFL) - (y[5] & 0xFFFFFFFFL);
        z[5] = (int)c;
        c >>= 32;
        c += (x[6] & 0xFFFFFFFFL) - (y[6] & 0xFFFFFFFFL);
        z[6] = (int)c;
        c >>= 32;
        c += (x[7] & 0xFFFFFFFFL) - (y[7] & 0xFFFFFFFFL);
        z[7] = (int)c;
        c >>= 32;
        return (int)c;
    }

    public static void subFrom(int[] x, int[] z)
    {
        long c = 0;
        c += (z[0] & 0xFFFFFFFFL) - (x[0] & 0xFFFFFFFFL);
        z[0] = (int)c;
        c >>= 32;
        c += (z[1] & 0xFFFFFFFFL) - (x[1] & 0xFFFFFFFFL);
        z[1] = (int)c;
        c >>= 32;
        c += (z[2] & 0xFFFFFFFFL) - (x[2] & 0xFFFFFFFFL);
        z[2] = (int)c;
        c >>= 32;
        c += (z[3] & 0xFFFFFFFFL) - (x[3] & 0xFFFFFFFFL);
        z[3] = (int)c;
        c >>= 32;
        c += (z[4] & 0xFFFFFFFFL) - (x[4] & 0xFFFFFFFFL);
        z[4] = (int)c;
        c >>= 32;
        c += (z[5] & 0xFFFFFFFFL) - (x[5] & 0xFFFFFFFFL);
        z[5] = (int)c;
        c >>= 32;
        c += (z[6] & 0xFFFFFFFFL) - (x[6] & 0xFFFFFFFFL);
        z[6] = (int)c;
        c >>= 32;
        c += (z[7] & 0xFFFFFFFFL) - (x[7] & 0xFFFFFFFFL);
        z[7] = (int)c;
    }

    public static BigInteger toBigInteger(int[] x)
    {
        byte[] bs = new byte[32];
        for (int i = 0; i < 8; ++i)
        {
            int x_i = x[i];
            if (x_i != 0)
            {
                Pack.intToBigEndian(x_i, bs, (7 - i) << 2);
            }
        }
        return new BigInteger(1, bs);
    }

    public static void zero(int[] z)
    {
        z[0] = 0;
        z[1] = 0;
        z[2] = 0;
        z[3] = 0;
        z[4] = 0;
        z[5] = 0;
        z[6] = 0;
        z[7] = 0;
    }
}
