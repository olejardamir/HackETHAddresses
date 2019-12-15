
import java.math.BigInteger;


public class Nat
{
    private static final long M = 4294967295L;

    public static void add(int len, int[] x, int[] y, int[] z)
    {
        long c = 0;
        for (int i = 0; i < len; ++i)
        {
            c += (x[i] & M) + (y[i] & M);
            z[i] = (int)c;
            c >>>= 32;
        }
    }

    public static void add33To(int len, int x, int[] z)
    {
        long c = (z[0] & M) + (x & M);
        z[0] = (int)c;
        c >>>= 32;
        c += (z[1] & M) + 1L;
        z[1] = (int)c;
        c >>>= 32;
        if (c != 0) {
            incAt(len, z, 2);
        }
    }

    public static int addTo(int len, int[] x, int[] z)
    {
        long c = 0;
        for (int i = 0; i < len; ++i)
        {
            c += (x[i] & M) + (z[i] & M);
            z[i] = (int)c;
            c >>>= 32;
        }
        return (int)c;
    }



    public static int[] copy(int len, int[] x)
    {
        int[] z = new int[len];
        System.arraycopy(x, 0, z, 0, len);
        return z;
    }

    public static int[] create(int len)
    {
        return new int[len];
    }

    public static void decAt(int len, int[] z, int zPos)
    {
        
        for (int i = zPos; i < len; ++i)
        {
            if (--z[i] != -1)
            {
                return;
            }
        }
    }

    public static int[] fromBigInteger(int bits, BigInteger x)
    {


        int len = (bits + 31) >> 5;
        int[] z = create(len);
        int i = 0;
        while (x.signum() != 0)
        {
            z[i++] = x.intValue();
            x = x.shiftRight(32);
        }
        return z;
    }

    public static boolean gte(int len, int[] x, int[] y)
    {
        for (int i = len - 1; i >= 0; --i)
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



    public static void incAt(int len, int[] z, int zPos)
    {
        
        for (int i = zPos; i < len; ++i)
        {
            if (++z[i] != 0)
            {
                return;
            }
        }
    }

    public static int incAt(int len, int[] z, int zOff, int zPos)
    {
        
        for (int i = zPos; i < len; ++i)
        {
            if (++z[zOff + i] != 0)
            {
                return 0;
            }
        }
        return 1;
    }

    public static boolean isOne(int len, int[] x)
    {
        if (x[0] != 1)
        {
            return false;
        }
        for (int i = 1; i < len; ++i)
        {
            if (x[i] != 0)
            {
                return false;
            }
        }
        return true;
    }



    public static void shiftDownBit(int len, int[] z, int c)
    {
        int i = len;
        while (--i >= 0)
        {
            int next = z[i];
            z[i] = (next >>> 1) | (c << 31);
            c = next;
        }
    }

    public static void shiftDownBits(int len, int[] z, int bits, int c)
    {

        int i = len;
        while (--i >= 0)
        {
            int next = z[i];
            z[i] = (next >>> bits) | (c << -bits);
            c = next;
        }
    }

    public static void shiftDownWord(int len, int[] z, int c)
    {
        int i = len;
        while (--i >= 0)
        {
            int next = z[i];
            z[i] = c;
            c = next;
        }
    }

    public static int shiftUpBit(int len, int[] x, int c, int[] z)
    {
        for (int i = 0; i < len; ++i)
        {
            int next = x[i];
            z[i] = (next << 1) | (c >>> 31);
            c = next;
        }
        return c >>> 31;
    }



    public static int shiftUpBits(int len, int[] z, int bits, int c)
    {

        for (int i = 0; i < len; ++i)
        {
            int next = z[i];
            z[i] = (next << bits) | (c >>> -bits);
            c = next;
        }
        return c >>> -bits;
    }

    public static int shiftUpBits(int len, int[] x, int bits, int c, int[] z)
    {

        for (int i = 0; i < len; ++i)
        {
            int next = x[i];
            z[i] = (next << bits) | (c >>> -bits);
            c = next;
        }
        return c >>> -bits;
    }

    public static void sub33From(int len, int x, int[] z)
    {
        long c = (z[0] & M) - (x & M);
        z[0] = (int)c;
        c >>= 32;
        c += (z[1] & M) - 1;
        z[1] = (int)c;
        c >>= 32;
        if (c != 0) {
            decAt(len, z, 2);
        }
    }

    public static int subFrom(int len, int[] x, int[] z)
    {
        long c = 0;
        for (int i = 0; i < len; ++i)
        {
            c += (z[i] & M) - (x[i] & M);
            z[i] = (int)c;
            c >>= 32;
        }
        return (int)c;
    }



}
