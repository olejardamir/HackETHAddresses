import java.math.BigInteger;

class SecP256K1Field
{
    final static int[] P;
    final private static int[] PExt;
    final private static int[] PExtInv;
    final private static int P7 = -1;
    final private static int PExt15 = -1;
    final private static int PInv33 = 977;


    static {
        int[] a = new int[8];
        a[0] = -977;
        a[1] = -2;
        a[2] = -1;
        a[3] = -1;
        a[4] = -1;
        a[5] = -1;
        a[6] = -1;
        a[7] = -1;
        P = a;
        int[] a0 = new int[16];
        a0[0] = 954529;
        a0[1] = 1954;
        a0[2] = 1;
        a0[3] = 0;
        a0[4] = 0;
        a0[5] = 0;
        a0[6] = 0;
        a0[7] = 0;
        a0[8] = -1954;
        a0[9] = -3;
        a0[10] = -1;
        a0[11] = -1;
        a0[12] = -1;
        a0[13] = -1;
        a0[14] = -1;
        a0[15] = -1;
        PExt = a0;
        int[] a1 = new int[10];
        a1[0] = -954529;
        a1[1] = -1955;
        a1[2] = -2;
        a1[3] = -1;
        a1[4] = -1;
        a1[5] = -1;
        a1[6] = -1;
        a1[7] = -1;
        a1[8] = 1953;
        a1[9] = 2;
        PExtInv = a1;
    }




    public static void add(int[] x, int[] y, int[] z)
    {
        int c = Nat256.add(x, y, z);
        if (c != 0 || (z[7] == P7 && Nat256.gte(z, P)))
        {
            Nat.add33To(8, PInv33, z);
        }
    }



    public static int[] fromBigInteger(BigInteger x)
    {
        int[] z = Nat256.fromBigInteger(x);
        if (z[7] == P7 && Nat256.gte(z, P))
        {
            Nat256.subFrom(P, z);
        }
        return z;
    }

    public static void multiplyAddToExt(int[] x, int[] y, int[] zz)
    {
        int c = Nat256.mulAddTo(x, y, zz);
        if (c != 0 || (zz[15] == PExt15 && Nat.gte(16, zz, PExt)))
        {
            if (Nat.addTo(PExtInv.length, PExtInv, zz) != 0)
            {
                Nat.incAt(16, zz, PExtInv.length);
            }
        }
    }

    public static void negate(int[] a, int[] a0) {
        if (Nat256.isZero(a)) {
            Nat256.zero(a0);
        } else {
            Nat256.sub(P, a, a0);
        }
    }

    public static void reduce(int[] xx, int[] z)
    {
        long cc = Nat256.mul33Add(PInv33, xx, 8, xx, 0, z, 0);
         Nat256.mul33DWordAdd(PInv33, cc, z, 0);
    }

    public static void reduce32(int x, int[] z)
    {
        if ((x != 0 && Nat256.mul33WordAdd(PInv33, x, z, 0) != 0)
                || (z[7] == P7 && Nat256.gte(z, P)))
        {
            Nat.add33To(8, PInv33, z);
        }
    }

    public static void squareN(int[] a, int i, int[] a0) {
        int[] a1 = new int[16];
        long x_01 = a[0] & 0xFFFFFFFFL;
        long zz_15;

        int c1 = 0, w1;
        {
            int i2 = 7, j1 = 16;
            do
            {
                long xVal1 = (a[i2--] & 0xFFFFFFFFL);
                long p1 = xVal1 * xVal1;
                a1[--j1] = (c1 << 31) | (int)(p1 >>> 33);
                a1[--j1] = (int)(p1 >>> 1);
                c1 = (int) p1;
            }
            while (i2 > 0);

            {
                long p1 = x_01 * x_01;
                zz_15 = ((c1 << 31) & 0xFFFFFFFFL) | (p1 >>> 33);
                a1[0] = (int) p1;
                c1 = (int)(p1 >>> 32) & 1;
            }
        }

        long x_11 = a[1] & 0xFFFFFFFFL;
        long zz_21 = a1[2] & 0xFFFFFFFFL;

        {
            zz_15 += x_11 * x_01;
            w1 = (int) zz_15;
            a1[1] = (w1 << 1) | c1;
            c1 = w1 >>> 31;
            zz_21 += zz_15 >>> 32;
        }

        long x_21 = a[2] & 0xFFFFFFFFL;
        long zz_31 = a1[3] & 0xFFFFFFFFL;
        long zz_41 = a1[4] & 0xFFFFFFFFL;
        {
            zz_21 += x_21 * x_01;
            w1 = (int) zz_21;
            a1[2] = (w1 << 1) | c1;
            c1 = w1 >>> 31;
            zz_31 += (zz_21 >>> 32) + x_21 * x_11;
            zz_41 += zz_31 >>> 32;
            zz_31 &= 0xFFFFFFFFL;
        }

        long x_31 = a[3] & 0xFFFFFFFFL;
        long zz_51 = (a1[5] & 0xFFFFFFFFL) + (zz_41 >>> 32);
        zz_41 &= 0xFFFFFFFFL;
        long zz_61 = (a1[6] & 0xFFFFFFFFL) + (zz_51 >>> 32);
        zz_51 &= 0xFFFFFFFFL;
        {
            zz_31 += x_31 * x_01;
            w1 = (int) zz_31;
            a1[3] = (w1 << 1) | c1;
            c1 = w1 >>> 31;
            zz_41 += (zz_31 >>> 32) + x_31 * x_11;
            zz_51 += (zz_41 >>> 32) + x_31 * x_21;
            zz_41 &= 0xFFFFFFFFL;
            zz_61 += zz_51 >>> 32;
            zz_51 &= 0xFFFFFFFFL;
        }

        long x_41 = a[4] & 0xFFFFFFFFL;
        long zz_71 = (a1[7] & 0xFFFFFFFFL) + (zz_61 >>> 32);
        zz_61 &= 0xFFFFFFFFL;
        long zz_81 = (a1[8] & 0xFFFFFFFFL) + (zz_71 >>> 32);
        zz_71 &= 0xFFFFFFFFL;
        {
            zz_41 += x_41 * x_01;
            w1 = (int) zz_41;
            a1[4] = (w1 << 1) | c1;
            c1 = w1 >>> 31;
            zz_51 += (zz_41 >>> 32) + x_41 * x_11;
            zz_61 += (zz_51 >>> 32) + x_41 * x_21;
            zz_51 &= 0xFFFFFFFFL;
            zz_71 += (zz_61 >>> 32) + x_41 * x_31;
            zz_61 &= 0xFFFFFFFFL;
            zz_81 += zz_71 >>> 32;
            zz_71 &= 0xFFFFFFFFL;
        }

        long x_51 = a[5] & 0xFFFFFFFFL;
        long zz_91 = (a1[9] & 0xFFFFFFFFL) + (zz_81 >>> 32);
        zz_81 &= 0xFFFFFFFFL;
        long zz_101 = (a1[10] & 0xFFFFFFFFL) + (zz_91 >>> 32);
        zz_91 &= 0xFFFFFFFFL;
        {
            zz_51 += x_51 * x_01;
            w1 = (int) zz_51;
            a1[5] = (w1 << 1) | c1;
            c1 = w1 >>> 31;
            zz_61 += (zz_51 >>> 32) + x_51 * x_11;
            zz_71 += (zz_61 >>> 32) + x_51 * x_21;
            zz_61 &= 0xFFFFFFFFL;
            zz_81 += (zz_71 >>> 32) + x_51 * x_31;
            zz_71 &= 0xFFFFFFFFL;
            zz_91 += (zz_81 >>> 32) + x_51 * x_41;
            zz_81 &= 0xFFFFFFFFL;
            zz_101 += zz_91 >>> 32;
            zz_91 &= 0xFFFFFFFFL;
        }

        long x_61 = a[6] & 0xFFFFFFFFL;
        long zz_111 = (a1[11] & 0xFFFFFFFFL) + (zz_101 >>> 32);
        zz_101 &= 0xFFFFFFFFL;
        long zz_121 = (a1[12] & 0xFFFFFFFFL) + (zz_111 >>> 32);
        zz_111 &= 0xFFFFFFFFL;
        {
            zz_61 += x_61 * x_01;
            w1 = (int) zz_61;
            a1[6] = (w1 << 1) | c1;
            c1 = w1 >>> 31;
            zz_71 += (zz_61 >>> 32) + x_61 * x_11;
            zz_81 += (zz_71 >>> 32) + x_61 * x_21;
            zz_71 &= 0xFFFFFFFFL;
            zz_91 += (zz_81 >>> 32) + x_61 * x_31;
            zz_81 &= 0xFFFFFFFFL;
            zz_101 += (zz_91 >>> 32) + x_61 * x_41;
            zz_91 &= 0xFFFFFFFFL;
            zz_111 += (zz_101 >>> 32) + x_61 * x_51;
            zz_101 &= 0xFFFFFFFFL;
            zz_121 += zz_111 >>> 32;
            zz_111 &= 0xFFFFFFFFL;
        }

        long x_71 = a[7] & 0xFFFFFFFFL;
        long zz_131 = (a1[13] & 0xFFFFFFFFL) + (zz_121 >>> 32);
        zz_121 &= 0xFFFFFFFFL;
        long zz_141 = (a1[14] & 0xFFFFFFFFL) + (zz_131 >>> 32);
        zz_131 &= 0xFFFFFFFFL;
        {
            zz_71 += x_71 * x_01;
            w1 = (int) zz_71;
            a1[7] = (w1 << 1) | c1;
            c1 = w1 >>> 31;
            zz_81 += (zz_71 >>> 32) + x_71 * x_11;
            zz_91 += (zz_81 >>> 32) + x_71 * x_21;
            zz_101 += (zz_91 >>> 32) + x_71 * x_31;
            zz_111 += (zz_101 >>> 32) + x_71 * x_41;
            zz_121 += (zz_111 >>> 32) + x_71 * x_51;
            zz_131 += (zz_121 >>> 32) + x_71 * x_61;
            zz_141 += zz_131 >>> 32;
        }

        w1 = (int) zz_81;
        a1[8] = (w1 << 1) | c1;
        c1 = w1 >>> 31;
        w1 = (int) zz_91;
        a1[9] = (w1 << 1) | c1;
        c1 = w1 >>> 31;
        w1 = (int) zz_101;
        a1[10] = (w1 << 1) | c1;
        c1 = w1 >>> 31;
        w1 = (int) zz_111;
        a1[11] = (w1 << 1) | c1;
        c1 = w1 >>> 31;
        w1 = (int) zz_121;
        a1[12] = (w1 << 1) | c1;
        c1 = w1 >>> 31;
        w1 = (int) zz_131;
        a1[13] = (w1 << 1) | c1;
        c1 = w1 >>> 31;
        w1 = (int) zz_141;
        a1[14] = (w1 << 1) | c1;
        c1 = w1 >>> 31;
        w1 = a1[15] + (int)(zz_141 >>> 32);
        a1[15] = (w1 << 1) | c1;
        SecP256K1Field.reduce(a1, a0);
        while(true) {
            int i0 = i + -1;
            if (i0 <= 0) {
                return;
            }
            long x_0 = a0[0] & 0xFFFFFFFFL;
            long zz_1;

            int c = 0, w;
            {
                int i1 = 7, j = 16;
                do
                {
                    long xVal = (a0[i1--] & 0xFFFFFFFFL);
                    long p = xVal * xVal;
                    a1[--j] = (c << 31) | (int)(p >>> 33);
                    a1[--j] = (int)(p >>> 1);
                    c = (int)p;
                }
                while (i1 > 0);

                {
                    long p = x_0 * x_0;
                    zz_1 = ((c << 31) & 0xFFFFFFFFL) | (p >>> 33);
                    a1[0] = (int)p;
                    c = (int)(p >>> 32) & 1;
                }
            }

            long x_1 = a0[1] & 0xFFFFFFFFL;
            long zz_2 = a1[2] & 0xFFFFFFFFL;

            {
                zz_1 += x_1 * x_0;
                w = (int)zz_1;
                a1[1] = (w << 1) | c;
                c = w >>> 31;
                zz_2 += zz_1 >>> 32;
            }

            long x_2 = a0[2] & 0xFFFFFFFFL;
            long zz_3 = a1[3] & 0xFFFFFFFFL;
            long zz_4 = a1[4] & 0xFFFFFFFFL;
            {
                zz_2 += x_2 * x_0;
                w = (int)zz_2;
                a1[2] = (w << 1) | c;
                c = w >>> 31;
                zz_3 += (zz_2 >>> 32) + x_2 * x_1;
                zz_4 += zz_3 >>> 32;
                zz_3 &= 0xFFFFFFFFL;
            }

            long x_3 = a0[3] & 0xFFFFFFFFL;
            long zz_5 = (a1[5] & 0xFFFFFFFFL) + (zz_4 >>> 32);
            zz_4 &= 0xFFFFFFFFL;
            long zz_6 = (a1[6] & 0xFFFFFFFFL) + (zz_5 >>> 32);
            zz_5 &= 0xFFFFFFFFL;
            {
                zz_3 += x_3 * x_0;
                w = (int)zz_3;
                a1[3] = (w << 1) | c;
                c = w >>> 31;
                zz_4 += (zz_3 >>> 32) + x_3 * x_1;
                zz_5 += (zz_4 >>> 32) + x_3 * x_2;
                zz_4 &= 0xFFFFFFFFL;
                zz_6 += zz_5 >>> 32;
                zz_5 &= 0xFFFFFFFFL;
            }

            long x_4 = a0[4] & 0xFFFFFFFFL;
            long zz_7 = (a1[7] & 0xFFFFFFFFL) + (zz_6 >>> 32);
            zz_6 &= 0xFFFFFFFFL;
            long zz_8 = (a1[8] & 0xFFFFFFFFL) + (zz_7 >>> 32);
            zz_7 &= 0xFFFFFFFFL;
            {
                zz_4 += x_4 * x_0;
                w = (int)zz_4;
                a1[4] = (w << 1) | c;
                c = w >>> 31;
                zz_5 += (zz_4 >>> 32) + x_4 * x_1;
                zz_6 += (zz_5 >>> 32) + x_4 * x_2;
                zz_5 &= 0xFFFFFFFFL;
                zz_7 += (zz_6 >>> 32) + x_4 * x_3;
                zz_6 &= 0xFFFFFFFFL;
                zz_8 += zz_7 >>> 32;
                zz_7 &= 0xFFFFFFFFL;
            }

            long x_5 = a0[5] & 0xFFFFFFFFL;
            long zz_9 = (a1[9] & 0xFFFFFFFFL) + (zz_8 >>> 32);
            zz_8 &= 0xFFFFFFFFL;
            long zz_10 = (a1[10] & 0xFFFFFFFFL) + (zz_9 >>> 32);
            zz_9 &= 0xFFFFFFFFL;
            {
                zz_5 += x_5 * x_0;
                w = (int)zz_5;
                a1[5] = (w << 1) | c;
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

            long x_6 = a0[6] & 0xFFFFFFFFL;
            long zz_11 = (a1[11] & 0xFFFFFFFFL) + (zz_10 >>> 32);
            zz_10 &= 0xFFFFFFFFL;
            long zz_12 = (a1[12] & 0xFFFFFFFFL) + (zz_11 >>> 32);
            zz_11 &= 0xFFFFFFFFL;
            {
                zz_6 += x_6 * x_0;
                w = (int)zz_6;
                a1[6] = (w << 1) | c;
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

            long x_7 = a0[7] & 0xFFFFFFFFL;
            long zz_13 = (a1[13] & 0xFFFFFFFFL) + (zz_12 >>> 32);
            zz_12 &= 0xFFFFFFFFL;
            long zz_14 = (a1[14] & 0xFFFFFFFFL) + (zz_13 >>> 32);
            zz_13 &= 0xFFFFFFFFL;
            {
                zz_7 += x_7 * x_0;
                w = (int)zz_7;
                a1[7] = (w << 1) | c;
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
            a1[8] = (w << 1) | c;
            c = w >>> 31;
            w = (int)zz_9;
            a1[9] = (w << 1) | c;
            c = w >>> 31;
            w = (int)zz_10;
            a1[10] = (w << 1) | c;
            c = w >>> 31;
            w = (int)zz_11;
            a1[11] = (w << 1) | c;
            c = w >>> 31;
            w = (int)zz_12;
            a1[12] = (w << 1) | c;
            c = w >>> 31;
            w = (int)zz_13;
            a1[13] = (w << 1) | c;
            c = w >>> 31;
            w = (int)zz_14;
            a1[14] = (w << 1) | c;
            c = w >>> 31;
            w = a1[15] + (int)(zz_14 >>> 32);
            a1[15] = (w << 1) | c;
            SecP256K1Field.reduce(a1, a0);
            i = i0;
        }
    }

    public static void subtract(int[] a, int[] a0, int[] a1) {
        if (Nat256.sub(a, a0, a1) != 0) {
            Nat.sub33From(8, 977, a1);
        }
    }

    public static void twice(int[] x, int[] z)
    {
        int c = Nat.shiftUpBit(8, x, 0, z);
        if (c != 0 || (z[7] == P7 && Nat256.gte(z, P)))
        {
            Nat.add33To(8, PInv33, z);
        }
    }
}