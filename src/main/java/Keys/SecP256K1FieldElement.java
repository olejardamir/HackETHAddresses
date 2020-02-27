package Keys;

import java.math.BigInteger;

public class SecP256K1FieldElement extends ECFieldElement {
    private static final BigInteger Q = SecP256K1Curve.q;

    int[] x;

    public SecP256K1FieldElement(BigInteger x)
    {


        this.x = SecP256K1Field.fromBigInteger(x);
    }

    SecP256K1FieldElement(int[] x)
    {
        this.x = x;
    }

    public boolean isZero()
    {
        return Nat256.isZero(x);
    }

    public boolean isOne()
    {
        return Nat256.isOne(x);
    }

    public BigInteger toBigInteger()
    {
        return Nat256.toBigInteger(x);
    }

    public int getFieldSize()
    {
        return Q.bitLength();
    }

    public ECFieldElement add(ECFieldElement b)
    {
        int[] z = new int[8];
        SecP256K1Field.add(x, ((SecP256K1FieldElement)b).x, z);
        return new SecP256K1FieldElement(z);
    }



    public ECFieldElement multiply(ECFieldElement b)
    {
        int[] z = new int[8];
        int[] a2 = new int[16];
        long y_0 = ((SecP256K1FieldElement)b).x[0] & 0xFFFFFFFFL;
        long y_1 = ((SecP256K1FieldElement)b).x[1] & 0xFFFFFFFFL;
        long y_2 = ((SecP256K1FieldElement)b).x[2] & 0xFFFFFFFFL;
        long y_3 = ((SecP256K1FieldElement)b).x[3] & 0xFFFFFFFFL;
        long y_4 = ((SecP256K1FieldElement)b).x[4] & 0xFFFFFFFFL;
        long y_5 = ((SecP256K1FieldElement)b).x[5] & 0xFFFFFFFFL;
        long y_6 = ((SecP256K1FieldElement)b).x[6] & 0xFFFFFFFFL;
        long y_7 = ((SecP256K1FieldElement)b).x[7] & 0xFFFFFFFFL;


            long c = 0, x_0 = x[0] & 0xFFFFFFFFL;
            c += x_0 * y_0;
            a2[0] = (int)c;
            c >>>= 32;
            c += x_0 * y_1;
            a2[1] = (int)c;
            c >>>= 32;
            c += x_0 * y_2;
            a2[2] = (int)c;
            c >>>= 32;
            c += x_0 * y_3;
            a2[3] = (int)c;
            c >>>= 32;
            c += x_0 * y_4;
            a2[4] = (int)c;
            c >>>= 32;
            c += x_0 * y_5;
            a2[5] = (int)c;
            c >>>= 32;
            c += x_0 * y_6;
            a2[6] = (int)c;
            c >>>= 32;
            c += x_0 * y_7;
            a2[7] = (int)c;
            c >>>= 32;
            a2[8] = (int)c;


        for (int i = 1; i < 8; ++i)
        {
            c = 0;
            long  x_i = x[i] & 0xFFFFFFFFL;
            c += x_i * y_0 + (a2[i] & 0xFFFFFFFFL);
            a2[i] = (int)c;
            c >>>= 32;
            c += x_i * y_1 + (a2[i + 1] & 0xFFFFFFFFL);
            a2[i + 1] = (int)c;
            c >>>= 32;
            c += x_i * y_2 + (a2[i + 2] & 0xFFFFFFFFL);
            a2[i + 2] = (int)c;
            c >>>= 32;
            c += x_i * y_3 + (a2[i + 3] & 0xFFFFFFFFL);
            a2[i + 3] = (int)c;
            c >>>= 32;
            c += x_i * y_4 + (a2[i + 4] & 0xFFFFFFFFL);
            a2[i + 4] = (int)c;
            c >>>= 32;
            c += x_i * y_5 + (a2[i + 5] & 0xFFFFFFFFL);
            a2[i + 5] = (int)c;
            c >>>= 32;
            c += x_i * y_6 + (a2[i + 6] & 0xFFFFFFFFL);
            a2[i + 6] = (int)c;
            c >>>= 32;
            c += x_i * y_7 + (a2[i + 7] & 0xFFFFFFFFL);
            a2[i + 7] = (int)c;
            c >>>= 32;
            a2[i + 8] = (int)c;
        }
        SecP256K1Field.reduce(a2, z);
        return new SecP256K1FieldElement(z);
    }


    public ECFieldElement negate()
    {
        int[] z = new int[8];
        SecP256K1Field.negate(x, z);
        return new SecP256K1FieldElement(z);
    }

    public ECFieldElement square()
    {
        int[] z = new int[8];
        int[] a1 = new int[16];
        long x_0 = x[0] & 0xFFFFFFFFL;
        long zz_1;

        int c = 0, w;
        {
            int i = 7, j = 16;
            do
            {
                long xVal = (x[i--] & 0xFFFFFFFFL);
                long p = xVal * xVal;
                a1[--j] = (c << 31) | (int)(p >>> 33);
                a1[--j] = (int)(p >>> 1);
                c = (int)p;
            }
            while (i > 0);

            {
                long p = x_0 * x_0;
                zz_1 = ((c << 31) & 0xFFFFFFFFL) | (p >>> 33);
                a1[0] = (int)p;
                c = (int)(p >>> 32) & 1;
            }
        }

        long x_1 = x[1] & 0xFFFFFFFFL;
        long zz_2 = a1[2] & 0xFFFFFFFFL;

        {
            zz_1 += x_1 * x_0;
            w = (int)zz_1;
            a1[1] = (w << 1) | c;
            c = w >>> 31;
            zz_2 += zz_1 >>> 32;
        }

        long x_2 = x[2] & 0xFFFFFFFFL;
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

        long x_3 = x[3] & 0xFFFFFFFFL;
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

        long x_4 = x[4] & 0xFFFFFFFFL;
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

        long x_5 = x[5] & 0xFFFFFFFFL;
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

        long x_6 = x[6] & 0xFFFFFFFFL;
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

        long x_7 = x[7] & 0xFFFFFFFFL;
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
        SecP256K1Field.reduce(a1, z);
        return new SecP256K1FieldElement(z);
    }

    public ECFieldElement invert()
    {

        int[] z = new int[8];
        Mod.invert(SecP256K1Field.P, x, z);
        return new SecP256K1FieldElement(z);
    }


}
