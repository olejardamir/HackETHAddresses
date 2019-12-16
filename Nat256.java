import java.math.BigInteger;

abstract class Nat256
{

    public static int add(int[] x, int[] y, int[] z)
    {
        long c;
		c = (x[0] & 0xFFFFFFFFL) + (y[0] & 0xFFFFFFFFL);
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
        long c;
		c = (x[0] & 0xFFFFFFFFL) + (y[0] & 0xFFFFFFFFL) + (z[0] & 0xFFFFFFFFL);
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
        for (int i = 7; i >= 0; i -= 1) {
			if (x[i] != y[i]) {
				return false;
			}
		}
        return true;
    }

    public static int[] fromBigInteger(BigInteger x)
    {


        int[] z;
		z = new int[8];
		for (int i = 0; x.signum() != 0;) {
			z[i] = x.intValue();
			i++;
			x = x.shiftRight(32);
		}
        return z;
    }

    public static boolean gte(int[] x, int[] y)
    {
        for (int i = 7; i >= 0; i -= 1)
        {
            int x_i;
			x_i = x[i] ^ Integer.MIN_VALUE;
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
			return false;
        for (int i = 1; i < 8; ++i)
			if (x[i] != 0)
				return false;
        return true;
    }

    public static boolean isZero(int[] x)
    {
        for (int i = 0; i < 8; ++i)
			if (x[i] != 0)
				return false;
        return true;
    }

    public static int mulAddTo(int[] x, int[] y, int[] zz)
    {
        long y_0 = y[0] & 0xFFFFFFFFL, y_1 = y[1] & 0xFFFFFFFFL, y_2 = y[2] & 0xFFFFFFFFL, y_3 = y[3] & 0xFFFFFFFFL,
				y_4 = y[4] & 0xFFFFFFFFL, y_5 = y[5] & 0xFFFFFFFFL, y_6 = y[6] & 0xFFFFFFFFL, y_7 = y[7] & 0xFFFFFFFFL,
				zc = 0;
        
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
        

        long c = 0, wVal = w & 0xFFFFFFFFL, x0 = x[xOff] & 0xFFFFFFFFL;
        c += x0 * wVal + (y[yOff] & 0xFFFFFFFFL);
        z[zOff] = (int)c;
        c >>>= 32;
        long x1 = x[xOff + 1] & 0xFFFFFFFFL;
        c += x0 + x1 * wVal + (y[yOff + 1] & 0xFFFFFFFFL);
        z[zOff + 1] = (int)c;
        c >>>= 32;
        long x2 = x[xOff + 2] & 0xFFFFFFFFL;
        c += x1 + x2 * wVal + (y[yOff + 2] & 0xFFFFFFFFL);
        z[zOff + 2] = (int)c;
        c >>>= 32;
        long x3 = x[xOff + 3] & 0xFFFFFFFFL;
        c += x2 + x3 * wVal + (y[yOff + 3] & 0xFFFFFFFFL);
        z[zOff + 3] = (int)c;
        c >>>= 32;
        long x4 = x[xOff + 4] & 0xFFFFFFFFL;
        c += x3 + x4 * wVal + (y[yOff + 4] & 0xFFFFFFFFL);
        z[zOff + 4] = (int)c;
        c >>>= 32;
        long x5 = x[xOff + 5] & 0xFFFFFFFFL;
        c += x4 + x5 * wVal + (y[yOff + 5] & 0xFFFFFFFFL);
        z[zOff + 5] = (int)c;
        c >>>= 32;
        long x6 = x[xOff + 6] & 0xFFFFFFFFL;
        c += x5 + x6 * wVal + (y[yOff + 6] & 0xFFFFFFFFL);
        z[zOff + 6] = (int)c;
        c >>>= 32;
        long x7 = x[xOff + 7] & 0xFFFFFFFFL;
        c += x6 + x7 * wVal + (y[yOff + 7] & 0xFFFFFFFFL);
        z[zOff + 7] = (int)c;
        c >>>= 32;
        return c + x7;
    }

    public static void mul33DWordAdd(int x, long y, int[] z, int zOff)
    {
        long c = 0, xVal = x & 0xFFFFFFFFL, y00 = y & 0xFFFFFFFFL;
        c += y00 * xVal + (z[zOff] & 0xFFFFFFFFL);
        z[zOff] = (int)c;
        c >>>= 32;
        long y01 = y >>> 32;
        c += y00 + y01 * xVal + (z[zOff + 1] & 0xFFFFFFFFL);
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



    public static int sub(int[] x, int[] y, int[] z)
    {
        long c = (x[0] & 0xFFFFFFFFL) - (y[0] & 0xFFFFFFFFL);
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
        long c = (z[0] & 0xFFFFFFFFL) - (x[0] & 0xFFFFFFFFL);
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
			if (x[i] != 0)
				Pack.intToBigEndian(x[i], bs, (7 - i) << 2);
        return new BigInteger(1, bs);
    }

    public static void zero(int[] z)
    {
        z[7] = z[6] = 0;
    }
}
