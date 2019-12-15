import java.math.BigInteger;

// 
// Decompiled by Procyon v0.5.36
// 

public class Nat256
{

    public static int addBothTo(final int[] x, final int[] y, final int[] z) {
        long c = 0L;
        c += ((long)x[0] & 0xFFFFFFFFL) + ((long)y[0] & 0xFFFFFFFFL) + ((long)z[0] & 0xFFFFFFFFL);
        z[0] = (int)c;
        c >>>= 32;
        c += ((long)x[1] & 0xFFFFFFFFL) + ((long)y[1] & 0xFFFFFFFFL) + ((long)z[1] & 0xFFFFFFFFL);
        z[1] = (int)c;
        c >>>= 32;
        c += ((long)x[2] & 0xFFFFFFFFL) + ((long)y[2] & 0xFFFFFFFFL) + ((long)z[2] & 0xFFFFFFFFL);
        z[2] = (int)c;
        c >>>= 32;
        c += ((long)x[3] & 0xFFFFFFFFL) + ((long)y[3] & 0xFFFFFFFFL) + ((long)z[3] & 0xFFFFFFFFL);
        z[3] = (int)c;
        c >>>= 32;
        c += ((long)x[4] & 0xFFFFFFFFL) + ((long)y[4] & 0xFFFFFFFFL) + ((long)z[4] & 0xFFFFFFFFL);
        z[4] = (int)c;
        c >>>= 32;
        c += ((long)x[5] & 0xFFFFFFFFL) + ((long)y[5] & 0xFFFFFFFFL) + ((long)z[5] & 0xFFFFFFFFL);
        z[5] = (int)c;
        c >>>= 32;
        c += ((long)x[6] & 0xFFFFFFFFL) + ((long)y[6] & 0xFFFFFFFFL) + ((long)z[6] & 0xFFFFFFFFL);
        z[6] = (int)c;
        c >>>= 32;
        c += ((long)x[7] & 0xFFFFFFFFL) + ((long)y[7] & 0xFFFFFFFFL) + ((long)z[7] & 0xFFFFFFFFL);
        z[7] = (int)c;
        c >>>= 32;
        return (int)c;
    }
    
    public static void copy(final int[] x, final int xOff, final int[] z, final int zOff) {
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
    
    public static boolean eq(final int[] x, final int[] y) {
        for (int i = 7; i >= 0; --i) {
            if (x[i] != y[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static int[] fromBigInteger(BigInteger x) {
        final int[] z = create();
        int i = 0;
        while (x.signum() != 0) {
            z[i++] = x.intValue();
            x = x.shiftRight(32);
        }
        return z;
    }
    
    public static int getBit(final int[] x, final int bit) {
        if (bit == 0) {
            return x[0] & 0x1;
        }
        if ((bit & 0xFF) != bit) {
            return 0;
        }
        final int w = bit >>> 5;
        final int b = bit & 0x1F;
        return x[w] >>> b & 0x1;
    }
    
    public static boolean gte(final int[] x, final int[] y) {
        for (int i = 7; i >= 0; --i) {
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
    
    public static boolean isOne(final int[] x) {
        if (x[0] != 1) {
            return false;
        }
        for (int i = 1; i < 8; ++i) {
            if (x[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isZero(final int[] x) {
        for (int i = 0; i < 8; ++i) {
            if (x[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void mul(final int[] x, final int[] y, final int[] zz) {
        final long y_0 = (long)y[0] & 0xFFFFFFFFL;
        final long y_2 = (long)y[1] & 0xFFFFFFFFL;
        final long y_3 = (long)y[2] & 0xFFFFFFFFL;
        final long y_4 = (long)y[3] & 0xFFFFFFFFL;
        final long y_5 = (long)y[4] & 0xFFFFFFFFL;
        final long y_6 = (long)y[5] & 0xFFFFFFFFL;
        final long y_7 = (long)y[6] & 0xFFFFFFFFL;
        final long y_8 = (long)y[7] & 0xFFFFFFFFL;
        long c = 0L;
        final long x_0 = (long)x[0] & 0xFFFFFFFFL;
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
        for (int i = 1; i < 8; ++i) {
            long c2 = 0L;
            final long x_i = (long)x[i] & 0xFFFFFFFFL;
            c2 += x_i * y_0 + ((long)zz[i] & 0xFFFFFFFFL);
            zz[i] = (int)c2;
            c2 >>>= 32;
            c2 += x_i * y_2 + ((long)zz[i + 1] & 0xFFFFFFFFL);
            zz[i + 1] = (int)c2;
            c2 >>>= 32;
            c2 += x_i * y_3 + ((long)zz[i + 2] & 0xFFFFFFFFL);
            zz[i + 2] = (int)c2;
            c2 >>>= 32;
            c2 += x_i * y_4 + ((long)zz[i + 3] & 0xFFFFFFFFL);
            zz[i + 3] = (int)c2;
            c2 >>>= 32;
            c2 += x_i * y_5 + ((long)zz[i + 4] & 0xFFFFFFFFL);
            zz[i + 4] = (int)c2;
            c2 >>>= 32;
            c2 += x_i * y_6 + ((long)zz[i + 5] & 0xFFFFFFFFL);
            zz[i + 5] = (int)c2;
            c2 >>>= 32;
            c2 += x_i * y_7 + ((long)zz[i + 6] & 0xFFFFFFFFL);
            zz[i + 6] = (int)c2;
            c2 >>>= 32;
            c2 += x_i * y_8 + ((long)zz[i + 7] & 0xFFFFFFFFL);
            zz[i + 7] = (int)c2;
            c2 >>>= 32;
            zz[i + 8] = (int)c2;
        }
    }
    
    public static int mulAddTo(final int[] x, final int[] y, final int[] zz) {
        final long y_0 = (long)y[0] & 0xFFFFFFFFL;
        final long y_2 = (long)y[1] & 0xFFFFFFFFL;
        final long y_3 = (long)y[2] & 0xFFFFFFFFL;
        final long y_4 = (long)y[3] & 0xFFFFFFFFL;
        final long y_5 = (long)y[4] & 0xFFFFFFFFL;
        final long y_6 = (long)y[5] & 0xFFFFFFFFL;
        final long y_7 = (long)y[6] & 0xFFFFFFFFL;
        final long y_8 = (long)y[7] & 0xFFFFFFFFL;
        long zc = 0L;
        for (int i = 0; i < 8; ++i) {
            long c = 0L;
            final long x_i = (long)x[i] & 0xFFFFFFFFL;
            c += x_i * y_0 + ((long)zz[i] & 0xFFFFFFFFL);
            zz[i] = (int)c;
            c >>>= 32;
            c += x_i * y_2 + ((long)zz[i + 1] & 0xFFFFFFFFL);
            zz[i + 1] = (int)c;
            c >>>= 32;
            c += x_i * y_3 + ((long)zz[i + 2] & 0xFFFFFFFFL);
            zz[i + 2] = (int)c;
            c >>>= 32;
            c += x_i * y_4 + ((long)zz[i + 3] & 0xFFFFFFFFL);
            zz[i + 3] = (int)c;
            c >>>= 32;
            c += x_i * y_5 + ((long)zz[i + 4] & 0xFFFFFFFFL);
            zz[i + 4] = (int)c;
            c >>>= 32;
            c += x_i * y_6 + ((long)zz[i + 5] & 0xFFFFFFFFL);
            zz[i + 5] = (int)c;
            c >>>= 32;
            c += x_i * y_7 + ((long)zz[i + 6] & 0xFFFFFFFFL);
            zz[i + 6] = (int)c;
            c >>>= 32;
            c += x_i * y_8 + ((long)zz[i + 7] & 0xFFFFFFFFL);
            zz[i + 7] = (int)c;
            c >>>= 32;
            c += zc + ((long)zz[i + 8] & 0xFFFFFFFFL);
            zz[i + 8] = (int)c;
            zc = c >>> 32;
        }
        return (int)zc;
    }
    
    public static long mul33Add(final int w, final int[] x, final int xOff, final int[] y, final int yOff, final int[] z, final int zOff) {
        long c = 0L;
        final long wVal = (long)w & 0xFFFFFFFFL;
        final long x2 = (long)x[xOff] & 0xFFFFFFFFL;
        c += wVal * x2 + ((long)y[yOff] & 0xFFFFFFFFL);
        z[zOff] = (int)c;
        c >>>= 32;
        final long x3 = (long)x[xOff + 1] & 0xFFFFFFFFL;
        c += wVal * x3 + x2 + ((long)y[yOff + 1] & 0xFFFFFFFFL);
        z[zOff + 1] = (int)c;
        c >>>= 32;
        final long x4 = (long)x[xOff + 2] & 0xFFFFFFFFL;
        c += wVal * x4 + x3 + ((long)y[yOff + 2] & 0xFFFFFFFFL);
        z[zOff + 2] = (int)c;
        c >>>= 32;
        final long x5 = (long)x[xOff + 3] & 0xFFFFFFFFL;
        c += wVal * x5 + x4 + ((long)y[yOff + 3] & 0xFFFFFFFFL);
        z[zOff + 3] = (int)c;
        c >>>= 32;
        final long x6 = (long)x[xOff + 4] & 0xFFFFFFFFL;
        c += wVal * x6 + x5 + ((long)y[yOff + 4] & 0xFFFFFFFFL);
        z[zOff + 4] = (int)c;
        c >>>= 32;
        final long x7 = (long)x[xOff + 5] & 0xFFFFFFFFL;
        c += wVal * x7 + x6 + ((long)y[yOff + 5] & 0xFFFFFFFFL);
        z[zOff + 5] = (int)c;
        c >>>= 32;
        final long x8 = (long)x[xOff + 6] & 0xFFFFFFFFL;
        c += wVal * x8 + x7 + ((long)y[yOff + 6] & 0xFFFFFFFFL);
        z[zOff + 6] = (int)c;
        c >>>= 32;
        final long x9 = (long)x[xOff + 7] & 0xFFFFFFFFL;
        c += wVal * x9 + x8 + ((long)y[yOff + 7] & 0xFFFFFFFFL);
        z[zOff + 7] = (int)c;
        c >>>= 32;
        c += x9;
        return c;
    }
    
    public static int mul33DWordAdd(final int x, final long y, final int[] z, final int zOff) {
        long c = 0L;
        final long xVal = (long)x & 0xFFFFFFFFL;
        final long y2 = y & 0xFFFFFFFFL;
        c += xVal * y2 + ((long)z[zOff] & 0xFFFFFFFFL);
        z[zOff] = (int)c;
        c >>>= 32;
        final long y3 = y >>> 32;
        c += xVal * y3 + y2 + ((long)z[zOff + 1] & 0xFFFFFFFFL);
        z[zOff + 1] = (int)c;
        c >>>= 32;
        c += y3 + ((long)z[zOff + 2] & 0xFFFFFFFFL);
        z[zOff + 2] = (int)c;
        c >>>= 32;
        c += ((long)z[zOff + 3] & 0xFFFFFFFFL);
        z[zOff + 3] = (int)c;
        c >>>= 32;
        return (c == 0L) ? 0 : Nat.incAt(8, z, zOff, 4);
    }
    
    public static int mul33WordAdd(final int x, final int y, final int[] z, final int zOff) {
        long c = 0L;
        final long xVal = (long)x & 0xFFFFFFFFL;
        final long yVal = (long)y & 0xFFFFFFFFL;
        c += yVal * xVal + ((long)z[zOff] & 0xFFFFFFFFL);
        z[zOff] = (int)c;
        c >>>= 32;
        c += yVal + ((long)z[zOff + 1] & 0xFFFFFFFFL);
        z[zOff + 1] = (int)c;
        c >>>= 32;
        c += ((long)z[zOff + 2] & 0xFFFFFFFFL);
        z[zOff + 2] = (int)c;
        c >>>= 32;
        return (c == 0L) ? 0 : Nat.incAt(8, z, zOff, 3);
    }
    
    public static void square(final int[] x, final int[] zz) {
        final long x_0 = (long)x[0] & 0xFFFFFFFFL;
        int c = 0;
        int i = 7;
        int j = 16;
        do {
            final long xVal = (long)x[i--] & 0xFFFFFFFFL;
            final long p = xVal * xVal;
            zz[--j] = (c << 31 | (int)(p >>> 33));
            zz[--j] = (int)(p >>> 1);
            c = (int)p;
        } while (i > 0);
        final long p2 = x_0 * x_0;
        long zz_1 = ((long)(c << 31) & 0xFFFFFFFFL) | p2 >>> 33;
        zz[0] = (int)p2;
        c = ((int)(p2 >>> 32) & 0x1);
        final long x_2 = (long)x[1] & 0xFFFFFFFFL;
        long zz_2 = (long)zz[2] & 0xFFFFFFFFL;
        zz_1 += x_2 * x_0;
        int w = (int)zz_1;
        zz[1] = (w << 1 | c);
        c = w >>> 31;
        zz_2 += zz_1 >>> 32;
        final long x_3 = (long)x[2] & 0xFFFFFFFFL;
        long zz_3 = (long)zz[3] & 0xFFFFFFFFL;
        long zz_4 = (long)zz[4] & 0xFFFFFFFFL;
        zz_2 += x_3 * x_0;
        w = (int)zz_2;
        zz[2] = (w << 1 | c);
        c = w >>> 31;
        zz_3 += (zz_2 >>> 32) + x_3 * x_2;
        zz_4 += zz_3 >>> 32;
        zz_3 &= 0xFFFFFFFFL;
        final long x_4 = (long)x[3] & 0xFFFFFFFFL;
        long zz_5 = ((long)zz[5] & 0xFFFFFFFFL) + (zz_4 >>> 32);
        zz_4 &= 0xFFFFFFFFL;
        long zz_6 = ((long)zz[6] & 0xFFFFFFFFL) + (zz_5 >>> 32);
        zz_5 &= 0xFFFFFFFFL;
        zz_3 += x_4 * x_0;
        w = (int)zz_3;
        zz[3] = (w << 1 | c);
        c = w >>> 31;
        zz_4 += (zz_3 >>> 32) + x_4 * x_2;
        zz_5 += (zz_4 >>> 32) + x_4 * x_3;
        zz_4 &= 0xFFFFFFFFL;
        zz_6 += zz_5 >>> 32;
        zz_5 &= 0xFFFFFFFFL;
        final long x_5 = (long)x[4] & 0xFFFFFFFFL;
        long zz_7 = ((long)zz[7] & 0xFFFFFFFFL) + (zz_6 >>> 32);
        zz_6 &= 0xFFFFFFFFL;
        long zz_8 = ((long)zz[8] & 0xFFFFFFFFL) + (zz_7 >>> 32);
        zz_7 &= 0xFFFFFFFFL;
        zz_4 += x_5 * x_0;
        w = (int)zz_4;
        zz[4] = (w << 1 | c);
        c = w >>> 31;
        zz_5 += (zz_4 >>> 32) + x_5 * x_2;
        zz_6 += (zz_5 >>> 32) + x_5 * x_3;
        zz_5 &= 0xFFFFFFFFL;
        zz_7 += (zz_6 >>> 32) + x_5 * x_4;
        zz_6 &= 0xFFFFFFFFL;
        zz_8 += zz_7 >>> 32;
        zz_7 &= 0xFFFFFFFFL;
        final long x_6 = (long)x[5] & 0xFFFFFFFFL;
        long zz_9 = ((long)zz[9] & 0xFFFFFFFFL) + (zz_8 >>> 32);
        zz_8 &= 0xFFFFFFFFL;
        long zz_10 = ((long)zz[10] & 0xFFFFFFFFL) + (zz_9 >>> 32);
        zz_9 &= 0xFFFFFFFFL;
        zz_5 += x_6 * x_0;
        w = (int)zz_5;
        zz[5] = (w << 1 | c);
        c = w >>> 31;
        zz_6 += (zz_5 >>> 32) + x_6 * x_2;
        zz_7 += (zz_6 >>> 32) + x_6 * x_3;
        zz_6 &= 0xFFFFFFFFL;
        zz_8 += (zz_7 >>> 32) + x_6 * x_4;
        zz_7 &= 0xFFFFFFFFL;
        zz_9 += (zz_8 >>> 32) + x_6 * x_5;
        zz_8 &= 0xFFFFFFFFL;
        zz_10 += zz_9 >>> 32;
        zz_9 &= 0xFFFFFFFFL;
        final long x_7 = (long)x[6] & 0xFFFFFFFFL;
        long zz_11 = ((long)zz[11] & 0xFFFFFFFFL) + (zz_10 >>> 32);
        zz_10 &= 0xFFFFFFFFL;
        long zz_12 = ((long)zz[12] & 0xFFFFFFFFL) + (zz_11 >>> 32);
        zz_11 &= 0xFFFFFFFFL;
        zz_6 += x_7 * x_0;
        w = (int)zz_6;
        zz[6] = (w << 1 | c);
        c = w >>> 31;
        zz_7 += (zz_6 >>> 32) + x_7 * x_2;
        zz_8 += (zz_7 >>> 32) + x_7 * x_3;
        zz_7 &= 0xFFFFFFFFL;
        zz_9 += (zz_8 >>> 32) + x_7 * x_4;
        zz_8 &= 0xFFFFFFFFL;
        zz_10 += (zz_9 >>> 32) + x_7 * x_5;
        zz_9 &= 0xFFFFFFFFL;
        zz_11 += (zz_10 >>> 32) + x_7 * x_6;
        zz_10 &= 0xFFFFFFFFL;
        zz_12 += zz_11 >>> 32;
        zz_11 &= 0xFFFFFFFFL;
        final long x_8 = (long)x[7] & 0xFFFFFFFFL;
        long zz_13 = ((long)zz[13] & 0xFFFFFFFFL) + (zz_12 >>> 32);
        zz_12 &= 0xFFFFFFFFL;
        long zz_14 = ((long)zz[14] & 0xFFFFFFFFL) + (zz_13 >>> 32);
        zz_13 &= 0xFFFFFFFFL;
        zz_7 += x_8 * x_0;
        w = (int)zz_7;
        zz[7] = (w << 1 | c);
        c = w >>> 31;
        zz_8 += (zz_7 >>> 32) + x_8 * x_2;
        zz_9 += (zz_8 >>> 32) + x_8 * x_3;
        zz_10 += (zz_9 >>> 32) + x_8 * x_4;
        zz_11 += (zz_10 >>> 32) + x_8 * x_5;
        zz_12 += (zz_11 >>> 32) + x_8 * x_6;
        zz_13 += (zz_12 >>> 32) + x_8 * x_7;
        zz_14 += zz_13 >>> 32;
        w = (int)zz_8;
        zz[8] = (w << 1 | c);
        c = w >>> 31;
        w = (int)zz_9;
        zz[9] = (w << 1 | c);
        c = w >>> 31;
        w = (int)zz_10;
        zz[10] = (w << 1 | c);
        c = w >>> 31;
        w = (int)zz_11;
        zz[11] = (w << 1 | c);
        c = w >>> 31;
        w = (int)zz_12;
        zz[12] = (w << 1 | c);
        c = w >>> 31;
        w = (int)zz_13;
        zz[13] = (w << 1 | c);
        c = w >>> 31;
        w = (int)zz_14;
        zz[14] = (w << 1 | c);
        c = w >>> 31;
        w = zz[15] + (int)(zz_14 >>> 32);
        zz[15] = (w << 1 | c);
    }
    
    public static int sub(final int[] x, final int[] y, final int[] z) {
        long c = 0L;
        c += ((long)x[0] & 0xFFFFFFFFL) - ((long)y[0] & 0xFFFFFFFFL);
        z[0] = (int)c;
        c >>= 32;
        c += ((long)x[1] & 0xFFFFFFFFL) - ((long)y[1] & 0xFFFFFFFFL);
        z[1] = (int)c;
        c >>= 32;
        c += ((long)x[2] & 0xFFFFFFFFL) - ((long)y[2] & 0xFFFFFFFFL);
        z[2] = (int)c;
        c >>= 32;
        c += ((long)x[3] & 0xFFFFFFFFL) - ((long)y[3] & 0xFFFFFFFFL);
        z[3] = (int)c;
        c >>= 32;
        c += ((long)x[4] & 0xFFFFFFFFL) - ((long)y[4] & 0xFFFFFFFFL);
        z[4] = (int)c;
        c >>= 32;
        c += ((long)x[5] & 0xFFFFFFFFL) - ((long)y[5] & 0xFFFFFFFFL);
        z[5] = (int)c;
        c >>= 32;
        c += ((long)x[6] & 0xFFFFFFFFL) - ((long)y[6] & 0xFFFFFFFFL);
        z[6] = (int)c;
        c >>= 32;
        c += ((long)x[7] & 0xFFFFFFFFL) - ((long)y[7] & 0xFFFFFFFFL);
        z[7] = (int)c;
        c >>= 32;
        return (int)c;
    }
    
    public static void subFrom(final int[] x, final int[] z) {
        long c = 0L;
        c += ((long)z[0] & 0xFFFFFFFFL) - ((long)x[0] & 0xFFFFFFFFL);
        z[0] = (int)c;
        c >>= 32;
        c += ((long)z[1] & 0xFFFFFFFFL) - ((long)x[1] & 0xFFFFFFFFL);
        z[1] = (int)c;
        c >>= 32;
        c += ((long)z[2] & 0xFFFFFFFFL) - ((long)x[2] & 0xFFFFFFFFL);
        z[2] = (int)c;
        c >>= 32;
        c += ((long)z[3] & 0xFFFFFFFFL) - ((long)x[3] & 0xFFFFFFFFL);
        z[3] = (int)c;
        c >>= 32;
        c += ((long)z[4] & 0xFFFFFFFFL) - ((long)x[4] & 0xFFFFFFFFL);
        z[4] = (int)c;
        c >>= 32;
        c += ((long)z[5] & 0xFFFFFFFFL) - ((long)x[5] & 0xFFFFFFFFL);
        z[5] = (int)c;
        c >>= 32;
        c += ((long)z[6] & 0xFFFFFFFFL) - ((long)x[6] & 0xFFFFFFFFL);
        z[6] = (int)c;
        c >>= 32;
        c += ((long)z[7] & 0xFFFFFFFFL) - ((long)x[7] & 0xFFFFFFFFL);
        z[7] = (int)c;
    }
    
    public static BigInteger toBigInteger(final int[] x) {
        final byte[] bs = new byte[32];
        for (int i = 0; i < 8; ++i) {
            final int x_i = x[i];
            if (x_i != 0) {
                Pack.intToBigEndian(x_i, bs, 7 - i << 2);
            }
        }
        return new BigInteger(1, bs);
    }
    
    public static void zero(final int[] z) {
        z[1] = (z[0] = 0);
        z[3] = (z[2] = 0);
        z[5] = (z[4] = 0);
        z[7] = (z[6] = 0);
    }
}
