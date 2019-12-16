
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

    public boolean testBitZero()
    {
        if (0 == 0) {
			return (x[0] & 1) == 1;
		}
		if ((0 & 255) != 0) {
			return 0 == 1;
		}
		return ((x[(0 >>> 5)] >>> (0 & 31)) & 1) == 1;
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
        int[] z;
		z = new int[8];
		SecP256K1Field.add(x, ((SecP256K1FieldElement)b).x, z);
        return new SecP256K1FieldElement(z);
    }



    public ECFieldElement multiply(ECFieldElement b)
    {
        int[] z;
		z = new int[8];
		int[] a2;
		a2 = new int[16];
		long y_0;
		y_0 = ((SecP256K1FieldElement) b).x[0] & 0xFFFFFFFFL;
		long y_1;
		y_1 = ((SecP256K1FieldElement) b).x[1] & 0xFFFFFFFFL;
		long y_2;
		y_2 = ((SecP256K1FieldElement) b).x[2] & 0xFFFFFFFFL;
		long y_3;
		y_3 = ((SecP256K1FieldElement) b).x[3] & 0xFFFFFFFFL;
		long y_4;
		y_4 = ((SecP256K1FieldElement) b).x[4] & 0xFFFFFFFFL;
		long y_5;
		y_5 = ((SecP256K1FieldElement) b).x[5] & 0xFFFFFFFFL;
		long y_6;
		y_6 = ((SecP256K1FieldElement) b).x[6] & 0xFFFFFFFFL;
		long y_7;
		y_7 = ((SecP256K1FieldElement) b).x[7] & 0xFFFFFFFFL;
		{
            long c;
			c = 0;
			long x_0;
			x_0 = x[0] & 0xFFFFFFFFL;
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
        }

        for (int i = 1; i < 8; i += 1)
        {
            long c;
			c = 0;
			long x_i;
			x_i = x[i] & 0xFFFFFFFFL;
			c += (x_i * y_0) + (a2[i] & 0xFFFFFFFFL);
            a2[i] = (int)c;
            c >>>= 32;
            c += (x_i * y_1) + (a2[i + 1] & 0xFFFFFFFFL);
            a2[i + 1] = (int)c;
            c >>>= 32;
            c += (x_i * y_2) + (a2[i + 2] & 0xFFFFFFFFL);
            a2[i + 2] = (int)c;
            c >>>= 32;
            c += (x_i * y_3) + (a2[i + 3] & 0xFFFFFFFFL);
            a2[i + 3] = (int)c;
            c >>>= 32;
            c += (x_i * y_4) + (a2[i + 4] & 0xFFFFFFFFL);
            a2[i + 4] = (int)c;
            c >>>= 32;
            c += (x_i * y_5) + (a2[i + 5] & 0xFFFFFFFFL);
            a2[i + 5] = (int)c;
            c >>>= 32;
            c += (x_i * y_6) + (a2[i + 6] & 0xFFFFFFFFL);
            a2[i + 6] = (int)c;
            c >>>= 32;
            c += (x_i * y_7) + (a2[i + 7] & 0xFFFFFFFFL);
            a2[i + 7] = (int)c;
            c >>>= 32;
            a2[i + 8] = (int)c;
        }
        SecP256K1Field.reduce(a2, z);
        return new SecP256K1FieldElement(z);
    }


    public ECFieldElement negate()
    {
        int[] z;
		z = new int[8];
		SecP256K1Field.negate(x, z);
        return new SecP256K1FieldElement(z);
    }

    public ECFieldElement square()
    {
        int[] z;
		z = new int[8];
		int[] a1;
		a1 = new int[16];
		long x_0;
		x_0 = x[0] & 0xFFFFFFFFL;
		long zz_1;

        int c = 0, w;
        {
            int i;
			i = 7;
			int j;
			j = 16;
			do
            {
                long xVal;
				xVal = x[i] & 0xFFFFFFFFL;
				i--;
				long p;
				p = xVal * xVal;
				j -= 1;
				a1[j] = (c << 31) | (int)(p >>> 33);
                j -= 1;
				a1[j] = (int)(p >>> 1);
                c = (int)p;
            }
            while (i > 0);

            {
                long p;
				p = x_0 * x_0;
				zz_1 = ((c << 31) & 0xFFFFFFFFL) | (p >>> 33);
                a1[0] = (int)p;
                c = (int)(p >>> 32) & 1;
            }
        }

        long x_1;
		x_1 = x[1] & 0xFFFFFFFFL;
		long zz_2;
		zz_2 = a1[2] & 0xFFFFFFFFL;
		{
            zz_1 += x_1 * x_0;
            w = (int)zz_1;
            a1[1] = (w << 1) | c;
            c = w >>> 31;
            zz_2 += zz_1 >>> 32;
        }

        long x_2;
		x_2 = x[2] & 0xFFFFFFFFL;
		long zz_3;
		zz_3 = a1[3] & 0xFFFFFFFFL;
		long zz_4;
		zz_4 = a1[4] & 0xFFFFFFFFL;
		{
            zz_2 += x_2 * x_0;
            w = (int)zz_2;
            a1[2] = (w << 1) | c;
            c = w >>> 31;
            zz_3 += (zz_2 >>> 32) + (x_2 * x_1);
            zz_4 += zz_3 >>> 32;
            zz_3 &= 0xFFFFFFFFL;
        }

        long x_3;
		x_3 = x[3] & 0xFFFFFFFFL;
		long zz_5;
		zz_5 = (a1[5] & 0xFFFFFFFFL) + (zz_4 >>> 32);
		zz_4 &= 0xFFFFFFFFL;
        long zz_6;
		zz_6 = (a1[6] & 0xFFFFFFFFL) + (zz_5 >>> 32);
		zz_5 &= 0xFFFFFFFFL;
        {
            zz_3 += x_3 * x_0;
            w = (int)zz_3;
            a1[3] = (w << 1) | c;
            c = w >>> 31;
            zz_4 += (zz_3 >>> 32) + (x_3 * x_1);
            zz_5 += (zz_4 >>> 32) + (x_3 * x_2);
            zz_4 &= 0xFFFFFFFFL;
            zz_6 += zz_5 >>> 32;
            zz_5 &= 0xFFFFFFFFL;
        }

        long x_4;
		x_4 = x[4] & 0xFFFFFFFFL;
		long zz_7;
		zz_7 = (a1[7] & 0xFFFFFFFFL) + (zz_6 >>> 32);
		zz_6 &= 0xFFFFFFFFL;
        long zz_8;
		zz_8 = (a1[8] & 0xFFFFFFFFL) + (zz_7 >>> 32);
		zz_7 &= 0xFFFFFFFFL;
        {
            zz_4 += x_4 * x_0;
            w = (int)zz_4;
            a1[4] = (w << 1) | c;
            c = w >>> 31;
            zz_5 += (zz_4 >>> 32) + (x_4 * x_1);
            zz_6 += (zz_5 >>> 32) + (x_4 * x_2);
            zz_5 &= 0xFFFFFFFFL;
            zz_7 += (zz_6 >>> 32) + (x_4 * x_3);
            zz_6 &= 0xFFFFFFFFL;
            zz_8 += zz_7 >>> 32;
            zz_7 &= 0xFFFFFFFFL;
        }

        long x_5;
		x_5 = x[5] & 0xFFFFFFFFL;
		long zz_9;
		zz_9 = (a1[9] & 0xFFFFFFFFL) + (zz_8 >>> 32);
		zz_8 &= 0xFFFFFFFFL;
        long zz_10;
		zz_10 = (a1[10] & 0xFFFFFFFFL) + (zz_9 >>> 32);
		zz_9 &= 0xFFFFFFFFL;
        {
            zz_5 += x_5 * x_0;
            w = (int)zz_5;
            a1[5] = (w << 1) | c;
            c = w >>> 31;
            zz_6 += (zz_5 >>> 32) + (x_5 * x_1);
            zz_7 += (zz_6 >>> 32) + (x_5 * x_2);
            zz_6 &= 0xFFFFFFFFL;
            zz_8 += (zz_7 >>> 32) + (x_5 * x_3);
            zz_7 &= 0xFFFFFFFFL;
            zz_9 += (zz_8 >>> 32) + (x_5 * x_4);
            zz_8 &= 0xFFFFFFFFL;
            zz_10 += zz_9 >>> 32;
            zz_9 &= 0xFFFFFFFFL;
        }

        long x_6;
		x_6 = x[6] & 0xFFFFFFFFL;
		long zz_11;
		zz_11 = (a1[11] & 0xFFFFFFFFL) + (zz_10 >>> 32);
		zz_10 &= 0xFFFFFFFFL;
        long zz_12;
		zz_12 = (a1[12] & 0xFFFFFFFFL) + (zz_11 >>> 32);
		zz_11 &= 0xFFFFFFFFL;
        {
            zz_6 += x_6 * x_0;
            w = (int)zz_6;
            a1[6] = (w << 1) | c;
            c = w >>> 31;
            zz_7 += (zz_6 >>> 32) + (x_6 * x_1);
            zz_8 += (zz_7 >>> 32) + (x_6 * x_2);
            zz_7 &= 0xFFFFFFFFL;
            zz_9 += (zz_8 >>> 32) + (x_6 * x_3);
            zz_8 &= 0xFFFFFFFFL;
            zz_10 += (zz_9 >>> 32) + (x_6 * x_4);
            zz_9 &= 0xFFFFFFFFL;
            zz_11 += (zz_10 >>> 32) + (x_6 * x_5);
            zz_10 &= 0xFFFFFFFFL;
            zz_12 += zz_11 >>> 32;
            zz_11 &= 0xFFFFFFFFL;
        }

        long x_7;
		x_7 = x[7] & 0xFFFFFFFFL;
		long zz_13;
		zz_13 = (a1[13] & 0xFFFFFFFFL) + (zz_12 >>> 32);
		zz_12 &= 0xFFFFFFFFL;
        long zz_14;
		zz_14 = (a1[14] & 0xFFFFFFFFL) + (zz_13 >>> 32);
		zz_13 &= 0xFFFFFFFFL;
        {
            zz_7 += x_7 * x_0;
            w = (int)zz_7;
            a1[7] = (w << 1) | c;
            c = w >>> 31;
            zz_8 += (zz_7 >>> 32) + (x_7 * x_1);
            zz_9 += (zz_8 >>> 32) + (x_7 * x_2);
            zz_10 += (zz_9 >>> 32) + (x_7 * x_3);
            zz_11 += (zz_10 >>> 32) + (x_7 * x_4);
            zz_12 += (zz_11 >>> 32) + (x_7 * x_5);
            zz_13 += (zz_12 >>> 32) + (x_7 * x_6);
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

        int[] z;
		z = new int[8];
		Mod.invert(SecP256K1Field.P, x, z);
        return new SecP256K1FieldElement(z);
    }

    
    
    public ECFieldElement sqrt()
    {
        

        int[] x1 = this.x;
        if (Nat256.isZero(x1) || Nat256.isOne(x1))
        {
            return this;
        }

        int[] x2 = new int[8];
        int[] a12 = new int[16];
        long x_02 = x1[0] & 0xFFFFFFFFL;
        long zz_16;

        int c2 = 0, w2;
        {
            int i2 = 7, j2 = 16;
            do
            {
                long xVal2 = (x1[i2--] & 0xFFFFFFFFL);
                long p2 = xVal2 * xVal2;
                a12[--j2] = (c2 << 31) | (int)(p2 >>> 33);
                a12[--j2] = (int)(p2 >>> 1);
                c2 = (int) p2;
            }
            while (i2 > 0);

            {
                long p2 = x_02 * x_02;
                zz_16 = ((c2 << 31) & 0xFFFFFFFFL) | (p2 >>> 33);
                a12[0] = (int) p2;
                c2 = (int)(p2 >>> 32) & 1;
            }
        }

        long x_12 = x1[1] & 0xFFFFFFFFL;
        long zz_22 = a12[2] & 0xFFFFFFFFL;

        {
            zz_16 += x_12 * x_02;
            w2 = (int) zz_16;
            a12[1] = (w2 << 1) | c2;
            c2 = w2 >>> 31;
            zz_22 += zz_16 >>> 32;
        }

        long x_22 = x1[2] & 0xFFFFFFFFL;
        long zz_32 = a12[3] & 0xFFFFFFFFL;
        long zz_42 = a12[4] & 0xFFFFFFFFL;
        {
            zz_22 += x_22 * x_02;
            w2 = (int) zz_22;
            a12[2] = (w2 << 1) | c2;
            c2 = w2 >>> 31;
            zz_32 += (zz_22 >>> 32) + x_22 * x_12;
            zz_42 += zz_32 >>> 32;
            zz_32 &= 0xFFFFFFFFL;
        }

        long x_32 = x1[3] & 0xFFFFFFFFL;
        long zz_52 = (a12[5] & 0xFFFFFFFFL) + (zz_42 >>> 32);
        zz_42 &= 0xFFFFFFFFL;
        long zz_62 = (a12[6] & 0xFFFFFFFFL) + (zz_52 >>> 32);
        zz_52 &= 0xFFFFFFFFL;
        {
            zz_32 += x_32 * x_02;
            w2 = (int) zz_32;
            a12[3] = (w2 << 1) | c2;
            c2 = w2 >>> 31;
            zz_42 += (zz_32 >>> 32) + x_32 * x_12;
            zz_52 += (zz_42 >>> 32) + x_32 * x_22;
            zz_42 &= 0xFFFFFFFFL;
            zz_62 += zz_52 >>> 32;
            zz_52 &= 0xFFFFFFFFL;
        }

        long x_42 = x1[4] & 0xFFFFFFFFL;
        long zz_72 = (a12[7] & 0xFFFFFFFFL) + (zz_62 >>> 32);
        zz_62 &= 0xFFFFFFFFL;
        long zz_82 = (a12[8] & 0xFFFFFFFFL) + (zz_72 >>> 32);
        zz_72 &= 0xFFFFFFFFL;
        {
            zz_42 += x_42 * x_02;
            w2 = (int) zz_42;
            a12[4] = (w2 << 1) | c2;
            c2 = w2 >>> 31;
            zz_52 += (zz_42 >>> 32) + x_42 * x_12;
            zz_62 += (zz_52 >>> 32) + x_42 * x_22;
            zz_52 &= 0xFFFFFFFFL;
            zz_72 += (zz_62 >>> 32) + x_42 * x_32;
            zz_62 &= 0xFFFFFFFFL;
            zz_82 += zz_72 >>> 32;
            zz_72 &= 0xFFFFFFFFL;
        }

        long x_52 = x1[5] & 0xFFFFFFFFL;
        long zz_92 = (a12[9] & 0xFFFFFFFFL) + (zz_82 >>> 32);
        zz_82 &= 0xFFFFFFFFL;
        long zz_102 = (a12[10] & 0xFFFFFFFFL) + (zz_92 >>> 32);
        zz_92 &= 0xFFFFFFFFL;
        {
            zz_52 += x_52 * x_02;
            w2 = (int) zz_52;
            a12[5] = (w2 << 1) | c2;
            c2 = w2 >>> 31;
            zz_62 += (zz_52 >>> 32) + x_52 * x_12;
            zz_72 += (zz_62 >>> 32) + x_52 * x_22;
            zz_62 &= 0xFFFFFFFFL;
            zz_82 += (zz_72 >>> 32) + x_52 * x_32;
            zz_72 &= 0xFFFFFFFFL;
            zz_92 += (zz_82 >>> 32) + x_52 * x_42;
            zz_82 &= 0xFFFFFFFFL;
            zz_102 += zz_92 >>> 32;
            zz_92 &= 0xFFFFFFFFL;
        }

        long x_62 = x1[6] & 0xFFFFFFFFL;
        long zz_112 = (a12[11] & 0xFFFFFFFFL) + (zz_102 >>> 32);
        zz_102 &= 0xFFFFFFFFL;
        long zz_122 = (a12[12] & 0xFFFFFFFFL) + (zz_112 >>> 32);
        zz_112 &= 0xFFFFFFFFL;
        {
            zz_62 += x_62 * x_02;
            w2 = (int) zz_62;
            a12[6] = (w2 << 1) | c2;
            c2 = w2 >>> 31;
            zz_72 += (zz_62 >>> 32) + x_62 * x_12;
            zz_82 += (zz_72 >>> 32) + x_62 * x_22;
            zz_72 &= 0xFFFFFFFFL;
            zz_92 += (zz_82 >>> 32) + x_62 * x_32;
            zz_82 &= 0xFFFFFFFFL;
            zz_102 += (zz_92 >>> 32) + x_62 * x_42;
            zz_92 &= 0xFFFFFFFFL;
            zz_112 += (zz_102 >>> 32) + x_62 * x_52;
            zz_102 &= 0xFFFFFFFFL;
            zz_122 += zz_112 >>> 32;
            zz_112 &= 0xFFFFFFFFL;
        }

        long x_72 = x1[7] & 0xFFFFFFFFL;
        long zz_132 = (a12[13] & 0xFFFFFFFFL) + (zz_122 >>> 32);
        zz_122 &= 0xFFFFFFFFL;
        long zz_142 = (a12[14] & 0xFFFFFFFFL) + (zz_132 >>> 32);
        zz_132 &= 0xFFFFFFFFL;
        {
            zz_72 += x_72 * x_02;
            w2 = (int) zz_72;
            a12[7] = (w2 << 1) | c2;
            c2 = w2 >>> 31;
            zz_82 += (zz_72 >>> 32) + x_72 * x_12;
            zz_92 += (zz_82 >>> 32) + x_72 * x_22;
            zz_102 += (zz_92 >>> 32) + x_72 * x_32;
            zz_112 += (zz_102 >>> 32) + x_72 * x_42;
            zz_122 += (zz_112 >>> 32) + x_72 * x_52;
            zz_132 += (zz_122 >>> 32) + x_72 * x_62;
            zz_142 += zz_132 >>> 32;
        }

        w2 = (int) zz_82;
        a12[8] = (w2 << 1) | c2;
        c2 = w2 >>> 31;
        w2 = (int) zz_92;
        a12[9] = (w2 << 1) | c2;
        c2 = w2 >>> 31;
        w2 = (int) zz_102;
        a12[10] = (w2 << 1) | c2;
        c2 = w2 >>> 31;
        w2 = (int) zz_112;
        a12[11] = (w2 << 1) | c2;
        c2 = w2 >>> 31;
        w2 = (int) zz_122;
        a12[12] = (w2 << 1) | c2;
        c2 = w2 >>> 31;
        w2 = (int) zz_132;
        a12[13] = (w2 << 1) | c2;
        c2 = w2 >>> 31;
        w2 = (int) zz_142;
        a12[14] = (w2 << 1) | c2;
        c2 = w2 >>> 31;
        w2 = a12[15] + (int)(zz_142 >>> 32);
        a12[15] = (w2 << 1) | c2;
        SecP256K1Field.reduce(a12, x2);
        int[] a212 = new int[16];
        long y_012 = x1[0] & 0xFFFFFFFFL;
        long y_112 = x1[1] & 0xFFFFFFFFL;
        long y_212 = x1[2] & 0xFFFFFFFFL;
        long y_312 = x1[3] & 0xFFFFFFFFL;
        long y_412 = x1[4] & 0xFFFFFFFFL;
        long y_512 = x1[5] & 0xFFFFFFFFL;
        long y_612 = x1[6] & 0xFFFFFFFFL;
        long y_712 = x1[7] & 0xFFFFFFFFL;

        {
            long c15 = 0, x_015 = x2[0] & 0xFFFFFFFFL;
            c15 += x_015 * y_012;
            a212[0] = (int) c15;
            c15 >>>= 32;
            c15 += x_015 * y_112;
            a212[1] = (int) c15;
            c15 >>>= 32;
            c15 += x_015 * y_212;
            a212[2] = (int) c15;
            c15 >>>= 32;
            c15 += x_015 * y_312;
            a212[3] = (int) c15;
            c15 >>>= 32;
            c15 += x_015 * y_412;
            a212[4] = (int) c15;
            c15 >>>= 32;
            c15 += x_015 * y_512;
            a212[5] = (int) c15;
            c15 >>>= 32;
            c15 += x_015 * y_612;
            a212[6] = (int) c15;
            c15 >>>= 32;
            c15 += x_015 * y_712;
            a212[7] = (int) c15;
            c15 >>>= 32;
            a212[8] = (int) c15;
        }

        for (int i13 = 1; i13 < 8; ++i13)
        {
            long c15 = 0, x_i12 = x2[i13] & 0xFFFFFFFFL;
            c15 += x_i12 * y_012 + (a212[i13] & 0xFFFFFFFFL);
            a212[i13] = (int) c15;
            c15 >>>= 32;
            c15 += x_i12 * y_112 + (a212[i13 + 1] & 0xFFFFFFFFL);
            a212[i13 + 1] = (int) c15;
            c15 >>>= 32;
            c15 += x_i12 * y_212 + (a212[i13 + 2] & 0xFFFFFFFFL);
            a212[i13 + 2] = (int) c15;
            c15 >>>= 32;
            c15 += x_i12 * y_312 + (a212[i13 + 3] & 0xFFFFFFFFL);
            a212[i13 + 3] = (int) c15;
            c15 >>>= 32;
            c15 += x_i12 * y_412 + (a212[i13 + 4] & 0xFFFFFFFFL);
            a212[i13 + 4] = (int) c15;
            c15 >>>= 32;
            c15 += x_i12 * y_512 + (a212[i13 + 5] & 0xFFFFFFFFL);
            a212[i13 + 5] = (int) c15;
            c15 >>>= 32;
            c15 += x_i12 * y_612 + (a212[i13 + 6] & 0xFFFFFFFFL);
            a212[i13 + 6] = (int) c15;
            c15 >>>= 32;
            c15 += x_i12 * y_712 + (a212[i13 + 7] & 0xFFFFFFFFL);
            a212[i13 + 7] = (int) c15;
            c15 >>>= 32;
            a212[i13 + 8] = (int) c15;
        }
        SecP256K1Field.reduce(a212, x2);
        int[] x3 = new int[8];
        int[] a11 = new int[16];
        long x_01 = x2[0] & 0xFFFFFFFFL;
        long zz_15;

        int c1 = 0, w1;
        {
            int i1 = 7, j1 = 16;
            do
            {
                long xVal1 = (x2[i1--] & 0xFFFFFFFFL);
                long p1 = xVal1 * xVal1;
                a11[--j1] = (c1 << 31) | (int)(p1 >>> 33);
                a11[--j1] = (int)(p1 >>> 1);
                c1 = (int) p1;
            }
            while (i1 > 0);

            {
                long p1 = x_01 * x_01;
                zz_15 = ((c1 << 31) & 0xFFFFFFFFL) | (p1 >>> 33);
                a11[0] = (int) p1;
                c1 = (int)(p1 >>> 32) & 1;
            }
        }

        long x_11 = x2[1] & 0xFFFFFFFFL;
        long zz_21 = a11[2] & 0xFFFFFFFFL;

        {
            zz_15 += x_11 * x_01;
            w1 = (int) zz_15;
            a11[1] = (w1 << 1) | c1;
            c1 = w1 >>> 31;
            zz_21 += zz_15 >>> 32;
        }

        long x_21 = x2[2] & 0xFFFFFFFFL;
        long zz_31 = a11[3] & 0xFFFFFFFFL;
        long zz_41 = a11[4] & 0xFFFFFFFFL;
        {
            zz_21 += x_21 * x_01;
            w1 = (int) zz_21;
            a11[2] = (w1 << 1) | c1;
            c1 = w1 >>> 31;
            zz_31 += (zz_21 >>> 32) + x_21 * x_11;
            zz_41 += zz_31 >>> 32;
            zz_31 &= 0xFFFFFFFFL;
        }

        long x_31 = x2[3] & 0xFFFFFFFFL;
        long zz_51 = (a11[5] & 0xFFFFFFFFL) + (zz_41 >>> 32);
        zz_41 &= 0xFFFFFFFFL;
        long zz_61 = (a11[6] & 0xFFFFFFFFL) + (zz_51 >>> 32);
        zz_51 &= 0xFFFFFFFFL;
        {
            zz_31 += x_31 * x_01;
            w1 = (int) zz_31;
            a11[3] = (w1 << 1) | c1;
            c1 = w1 >>> 31;
            zz_41 += (zz_31 >>> 32) + x_31 * x_11;
            zz_51 += (zz_41 >>> 32) + x_31 * x_21;
            zz_41 &= 0xFFFFFFFFL;
            zz_61 += zz_51 >>> 32;
            zz_51 &= 0xFFFFFFFFL;
        }

        long x_41 = x2[4] & 0xFFFFFFFFL;
        long zz_71 = (a11[7] & 0xFFFFFFFFL) + (zz_61 >>> 32);
        zz_61 &= 0xFFFFFFFFL;
        long zz_81 = (a11[8] & 0xFFFFFFFFL) + (zz_71 >>> 32);
        zz_71 &= 0xFFFFFFFFL;
        {
            zz_41 += x_41 * x_01;
            w1 = (int) zz_41;
            a11[4] = (w1 << 1) | c1;
            c1 = w1 >>> 31;
            zz_51 += (zz_41 >>> 32) + x_41 * x_11;
            zz_61 += (zz_51 >>> 32) + x_41 * x_21;
            zz_51 &= 0xFFFFFFFFL;
            zz_71 += (zz_61 >>> 32) + x_41 * x_31;
            zz_61 &= 0xFFFFFFFFL;
            zz_81 += zz_71 >>> 32;
            zz_71 &= 0xFFFFFFFFL;
        }

        long x_51 = x2[5] & 0xFFFFFFFFL;
        long zz_91 = (a11[9] & 0xFFFFFFFFL) + (zz_81 >>> 32);
        zz_81 &= 0xFFFFFFFFL;
        long zz_101 = (a11[10] & 0xFFFFFFFFL) + (zz_91 >>> 32);
        zz_91 &= 0xFFFFFFFFL;
        {
            zz_51 += x_51 * x_01;
            w1 = (int) zz_51;
            a11[5] = (w1 << 1) | c1;
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

        long x_61 = x2[6] & 0xFFFFFFFFL;
        long zz_111 = (a11[11] & 0xFFFFFFFFL) + (zz_101 >>> 32);
        zz_101 &= 0xFFFFFFFFL;
        long zz_121 = (a11[12] & 0xFFFFFFFFL) + (zz_111 >>> 32);
        zz_111 &= 0xFFFFFFFFL;
        {
            zz_61 += x_61 * x_01;
            w1 = (int) zz_61;
            a11[6] = (w1 << 1) | c1;
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

        long x_71 = x2[7] & 0xFFFFFFFFL;
        long zz_131 = (a11[13] & 0xFFFFFFFFL) + (zz_121 >>> 32);
        zz_121 &= 0xFFFFFFFFL;
        long zz_141 = (a11[14] & 0xFFFFFFFFL) + (zz_131 >>> 32);
        zz_131 &= 0xFFFFFFFFL;
        {
            zz_71 += x_71 * x_01;
            w1 = (int) zz_71;
            a11[7] = (w1 << 1) | c1;
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
        a11[8] = (w1 << 1) | c1;
        c1 = w1 >>> 31;
        w1 = (int) zz_91;
        a11[9] = (w1 << 1) | c1;
        c1 = w1 >>> 31;
        w1 = (int) zz_101;
        a11[10] = (w1 << 1) | c1;
        c1 = w1 >>> 31;
        w1 = (int) zz_111;
        a11[11] = (w1 << 1) | c1;
        c1 = w1 >>> 31;
        w1 = (int) zz_121;
        a11[12] = (w1 << 1) | c1;
        c1 = w1 >>> 31;
        w1 = (int) zz_131;
        a11[13] = (w1 << 1) | c1;
        c1 = w1 >>> 31;
        w1 = (int) zz_141;
        a11[14] = (w1 << 1) | c1;
        c1 = w1 >>> 31;
        w1 = a11[15] + (int)(zz_141 >>> 32);
        a11[15] = (w1 << 1) | c1;
        SecP256K1Field.reduce(a11, x3);
        int[] a211 = new int[16];
        long y_011 = x1[0] & 0xFFFFFFFFL;
        long y_111 = x1[1] & 0xFFFFFFFFL;
        long y_211 = x1[2] & 0xFFFFFFFFL;
        long y_311 = x1[3] & 0xFFFFFFFFL;
        long y_411 = x1[4] & 0xFFFFFFFFL;
        long y_511 = x1[5] & 0xFFFFFFFFL;
        long y_611 = x1[6] & 0xFFFFFFFFL;
        long y_711 = x1[7] & 0xFFFFFFFFL;

        {
            long c14 = 0, x_014 = x3[0] & 0xFFFFFFFFL;
            c14 += x_014 * y_011;
            a211[0] = (int) c14;
            c14 >>>= 32;
            c14 += x_014 * y_111;
            a211[1] = (int) c14;
            c14 >>>= 32;
            c14 += x_014 * y_211;
            a211[2] = (int) c14;
            c14 >>>= 32;
            c14 += x_014 * y_311;
            a211[3] = (int) c14;
            c14 >>>= 32;
            c14 += x_014 * y_411;
            a211[4] = (int) c14;
            c14 >>>= 32;
            c14 += x_014 * y_511;
            a211[5] = (int) c14;
            c14 >>>= 32;
            c14 += x_014 * y_611;
            a211[6] = (int) c14;
            c14 >>>= 32;
            c14 += x_014 * y_711;
            a211[7] = (int) c14;
            c14 >>>= 32;
            a211[8] = (int) c14;
        }

        for (int i12 = 1; i12 < 8; ++i12)
        {
            long c14 = 0, x_i11 = x3[i12] & 0xFFFFFFFFL;
            c14 += x_i11 * y_011 + (a211[i12] & 0xFFFFFFFFL);
            a211[i12] = (int) c14;
            c14 >>>= 32;
            c14 += x_i11 * y_111 + (a211[i12 + 1] & 0xFFFFFFFFL);
            a211[i12 + 1] = (int) c14;
            c14 >>>= 32;
            c14 += x_i11 * y_211 + (a211[i12 + 2] & 0xFFFFFFFFL);
            a211[i12 + 2] = (int) c14;
            c14 >>>= 32;
            c14 += x_i11 * y_311 + (a211[i12 + 3] & 0xFFFFFFFFL);
            a211[i12 + 3] = (int) c14;
            c14 >>>= 32;
            c14 += x_i11 * y_411 + (a211[i12 + 4] & 0xFFFFFFFFL);
            a211[i12 + 4] = (int) c14;
            c14 >>>= 32;
            c14 += x_i11 * y_511 + (a211[i12 + 5] & 0xFFFFFFFFL);
            a211[i12 + 5] = (int) c14;
            c14 >>>= 32;
            c14 += x_i11 * y_611 + (a211[i12 + 6] & 0xFFFFFFFFL);
            a211[i12 + 6] = (int) c14;
            c14 >>>= 32;
            c14 += x_i11 * y_711 + (a211[i12 + 7] & 0xFFFFFFFFL);
            a211[i12 + 7] = (int) c14;
            c14 >>>= 32;
            a211[i12 + 8] = (int) c14;
        }
        SecP256K1Field.reduce(a211, x3);
        int[] x6 = new int[8];
        SecP256K1Field.squareN(x3, 3, x6);
        int[] a210 = new int[16];
        long y_010 = x3[0] & 0xFFFFFFFFL;
        long y_110 = x3[1] & 0xFFFFFFFFL;
        long y_210 = x3[2] & 0xFFFFFFFFL;
        long y_310 = x3[3] & 0xFFFFFFFFL;
        long y_410 = x3[4] & 0xFFFFFFFFL;
        long y_510 = x3[5] & 0xFFFFFFFFL;
        long y_610 = x3[6] & 0xFFFFFFFFL;
        long y_710 = x3[7] & 0xFFFFFFFFL;

        {
            long c13 = 0, x_013 = x6[0] & 0xFFFFFFFFL;
            c13 += x_013 * y_010;
            a210[0] = (int) c13;
            c13 >>>= 32;
            c13 += x_013 * y_110;
            a210[1] = (int) c13;
            c13 >>>= 32;
            c13 += x_013 * y_210;
            a210[2] = (int) c13;
            c13 >>>= 32;
            c13 += x_013 * y_310;
            a210[3] = (int) c13;
            c13 >>>= 32;
            c13 += x_013 * y_410;
            a210[4] = (int) c13;
            c13 >>>= 32;
            c13 += x_013 * y_510;
            a210[5] = (int) c13;
            c13 >>>= 32;
            c13 += x_013 * y_610;
            a210[6] = (int) c13;
            c13 >>>= 32;
            c13 += x_013 * y_710;
            a210[7] = (int) c13;
            c13 >>>= 32;
            a210[8] = (int) c13;
        }

        for (int i11 = 1; i11 < 8; ++i11)
        {
            long c13 = 0, x_i10 = x6[i11] & 0xFFFFFFFFL;
            c13 += x_i10 * y_010 + (a210[i11] & 0xFFFFFFFFL);
            a210[i11] = (int) c13;
            c13 >>>= 32;
            c13 += x_i10 * y_110 + (a210[i11 + 1] & 0xFFFFFFFFL);
            a210[i11 + 1] = (int) c13;
            c13 >>>= 32;
            c13 += x_i10 * y_210 + (a210[i11 + 2] & 0xFFFFFFFFL);
            a210[i11 + 2] = (int) c13;
            c13 >>>= 32;
            c13 += x_i10 * y_310 + (a210[i11 + 3] & 0xFFFFFFFFL);
            a210[i11 + 3] = (int) c13;
            c13 >>>= 32;
            c13 += x_i10 * y_410 + (a210[i11 + 4] & 0xFFFFFFFFL);
            a210[i11 + 4] = (int) c13;
            c13 >>>= 32;
            c13 += x_i10 * y_510 + (a210[i11 + 5] & 0xFFFFFFFFL);
            a210[i11 + 5] = (int) c13;
            c13 >>>= 32;
            c13 += x_i10 * y_610 + (a210[i11 + 6] & 0xFFFFFFFFL);
            a210[i11 + 6] = (int) c13;
            c13 >>>= 32;
            c13 += x_i10 * y_710 + (a210[i11 + 7] & 0xFFFFFFFFL);
            a210[i11 + 7] = (int) c13;
            c13 >>>= 32;
            a210[i11 + 8] = (int) c13;
        }
        SecP256K1Field.reduce(a210, x6);
        SecP256K1Field.squareN(x6, 3, x6);
        int[] a29 = new int[16];
        long y_09 = x3[0] & 0xFFFFFFFFL;
        long y_19 = x3[1] & 0xFFFFFFFFL;
        long y_29 = x3[2] & 0xFFFFFFFFL;
        long y_39 = x3[3] & 0xFFFFFFFFL;
        long y_49 = x3[4] & 0xFFFFFFFFL;
        long y_59 = x3[5] & 0xFFFFFFFFL;
        long y_69 = x3[6] & 0xFFFFFFFFL;
        long y_79 = x3[7] & 0xFFFFFFFFL;

        {
            long c12 = 0, x_012 = x6[0] & 0xFFFFFFFFL;
            c12 += x_012 * y_09;
            a29[0] = (int) c12;
            c12 >>>= 32;
            c12 += x_012 * y_19;
            a29[1] = (int) c12;
            c12 >>>= 32;
            c12 += x_012 * y_29;
            a29[2] = (int) c12;
            c12 >>>= 32;
            c12 += x_012 * y_39;
            a29[3] = (int) c12;
            c12 >>>= 32;
            c12 += x_012 * y_49;
            a29[4] = (int) c12;
            c12 >>>= 32;
            c12 += x_012 * y_59;
            a29[5] = (int) c12;
            c12 >>>= 32;
            c12 += x_012 * y_69;
            a29[6] = (int) c12;
            c12 >>>= 32;
            c12 += x_012 * y_79;
            a29[7] = (int) c12;
            c12 >>>= 32;
            a29[8] = (int) c12;
        }

        for (int i10 = 1; i10 < 8; ++i10)
        {
            long c12 = 0, x_i9 = x6[i10] & 0xFFFFFFFFL;
            c12 += x_i9 * y_09 + (a29[i10] & 0xFFFFFFFFL);
            a29[i10] = (int) c12;
            c12 >>>= 32;
            c12 += x_i9 * y_19 + (a29[i10 + 1] & 0xFFFFFFFFL);
            a29[i10 + 1] = (int) c12;
            c12 >>>= 32;
            c12 += x_i9 * y_29 + (a29[i10 + 2] & 0xFFFFFFFFL);
            a29[i10 + 2] = (int) c12;
            c12 >>>= 32;
            c12 += x_i9 * y_39 + (a29[i10 + 3] & 0xFFFFFFFFL);
            a29[i10 + 3] = (int) c12;
            c12 >>>= 32;
            c12 += x_i9 * y_49 + (a29[i10 + 4] & 0xFFFFFFFFL);
            a29[i10 + 4] = (int) c12;
            c12 >>>= 32;
            c12 += x_i9 * y_59 + (a29[i10 + 5] & 0xFFFFFFFFL);
            a29[i10 + 5] = (int) c12;
            c12 >>>= 32;
            c12 += x_i9 * y_69 + (a29[i10 + 6] & 0xFFFFFFFFL);
            a29[i10 + 6] = (int) c12;
            c12 >>>= 32;
            c12 += x_i9 * y_79 + (a29[i10 + 7] & 0xFFFFFFFFL);
            a29[i10 + 7] = (int) c12;
            c12 >>>= 32;
            a29[i10 + 8] = (int) c12;
        }
        SecP256K1Field.reduce(a29, x6);
        SecP256K1Field.squareN(x6, 2, x6);
        int[] a28 = new int[16];
        long y_08 = x2[0] & 0xFFFFFFFFL;
        long y_18 = x2[1] & 0xFFFFFFFFL;
        long y_28 = x2[2] & 0xFFFFFFFFL;
        long y_38 = x2[3] & 0xFFFFFFFFL;
        long y_48 = x2[4] & 0xFFFFFFFFL;
        long y_58 = x2[5] & 0xFFFFFFFFL;
        long y_68 = x2[6] & 0xFFFFFFFFL;
        long y_78 = x2[7] & 0xFFFFFFFFL;

        {
            long c11 = 0, x_011 = x6[0] & 0xFFFFFFFFL;
            c11 += x_011 * y_08;
            a28[0] = (int) c11;
            c11 >>>= 32;
            c11 += x_011 * y_18;
            a28[1] = (int) c11;
            c11 >>>= 32;
            c11 += x_011 * y_28;
            a28[2] = (int) c11;
            c11 >>>= 32;
            c11 += x_011 * y_38;
            a28[3] = (int) c11;
            c11 >>>= 32;
            c11 += x_011 * y_48;
            a28[4] = (int) c11;
            c11 >>>= 32;
            c11 += x_011 * y_58;
            a28[5] = (int) c11;
            c11 >>>= 32;
            c11 += x_011 * y_68;
            a28[6] = (int) c11;
            c11 >>>= 32;
            c11 += x_011 * y_78;
            a28[7] = (int) c11;
            c11 >>>= 32;
            a28[8] = (int) c11;
        }

        for (int i9 = 1; i9 < 8; ++i9)
        {
            long c11 = 0, x_i8 = x6[i9] & 0xFFFFFFFFL;
            c11 += x_i8 * y_08 + (a28[i9] & 0xFFFFFFFFL);
            a28[i9] = (int) c11;
            c11 >>>= 32;
            c11 += x_i8 * y_18 + (a28[i9 + 1] & 0xFFFFFFFFL);
            a28[i9 + 1] = (int) c11;
            c11 >>>= 32;
            c11 += x_i8 * y_28 + (a28[i9 + 2] & 0xFFFFFFFFL);
            a28[i9 + 2] = (int) c11;
            c11 >>>= 32;
            c11 += x_i8 * y_38 + (a28[i9 + 3] & 0xFFFFFFFFL);
            a28[i9 + 3] = (int) c11;
            c11 >>>= 32;
            c11 += x_i8 * y_48 + (a28[i9 + 4] & 0xFFFFFFFFL);
            a28[i9 + 4] = (int) c11;
            c11 >>>= 32;
            c11 += x_i8 * y_58 + (a28[i9 + 5] & 0xFFFFFFFFL);
            a28[i9 + 5] = (int) c11;
            c11 >>>= 32;
            c11 += x_i8 * y_68 + (a28[i9 + 6] & 0xFFFFFFFFL);
            a28[i9 + 6] = (int) c11;
            c11 >>>= 32;
            c11 += x_i8 * y_78 + (a28[i9 + 7] & 0xFFFFFFFFL);
            a28[i9 + 7] = (int) c11;
            c11 >>>= 32;
            a28[i9 + 8] = (int) c11;
        }
        SecP256K1Field.reduce(a28, x6);
        int[] x22 = new int[8];
        SecP256K1Field.squareN(x6, 11, x22);
        int[] a27 = new int[16];
        long y_07 = x6[0] & 0xFFFFFFFFL;
        long y_17 = x6[1] & 0xFFFFFFFFL;
        long y_27 = x6[2] & 0xFFFFFFFFL;
        long y_37 = x6[3] & 0xFFFFFFFFL;
        long y_47 = x6[4] & 0xFFFFFFFFL;
        long y_57 = x6[5] & 0xFFFFFFFFL;
        long y_67 = x6[6] & 0xFFFFFFFFL;
        long y_77 = x6[7] & 0xFFFFFFFFL;

        {
            long c10 = 0, x_010 = x22[0] & 0xFFFFFFFFL;
            c10 += x_010 * y_07;
            a27[0] = (int) c10;
            c10 >>>= 32;
            c10 += x_010 * y_17;
            a27[1] = (int) c10;
            c10 >>>= 32;
            c10 += x_010 * y_27;
            a27[2] = (int) c10;
            c10 >>>= 32;
            c10 += x_010 * y_37;
            a27[3] = (int) c10;
            c10 >>>= 32;
            c10 += x_010 * y_47;
            a27[4] = (int) c10;
            c10 >>>= 32;
            c10 += x_010 * y_57;
            a27[5] = (int) c10;
            c10 >>>= 32;
            c10 += x_010 * y_67;
            a27[6] = (int) c10;
            c10 >>>= 32;
            c10 += x_010 * y_77;
            a27[7] = (int) c10;
            c10 >>>= 32;
            a27[8] = (int) c10;
        }

        for (int i8 = 1; i8 < 8; ++i8)
        {
            long c10 = 0, x_i7 = x22[i8] & 0xFFFFFFFFL;
            c10 += x_i7 * y_07 + (a27[i8] & 0xFFFFFFFFL);
            a27[i8] = (int) c10;
            c10 >>>= 32;
            c10 += x_i7 * y_17 + (a27[i8 + 1] & 0xFFFFFFFFL);
            a27[i8 + 1] = (int) c10;
            c10 >>>= 32;
            c10 += x_i7 * y_27 + (a27[i8 + 2] & 0xFFFFFFFFL);
            a27[i8 + 2] = (int) c10;
            c10 >>>= 32;
            c10 += x_i7 * y_37 + (a27[i8 + 3] & 0xFFFFFFFFL);
            a27[i8 + 3] = (int) c10;
            c10 >>>= 32;
            c10 += x_i7 * y_47 + (a27[i8 + 4] & 0xFFFFFFFFL);
            a27[i8 + 4] = (int) c10;
            c10 >>>= 32;
            c10 += x_i7 * y_57 + (a27[i8 + 5] & 0xFFFFFFFFL);
            a27[i8 + 5] = (int) c10;
            c10 >>>= 32;
            c10 += x_i7 * y_67 + (a27[i8 + 6] & 0xFFFFFFFFL);
            a27[i8 + 6] = (int) c10;
            c10 >>>= 32;
            c10 += x_i7 * y_77 + (a27[i8 + 7] & 0xFFFFFFFFL);
            a27[i8 + 7] = (int) c10;
            c10 >>>= 32;
            a27[i8 + 8] = (int) c10;
        }
        SecP256K1Field.reduce(a27, x22);
        SecP256K1Field.squareN(x22, 22, x6);
        int[] a26 = new int[16];
        long y_06 = x22[0] & 0xFFFFFFFFL;
        long y_16 = x22[1] & 0xFFFFFFFFL;
        long y_26 = x22[2] & 0xFFFFFFFFL;
        long y_36 = x22[3] & 0xFFFFFFFFL;
        long y_46 = x22[4] & 0xFFFFFFFFL;
        long y_56 = x22[5] & 0xFFFFFFFFL;
        long y_66 = x22[6] & 0xFFFFFFFFL;
        long y_76 = x22[7] & 0xFFFFFFFFL;

        {
            long c9 = 0, x_09 = x6[0] & 0xFFFFFFFFL;
            c9 += x_09 * y_06;
            a26[0] = (int) c9;
            c9 >>>= 32;
            c9 += x_09 * y_16;
            a26[1] = (int) c9;
            c9 >>>= 32;
            c9 += x_09 * y_26;
            a26[2] = (int) c9;
            c9 >>>= 32;
            c9 += x_09 * y_36;
            a26[3] = (int) c9;
            c9 >>>= 32;
            c9 += x_09 * y_46;
            a26[4] = (int) c9;
            c9 >>>= 32;
            c9 += x_09 * y_56;
            a26[5] = (int) c9;
            c9 >>>= 32;
            c9 += x_09 * y_66;
            a26[6] = (int) c9;
            c9 >>>= 32;
            c9 += x_09 * y_76;
            a26[7] = (int) c9;
            c9 >>>= 32;
            a26[8] = (int) c9;
        }

        for (int i7 = 1; i7 < 8; ++i7)
        {
            long c9 = 0, x_i6 = x6[i7] & 0xFFFFFFFFL;
            c9 += x_i6 * y_06 + (a26[i7] & 0xFFFFFFFFL);
            a26[i7] = (int) c9;
            c9 >>>= 32;
            c9 += x_i6 * y_16 + (a26[i7 + 1] & 0xFFFFFFFFL);
            a26[i7 + 1] = (int) c9;
            c9 >>>= 32;
            c9 += x_i6 * y_26 + (a26[i7 + 2] & 0xFFFFFFFFL);
            a26[i7 + 2] = (int) c9;
            c9 >>>= 32;
            c9 += x_i6 * y_36 + (a26[i7 + 3] & 0xFFFFFFFFL);
            a26[i7 + 3] = (int) c9;
            c9 >>>= 32;
            c9 += x_i6 * y_46 + (a26[i7 + 4] & 0xFFFFFFFFL);
            a26[i7 + 4] = (int) c9;
            c9 >>>= 32;
            c9 += x_i6 * y_56 + (a26[i7 + 5] & 0xFFFFFFFFL);
            a26[i7 + 5] = (int) c9;
            c9 >>>= 32;
            c9 += x_i6 * y_66 + (a26[i7 + 6] & 0xFFFFFFFFL);
            a26[i7 + 6] = (int) c9;
            c9 >>>= 32;
            c9 += x_i6 * y_76 + (a26[i7 + 7] & 0xFFFFFFFFL);
            a26[i7 + 7] = (int) c9;
            c9 >>>= 32;
            a26[i7 + 8] = (int) c9;
        }
        SecP256K1Field.reduce(a26, x6);
        int[] x88 = new int[8];
        SecP256K1Field.squareN(x6, 44, x88);
        int[] a25 = new int[16];
        long y_05 = x6[0] & 0xFFFFFFFFL;
        long y_15 = x6[1] & 0xFFFFFFFFL;
        long y_25 = x6[2] & 0xFFFFFFFFL;
        long y_35 = x6[3] & 0xFFFFFFFFL;
        long y_45 = x6[4] & 0xFFFFFFFFL;
        long y_55 = x6[5] & 0xFFFFFFFFL;
        long y_65 = x6[6] & 0xFFFFFFFFL;
        long y_75 = x6[7] & 0xFFFFFFFFL;

        {
            long c8 = 0, x_08 = x88[0] & 0xFFFFFFFFL;
            c8 += x_08 * y_05;
            a25[0] = (int) c8;
            c8 >>>= 32;
            c8 += x_08 * y_15;
            a25[1] = (int) c8;
            c8 >>>= 32;
            c8 += x_08 * y_25;
            a25[2] = (int) c8;
            c8 >>>= 32;
            c8 += x_08 * y_35;
            a25[3] = (int) c8;
            c8 >>>= 32;
            c8 += x_08 * y_45;
            a25[4] = (int) c8;
            c8 >>>= 32;
            c8 += x_08 * y_55;
            a25[5] = (int) c8;
            c8 >>>= 32;
            c8 += x_08 * y_65;
            a25[6] = (int) c8;
            c8 >>>= 32;
            c8 += x_08 * y_75;
            a25[7] = (int) c8;
            c8 >>>= 32;
            a25[8] = (int) c8;
        }

        for (int i6 = 1; i6 < 8; ++i6)
        {
            long c8 = 0, x_i5 = x88[i6] & 0xFFFFFFFFL;
            c8 += x_i5 * y_05 + (a25[i6] & 0xFFFFFFFFL);
            a25[i6] = (int) c8;
            c8 >>>= 32;
            c8 += x_i5 * y_15 + (a25[i6 + 1] & 0xFFFFFFFFL);
            a25[i6 + 1] = (int) c8;
            c8 >>>= 32;
            c8 += x_i5 * y_25 + (a25[i6 + 2] & 0xFFFFFFFFL);
            a25[i6 + 2] = (int) c8;
            c8 >>>= 32;
            c8 += x_i5 * y_35 + (a25[i6 + 3] & 0xFFFFFFFFL);
            a25[i6 + 3] = (int) c8;
            c8 >>>= 32;
            c8 += x_i5 * y_45 + (a25[i6 + 4] & 0xFFFFFFFFL);
            a25[i6 + 4] = (int) c8;
            c8 >>>= 32;
            c8 += x_i5 * y_55 + (a25[i6 + 5] & 0xFFFFFFFFL);
            a25[i6 + 5] = (int) c8;
            c8 >>>= 32;
            c8 += x_i5 * y_65 + (a25[i6 + 6] & 0xFFFFFFFFL);
            a25[i6 + 6] = (int) c8;
            c8 >>>= 32;
            c8 += x_i5 * y_75 + (a25[i6 + 7] & 0xFFFFFFFFL);
            a25[i6 + 7] = (int) c8;
            c8 >>>= 32;
            a25[i6 + 8] = (int) c8;
        }
        SecP256K1Field.reduce(a25, x88);
        int[] x176 = new int[8];
        SecP256K1Field.squareN(x88, 88, x176);
        int[] a24 = new int[16];
        long y_04 = x88[0] & 0xFFFFFFFFL;
        long y_14 = x88[1] & 0xFFFFFFFFL;
        long y_24 = x88[2] & 0xFFFFFFFFL;
        long y_34 = x88[3] & 0xFFFFFFFFL;
        long y_44 = x88[4] & 0xFFFFFFFFL;
        long y_54 = x88[5] & 0xFFFFFFFFL;
        long y_64 = x88[6] & 0xFFFFFFFFL;
        long y_74 = x88[7] & 0xFFFFFFFFL;

        {
            long c7 = 0, x_07 = x176[0] & 0xFFFFFFFFL;
            c7 += x_07 * y_04;
            a24[0] = (int) c7;
            c7 >>>= 32;
            c7 += x_07 * y_14;
            a24[1] = (int) c7;
            c7 >>>= 32;
            c7 += x_07 * y_24;
            a24[2] = (int) c7;
            c7 >>>= 32;
            c7 += x_07 * y_34;
            a24[3] = (int) c7;
            c7 >>>= 32;
            c7 += x_07 * y_44;
            a24[4] = (int) c7;
            c7 >>>= 32;
            c7 += x_07 * y_54;
            a24[5] = (int) c7;
            c7 >>>= 32;
            c7 += x_07 * y_64;
            a24[6] = (int) c7;
            c7 >>>= 32;
            c7 += x_07 * y_74;
            a24[7] = (int) c7;
            c7 >>>= 32;
            a24[8] = (int) c7;
        }

        for (int i5 = 1; i5 < 8; ++i5)
        {
            long c7 = 0, x_i4 = x176[i5] & 0xFFFFFFFFL;
            c7 += x_i4 * y_04 + (a24[i5] & 0xFFFFFFFFL);
            a24[i5] = (int) c7;
            c7 >>>= 32;
            c7 += x_i4 * y_14 + (a24[i5 + 1] & 0xFFFFFFFFL);
            a24[i5 + 1] = (int) c7;
            c7 >>>= 32;
            c7 += x_i4 * y_24 + (a24[i5 + 2] & 0xFFFFFFFFL);
            a24[i5 + 2] = (int) c7;
            c7 >>>= 32;
            c7 += x_i4 * y_34 + (a24[i5 + 3] & 0xFFFFFFFFL);
            a24[i5 + 3] = (int) c7;
            c7 >>>= 32;
            c7 += x_i4 * y_44 + (a24[i5 + 4] & 0xFFFFFFFFL);
            a24[i5 + 4] = (int) c7;
            c7 >>>= 32;
            c7 += x_i4 * y_54 + (a24[i5 + 5] & 0xFFFFFFFFL);
            a24[i5 + 5] = (int) c7;
            c7 >>>= 32;
            c7 += x_i4 * y_64 + (a24[i5 + 6] & 0xFFFFFFFFL);
            a24[i5 + 6] = (int) c7;
            c7 >>>= 32;
            c7 += x_i4 * y_74 + (a24[i5 + 7] & 0xFFFFFFFFL);
            a24[i5 + 7] = (int) c7;
            c7 >>>= 32;
            a24[i5 + 8] = (int) c7;
        }
        SecP256K1Field.reduce(a24, x176);
        SecP256K1Field.squareN(x176, 44, x88);
        int[] a23 = new int[16];
        long y_03 = x6[0] & 0xFFFFFFFFL;
        long y_13 = x6[1] & 0xFFFFFFFFL;
        long y_23 = x6[2] & 0xFFFFFFFFL;
        long y_33 = x6[3] & 0xFFFFFFFFL;
        long y_43 = x6[4] & 0xFFFFFFFFL;
        long y_53 = x6[5] & 0xFFFFFFFFL;
        long y_63 = x6[6] & 0xFFFFFFFFL;
        long y_73 = x6[7] & 0xFFFFFFFFL;

        {
            long c6 = 0, x_06 = x88[0] & 0xFFFFFFFFL;
            c6 += x_06 * y_03;
            a23[0] = (int) c6;
            c6 >>>= 32;
            c6 += x_06 * y_13;
            a23[1] = (int) c6;
            c6 >>>= 32;
            c6 += x_06 * y_23;
            a23[2] = (int) c6;
            c6 >>>= 32;
            c6 += x_06 * y_33;
            a23[3] = (int) c6;
            c6 >>>= 32;
            c6 += x_06 * y_43;
            a23[4] = (int) c6;
            c6 >>>= 32;
            c6 += x_06 * y_53;
            a23[5] = (int) c6;
            c6 >>>= 32;
            c6 += x_06 * y_63;
            a23[6] = (int) c6;
            c6 >>>= 32;
            c6 += x_06 * y_73;
            a23[7] = (int) c6;
            c6 >>>= 32;
            a23[8] = (int) c6;
        }

        for (int i4 = 1; i4 < 8; ++i4)
        {
            long c6 = 0, x_i3 = x88[i4] & 0xFFFFFFFFL;
            c6 += x_i3 * y_03 + (a23[i4] & 0xFFFFFFFFL);
            a23[i4] = (int) c6;
            c6 >>>= 32;
            c6 += x_i3 * y_13 + (a23[i4 + 1] & 0xFFFFFFFFL);
            a23[i4 + 1] = (int) c6;
            c6 >>>= 32;
            c6 += x_i3 * y_23 + (a23[i4 + 2] & 0xFFFFFFFFL);
            a23[i4 + 2] = (int) c6;
            c6 >>>= 32;
            c6 += x_i3 * y_33 + (a23[i4 + 3] & 0xFFFFFFFFL);
            a23[i4 + 3] = (int) c6;
            c6 >>>= 32;
            c6 += x_i3 * y_43 + (a23[i4 + 4] & 0xFFFFFFFFL);
            a23[i4 + 4] = (int) c6;
            c6 >>>= 32;
            c6 += x_i3 * y_53 + (a23[i4 + 5] & 0xFFFFFFFFL);
            a23[i4 + 5] = (int) c6;
            c6 >>>= 32;
            c6 += x_i3 * y_63 + (a23[i4 + 6] & 0xFFFFFFFFL);
            a23[i4 + 6] = (int) c6;
            c6 >>>= 32;
            c6 += x_i3 * y_73 + (a23[i4 + 7] & 0xFFFFFFFFL);
            a23[i4 + 7] = (int) c6;
            c6 >>>= 32;
            a23[i4 + 8] = (int) c6;
        }
        SecP256K1Field.reduce(a23, x88);
        SecP256K1Field.squareN(x88, 3, x6);
        int[] a22 = new int[16];
        long y_02 = x3[0] & 0xFFFFFFFFL;
        long y_12 = x3[1] & 0xFFFFFFFFL;
        long y_22 = x3[2] & 0xFFFFFFFFL;
        long y_32 = x3[3] & 0xFFFFFFFFL;
        long y_42 = x3[4] & 0xFFFFFFFFL;
        long y_52 = x3[5] & 0xFFFFFFFFL;
        long y_62 = x3[6] & 0xFFFFFFFFL;
        long y_72 = x3[7] & 0xFFFFFFFFL;

        {
            long c5 = 0, x_05 = x6[0] & 0xFFFFFFFFL;
            c5 += x_05 * y_02;
            a22[0] = (int) c5;
            c5 >>>= 32;
            c5 += x_05 * y_12;
            a22[1] = (int) c5;
            c5 >>>= 32;
            c5 += x_05 * y_22;
            a22[2] = (int) c5;
            c5 >>>= 32;
            c5 += x_05 * y_32;
            a22[3] = (int) c5;
            c5 >>>= 32;
            c5 += x_05 * y_42;
            a22[4] = (int) c5;
            c5 >>>= 32;
            c5 += x_05 * y_52;
            a22[5] = (int) c5;
            c5 >>>= 32;
            c5 += x_05 * y_62;
            a22[6] = (int) c5;
            c5 >>>= 32;
            c5 += x_05 * y_72;
            a22[7] = (int) c5;
            c5 >>>= 32;
            a22[8] = (int) c5;
        }

        for (int i3 = 1; i3 < 8; ++i3)
        {
            long c5 = 0, x_i2 = x6[i3] & 0xFFFFFFFFL;
            c5 += x_i2 * y_02 + (a22[i3] & 0xFFFFFFFFL);
            a22[i3] = (int) c5;
            c5 >>>= 32;
            c5 += x_i2 * y_12 + (a22[i3 + 1] & 0xFFFFFFFFL);
            a22[i3 + 1] = (int) c5;
            c5 >>>= 32;
            c5 += x_i2 * y_22 + (a22[i3 + 2] & 0xFFFFFFFFL);
            a22[i3 + 2] = (int) c5;
            c5 >>>= 32;
            c5 += x_i2 * y_32 + (a22[i3 + 3] & 0xFFFFFFFFL);
            a22[i3 + 3] = (int) c5;
            c5 >>>= 32;
            c5 += x_i2 * y_42 + (a22[i3 + 4] & 0xFFFFFFFFL);
            a22[i3 + 4] = (int) c5;
            c5 >>>= 32;
            c5 += x_i2 * y_52 + (a22[i3 + 5] & 0xFFFFFFFFL);
            a22[i3 + 5] = (int) c5;
            c5 >>>= 32;
            c5 += x_i2 * y_62 + (a22[i3 + 6] & 0xFFFFFFFFL);
            a22[i3 + 6] = (int) c5;
            c5 >>>= 32;
            c5 += x_i2 * y_72 + (a22[i3 + 7] & 0xFFFFFFFFL);
            a22[i3 + 7] = (int) c5;
            c5 >>>= 32;
            a22[i3 + 8] = (int) c5;
        }
        SecP256K1Field.reduce(a22, x6);

        SecP256K1Field.squareN(x6, 23, x6);
        int[] a21 = new int[16];
        long y_01 = x22[0] & 0xFFFFFFFFL;
        long y_11 = x22[1] & 0xFFFFFFFFL;
        long y_21 = x22[2] & 0xFFFFFFFFL;
        long y_31 = x22[3] & 0xFFFFFFFFL;
        long y_41 = x22[4] & 0xFFFFFFFFL;
        long y_51 = x22[5] & 0xFFFFFFFFL;
        long y_61 = x22[6] & 0xFFFFFFFFL;
        long y_71 = x22[7] & 0xFFFFFFFFL;

        {
            long c4 = 0, x_04 = x6[0] & 0xFFFFFFFFL;
            c4 += x_04 * y_01;
            a21[0] = (int) c4;
            c4 >>>= 32;
            c4 += x_04 * y_11;
            a21[1] = (int) c4;
            c4 >>>= 32;
            c4 += x_04 * y_21;
            a21[2] = (int) c4;
            c4 >>>= 32;
            c4 += x_04 * y_31;
            a21[3] = (int) c4;
            c4 >>>= 32;
            c4 += x_04 * y_41;
            a21[4] = (int) c4;
            c4 >>>= 32;
            c4 += x_04 * y_51;
            a21[5] = (int) c4;
            c4 >>>= 32;
            c4 += x_04 * y_61;
            a21[6] = (int) c4;
            c4 >>>= 32;
            c4 += x_04 * y_71;
            a21[7] = (int) c4;
            c4 >>>= 32;
            a21[8] = (int) c4;
        }

        for (int i2 = 1; i2 < 8; ++i2)
        {
            long c4 = 0, x_i1 = x6[i2] & 0xFFFFFFFFL;
            c4 += x_i1 * y_01 + (a21[i2] & 0xFFFFFFFFL);
            a21[i2] = (int) c4;
            c4 >>>= 32;
            c4 += x_i1 * y_11 + (a21[i2 + 1] & 0xFFFFFFFFL);
            a21[i2 + 1] = (int) c4;
            c4 >>>= 32;
            c4 += x_i1 * y_21 + (a21[i2 + 2] & 0xFFFFFFFFL);
            a21[i2 + 2] = (int) c4;
            c4 >>>= 32;
            c4 += x_i1 * y_31 + (a21[i2 + 3] & 0xFFFFFFFFL);
            a21[i2 + 3] = (int) c4;
            c4 >>>= 32;
            c4 += x_i1 * y_41 + (a21[i2 + 4] & 0xFFFFFFFFL);
            a21[i2 + 4] = (int) c4;
            c4 >>>= 32;
            c4 += x_i1 * y_51 + (a21[i2 + 5] & 0xFFFFFFFFL);
            a21[i2 + 5] = (int) c4;
            c4 >>>= 32;
            c4 += x_i1 * y_61 + (a21[i2 + 6] & 0xFFFFFFFFL);
            a21[i2 + 6] = (int) c4;
            c4 >>>= 32;
            c4 += x_i1 * y_71 + (a21[i2 + 7] & 0xFFFFFFFFL);
            a21[i2 + 7] = (int) c4;
            c4 >>>= 32;
            a21[i2 + 8] = (int) c4;
        }
        SecP256K1Field.reduce(a21, x6);
        SecP256K1Field.squareN(x6, 6, x6);
        int[] a2 = new int[16];
        long y_0 = x2[0] & 0xFFFFFFFFL;
        long y_1 = x2[1] & 0xFFFFFFFFL;
        long y_2 = x2[2] & 0xFFFFFFFFL;
        long y_3 = x2[3] & 0xFFFFFFFFL;
        long y_4 = x2[4] & 0xFFFFFFFFL;
        long y_5 = x2[5] & 0xFFFFFFFFL;
        long y_6 = x2[6] & 0xFFFFFFFFL;
        long y_7 = x2[7] & 0xFFFFFFFFL;

        {
            long c3 = 0, x_03 = x6[0] & 0xFFFFFFFFL;
            c3 += x_03 * y_0;
            a2[0] = (int) c3;
            c3 >>>= 32;
            c3 += x_03 * y_1;
            a2[1] = (int) c3;
            c3 >>>= 32;
            c3 += x_03 * y_2;
            a2[2] = (int) c3;
            c3 >>>= 32;
            c3 += x_03 * y_3;
            a2[3] = (int) c3;
            c3 >>>= 32;
            c3 += x_03 * y_4;
            a2[4] = (int) c3;
            c3 >>>= 32;
            c3 += x_03 * y_5;
            a2[5] = (int) c3;
            c3 >>>= 32;
            c3 += x_03 * y_6;
            a2[6] = (int) c3;
            c3 >>>= 32;
            c3 += x_03 * y_7;
            a2[7] = (int) c3;
            c3 >>>= 32;
            a2[8] = (int) c3;
        }

        for (int i1 = 1; i1 < 8; ++i1)
        {
            long c3 = 0, x_i = x6[i1] & 0xFFFFFFFFL;
            c3 += x_i * y_0 + (a2[i1] & 0xFFFFFFFFL);
            a2[i1] = (int) c3;
            c3 >>>= 32;
            c3 += x_i * y_1 + (a2[i1 + 1] & 0xFFFFFFFFL);
            a2[i1 + 1] = (int) c3;
            c3 >>>= 32;
            c3 += x_i * y_2 + (a2[i1 + 2] & 0xFFFFFFFFL);
            a2[i1 + 2] = (int) c3;
            c3 >>>= 32;
            c3 += x_i * y_3 + (a2[i1 + 3] & 0xFFFFFFFFL);
            a2[i1 + 3] = (int) c3;
            c3 >>>= 32;
            c3 += x_i * y_4 + (a2[i1 + 4] & 0xFFFFFFFFL);
            a2[i1 + 4] = (int) c3;
            c3 >>>= 32;
            c3 += x_i * y_5 + (a2[i1 + 5] & 0xFFFFFFFFL);
            a2[i1 + 5] = (int) c3;
            c3 >>>= 32;
            c3 += x_i * y_6 + (a2[i1 + 6] & 0xFFFFFFFFL);
            a2[i1 + 6] = (int) c3;
            c3 >>>= 32;
            c3 += x_i * y_7 + (a2[i1 + 7] & 0xFFFFFFFFL);
            a2[i1 + 7] = (int) c3;
            c3 >>>= 32;
            a2[i1 + 8] = (int) c3;
        }
        SecP256K1Field.reduce(a2, x6);
        SecP256K1Field.squareN(x6, 2, x6);

        int[] a1 = new int[16];
        long x_0 = x6[0] & 0xFFFFFFFFL;
        long zz_1;

        int c = 0, w;
        {
            int i = 7, j = 16;
            do
            {
                long xVal = (x6[i--] & 0xFFFFFFFFL);
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

        long x_1 = x6[1] & 0xFFFFFFFFL;
        long zz_2 = a1[2] & 0xFFFFFFFFL;

        {
            zz_1 += x_1 * x_0;
            w = (int)zz_1;
            a1[1] = (w << 1) | c;
            c = w >>> 31;
            zz_2 += zz_1 >>> 32;
        }

        long x_2 = x6[2] & 0xFFFFFFFFL;
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

        long x_3 = x6[3] & 0xFFFFFFFFL;
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

        long x_4 = x6[4] & 0xFFFFFFFFL;
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

        long x_5 = x6[5] & 0xFFFFFFFFL;
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

        long x_6 = x6[6] & 0xFFFFFFFFL;
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

        long x_7 = x6[7] & 0xFFFFFFFFL;
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
        SecP256K1Field.reduce(a1, x2);

        return Nat256.eq(x1, x2) ? new SecP256K1FieldElement(x6) : null;
    }




}
