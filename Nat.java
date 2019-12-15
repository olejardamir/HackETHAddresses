import java.math.BigInteger;

// 
// Decompiled by Procyon v0.5.36
// 

public class Nat
{
    private static final long M = 4294967295L;
    
    public static void add(final int len, final int[] x, final int[] y, final int[] z) {
        long c = 0L;
        for (int i = 0; i < len; ++i) {
            c += ((long)x[i] & 0xFFFFFFFFL) + ((long)y[i] & 0xFFFFFFFFL);
            z[i] = (int)c;
            c >>>= 32;
        }
    }
    
    public static void add33To(final int len, final int x, final int[] z) {
        long c = ((long)z[0] & 0xFFFFFFFFL) + ((long)x & 0xFFFFFFFFL);
        z[0] = (int)c;
        c >>>= 32;
        c += ((long)z[1] & 0xFFFFFFFFL) + 1L;
        z[1] = (int)c;
        c >>>= 32;
        if (c != 0L) {
            incAt(len, z, 2);
        }
    }
    
    public static int addTo(final int len, final int[] x, final int[] z) {
        long c = 0L;
        for (int i = 0; i < len; ++i) {
            c += ((long)x[i] & 0xFFFFFFFFL) + ((long)z[i] & 0xFFFFFFFFL);
            z[i] = (int)c;
            c >>>= 32;
        }
        return (int)c;
    }
    
    public static int[] copy(final int len, final int[] x) {
        final int[] z = new int[len];
        System.arraycopy(x, 0, z, 0, len);
        return z;
    }
    
    public static int[] create(final int len) {
        return new int[len];
    }
    
    public static void decAt(final int len, final int[] z, final int zPos) {
        for (int i = zPos; i < len; ++i) {
            final int n = i;
            if (--z[n] != -1) {
                return;
            }
        }
    }
    
    public static int[] fromBigInteger(final int bits, BigInteger x) {
        final int len = bits + 31 >> 5;
        final int[] z = create(len);
        int i = 0;
        while (x.signum() != 0) {
            z[i++] = x.intValue();
            x = x.shiftRight(32);
        }
        return z;
    }
    
    public static boolean gte(final int len, final int[] x, final int[] y) {
        for (int i = len - 1; i >= 0; --i) {
            final int x_i = x[i] ^ Integer.MIN_VALUE;
            final int y_i = y[i] ^ Integer.MIN_VALUE;
            if (x_i < y_i) {
                return false;
            }
            if (x_i > y_i) {
                return true;
            }
        }
        return true;
    }
    
    public static void incAt(final int len, final int[] z, final int zPos) {
        for (int i = zPos; i < len; ++i) {
            if (++z[i] != 0) {
                return;
            }
        }
    }
    
    public static int incAt(final int len, final int[] z, final int zOff, final int zPos) {
        for (int i = zPos; i < len; ++i) {
            if (++z[zOff + i] != 0) {
                return 0;
            }
        }
        return 1;
    }
    
    public static boolean isOne(final int len, final int[] x) {
        if (x[0] != 1) {
            return false;
        }
        for (int i = 1; i < len; ++i) {
            if (x[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void shiftDownBit(final int len, final int[] z, int c) {
        int i = len;
        while (--i >= 0) {
            final int next = z[i];
            z[i] = (next >>> 1 | c << 31);
            c = next;
        }
    }
    
    public static void shiftDownBits(final int len, final int[] z, final int bits, int c) {
        int i = len;
        while (--i >= 0) {
            final int next = z[i];
            z[i] = (next >>> bits | c << -bits);
            c = next;
        }
    }
    
    public static void shiftDownWord(final int len, final int[] z, int c) {
        int i = len;
        while (--i >= 0) {
            final int next = z[i];
            z[i] = c;
            c = next;
        }
    }
    
    public static int shiftUpBit(final int len, final int[] x, int c, final int[] z) {
        for (int i = 0; i < len; ++i) {
            final int next = x[i];
            z[i] = (next << 1 | c >>> 31);
            c = next;
        }
        return c >>> 31;
    }
    
    public static int shiftUpBits(final int len, final int[] z, final int bits, int c) {
        for (int i = 0; i < len; ++i) {
            final int next = z[i];
            z[i] = (next << bits | c >>> -bits);
            c = next;
        }
        return c >>> -bits;
    }
    
    public static int shiftUpBits(final int len, final int[] x, final int bits, int c, final int[] z) {
        for (int i = 0; i < len; ++i) {
            final int next = x[i];
            z[i] = (next << bits | c >>> -bits);
            c = next;
        }
        return c >>> -bits;
    }
    
    public static void sub33From(final int len, final int x, final int[] z) {
        long c = ((long)z[0] & 0xFFFFFFFFL) - ((long)x & 0xFFFFFFFFL);
        z[0] = (int)c;
        c >>= 32;
        c += ((long)z[1] & 0xFFFFFFFFL) - 1L;
        z[1] = (int)c;
        c >>= 32;
        if (c != 0L) {
            decAt(len, z, 2);
        }
    }
    
    public static int subFrom(final int len, final int[] x, final int[] z) {
        long c = 0L;
        for (int i = 0; i < len; ++i) {
            c += ((long)z[i] & 0xFFFFFFFFL) - ((long)x[i] & 0xFFFFFFFFL);
            z[i] = (int)c;
            c >>= 32;
        }
        return (int)c;
    }
}
