package Keys;

public class SecP256K1Point extends ECPoint {

    public SecP256K1Point(ECCurve curve, ECFieldElement x, ECFieldElement y)
    {
        this(curve, x, y, false);
    }



    public SecP256K1Point(ECCurve curve, ECFieldElement x, ECFieldElement y, boolean withCompression)
    {
        super(curve, x, y);


        this.withCompression = withCompression;
    }

    SecP256K1Point(ECCurve curve, ECFieldElement x, ECFieldElement y, ECFieldElement[] zs,
                   boolean withCompression)
    {
        super(curve, x, y, zs);

        this.withCompression = withCompression;
    }

     public ECPoint add(ECPoint b) {

        if (this == b)
        {
            return twice();
        }

        ECCurve curve = this.getCurve();

        SecP256K1FieldElement X1 = (SecP256K1FieldElement)this.x, Y1 = (SecP256K1FieldElement)this.y;
        SecP256K1FieldElement X2 = (SecP256K1FieldElement)b.getXCoord(), Y2 = (SecP256K1FieldElement)b.getYCoord();

        SecP256K1FieldElement Z1 = (SecP256K1FieldElement)this.zs[0];
        SecP256K1FieldElement Z2 = (SecP256K1FieldElement)b.getZCoord(0);

        int c;
         int[] tt1 = new int[16];
         int[] t2 = new int[8];
         int[] t3 = new int[8];
         int[] t4 = new int[8];

        boolean Z1IsOne = Z1.isOne();
        int[] U2, S2;
        if (Z1IsOne)
        {
            U2 = X2.x;
            S2 = Y2.x;
        }
        else
        {
            S2 = t3;
            int[] a1 = new int[16];
            long x_0 = Z1.x[0] & 0xFFFFFFFFL;
            long zz_1;

            int c1 = 0, w;
            {
                int i = 7, j = 16;
                do
                {
                    long xVal = (Z1.x[i--] & 0xFFFFFFFFL);
                    long p = xVal * xVal;
                    a1[--j] = (c1 << 31) | (int)(p >>> 33);
                    a1[--j] = (int)(p >>> 1);
                    c1 = (int)p;
                }
                while (i > 0);

                {
                    long p = x_0 * x_0;
                    zz_1 = ((c1 << 31) & 0xFFFFFFFFL) | (p >>> 33);
                    a1[0] = (int)p;
                    c1 = (int)(p >>> 32) & 1;
                }
            }

            long x_1 = Z1.x[1] & 0xFFFFFFFFL;
            long zz_2 = a1[2] & 0xFFFFFFFFL;


                zz_1 += x_1 * x_0;
                w = (int)zz_1;
                a1[1] = (w << 1) | c1;
                c1 = w >>> 31;
                zz_2 += zz_1 >>> 32;


            long x_2 = Z1.x[2] & 0xFFFFFFFFL;
            long zz_3 = a1[3] & 0xFFFFFFFFL;
            long zz_4 = a1[4] & 0xFFFFFFFFL;

                zz_2 += x_2 * x_0;
                w = (int)zz_2;
                a1[2] = (w << 1) | c1;
                c1 = w >>> 31;
                zz_3 += (zz_2 >>> 32) + x_2 * x_1;
                zz_4 += zz_3 >>> 32;
                zz_3 &= 0xFFFFFFFFL;


            long x_3 = Z1.x[3] & 0xFFFFFFFFL;
            long zz_5 = (a1[5] & 0xFFFFFFFFL) + (zz_4 >>> 32);
            zz_4 &= 0xFFFFFFFFL;
            long zz_6 = (a1[6] & 0xFFFFFFFFL) + (zz_5 >>> 32);
            zz_5 &= 0xFFFFFFFFL;

                zz_3 += x_3 * x_0;
                w = (int)zz_3;
                a1[3] = (w << 1) | c1;
                c1 = w >>> 31;
                zz_4 += (zz_3 >>> 32) + x_3 * x_1;
                zz_5 += (zz_4 >>> 32) + x_3 * x_2;
                zz_4 &= 0xFFFFFFFFL;
                zz_6 += zz_5 >>> 32;
                zz_5 &= 0xFFFFFFFFL;


            long x_4 = Z1.x[4] & 0xFFFFFFFFL;
            long zz_7 = (a1[7] & 0xFFFFFFFFL) + (zz_6 >>> 32);
            zz_6 &= 0xFFFFFFFFL;
            long zz_8 = (a1[8] & 0xFFFFFFFFL) + (zz_7 >>> 32);
            zz_7 &= 0xFFFFFFFFL;

                zz_4 += x_4 * x_0;
                w = (int)zz_4;
                a1[4] = (w << 1) | c1;
                c1 = w >>> 31;
                zz_5 += (zz_4 >>> 32) + x_4 * x_1;
                zz_6 += (zz_5 >>> 32) + x_4 * x_2;
                zz_5 &= 0xFFFFFFFFL;
                zz_7 += (zz_6 >>> 32) + x_4 * x_3;
                zz_6 &= 0xFFFFFFFFL;
                zz_8 += zz_7 >>> 32;
                zz_7 &= 0xFFFFFFFFL;


            long x_5 = Z1.x[5] & 0xFFFFFFFFL;
            long zz_9 = (a1[9] & 0xFFFFFFFFL) + (zz_8 >>> 32);
            zz_8 &= 0xFFFFFFFFL;
            long zz_10 = (a1[10] & 0xFFFFFFFFL) + (zz_9 >>> 32);
            zz_9 &= 0xFFFFFFFFL;

                zz_5 += x_5 * x_0;
                w = (int)zz_5;
                a1[5] = (w << 1) | c1;
                c1 = w >>> 31;
                zz_6 += (zz_5 >>> 32) + x_5 * x_1;
                zz_7 += (zz_6 >>> 32) + x_5 * x_2;
                zz_6 &= 0xFFFFFFFFL;
                zz_8 += (zz_7 >>> 32) + x_5 * x_3;
                zz_7 &= 0xFFFFFFFFL;
                zz_9 += (zz_8 >>> 32) + x_5 * x_4;
                zz_8 &= 0xFFFFFFFFL;
                zz_10 += zz_9 >>> 32;
                zz_9 &= 0xFFFFFFFFL;


            long x_6 = Z1.x[6] & 0xFFFFFFFFL;
            long zz_11 = (a1[11] & 0xFFFFFFFFL) + (zz_10 >>> 32);
            zz_10 &= 0xFFFFFFFFL;
            long zz_12 = (a1[12] & 0xFFFFFFFFL) + (zz_11 >>> 32);
            zz_11 &= 0xFFFFFFFFL;

                zz_6 += x_6 * x_0;
                w = (int)zz_6;
                a1[6] = (w << 1) | c1;
                c1 = w >>> 31;
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


            long x_7 = Z1.x[7] & 0xFFFFFFFFL;
            long zz_13 = (a1[13] & 0xFFFFFFFFL) + (zz_12 >>> 32);
            zz_12 &= 0xFFFFFFFFL;
            long zz_14 = (a1[14] & 0xFFFFFFFFL) + (zz_13 >>> 32);
            zz_13 &= 0xFFFFFFFFL;

                zz_7 += x_7 * x_0;
                w = (int)zz_7;
                a1[7] = (w << 1) | c1;
                c1 = w >>> 31;
                zz_8 += (zz_7 >>> 32) + x_7 * x_1;
                zz_9 += (zz_8 >>> 32) + x_7 * x_2;
                zz_10 += (zz_9 >>> 32) + x_7 * x_3;
                zz_11 += (zz_10 >>> 32) + x_7 * x_4;
                zz_12 += (zz_11 >>> 32) + x_7 * x_5;
                zz_13 += (zz_12 >>> 32) + x_7 * x_6;
                zz_14 += zz_13 >>> 32;


            w = (int)zz_8;
            a1[8] = (w << 1) | c1;
            c1 = w >>> 31;
            w = (int)zz_9;
            a1[9] = (w << 1) | c1;
            c1 = w >>> 31;
            w = (int)zz_10;
            a1[10] = (w << 1) | c1;
            c1 = w >>> 31;
            w = (int)zz_11;
            a1[11] = (w << 1) | c1;
            c1 = w >>> 31;
            w = (int)zz_12;
            a1[12] = (w << 1) | c1;
            c1 = w >>> 31;
            w = (int)zz_13;
            a1[13] = (w << 1) | c1;
            c1 = w >>> 31;
            w = (int)zz_14;
            a1[14] = (w << 1) | c1;
            c1 = w >>> 31;
            w = a1[15] + (int)(zz_14 >>> 32);
            a1[15] = (w << 1) | c1;
            SecP256K1Field.reduce(a1, S2);

            U2 = t2;
            int[] a22 = new int[16];
            long y_02 = X2.x[0] & 0xFFFFFFFFL;
            long y_12 = X2.x[1] & 0xFFFFFFFFL;
            long y_22 = X2.x[2] & 0xFFFFFFFFL;
            long y_32 = X2.x[3] & 0xFFFFFFFFL;
            long y_42 = X2.x[4] & 0xFFFFFFFFL;
            long y_52 = X2.x[5] & 0xFFFFFFFFL;
            long y_62 = X2.x[6] & 0xFFFFFFFFL;
            long y_72 = X2.x[7] & 0xFFFFFFFFL;


                long c4 = 0, x_03 = S2[0] & 0xFFFFFFFFL;
                c4 += x_03 * y_02;
                a22[0] = (int) c4;
                c4 >>>= 32;
                c4 += x_03 * y_12;
                a22[1] = (int) c4;
                c4 >>>= 32;
                c4 += x_03 * y_22;
                a22[2] = (int) c4;
                c4 >>>= 32;
                c4 += x_03 * y_32;
                a22[3] = (int) c4;
                c4 >>>= 32;
                c4 += x_03 * y_42;
                a22[4] = (int) c4;
                c4 >>>= 32;
                c4 += x_03 * y_52;
                a22[5] = (int) c4;
                c4 >>>= 32;
                c4 += x_03 * y_62;
                a22[6] = (int) c4;
                c4 >>>= 32;
                c4 += x_03 * y_72;
                a22[7] = (int) c4;
                c4 >>>= 32;
                a22[8] = (int) c4;


            for (int i2 = 1; i2 < 8; ++i2)
            {
                c4 = 0;
                long x_i2 = S2[i2] & 0xFFFFFFFFL;
                c4 += x_i2 * y_02 + (a22[i2] & 0xFFFFFFFFL);
                a22[i2] = (int) c4;
                c4 >>>= 32;
                c4 += x_i2 * y_12 + (a22[i2 + 1] & 0xFFFFFFFFL);
                a22[i2 + 1] = (int) c4;
                c4 >>>= 32;
                c4 += x_i2 * y_22 + (a22[i2 + 2] & 0xFFFFFFFFL);
                a22[i2 + 2] = (int) c4;
                c4 >>>= 32;
                c4 += x_i2 * y_32 + (a22[i2 + 3] & 0xFFFFFFFFL);
                a22[i2 + 3] = (int) c4;
                c4 >>>= 32;
                c4 += x_i2 * y_42 + (a22[i2 + 4] & 0xFFFFFFFFL);
                a22[i2 + 4] = (int) c4;
                c4 >>>= 32;
                c4 += x_i2 * y_52 + (a22[i2 + 5] & 0xFFFFFFFFL);
                a22[i2 + 5] = (int) c4;
                c4 >>>= 32;
                c4 += x_i2 * y_62 + (a22[i2 + 6] & 0xFFFFFFFFL);
                a22[i2 + 6] = (int) c4;
                c4 >>>= 32;
                c4 += x_i2 * y_72 + (a22[i2 + 7] & 0xFFFFFFFFL);
                a22[i2 + 7] = (int) c4;
                c4 >>>= 32;
                a22[i2 + 8] = (int) c4;
            }
            SecP256K1Field.reduce(a22, U2);

            int[] a21 = new int[16];
            long y_01 = Z1.x[0] & 0xFFFFFFFFL;
            long y_11 = Z1.x[1] & 0xFFFFFFFFL;
            long y_21 = Z1.x[2] & 0xFFFFFFFFL;
            long y_31 = Z1.x[3] & 0xFFFFFFFFL;
            long y_41 = Z1.x[4] & 0xFFFFFFFFL;
            long y_51 = Z1.x[5] & 0xFFFFFFFFL;
            long y_61 = Z1.x[6] & 0xFFFFFFFFL;
            long y_71 = Z1.x[7] & 0xFFFFFFFFL;


                long c3 = 0, x_02 = S2[0] & 0xFFFFFFFFL;
                c3 += x_02 * y_01;
                a21[0] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_11;
                a21[1] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_21;
                a21[2] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_31;
                a21[3] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_41;
                a21[4] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_51;
                a21[5] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_61;
                a21[6] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_71;
                a21[7] = (int) c3;
                c3 >>>= 32;
                a21[8] = (int) c3;


            for (int i1 = 1; i1 < 8; ++i1)
            {
                c3 = 0;
                long  x_i1 = S2[i1] & 0xFFFFFFFFL;
                c3 += x_i1 * y_01 + (a21[i1] & 0xFFFFFFFFL);
                a21[i1] = (int) c3;
                c3 >>>= 32;
                c3 += x_i1 * y_11 + (a21[i1 + 1] & 0xFFFFFFFFL);
                a21[i1 + 1] = (int) c3;
                c3 >>>= 32;
                c3 += x_i1 * y_21 + (a21[i1 + 2] & 0xFFFFFFFFL);
                a21[i1 + 2] = (int) c3;
                c3 >>>= 32;
                c3 += x_i1 * y_31 + (a21[i1 + 3] & 0xFFFFFFFFL);
                a21[i1 + 3] = (int) c3;
                c3 >>>= 32;
                c3 += x_i1 * y_41 + (a21[i1 + 4] & 0xFFFFFFFFL);
                a21[i1 + 4] = (int) c3;
                c3 >>>= 32;
                c3 += x_i1 * y_51 + (a21[i1 + 5] & 0xFFFFFFFFL);
                a21[i1 + 5] = (int) c3;
                c3 >>>= 32;
                c3 += x_i1 * y_61 + (a21[i1 + 6] & 0xFFFFFFFFL);
                a21[i1 + 6] = (int) c3;
                c3 >>>= 32;
                c3 += x_i1 * y_71 + (a21[i1 + 7] & 0xFFFFFFFFL);
                a21[i1 + 7] = (int) c3;
                c3 >>>= 32;
                a21[i1 + 8] = (int) c3;
            }
            SecP256K1Field.reduce(a21, S2);
            int[] a2 = new int[16];
            long y_0 = Y2.x[0] & 0xFFFFFFFFL;
            long y_1 = Y2.x[1] & 0xFFFFFFFFL;
            long y_2 = Y2.x[2] & 0xFFFFFFFFL;
            long y_3 = Y2.x[3] & 0xFFFFFFFFL;
            long y_4 = Y2.x[4] & 0xFFFFFFFFL;
            long y_5 = Y2.x[5] & 0xFFFFFFFFL;
            long y_6 = Y2.x[6] & 0xFFFFFFFFL;
            long y_7 = Y2.x[7] & 0xFFFFFFFFL;


                long c2 = 0, x_01 = S2[0] & 0xFFFFFFFFL;
                c2 += x_01 * y_0;
                a2[0] = (int) c2;
                c2 >>>= 32;
                c2 += x_01 * y_1;
                a2[1] = (int) c2;
                c2 >>>= 32;
                c2 += x_01 * y_2;
                a2[2] = (int) c2;
                c2 >>>= 32;
                c2 += x_01 * y_3;
                a2[3] = (int) c2;
                c2 >>>= 32;
                c2 += x_01 * y_4;
                a2[4] = (int) c2;
                c2 >>>= 32;
                c2 += x_01 * y_5;
                a2[5] = (int) c2;
                c2 >>>= 32;
                c2 += x_01 * y_6;
                a2[6] = (int) c2;
                c2 >>>= 32;
                c2 += x_01 * y_7;
                a2[7] = (int) c2;
                c2 >>>= 32;
                a2[8] = (int) c2;


            for (int i = 1; i < 8; ++i)
            {
                 c2 = 0;
                long x_i = S2[i] & 0xFFFFFFFFL;
                c2 += x_i * y_0 + (a2[i] & 0xFFFFFFFFL);
                a2[i] = (int) c2;
                c2 >>>= 32;
                c2 += x_i * y_1 + (a2[i + 1] & 0xFFFFFFFFL);
                a2[i + 1] = (int) c2;
                c2 >>>= 32;
                c2 += x_i * y_2 + (a2[i + 2] & 0xFFFFFFFFL);
                a2[i + 2] = (int) c2;
                c2 >>>= 32;
                c2 += x_i * y_3 + (a2[i + 3] & 0xFFFFFFFFL);
                a2[i + 3] = (int) c2;
                c2 >>>= 32;
                c2 += x_i * y_4 + (a2[i + 4] & 0xFFFFFFFFL);
                a2[i + 4] = (int) c2;
                c2 >>>= 32;
                c2 += x_i * y_5 + (a2[i + 5] & 0xFFFFFFFFL);
                a2[i + 5] = (int) c2;
                c2 >>>= 32;
                c2 += x_i * y_6 + (a2[i + 6] & 0xFFFFFFFFL);
                a2[i + 6] = (int) c2;
                c2 >>>= 32;
                c2 += x_i * y_7 + (a2[i + 7] & 0xFFFFFFFFL);
                a2[i + 7] = (int) c2;
                c2 >>>= 32;
                a2[i + 8] = (int) c2;
            }
            SecP256K1Field.reduce(a2, S2);
        }

        boolean Z2IsOne = Z2.isOne();
        int[] U1, S1;
        if (Z2IsOne)
        {
            U1 = X1.x;
            S1 = Y1.x;
        }
        else
        {
            S1 = t4;
            int[] a1 = new int[16];
            long x_0 = Z2.x[0] & 0xFFFFFFFFL;
            long zz_1;

            int c1 = 0, w;
            {
                int i = 7, j = 16;
                do
                {
                    long xVal = (Z2.x[i--] & 0xFFFFFFFFL);
                    long p = xVal * xVal;
                    a1[--j] = (c1 << 31) | (int)(p >>> 33);
                    a1[--j] = (int)(p >>> 1);
                    c1 = (int)p;
                }
                while (i > 0);

                {
                    long p = x_0 * x_0;
                    zz_1 = ((c1 << 31) & 0xFFFFFFFFL) | (p >>> 33);
                    a1[0] = (int)p;
                    c1 = (int)(p >>> 32) & 1;
                }
            }

            long x_1 = Z2.x[1] & 0xFFFFFFFFL;
            long zz_2 = a1[2] & 0xFFFFFFFFL;


                zz_1 += x_1 * x_0;
                w = (int)zz_1;
                a1[1] = (w << 1) | c1;
                c1 = w >>> 31;
                zz_2 += zz_1 >>> 32;


            long x_2 = Z2.x[2] & 0xFFFFFFFFL;
            long zz_3 = a1[3] & 0xFFFFFFFFL;
            long zz_4 = a1[4] & 0xFFFFFFFFL;

                zz_2 += x_2 * x_0;
                w = (int)zz_2;
                a1[2] = (w << 1) | c1;
                c1 = w >>> 31;
                zz_3 += (zz_2 >>> 32) + x_2 * x_1;
                zz_4 += zz_3 >>> 32;
                zz_3 &= 0xFFFFFFFFL;


            long x_3 = Z2.x[3] & 0xFFFFFFFFL;
            long zz_5 = (a1[5] & 0xFFFFFFFFL) + (zz_4 >>> 32);
            zz_4 &= 0xFFFFFFFFL;
            long zz_6 = (a1[6] & 0xFFFFFFFFL) + (zz_5 >>> 32);
            zz_5 &= 0xFFFFFFFFL;

                zz_3 += x_3 * x_0;
                w = (int)zz_3;
                a1[3] = (w << 1) | c1;
                c1 = w >>> 31;
                zz_4 += (zz_3 >>> 32) + x_3 * x_1;
                zz_5 += (zz_4 >>> 32) + x_3 * x_2;
                zz_4 &= 0xFFFFFFFFL;
                zz_6 += zz_5 >>> 32;
                zz_5 &= 0xFFFFFFFFL;


            long x_4 = Z2.x[4] & 0xFFFFFFFFL;
            long zz_7 = (a1[7] & 0xFFFFFFFFL) + (zz_6 >>> 32);
            zz_6 &= 0xFFFFFFFFL;
            long zz_8 = (a1[8] & 0xFFFFFFFFL) + (zz_7 >>> 32);
            zz_7 &= 0xFFFFFFFFL;

                zz_4 += x_4 * x_0;
                w = (int)zz_4;
                a1[4] = (w << 1) | c1;
                c1 = w >>> 31;
                zz_5 += (zz_4 >>> 32) + x_4 * x_1;
                zz_6 += (zz_5 >>> 32) + x_4 * x_2;
                zz_5 &= 0xFFFFFFFFL;
                zz_7 += (zz_6 >>> 32) + x_4 * x_3;
                zz_6 &= 0xFFFFFFFFL;
                zz_8 += zz_7 >>> 32;
                zz_7 &= 0xFFFFFFFFL;


            long x_5 = Z2.x[5] & 0xFFFFFFFFL;
            long zz_9 = (a1[9] & 0xFFFFFFFFL) + (zz_8 >>> 32);
            zz_8 &= 0xFFFFFFFFL;
            long zz_10 = (a1[10] & 0xFFFFFFFFL) + (zz_9 >>> 32);
            zz_9 &= 0xFFFFFFFFL;

                zz_5 += x_5 * x_0;
                w = (int)zz_5;
                a1[5] = (w << 1) | c1;
                c1 = w >>> 31;
                zz_6 += (zz_5 >>> 32) + x_5 * x_1;
                zz_7 += (zz_6 >>> 32) + x_5 * x_2;
                zz_6 &= 0xFFFFFFFFL;
                zz_8 += (zz_7 >>> 32) + x_5 * x_3;
                zz_7 &= 0xFFFFFFFFL;
                zz_9 += (zz_8 >>> 32) + x_5 * x_4;
                zz_8 &= 0xFFFFFFFFL;
                zz_10 += zz_9 >>> 32;
                zz_9 &= 0xFFFFFFFFL;


            long x_6 = Z2.x[6] & 0xFFFFFFFFL;
            long zz_11 = (a1[11] & 0xFFFFFFFFL) + (zz_10 >>> 32);
            zz_10 &= 0xFFFFFFFFL;
            long zz_12 = (a1[12] & 0xFFFFFFFFL) + (zz_11 >>> 32);
            zz_11 &= 0xFFFFFFFFL;

                zz_6 += x_6 * x_0;
                w = (int)zz_6;
                a1[6] = (w << 1) | c1;
                c1 = w >>> 31;
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


            long x_7 = Z2.x[7] & 0xFFFFFFFFL;
            long zz_13 = (a1[13] & 0xFFFFFFFFL) + (zz_12 >>> 32);
            zz_12 &= 0xFFFFFFFFL;
            long zz_14 = (a1[14] & 0xFFFFFFFFL) + (zz_13 >>> 32);
            zz_13 &= 0xFFFFFFFFL;

                zz_7 += x_7 * x_0;
                w = (int)zz_7;
                a1[7] = (w << 1) | c1;
                c1 = w >>> 31;
                zz_8 += (zz_7 >>> 32) + x_7 * x_1;
                zz_9 += (zz_8 >>> 32) + x_7 * x_2;
                zz_10 += (zz_9 >>> 32) + x_7 * x_3;
                zz_11 += (zz_10 >>> 32) + x_7 * x_4;
                zz_12 += (zz_11 >>> 32) + x_7 * x_5;
                zz_13 += (zz_12 >>> 32) + x_7 * x_6;
                zz_14 += zz_13 >>> 32;


            w = (int)zz_8;
            a1[8] = (w << 1) | c1;
            c1 = w >>> 31;
            w = (int)zz_9;
            a1[9] = (w << 1) | c1;
            c1 = w >>> 31;
            w = (int)zz_10;
            a1[10] = (w << 1) | c1;
            c1 = w >>> 31;
            w = (int)zz_11;
            a1[11] = (w << 1) | c1;
            c1 = w >>> 31;
            w = (int)zz_12;
            a1[12] = (w << 1) | c1;
            c1 = w >>> 31;
            w = (int)zz_13;
            a1[13] = (w << 1) | c1;
            c1 = w >>> 31;
            w = (int)zz_14;
            a1[14] = (w << 1) | c1;
            c1 = w >>> 31;
            w = a1[15] + (int)(zz_14 >>> 32);
            a1[15] = (w << 1) | c1;
            SecP256K1Field.reduce(a1, S1);

            U1 = tt1;
            int[] a22 = new int[16];
            long y_02 = X1.x[0] & 0xFFFFFFFFL;
            long y_12 = X1.x[1] & 0xFFFFFFFFL;
            long y_22 = X1.x[2] & 0xFFFFFFFFL;
            long y_32 = X1.x[3] & 0xFFFFFFFFL;
            long y_42 = X1.x[4] & 0xFFFFFFFFL;
            long y_52 = X1.x[5] & 0xFFFFFFFFL;
            long y_62 = X1.x[6] & 0xFFFFFFFFL;
            long y_72 = X1.x[7] & 0xFFFFFFFFL;


                long c4 = 0, x_03 = S1[0] & 0xFFFFFFFFL;
                c4 += x_03 * y_02;
                a22[0] = (int) c4;
                c4 >>>= 32;
                c4 += x_03 * y_12;
                a22[1] = (int) c4;
                c4 >>>= 32;
                c4 += x_03 * y_22;
                a22[2] = (int) c4;
                c4 >>>= 32;
                c4 += x_03 * y_32;
                a22[3] = (int) c4;
                c4 >>>= 32;
                c4 += x_03 * y_42;
                a22[4] = (int) c4;
                c4 >>>= 32;
                c4 += x_03 * y_52;
                a22[5] = (int) c4;
                c4 >>>= 32;
                c4 += x_03 * y_62;
                a22[6] = (int) c4;
                c4 >>>= 32;
                c4 += x_03 * y_72;
                a22[7] = (int) c4;
                c4 >>>= 32;
                a22[8] = (int) c4;


            for (int i2 = 1; i2 < 8; ++i2)
            {
                c4 = 0;
                long  x_i2 = S1[i2] & 0xFFFFFFFFL;
                c4 += x_i2 * y_02 + (a22[i2] & 0xFFFFFFFFL);
                a22[i2] = (int) c4;
                c4 >>>= 32;
                c4 += x_i2 * y_12 + (a22[i2 + 1] & 0xFFFFFFFFL);
                a22[i2 + 1] = (int) c4;
                c4 >>>= 32;
                c4 += x_i2 * y_22 + (a22[i2 + 2] & 0xFFFFFFFFL);
                a22[i2 + 2] = (int) c4;
                c4 >>>= 32;
                c4 += x_i2 * y_32 + (a22[i2 + 3] & 0xFFFFFFFFL);
                a22[i2 + 3] = (int) c4;
                c4 >>>= 32;
                c4 += x_i2 * y_42 + (a22[i2 + 4] & 0xFFFFFFFFL);
                a22[i2 + 4] = (int) c4;
                c4 >>>= 32;
                c4 += x_i2 * y_52 + (a22[i2 + 5] & 0xFFFFFFFFL);
                a22[i2 + 5] = (int) c4;
                c4 >>>= 32;
                c4 += x_i2 * y_62 + (a22[i2 + 6] & 0xFFFFFFFFL);
                a22[i2 + 6] = (int) c4;
                c4 >>>= 32;
                c4 += x_i2 * y_72 + (a22[i2 + 7] & 0xFFFFFFFFL);
                a22[i2 + 7] = (int) c4;
                c4 >>>= 32;
                a22[i2 + 8] = (int) c4;
            }
            SecP256K1Field.reduce(a22, U1);

            int[] a21 = new int[16];
            long y_01 = Z2.x[0] & 0xFFFFFFFFL;
            long y_11 = Z2.x[1] & 0xFFFFFFFFL;
            long y_21 = Z2.x[2] & 0xFFFFFFFFL;
            long y_31 = Z2.x[3] & 0xFFFFFFFFL;
            long y_41 = Z2.x[4] & 0xFFFFFFFFL;
            long y_51 = Z2.x[5] & 0xFFFFFFFFL;
            long y_61 = Z2.x[6] & 0xFFFFFFFFL;
            long y_71 = Z2.x[7] & 0xFFFFFFFFL;


                long c3 = 0, x_02 = S1[0] & 0xFFFFFFFFL;
                c3 += x_02 * y_01;
                a21[0] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_11;
                a21[1] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_21;
                a21[2] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_31;
                a21[3] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_41;
                a21[4] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_51;
                a21[5] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_61;
                a21[6] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_71;
                a21[7] = (int) c3;
                c3 >>>= 32;
                a21[8] = (int) c3;


            for (int i1 = 1; i1 < 8; ++i1)
            {
                c3 = 0;
                long  x_i1 = S1[i1] & 0xFFFFFFFFL;
                c3 += x_i1 * y_01 + (a21[i1] & 0xFFFFFFFFL);
                a21[i1] = (int) c3;
                c3 >>>= 32;
                c3 += x_i1 * y_11 + (a21[i1 + 1] & 0xFFFFFFFFL);
                a21[i1 + 1] = (int) c3;
                c3 >>>= 32;
                c3 += x_i1 * y_21 + (a21[i1 + 2] & 0xFFFFFFFFL);
                a21[i1 + 2] = (int) c3;
                c3 >>>= 32;
                c3 += x_i1 * y_31 + (a21[i1 + 3] & 0xFFFFFFFFL);
                a21[i1 + 3] = (int) c3;
                c3 >>>= 32;
                c3 += x_i1 * y_41 + (a21[i1 + 4] & 0xFFFFFFFFL);
                a21[i1 + 4] = (int) c3;
                c3 >>>= 32;
                c3 += x_i1 * y_51 + (a21[i1 + 5] & 0xFFFFFFFFL);
                a21[i1 + 5] = (int) c3;
                c3 >>>= 32;
                c3 += x_i1 * y_61 + (a21[i1 + 6] & 0xFFFFFFFFL);
                a21[i1 + 6] = (int) c3;
                c3 >>>= 32;
                c3 += x_i1 * y_71 + (a21[i1 + 7] & 0xFFFFFFFFL);
                a21[i1 + 7] = (int) c3;
                c3 >>>= 32;
                a21[i1 + 8] = (int) c3;
            }
            SecP256K1Field.reduce(a21, S1);
            int[] a2 = new int[16];
            long y_0 = Y1.x[0] & 0xFFFFFFFFL;
            long y_1 = Y1.x[1] & 0xFFFFFFFFL;
            long y_2 = Y1.x[2] & 0xFFFFFFFFL;
            long y_3 = Y1.x[3] & 0xFFFFFFFFL;
            long y_4 = Y1.x[4] & 0xFFFFFFFFL;
            long y_5 = Y1.x[5] & 0xFFFFFFFFL;
            long y_6 = Y1.x[6] & 0xFFFFFFFFL;
            long y_7 = Y1.x[7] & 0xFFFFFFFFL;


                long c2 = 0, x_01 = S1[0] & 0xFFFFFFFFL;
                c2 += x_01 * y_0;
                a2[0] = (int) c2;
                c2 >>>= 32;
                c2 += x_01 * y_1;
                a2[1] = (int) c2;
                c2 >>>= 32;
                c2 += x_01 * y_2;
                a2[2] = (int) c2;
                c2 >>>= 32;
                c2 += x_01 * y_3;
                a2[3] = (int) c2;
                c2 >>>= 32;
                c2 += x_01 * y_4;
                a2[4] = (int) c2;
                c2 >>>= 32;
                c2 += x_01 * y_5;
                a2[5] = (int) c2;
                c2 >>>= 32;
                c2 += x_01 * y_6;
                a2[6] = (int) c2;
                c2 >>>= 32;
                c2 += x_01 * y_7;
                a2[7] = (int) c2;
                c2 >>>= 32;
                a2[8] = (int) c2;


            for (int i = 1; i < 8; ++i)
            {
                c2 = 0;
                long  x_i = S1[i] & 0xFFFFFFFFL;
                c2 += x_i * y_0 + (a2[i] & 0xFFFFFFFFL);
                a2[i] = (int) c2;
                c2 >>>= 32;
                c2 += x_i * y_1 + (a2[i + 1] & 0xFFFFFFFFL);
                a2[i + 1] = (int) c2;
                c2 >>>= 32;
                c2 += x_i * y_2 + (a2[i + 2] & 0xFFFFFFFFL);
                a2[i + 2] = (int) c2;
                c2 >>>= 32;
                c2 += x_i * y_3 + (a2[i + 3] & 0xFFFFFFFFL);
                a2[i + 3] = (int) c2;
                c2 >>>= 32;
                c2 += x_i * y_4 + (a2[i + 4] & 0xFFFFFFFFL);
                a2[i + 4] = (int) c2;
                c2 >>>= 32;
                c2 += x_i * y_5 + (a2[i + 5] & 0xFFFFFFFFL);
                a2[i + 5] = (int) c2;
                c2 >>>= 32;
                c2 += x_i * y_6 + (a2[i + 6] & 0xFFFFFFFFL);
                a2[i + 6] = (int) c2;
                c2 >>>= 32;
                c2 += x_i * y_7 + (a2[i + 7] & 0xFFFFFFFFL);
                a2[i + 7] = (int) c2;
                c2 >>>= 32;
                a2[i + 8] = (int) c2;
            }
            SecP256K1Field.reduce(a2, S1);
        }

         int[] H = new int[8];
        SecP256K1Field.subtract(U1, U2, H);

        SecP256K1Field.subtract(S1, S2, t2);

        


         int[] a11 = new int[16];
         long x_01 = H[0] & 0xFFFFFFFFL;
         long zz_15;

         int c2 = 0, w1;
         {
             int i1 = 7, j1 = 16;
             do
             {
                 long xVal1 = (H[i1--] & 0xFFFFFFFFL);
                 long p1 = xVal1 * xVal1;
                 a11[--j1] = (c2 << 31) | (int)(p1 >>> 33);
                 a11[--j1] = (int)(p1 >>> 1);
                 c2 = (int) p1;
             }
             while (i1 > 0);

             {
                 long p1 = x_01 * x_01;
                 zz_15 = ((c2 << 31) & 0xFFFFFFFFL) | (p1 >>> 33);
                 a11[0] = (int) p1;
                 c2 = (int)(p1 >>> 32) & 1;
             }
         }

         long x_11 = H[1] & 0xFFFFFFFFL;
         long zz_21 = a11[2] & 0xFFFFFFFFL;


             zz_15 += x_11 * x_01;
             w1 = (int) zz_15;
             a11[1] = (w1 << 1) | c2;
             c2 = w1 >>> 31;
             zz_21 += zz_15 >>> 32;


         long x_21 = H[2] & 0xFFFFFFFFL;
         long zz_31 = a11[3] & 0xFFFFFFFFL;
         long zz_41 = a11[4] & 0xFFFFFFFFL;

             zz_21 += x_21 * x_01;
             w1 = (int) zz_21;
             a11[2] = (w1 << 1) | c2;
             c2 = w1 >>> 31;
             zz_31 += (zz_21 >>> 32) + x_21 * x_11;
             zz_41 += zz_31 >>> 32;
             zz_31 &= 0xFFFFFFFFL;


         long x_31 = H[3] & 0xFFFFFFFFL;
         long zz_51 = (a11[5] & 0xFFFFFFFFL) + (zz_41 >>> 32);
         zz_41 &= 0xFFFFFFFFL;
         long zz_61 = (a11[6] & 0xFFFFFFFFL) + (zz_51 >>> 32);
         zz_51 &= 0xFFFFFFFFL;

             zz_31 += x_31 * x_01;
             w1 = (int) zz_31;
             a11[3] = (w1 << 1) | c2;
             c2 = w1 >>> 31;
             zz_41 += (zz_31 >>> 32) + x_31 * x_11;
             zz_51 += (zz_41 >>> 32) + x_31 * x_21;
             zz_41 &= 0xFFFFFFFFL;
             zz_61 += zz_51 >>> 32;
             zz_51 &= 0xFFFFFFFFL;


         long x_41 = H[4] & 0xFFFFFFFFL;
         long zz_71 = (a11[7] & 0xFFFFFFFFL) + (zz_61 >>> 32);
         zz_61 &= 0xFFFFFFFFL;
         long zz_81 = (a11[8] & 0xFFFFFFFFL) + (zz_71 >>> 32);
         zz_71 &= 0xFFFFFFFFL;

             zz_41 += x_41 * x_01;
             w1 = (int) zz_41;
             a11[4] = (w1 << 1) | c2;
             c2 = w1 >>> 31;
             zz_51 += (zz_41 >>> 32) + x_41 * x_11;
             zz_61 += (zz_51 >>> 32) + x_41 * x_21;
             zz_51 &= 0xFFFFFFFFL;
             zz_71 += (zz_61 >>> 32) + x_41 * x_31;
             zz_61 &= 0xFFFFFFFFL;
             zz_81 += zz_71 >>> 32;
             zz_71 &= 0xFFFFFFFFL;


         long x_51 = H[5] & 0xFFFFFFFFL;
         long zz_91 = (a11[9] & 0xFFFFFFFFL) + (zz_81 >>> 32);
         zz_81 &= 0xFFFFFFFFL;
         long zz_101 = (a11[10] & 0xFFFFFFFFL) + (zz_91 >>> 32);
         zz_91 &= 0xFFFFFFFFL;

             zz_51 += x_51 * x_01;
             w1 = (int) zz_51;
             a11[5] = (w1 << 1) | c2;
             c2 = w1 >>> 31;
             zz_61 += (zz_51 >>> 32) + x_51 * x_11;
             zz_71 += (zz_61 >>> 32) + x_51 * x_21;
             zz_61 &= 0xFFFFFFFFL;
             zz_81 += (zz_71 >>> 32) + x_51 * x_31;
             zz_71 &= 0xFFFFFFFFL;
             zz_91 += (zz_81 >>> 32) + x_51 * x_41;
             zz_81 &= 0xFFFFFFFFL;
             zz_101 += zz_91 >>> 32;
             zz_91 &= 0xFFFFFFFFL;


         long x_61 = H[6] & 0xFFFFFFFFL;
         long zz_111 = (a11[11] & 0xFFFFFFFFL) + (zz_101 >>> 32);
         zz_101 &= 0xFFFFFFFFL;
         long zz_121 = (a11[12] & 0xFFFFFFFFL) + (zz_111 >>> 32);
         zz_111 &= 0xFFFFFFFFL;

             zz_61 += x_61 * x_01;
             w1 = (int) zz_61;
             a11[6] = (w1 << 1) | c2;
             c2 = w1 >>> 31;
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


         long x_71 = H[7] & 0xFFFFFFFFL;
         long zz_131 = (a11[13] & 0xFFFFFFFFL) + (zz_121 >>> 32);
         zz_121 &= 0xFFFFFFFFL;
         long zz_141 = (a11[14] & 0xFFFFFFFFL) + (zz_131 >>> 32);
         zz_131 &= 0xFFFFFFFFL;

             zz_71 += x_71 * x_01;
             w1 = (int) zz_71;
             a11[7] = (w1 << 1) | c2;
             c2 = w1 >>> 31;
             zz_81 += (zz_71 >>> 32) + x_71 * x_11;
             zz_91 += (zz_81 >>> 32) + x_71 * x_21;
             zz_101 += (zz_91 >>> 32) + x_71 * x_31;
             zz_111 += (zz_101 >>> 32) + x_71 * x_41;
             zz_121 += (zz_111 >>> 32) + x_71 * x_51;
             zz_131 += (zz_121 >>> 32) + x_71 * x_61;
             zz_141 += zz_131 >>> 32;


         w1 = (int) zz_81;
         a11[8] = (w1 << 1) | c2;
         c2 = w1 >>> 31;
         w1 = (int) zz_91;
         a11[9] = (w1 << 1) | c2;
         c2 = w1 >>> 31;
         w1 = (int) zz_101;
         a11[10] = (w1 << 1) | c2;
         c2 = w1 >>> 31;
         w1 = (int) zz_111;
         a11[11] = (w1 << 1) | c2;
         c2 = w1 >>> 31;
         w1 = (int) zz_121;
         a11[12] = (w1 << 1) | c2;
         c2 = w1 >>> 31;
         w1 = (int) zz_131;
         a11[13] = (w1 << 1) | c2;
         c2 = w1 >>> 31;
         w1 = (int) zz_141;
         a11[14] = (w1 << 1) | c2;
         c2 = w1 >>> 31;
         w1 = a11[15] + (int)(zz_141 >>> 32);
         a11[15] = (w1 << 1) | c2;
         SecP256K1Field.reduce(a11, t3);

         int[] G = new int[8];
         int[] a22 = new int[16];
         long y_03 = H[0] & 0xFFFFFFFFL;
         long y_13 = H[1] & 0xFFFFFFFFL;
         long y_23 = H[2] & 0xFFFFFFFFL;
         long y_33 = H[3] & 0xFFFFFFFFL;
         long y_43 = H[4] & 0xFFFFFFFFL;
         long y_53 = H[5] & 0xFFFFFFFFL;
         long y_63 = H[6] & 0xFFFFFFFFL;
         long y_73 = H[7] & 0xFFFFFFFFL;


             long c6 = 0, x_05 = t3[0] & 0xFFFFFFFFL;
             c6 += x_05 * y_03;
             a22[0] = (int) c6;
             c6 >>>= 32;
             c6 += x_05 * y_13;
             a22[1] = (int) c6;
             c6 >>>= 32;
             c6 += x_05 * y_23;
             a22[2] = (int) c6;
             c6 >>>= 32;
             c6 += x_05 * y_33;
             a22[3] = (int) c6;
             c6 >>>= 32;
             c6 += x_05 * y_43;
             a22[4] = (int) c6;
             c6 >>>= 32;
             c6 += x_05 * y_53;
             a22[5] = (int) c6;
             c6 >>>= 32;
             c6 += x_05 * y_63;
             a22[6] = (int) c6;
             c6 >>>= 32;
             c6 += x_05 * y_73;
             a22[7] = (int) c6;
             c6 >>>= 32;
             a22[8] = (int) c6;


         for (int i3 = 1; i3 < 8; ++i3)
         {
             c6 = 0;
             long  x_i3 = t3[i3] & 0xFFFFFFFFL;
             c6 += x_i3 * y_03 + (a22[i3] & 0xFFFFFFFFL);
             a22[i3] = (int) c6;
             c6 >>>= 32;
             c6 += x_i3 * y_13 + (a22[i3 + 1] & 0xFFFFFFFFL);
             a22[i3 + 1] = (int) c6;
             c6 >>>= 32;
             c6 += x_i3 * y_23 + (a22[i3 + 2] & 0xFFFFFFFFL);
             a22[i3 + 2] = (int) c6;
             c6 >>>= 32;
             c6 += x_i3 * y_33 + (a22[i3 + 3] & 0xFFFFFFFFL);
             a22[i3 + 3] = (int) c6;
             c6 >>>= 32;
             c6 += x_i3 * y_43 + (a22[i3 + 4] & 0xFFFFFFFFL);
             a22[i3 + 4] = (int) c6;
             c6 >>>= 32;
             c6 += x_i3 * y_53 + (a22[i3 + 5] & 0xFFFFFFFFL);
             a22[i3 + 5] = (int) c6;
             c6 >>>= 32;
             c6 += x_i3 * y_63 + (a22[i3 + 6] & 0xFFFFFFFFL);
             a22[i3 + 6] = (int) c6;
             c6 >>>= 32;
             c6 += x_i3 * y_73 + (a22[i3 + 7] & 0xFFFFFFFFL);
             a22[i3 + 7] = (int) c6;
             c6 >>>= 32;
             a22[i3 + 8] = (int) c6;
         }
         SecP256K1Field.reduce(a22, G);

         int[] a21 = new int[16];
         long y_02 = U1[0] & 0xFFFFFFFFL;
         long y_12 = U1[1] & 0xFFFFFFFFL;
         long y_22 = U1[2] & 0xFFFFFFFFL;
         long y_32 = U1[3] & 0xFFFFFFFFL;
         long y_42 = U1[4] & 0xFFFFFFFFL;
         long y_52 = U1[5] & 0xFFFFFFFFL;
         long y_62 = U1[6] & 0xFFFFFFFFL;
         long y_72 = U1[7] & 0xFFFFFFFFL;


             long c5 = 0, x_04 = t3[0] & 0xFFFFFFFFL;
             c5 += x_04 * y_02;
             a21[0] = (int) c5;
             c5 >>>= 32;
             c5 += x_04 * y_12;
             a21[1] = (int) c5;
             c5 >>>= 32;
             c5 += x_04 * y_22;
             a21[2] = (int) c5;
             c5 >>>= 32;
             c5 += x_04 * y_32;
             a21[3] = (int) c5;
             c5 >>>= 32;
             c5 += x_04 * y_42;
             a21[4] = (int) c5;
             c5 >>>= 32;
             c5 += x_04 * y_52;
             a21[5] = (int) c5;
             c5 >>>= 32;
             c5 += x_04 * y_62;
             a21[6] = (int) c5;
             c5 >>>= 32;
             c5 += x_04 * y_72;
             a21[7] = (int) c5;
             c5 >>>= 32;
             a21[8] = (int) c5;


         for (int i2 = 1; i2 < 8; ++i2)
         {
             c5 = 0;
             long  x_i2 = t3[i2] & 0xFFFFFFFFL;
             c5 += x_i2 * y_02 + (a21[i2] & 0xFFFFFFFFL);
             a21[i2] = (int) c5;
             c5 >>>= 32;
             c5 += x_i2 * y_12 + (a21[i2 + 1] & 0xFFFFFFFFL);
             a21[i2 + 1] = (int) c5;
             c5 >>>= 32;
             c5 += x_i2 * y_22 + (a21[i2 + 2] & 0xFFFFFFFFL);
             a21[i2 + 2] = (int) c5;
             c5 >>>= 32;
             c5 += x_i2 * y_32 + (a21[i2 + 3] & 0xFFFFFFFFL);
             a21[i2 + 3] = (int) c5;
             c5 >>>= 32;
             c5 += x_i2 * y_42 + (a21[i2 + 4] & 0xFFFFFFFFL);
             a21[i2 + 4] = (int) c5;
             c5 >>>= 32;
             c5 += x_i2 * y_52 + (a21[i2 + 5] & 0xFFFFFFFFL);
             a21[i2 + 5] = (int) c5;
             c5 >>>= 32;
             c5 += x_i2 * y_62 + (a21[i2 + 6] & 0xFFFFFFFFL);
             a21[i2 + 6] = (int) c5;
             c5 >>>= 32;
             c5 += x_i2 * y_72 + (a21[i2 + 7] & 0xFFFFFFFFL);
             a21[i2 + 7] = (int) c5;
             c5 >>>= 32;
             a21[i2 + 8] = (int) c5;
         }
         SecP256K1Field.reduce(a21, t3);

         SecP256K1Field.negate(G, G);
         long y_01 = G[0] & 0xFFFFFFFFL;
         long y_11 = G[1] & 0xFFFFFFFFL;
         long y_21 = G[2] & 0xFFFFFFFFL;
         long y_31 = G[3] & 0xFFFFFFFFL;
         long y_41 = G[4] & 0xFFFFFFFFL;
         long y_51 = G[5] & 0xFFFFFFFFL;
         long y_61 = G[6] & 0xFFFFFFFFL;
         long y_71 = G[7] & 0xFFFFFFFFL;


             long c4 = 0, x_03 = S1[0] & 0xFFFFFFFFL;
             c4 += x_03 * y_01;
             tt1[0] = (int) c4;
             c4 >>>= 32;
             c4 += x_03 * y_11;
             tt1[1] = (int) c4;
             c4 >>>= 32;
             c4 += x_03 * y_21;
             tt1[2] = (int) c4;
             c4 >>>= 32;
             c4 += x_03 * y_31;
             tt1[3] = (int) c4;
             c4 >>>= 32;
             c4 += x_03 * y_41;
             tt1[4] = (int) c4;
             c4 >>>= 32;
             c4 += x_03 * y_51;
             tt1[5] = (int) c4;
             c4 >>>= 32;
             c4 += x_03 * y_61;
             tt1[6] = (int) c4;
             c4 >>>= 32;
             c4 += x_03 * y_71;
             tt1[7] = (int) c4;
             c4 >>>= 32;
             tt1[8] = (int) c4;


         for (int i1 = 1; i1 < 8; ++i1)
         {
             c4 = 0;
             long  x_i1 = S1[i1] & 0xFFFFFFFFL;
             c4 += x_i1 * y_01 + (tt1[i1] & 0xFFFFFFFFL);
             tt1[i1] = (int) c4;
             c4 >>>= 32;
             c4 += x_i1 * y_11 + (tt1[i1 + 1] & 0xFFFFFFFFL);
             tt1[i1 + 1] = (int) c4;
             c4 >>>= 32;
             c4 += x_i1 * y_21 + (tt1[i1 + 2] & 0xFFFFFFFFL);
             tt1[i1 + 2] = (int) c4;
             c4 >>>= 32;
             c4 += x_i1 * y_31 + (tt1[i1 + 3] & 0xFFFFFFFFL);
             tt1[i1 + 3] = (int) c4;
             c4 >>>= 32;
             c4 += x_i1 * y_41 + (tt1[i1 + 4] & 0xFFFFFFFFL);
             tt1[i1 + 4] = (int) c4;
             c4 >>>= 32;
             c4 += x_i1 * y_51 + (tt1[i1 + 5] & 0xFFFFFFFFL);
             tt1[i1 + 5] = (int) c4;
             c4 >>>= 32;
             c4 += x_i1 * y_61 + (tt1[i1 + 6] & 0xFFFFFFFFL);
             tt1[i1 + 6] = (int) c4;
             c4 >>>= 32;
             c4 += x_i1 * y_71 + (tt1[i1 + 7] & 0xFFFFFFFFL);
             tt1[i1 + 7] = (int) c4;
             c4 >>>= 32;
             tt1[i1 + 8] = (int) c4;
         }

         c = Nat256.addBothTo(t3, t3, G);
        SecP256K1Field.reduce32(c, G);

        SecP256K1FieldElement X3 = new SecP256K1FieldElement(t4);
         int[] a1 = new int[16];
         long x_0 = t2[0] & 0xFFFFFFFFL;
         long zz_1;

         int c1 = 0, w;
         {
             int i = 7, j = 16;
             do
             {
                 long xVal = (t2[i--] & 0xFFFFFFFFL);
                 long p = xVal * xVal;
                 a1[--j] = (c1 << 31) | (int)(p >>> 33);
                 a1[--j] = (int)(p >>> 1);
                 c1 = (int)p;
             }
             while (i > 0);

             {
                 long p = x_0 * x_0;
                 zz_1 = ((c1 << 31) & 0xFFFFFFFFL) | (p >>> 33);
                 a1[0] = (int)p;
                 c1 = (int)(p >>> 32) & 1;
             }
         }

         long x_1 = t2[1] & 0xFFFFFFFFL;
         long zz_2 = a1[2] & 0xFFFFFFFFL;


             zz_1 += x_1 * x_0;
             w = (int)zz_1;
             a1[1] = (w << 1) | c1;
             c1 = w >>> 31;
             zz_2 += zz_1 >>> 32;


         long x_2 = t2[2] & 0xFFFFFFFFL;
         long zz_3 = a1[3] & 0xFFFFFFFFL;
         long zz_4 = a1[4] & 0xFFFFFFFFL;

             zz_2 += x_2 * x_0;
             w = (int)zz_2;
             a1[2] = (w << 1) | c1;
             c1 = w >>> 31;
             zz_3 += (zz_2 >>> 32) + x_2 * x_1;
             zz_4 += zz_3 >>> 32;
             zz_3 &= 0xFFFFFFFFL;


         long x_3 = t2[3] & 0xFFFFFFFFL;
         long zz_5 = (a1[5] & 0xFFFFFFFFL) + (zz_4 >>> 32);
         zz_4 &= 0xFFFFFFFFL;
         long zz_6 = (a1[6] & 0xFFFFFFFFL) + (zz_5 >>> 32);
         zz_5 &= 0xFFFFFFFFL;

             zz_3 += x_3 * x_0;
             w = (int)zz_3;
             a1[3] = (w << 1) | c1;
             c1 = w >>> 31;
             zz_4 += (zz_3 >>> 32) + x_3 * x_1;
             zz_5 += (zz_4 >>> 32) + x_3 * x_2;
             zz_4 &= 0xFFFFFFFFL;
             zz_6 += zz_5 >>> 32;
             zz_5 &= 0xFFFFFFFFL;


         long x_4 = t2[4] & 0xFFFFFFFFL;
         long zz_7 = (a1[7] & 0xFFFFFFFFL) + (zz_6 >>> 32);
         zz_6 &= 0xFFFFFFFFL;
         long zz_8 = (a1[8] & 0xFFFFFFFFL) + (zz_7 >>> 32);
         zz_7 &= 0xFFFFFFFFL;

             zz_4 += x_4 * x_0;
             w = (int)zz_4;
             a1[4] = (w << 1) | c1;
             c1 = w >>> 31;
             zz_5 += (zz_4 >>> 32) + x_4 * x_1;
             zz_6 += (zz_5 >>> 32) + x_4 * x_2;
             zz_5 &= 0xFFFFFFFFL;
             zz_7 += (zz_6 >>> 32) + x_4 * x_3;
             zz_6 &= 0xFFFFFFFFL;
             zz_8 += zz_7 >>> 32;
             zz_7 &= 0xFFFFFFFFL;


         long x_5 = t2[5] & 0xFFFFFFFFL;
         long zz_9 = (a1[9] & 0xFFFFFFFFL) + (zz_8 >>> 32);
         zz_8 &= 0xFFFFFFFFL;
         long zz_10 = (a1[10] & 0xFFFFFFFFL) + (zz_9 >>> 32);
         zz_9 &= 0xFFFFFFFFL;

             zz_5 += x_5 * x_0;
             w = (int)zz_5;
             a1[5] = (w << 1) | c1;
             c1 = w >>> 31;
             zz_6 += (zz_5 >>> 32) + x_5 * x_1;
             zz_7 += (zz_6 >>> 32) + x_5 * x_2;
             zz_6 &= 0xFFFFFFFFL;
             zz_8 += (zz_7 >>> 32) + x_5 * x_3;
             zz_7 &= 0xFFFFFFFFL;
             zz_9 += (zz_8 >>> 32) + x_5 * x_4;
             zz_8 &= 0xFFFFFFFFL;
             zz_10 += zz_9 >>> 32;
             zz_9 &= 0xFFFFFFFFL;


         long x_6 = t2[6] & 0xFFFFFFFFL;
         long zz_11 = (a1[11] & 0xFFFFFFFFL) + (zz_10 >>> 32);
         zz_10 &= 0xFFFFFFFFL;
         long zz_12 = (a1[12] & 0xFFFFFFFFL) + (zz_11 >>> 32);
         zz_11 &= 0xFFFFFFFFL;

             zz_6 += x_6 * x_0;
             w = (int)zz_6;
             a1[6] = (w << 1) | c1;
             c1 = w >>> 31;
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


         long x_7 = t2[7] & 0xFFFFFFFFL;
         long zz_13 = (a1[13] & 0xFFFFFFFFL) + (zz_12 >>> 32);
         zz_12 &= 0xFFFFFFFFL;
         long zz_14 = (a1[14] & 0xFFFFFFFFL) + (zz_13 >>> 32);
         zz_13 &= 0xFFFFFFFFL;

             zz_7 += x_7 * x_0;
             w = (int)zz_7;
             a1[7] = (w << 1) | c1;
             c1 = w >>> 31;
             zz_8 += (zz_7 >>> 32) + x_7 * x_1;
             zz_9 += (zz_8 >>> 32) + x_7 * x_2;
             zz_10 += (zz_9 >>> 32) + x_7 * x_3;
             zz_11 += (zz_10 >>> 32) + x_7 * x_4;
             zz_12 += (zz_11 >>> 32) + x_7 * x_5;
             zz_13 += (zz_12 >>> 32) + x_7 * x_6;
             zz_14 += zz_13 >>> 32;


         w = (int)zz_8;
         a1[8] = (w << 1) | c1;
         c1 = w >>> 31;
         w = (int)zz_9;
         a1[9] = (w << 1) | c1;
         c1 = w >>> 31;
         w = (int)zz_10;
         a1[10] = (w << 1) | c1;
         c1 = w >>> 31;
         w = (int)zz_11;
         a1[11] = (w << 1) | c1;
         c1 = w >>> 31;
         w = (int)zz_12;
         a1[12] = (w << 1) | c1;
         c1 = w >>> 31;
         w = (int)zz_13;
         a1[13] = (w << 1) | c1;
         c1 = w >>> 31;
         w = (int)zz_14;
         a1[14] = (w << 1) | c1;
         c1 = w >>> 31;
         w = a1[15] + (int)(zz_14 >>> 32);
         a1[15] = (w << 1) | c1;
         SecP256K1Field.reduce(a1, X3.x);
         SecP256K1Field.subtract(X3.x, G, X3.x);

        SecP256K1FieldElement Y3 = new SecP256K1FieldElement(G);
        SecP256K1Field.subtract(t3, X3.x, Y3.x);
        SecP256K1Field.multiplyAddToExt(Y3.x, t2, tt1);
        SecP256K1Field.reduce(tt1, Y3.x);

        SecP256K1FieldElement Z3 = new SecP256K1FieldElement(H);
        if (!Z1IsOne)
        {
            int[] a2 = new int[16];
            long y_0 = Z1.x[0] & 0xFFFFFFFFL;
            long y_1 = Z1.x[1] & 0xFFFFFFFFL;
            long y_2 = Z1.x[2] & 0xFFFFFFFFL;
            long y_3 = Z1.x[3] & 0xFFFFFFFFL;
            long y_4 = Z1.x[4] & 0xFFFFFFFFL;
            long y_5 = Z1.x[5] & 0xFFFFFFFFL;
            long y_6 = Z1.x[6] & 0xFFFFFFFFL;
            long y_7 = Z1.x[7] & 0xFFFFFFFFL;


                long c3 = 0, x_02 = Z3.x[0] & 0xFFFFFFFFL;
                c3 += x_02 * y_0;
                a2[0] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_1;
                a2[1] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_2;
                a2[2] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_3;
                a2[3] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_4;
                a2[4] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_5;
                a2[5] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_6;
                a2[6] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_7;
                a2[7] = (int) c3;
                c3 >>>= 32;
                a2[8] = (int) c3;


            for (int i = 1; i < 8; ++i)
            {
                c3 = 0;
                long  x_i = Z3.x[i] & 0xFFFFFFFFL;
                c3 += x_i * y_0 + (a2[i] & 0xFFFFFFFFL);
                a2[i] = (int) c3;
                c3 >>>= 32;
                c3 += x_i * y_1 + (a2[i + 1] & 0xFFFFFFFFL);
                a2[i + 1] = (int) c3;
                c3 >>>= 32;
                c3 += x_i * y_2 + (a2[i + 2] & 0xFFFFFFFFL);
                a2[i + 2] = (int) c3;
                c3 >>>= 32;
                c3 += x_i * y_3 + (a2[i + 3] & 0xFFFFFFFFL);
                a2[i + 3] = (int) c3;
                c3 >>>= 32;
                c3 += x_i * y_4 + (a2[i + 4] & 0xFFFFFFFFL);
                a2[i + 4] = (int) c3;
                c3 >>>= 32;
                c3 += x_i * y_5 + (a2[i + 5] & 0xFFFFFFFFL);
                a2[i + 5] = (int) c3;
                c3 >>>= 32;
                c3 += x_i * y_6 + (a2[i + 6] & 0xFFFFFFFFL);
                a2[i + 6] = (int) c3;
                c3 >>>= 32;
                c3 += x_i * y_7 + (a2[i + 7] & 0xFFFFFFFFL);
                a2[i + 7] = (int) c3;
                c3 >>>= 32;
                a2[i + 8] = (int) c3;
            }
            SecP256K1Field.reduce(a2, Z3.x);
        }
        if (!Z2IsOne)
        {
            int[] a2 = new int[16];
            long y_0 = Z2.x[0] & 0xFFFFFFFFL;
            long y_1 = Z2.x[1] & 0xFFFFFFFFL;
            long y_2 = Z2.x[2] & 0xFFFFFFFFL;
            long y_3 = Z2.x[3] & 0xFFFFFFFFL;
            long y_4 = Z2.x[4] & 0xFFFFFFFFL;
            long y_5 = Z2.x[5] & 0xFFFFFFFFL;
            long y_6 = Z2.x[6] & 0xFFFFFFFFL;
            long y_7 = Z2.x[7] & 0xFFFFFFFFL;


                long c3 = 0, x_02 = Z3.x[0] & 0xFFFFFFFFL;
                c3 += x_02 * y_0;
                a2[0] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_1;
                a2[1] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_2;
                a2[2] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_3;
                a2[3] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_4;
                a2[4] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_5;
                a2[5] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_6;
                a2[6] = (int) c3;
                c3 >>>= 32;
                c3 += x_02 * y_7;
                a2[7] = (int) c3;
                c3 >>>= 32;
                a2[8] = (int) c3;


            for (int i = 1; i < 8; ++i)
            {
                c3 = 0;
                long  x_i = Z3.x[i] & 0xFFFFFFFFL;
                c3 += x_i * y_0 + (a2[i] & 0xFFFFFFFFL);
                a2[i] = (int) c3;
                c3 >>>= 32;
                c3 += x_i * y_1 + (a2[i + 1] & 0xFFFFFFFFL);
                a2[i + 1] = (int) c3;
                c3 >>>= 32;
                c3 += x_i * y_2 + (a2[i + 2] & 0xFFFFFFFFL);
                a2[i + 2] = (int) c3;
                c3 >>>= 32;
                c3 += x_i * y_3 + (a2[i + 3] & 0xFFFFFFFFL);
                a2[i + 3] = (int) c3;
                c3 >>>= 32;
                c3 += x_i * y_4 + (a2[i + 4] & 0xFFFFFFFFL);
                a2[i + 4] = (int) c3;
                c3 >>>= 32;
                c3 += x_i * y_5 + (a2[i + 5] & 0xFFFFFFFFL);
                a2[i + 5] = (int) c3;
                c3 >>>= 32;
                c3 += x_i * y_6 + (a2[i + 6] & 0xFFFFFFFFL);
                a2[i + 6] = (int) c3;
                c3 >>>= 32;
                c3 += x_i * y_7 + (a2[i + 7] & 0xFFFFFFFFL);
                a2[i + 7] = (int) c3;
                c3 >>>= 32;
                a2[i + 8] = (int) c3;
            }
            SecP256K1Field.reduce(a2, Z3.x);
        }

        ECFieldElement[] zs = new ECFieldElement[] { Z3 };

        return new SecP256K1Point(curve, X3, Y3, zs, this.withCompression);
    }

    //TODO, CONTINUE REFACTORING !
    public ECPoint twice()
    {
        if (this.isInfinity())
        {
            return this;
        }

        ECCurve curve = this.getCurve();

        SecP256K1FieldElement Y1 = (SecP256K1FieldElement)this.y;
        if (Y1.isZero())
        {
            return curve.getInfinity();
        }

        SecP256K1FieldElement X1 = (SecP256K1FieldElement)this.x, Z1 = (SecP256K1FieldElement)this.zs[0];

        int c;

        int[] Y1Squared = new int[8];
        int[] a13 = new int[16];
        long x_03 = Y1.x[0] & 0xFFFFFFFFL;
        long zz_17;

        int c4 = 0, w3;
        {
            int i3 = 7, j3 = 16;
            do
            {
                long xVal3 = (Y1.x[i3--] & 0xFFFFFFFFL);
                long p3 = xVal3 * xVal3;
                a13[--j3] = (c4 << 31) | (int)(p3 >>> 33);
                a13[--j3] = (int)(p3 >>> 1);
                c4 = (int) p3;
            }
            while (i3 > 0);

            {
                long p3 = x_03 * x_03;
                zz_17 = ((c4 << 31) & 0xFFFFFFFFL) | (p3 >>> 33);
                a13[0] = (int) p3;
                c4 = (int)(p3 >>> 32) & 1;
            }
        }

        long x_13 = Y1.x[1] & 0xFFFFFFFFL;
        long zz_23 = a13[2] & 0xFFFFFFFFL;


            zz_17 += x_13 * x_03;
            w3 = (int) zz_17;
            a13[1] = (w3 << 1) | c4;
            c4 = w3 >>> 31;
            zz_23 += zz_17 >>> 32;


        long x_23 = Y1.x[2] & 0xFFFFFFFFL;
        long zz_33 = a13[3] & 0xFFFFFFFFL;
        long zz_43 = a13[4] & 0xFFFFFFFFL;

            zz_23 += x_23 * x_03;
            w3 = (int) zz_23;
            a13[2] = (w3 << 1) | c4;
            c4 = w3 >>> 31;
            zz_33 += (zz_23 >>> 32) + x_23 * x_13;
            zz_43 += zz_33 >>> 32;
            zz_33 &= 0xFFFFFFFFL;


        long x_33 = Y1.x[3] & 0xFFFFFFFFL;
        long zz_53 = (a13[5] & 0xFFFFFFFFL) + (zz_43 >>> 32);
        zz_43 &= 0xFFFFFFFFL;
        long zz_63 = (a13[6] & 0xFFFFFFFFL) + (zz_53 >>> 32);
        zz_53 &= 0xFFFFFFFFL;

            zz_33 += x_33 * x_03;
            w3 = (int) zz_33;
            a13[3] = (w3 << 1) | c4;
            c4 = w3 >>> 31;
            zz_43 += (zz_33 >>> 32) + x_33 * x_13;
            zz_53 += (zz_43 >>> 32) + x_33 * x_23;
            zz_43 &= 0xFFFFFFFFL;
            zz_63 += zz_53 >>> 32;
            zz_53 &= 0xFFFFFFFFL;


        long x_43 = Y1.x[4] & 0xFFFFFFFFL;
        long zz_73 = (a13[7] & 0xFFFFFFFFL) + (zz_63 >>> 32);
        zz_63 &= 0xFFFFFFFFL;
        long zz_83 = (a13[8] & 0xFFFFFFFFL) + (zz_73 >>> 32);
        zz_73 &= 0xFFFFFFFFL;

            zz_43 += x_43 * x_03;
            w3 = (int) zz_43;
            a13[4] = (w3 << 1) | c4;
            c4 = w3 >>> 31;
            zz_53 += (zz_43 >>> 32) + x_43 * x_13;
            zz_63 += (zz_53 >>> 32) + x_43 * x_23;
            zz_53 &= 0xFFFFFFFFL;
            zz_73 += (zz_63 >>> 32) + x_43 * x_33;
            zz_63 &= 0xFFFFFFFFL;
            zz_83 += zz_73 >>> 32;
            zz_73 &= 0xFFFFFFFFL;


        long x_53 = Y1.x[5] & 0xFFFFFFFFL;
        long zz_93 = (a13[9] & 0xFFFFFFFFL) + (zz_83 >>> 32);
        zz_83 &= 0xFFFFFFFFL;
        long zz_103 = (a13[10] & 0xFFFFFFFFL) + (zz_93 >>> 32);
        zz_93 &= 0xFFFFFFFFL;

            zz_53 += x_53 * x_03;
            w3 = (int) zz_53;
            a13[5] = (w3 << 1) | c4;
            c4 = w3 >>> 31;
            zz_63 += (zz_53 >>> 32) + x_53 * x_13;
            zz_73 += (zz_63 >>> 32) + x_53 * x_23;
            zz_63 &= 0xFFFFFFFFL;
            zz_83 += (zz_73 >>> 32) + x_53 * x_33;
            zz_73 &= 0xFFFFFFFFL;
            zz_93 += (zz_83 >>> 32) + x_53 * x_43;
            zz_83 &= 0xFFFFFFFFL;
            zz_103 += zz_93 >>> 32;
            zz_93 &= 0xFFFFFFFFL;


        long x_63 = Y1.x[6] & 0xFFFFFFFFL;
        long zz_113 = (a13[11] & 0xFFFFFFFFL) + (zz_103 >>> 32);
        zz_103 &= 0xFFFFFFFFL;
        long zz_123 = (a13[12] & 0xFFFFFFFFL) + (zz_113 >>> 32);
        zz_113 &= 0xFFFFFFFFL;

            zz_63 += x_63 * x_03;
            w3 = (int) zz_63;
            a13[6] = (w3 << 1) | c4;
            c4 = w3 >>> 31;
            zz_73 += (zz_63 >>> 32) + x_63 * x_13;
            zz_83 += (zz_73 >>> 32) + x_63 * x_23;
            zz_73 &= 0xFFFFFFFFL;
            zz_93 += (zz_83 >>> 32) + x_63 * x_33;
            zz_83 &= 0xFFFFFFFFL;
            zz_103 += (zz_93 >>> 32) + x_63 * x_43;
            zz_93 &= 0xFFFFFFFFL;
            zz_113 += (zz_103 >>> 32) + x_63 * x_53;
            zz_103 &= 0xFFFFFFFFL;
            zz_123 += zz_113 >>> 32;
            zz_113 &= 0xFFFFFFFFL;


        long x_73 = Y1.x[7] & 0xFFFFFFFFL;
        long zz_133 = (a13[13] & 0xFFFFFFFFL) + (zz_123 >>> 32);
        zz_123 &= 0xFFFFFFFFL;
        long zz_143 = (a13[14] & 0xFFFFFFFFL) + (zz_133 >>> 32);
        zz_133 &= 0xFFFFFFFFL;

            zz_73 += x_73 * x_03;
            w3 = (int) zz_73;
            a13[7] = (w3 << 1) | c4;
            c4 = w3 >>> 31;
            zz_83 += (zz_73 >>> 32) + x_73 * x_13;
            zz_93 += (zz_83 >>> 32) + x_73 * x_23;
            zz_103 += (zz_93 >>> 32) + x_73 * x_33;
            zz_113 += (zz_103 >>> 32) + x_73 * x_43;
            zz_123 += (zz_113 >>> 32) + x_73 * x_53;
            zz_133 += (zz_123 >>> 32) + x_73 * x_63;
            zz_143 += zz_133 >>> 32;


        w3 = (int) zz_83;
        a13[8] = (w3 << 1) | c4;
        c4 = w3 >>> 31;
        w3 = (int) zz_93;
        a13[9] = (w3 << 1) | c4;
        c4 = w3 >>> 31;
        w3 = (int) zz_103;
        a13[10] = (w3 << 1) | c4;
        c4 = w3 >>> 31;
        w3 = (int) zz_113;
        a13[11] = (w3 << 1) | c4;
        c4 = w3 >>> 31;
        w3 = (int) zz_123;
        a13[12] = (w3 << 1) | c4;
        c4 = w3 >>> 31;
        w3 = (int) zz_133;
        a13[13] = (w3 << 1) | c4;
        c4 = w3 >>> 31;
        w3 = (int) zz_143;
        a13[14] = (w3 << 1) | c4;
        c4 = w3 >>> 31;
        w3 = a13[15] + (int)(zz_143 >>> 32);
        a13[15] = (w3 << 1) | c4;
        SecP256K1Field.reduce(a13, Y1Squared);

        int[] T = new int[8];
        int[] a12 = new int[16];
        long x_02 = Y1Squared[0] & 0xFFFFFFFFL;
        long zz_16;

        int c3 = 0, w2;
        {
            int i2 = 7, j2 = 16;
            do
            {
                long xVal2 = (Y1Squared[i2--] & 0xFFFFFFFFL);
                long p2 = xVal2 * xVal2;
                a12[--j2] = (c3 << 31) | (int)(p2 >>> 33);
                a12[--j2] = (int)(p2 >>> 1);
                c3 = (int) p2;
            }
            while (i2 > 0);

            {
                long p2 = x_02 * x_02;
                zz_16 = ((c3 << 31) & 0xFFFFFFFFL) | (p2 >>> 33);
                a12[0] = (int) p2;
                c3 = (int)(p2 >>> 32) & 1;
            }
        }

        long x_12 = Y1Squared[1] & 0xFFFFFFFFL;
        long zz_22 = a12[2] & 0xFFFFFFFFL;


            zz_16 += x_12 * x_02;
            w2 = (int) zz_16;
            a12[1] = (w2 << 1) | c3;
            c3 = w2 >>> 31;
            zz_22 += zz_16 >>> 32;


        long x_22 = Y1Squared[2] & 0xFFFFFFFFL;
        long zz_32 = a12[3] & 0xFFFFFFFFL;
        long zz_42 = a12[4] & 0xFFFFFFFFL;

            zz_22 += x_22 * x_02;
            w2 = (int) zz_22;
            a12[2] = (w2 << 1) | c3;
            c3 = w2 >>> 31;
            zz_32 += (zz_22 >>> 32) + x_22 * x_12;
            zz_42 += zz_32 >>> 32;
            zz_32 &= 0xFFFFFFFFL;


        long x_32 = Y1Squared[3] & 0xFFFFFFFFL;
        long zz_52 = (a12[5] & 0xFFFFFFFFL) + (zz_42 >>> 32);
        zz_42 &= 0xFFFFFFFFL;
        long zz_62 = (a12[6] & 0xFFFFFFFFL) + (zz_52 >>> 32);
        zz_52 &= 0xFFFFFFFFL;

            zz_32 += x_32 * x_02;
            w2 = (int) zz_32;
            a12[3] = (w2 << 1) | c3;
            c3 = w2 >>> 31;
            zz_42 += (zz_32 >>> 32) + x_32 * x_12;
            zz_52 += (zz_42 >>> 32) + x_32 * x_22;
            zz_42 &= 0xFFFFFFFFL;
            zz_62 += zz_52 >>> 32;
            zz_52 &= 0xFFFFFFFFL;


        long x_42 = Y1Squared[4] & 0xFFFFFFFFL;
        long zz_72 = (a12[7] & 0xFFFFFFFFL) + (zz_62 >>> 32);
        zz_62 &= 0xFFFFFFFFL;
        long zz_82 = (a12[8] & 0xFFFFFFFFL) + (zz_72 >>> 32);
        zz_72 &= 0xFFFFFFFFL;

            zz_42 += x_42 * x_02;
            w2 = (int) zz_42;
            a12[4] = (w2 << 1) | c3;
            c3 = w2 >>> 31;
            zz_52 += (zz_42 >>> 32) + x_42 * x_12;
            zz_62 += (zz_52 >>> 32) + x_42 * x_22;
            zz_52 &= 0xFFFFFFFFL;
            zz_72 += (zz_62 >>> 32) + x_42 * x_32;
            zz_62 &= 0xFFFFFFFFL;
            zz_82 += zz_72 >>> 32;
            zz_72 &= 0xFFFFFFFFL;


        long x_52 = Y1Squared[5] & 0xFFFFFFFFL;
        long zz_92 = (a12[9] & 0xFFFFFFFFL) + (zz_82 >>> 32);
        zz_82 &= 0xFFFFFFFFL;
        long zz_102 = (a12[10] & 0xFFFFFFFFL) + (zz_92 >>> 32);
        zz_92 &= 0xFFFFFFFFL;

            zz_52 += x_52 * x_02;
            w2 = (int) zz_52;
            a12[5] = (w2 << 1) | c3;
            c3 = w2 >>> 31;
            zz_62 += (zz_52 >>> 32) + x_52 * x_12;
            zz_72 += (zz_62 >>> 32) + x_52 * x_22;
            zz_62 &= 0xFFFFFFFFL;
            zz_82 += (zz_72 >>> 32) + x_52 * x_32;
            zz_72 &= 0xFFFFFFFFL;
            zz_92 += (zz_82 >>> 32) + x_52 * x_42;
            zz_82 &= 0xFFFFFFFFL;
            zz_102 += zz_92 >>> 32;
            zz_92 &= 0xFFFFFFFFL;


        long x_62 = Y1Squared[6] & 0xFFFFFFFFL;
        long zz_112 = (a12[11] & 0xFFFFFFFFL) + (zz_102 >>> 32);
        zz_102 &= 0xFFFFFFFFL;
        long zz_122 = (a12[12] & 0xFFFFFFFFL) + (zz_112 >>> 32);
        zz_112 &= 0xFFFFFFFFL;

            zz_62 += x_62 * x_02;
            w2 = (int) zz_62;
            a12[6] = (w2 << 1) | c3;
            c3 = w2 >>> 31;
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


        long x_72 = Y1Squared[7] & 0xFFFFFFFFL;
        long zz_132 = (a12[13] & 0xFFFFFFFFL) + (zz_122 >>> 32);
        zz_122 &= 0xFFFFFFFFL;
        long zz_142 = (a12[14] & 0xFFFFFFFFL) + (zz_132 >>> 32);
        zz_132 &= 0xFFFFFFFFL;

            zz_72 += x_72 * x_02;
            w2 = (int) zz_72;
            a12[7] = (w2 << 1) | c3;
            c3 = w2 >>> 31;
            zz_82 += (zz_72 >>> 32) + x_72 * x_12;
            zz_92 += (zz_82 >>> 32) + x_72 * x_22;
            zz_102 += (zz_92 >>> 32) + x_72 * x_32;
            zz_112 += (zz_102 >>> 32) + x_72 * x_42;
            zz_122 += (zz_112 >>> 32) + x_72 * x_52;
            zz_132 += (zz_122 >>> 32) + x_72 * x_62;
            zz_142 += zz_132 >>> 32;


        w2 = (int) zz_82;
        a12[8] = (w2 << 1) | c3;
        c3 = w2 >>> 31;
        w2 = (int) zz_92;
        a12[9] = (w2 << 1) | c3;
        c3 = w2 >>> 31;
        w2 = (int) zz_102;
        a12[10] = (w2 << 1) | c3;
        c3 = w2 >>> 31;
        w2 = (int) zz_112;
        a12[11] = (w2 << 1) | c3;
        c3 = w2 >>> 31;
        w2 = (int) zz_122;
        a12[12] = (w2 << 1) | c3;
        c3 = w2 >>> 31;
        w2 = (int) zz_132;
        a12[13] = (w2 << 1) | c3;
        c3 = w2 >>> 31;
        w2 = (int) zz_142;
        a12[14] = (w2 << 1) | c3;
        c3 = w2 >>> 31;
        w2 = a12[15] + (int)(zz_142 >>> 32);
        a12[15] = (w2 << 1) | c3;
        SecP256K1Field.reduce(a12, T);

        int[] M = new int[8];
        int[] a11 = new int[16];
        long x_01 = X1.x[0] & 0xFFFFFFFFL;
        long zz_15;

        int c2 = 0, w1;
        {
            int i1 = 7, j1 = 16;
            do
            {
                long xVal1 = (X1.x[i1--] & 0xFFFFFFFFL);
                long p1 = xVal1 * xVal1;
                a11[--j1] = (c2 << 31) | (int)(p1 >>> 33);
                a11[--j1] = (int)(p1 >>> 1);
                c2 = (int) p1;
            }
            while (i1 > 0);

            {
                long p1 = x_01 * x_01;
                zz_15 = ((c2 << 31) & 0xFFFFFFFFL) | (p1 >>> 33);
                a11[0] = (int) p1;
                c2 = (int)(p1 >>> 32) & 1;
            }
        }

        long x_11 = X1.x[1] & 0xFFFFFFFFL;
        long zz_21 = a11[2] & 0xFFFFFFFFL;


            zz_15 += x_11 * x_01;
            w1 = (int) zz_15;
            a11[1] = (w1 << 1) | c2;
            c2 = w1 >>> 31;
            zz_21 += zz_15 >>> 32;


        long x_21 = X1.x[2] & 0xFFFFFFFFL;
        long zz_31 = a11[3] & 0xFFFFFFFFL;
        long zz_41 = a11[4] & 0xFFFFFFFFL;

            zz_21 += x_21 * x_01;
            w1 = (int) zz_21;
            a11[2] = (w1 << 1) | c2;
            c2 = w1 >>> 31;
            zz_31 += (zz_21 >>> 32) + x_21 * x_11;
            zz_41 += zz_31 >>> 32;
            zz_31 &= 0xFFFFFFFFL;


        long x_31 = X1.x[3] & 0xFFFFFFFFL;
        long zz_51 = (a11[5] & 0xFFFFFFFFL) + (zz_41 >>> 32);
        zz_41 &= 0xFFFFFFFFL;
        long zz_61 = (a11[6] & 0xFFFFFFFFL) + (zz_51 >>> 32);
        zz_51 &= 0xFFFFFFFFL;

            zz_31 += x_31 * x_01;
            w1 = (int) zz_31;
            a11[3] = (w1 << 1) | c2;
            c2 = w1 >>> 31;
            zz_41 += (zz_31 >>> 32) + x_31 * x_11;
            zz_51 += (zz_41 >>> 32) + x_31 * x_21;
            zz_41 &= 0xFFFFFFFFL;
            zz_61 += zz_51 >>> 32;
            zz_51 &= 0xFFFFFFFFL;


        long x_41 = X1.x[4] & 0xFFFFFFFFL;
        long zz_71 = (a11[7] & 0xFFFFFFFFL) + (zz_61 >>> 32);
        zz_61 &= 0xFFFFFFFFL;
        long zz_81 = (a11[8] & 0xFFFFFFFFL) + (zz_71 >>> 32);
        zz_71 &= 0xFFFFFFFFL;

            zz_41 += x_41 * x_01;
            w1 = (int) zz_41;
            a11[4] = (w1 << 1) | c2;
            c2 = w1 >>> 31;
            zz_51 += (zz_41 >>> 32) + x_41 * x_11;
            zz_61 += (zz_51 >>> 32) + x_41 * x_21;
            zz_51 &= 0xFFFFFFFFL;
            zz_71 += (zz_61 >>> 32) + x_41 * x_31;
            zz_61 &= 0xFFFFFFFFL;
            zz_81 += zz_71 >>> 32;
            zz_71 &= 0xFFFFFFFFL;


        long x_51 = X1.x[5] & 0xFFFFFFFFL;
        long zz_91 = (a11[9] & 0xFFFFFFFFL) + (zz_81 >>> 32);
        zz_81 &= 0xFFFFFFFFL;
        long zz_101 = (a11[10] & 0xFFFFFFFFL) + (zz_91 >>> 32);
        zz_91 &= 0xFFFFFFFFL;

            zz_51 += x_51 * x_01;
            w1 = (int) zz_51;
            a11[5] = (w1 << 1) | c2;
            c2 = w1 >>> 31;
            zz_61 += (zz_51 >>> 32) + x_51 * x_11;
            zz_71 += (zz_61 >>> 32) + x_51 * x_21;
            zz_61 &= 0xFFFFFFFFL;
            zz_81 += (zz_71 >>> 32) + x_51 * x_31;
            zz_71 &= 0xFFFFFFFFL;
            zz_91 += (zz_81 >>> 32) + x_51 * x_41;
            zz_81 &= 0xFFFFFFFFL;
            zz_101 += zz_91 >>> 32;
            zz_91 &= 0xFFFFFFFFL;


        long x_61 = X1.x[6] & 0xFFFFFFFFL;
        long zz_111 = (a11[11] & 0xFFFFFFFFL) + (zz_101 >>> 32);
        zz_101 &= 0xFFFFFFFFL;
        long zz_121 = (a11[12] & 0xFFFFFFFFL) + (zz_111 >>> 32);
        zz_111 &= 0xFFFFFFFFL;

            zz_61 += x_61 * x_01;
            w1 = (int) zz_61;
            a11[6] = (w1 << 1) | c2;
            c2 = w1 >>> 31;
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


        long x_71 = X1.x[7] & 0xFFFFFFFFL;
        long zz_131 = (a11[13] & 0xFFFFFFFFL) + (zz_121 >>> 32);
        zz_121 &= 0xFFFFFFFFL;
        long zz_141 = (a11[14] & 0xFFFFFFFFL) + (zz_131 >>> 32);
        zz_131 &= 0xFFFFFFFFL;

            zz_71 += x_71 * x_01;
            w1 = (int) zz_71;
            a11[7] = (w1 << 1) | c2;
            c2 = w1 >>> 31;
            zz_81 += (zz_71 >>> 32) + x_71 * x_11;
            zz_91 += (zz_81 >>> 32) + x_71 * x_21;
            zz_101 += (zz_91 >>> 32) + x_71 * x_31;
            zz_111 += (zz_101 >>> 32) + x_71 * x_41;
            zz_121 += (zz_111 >>> 32) + x_71 * x_51;
            zz_131 += (zz_121 >>> 32) + x_71 * x_61;
            zz_141 += zz_131 >>> 32;


        w1 = (int) zz_81;
        a11[8] = (w1 << 1) | c2;
        c2 = w1 >>> 31;
        w1 = (int) zz_91;
        a11[9] = (w1 << 1) | c2;
        c2 = w1 >>> 31;
        w1 = (int) zz_101;
        a11[10] = (w1 << 1) | c2;
        c2 = w1 >>> 31;
        w1 = (int) zz_111;
        a11[11] = (w1 << 1) | c2;
        c2 = w1 >>> 31;
        w1 = (int) zz_121;
        a11[12] = (w1 << 1) | c2;
        c2 = w1 >>> 31;
        w1 = (int) zz_131;
        a11[13] = (w1 << 1) | c2;
        c2 = w1 >>> 31;
        w1 = (int) zz_141;
        a11[14] = (w1 << 1) | c2;
        c2 = w1 >>> 31;
        w1 = a11[15] + (int)(zz_141 >>> 32);
        a11[15] = (w1 << 1) | c2;
        SecP256K1Field.reduce(a11, M);
        c = Nat256.addBothTo(M, M, M);
        SecP256K1Field.reduce32(c, M);

        int[] a22 = new int[16];
        long y_02 = X1.x[0] & 0xFFFFFFFFL;
        long y_12 = X1.x[1] & 0xFFFFFFFFL;
        long y_22 = X1.x[2] & 0xFFFFFFFFL;
        long y_32 = X1.x[3] & 0xFFFFFFFFL;
        long y_42 = X1.x[4] & 0xFFFFFFFFL;
        long y_52 = X1.x[5] & 0xFFFFFFFFL;
        long y_62 = X1.x[6] & 0xFFFFFFFFL;
        long y_72 = X1.x[7] & 0xFFFFFFFFL;


            long c7 = 0, x_06 = Y1Squared[0] & 0xFFFFFFFFL;
            c7 += x_06 * y_02;
            a22[0] = (int) c7;
            c7 >>>= 32;
            c7 += x_06 * y_12;
            a22[1] = (int) c7;
            c7 >>>= 32;
            c7 += x_06 * y_22;
            a22[2] = (int) c7;
            c7 >>>= 32;
            c7 += x_06 * y_32;
            a22[3] = (int) c7;
            c7 >>>= 32;
            c7 += x_06 * y_42;
            a22[4] = (int) c7;
            c7 >>>= 32;
            c7 += x_06 * y_52;
            a22[5] = (int) c7;
            c7 >>>= 32;
            c7 += x_06 * y_62;
            a22[6] = (int) c7;
            c7 >>>= 32;
            c7 += x_06 * y_72;
            a22[7] = (int) c7;
            c7 >>>= 32;
            a22[8] = (int) c7;


        for (int i2 = 1; i2 < 8; ++i2)
        {
             c7 = 0;
                     long x_i2 = Y1Squared[i2] & 0xFFFFFFFFL;
            c7 += x_i2 * y_02 + (a22[i2] & 0xFFFFFFFFL);
            a22[i2] = (int) c7;
            c7 >>>= 32;
            c7 += x_i2 * y_12 + (a22[i2 + 1] & 0xFFFFFFFFL);
            a22[i2 + 1] = (int) c7;
            c7 >>>= 32;
            c7 += x_i2 * y_22 + (a22[i2 + 2] & 0xFFFFFFFFL);
            a22[i2 + 2] = (int) c7;
            c7 >>>= 32;
            c7 += x_i2 * y_32 + (a22[i2 + 3] & 0xFFFFFFFFL);
            a22[i2 + 3] = (int) c7;
            c7 >>>= 32;
            c7 += x_i2 * y_42 + (a22[i2 + 4] & 0xFFFFFFFFL);
            a22[i2 + 4] = (int) c7;
            c7 >>>= 32;
            c7 += x_i2 * y_52 + (a22[i2 + 5] & 0xFFFFFFFFL);
            a22[i2 + 5] = (int) c7;
            c7 >>>= 32;
            c7 += x_i2 * y_62 + (a22[i2 + 6] & 0xFFFFFFFFL);
            a22[i2 + 6] = (int) c7;
            c7 >>>= 32;
            c7 += x_i2 * y_72 + (a22[i2 + 7] & 0xFFFFFFFFL);
            a22[i2 + 7] = (int) c7;
            c7 >>>= 32;
            a22[i2 + 8] = (int) c7;
        }
        SecP256K1Field.reduce(a22, Y1Squared);
        c = Nat.shiftUpBits(8, Y1Squared, 2, 0);
        SecP256K1Field.reduce32(c, Y1Squared);

        int[] t1 = new int[8];
        c = Nat.shiftUpBits(8, T, 3, 0, t1);
        SecP256K1Field.reduce32(c, t1);

        SecP256K1FieldElement X3 = new SecP256K1FieldElement(T);
        int[] a1 = new int[16];
        long x_0 = M[0] & 0xFFFFFFFFL;
        long zz_1;

        int c1 = 0, w;
        {
            int i = 7, j = 16;
            do
            {
                long xVal = (M[i--] & 0xFFFFFFFFL);
                long p = xVal * xVal;
                a1[--j] = (c1 << 31) | (int)(p >>> 33);
                a1[--j] = (int)(p >>> 1);
                c1 = (int)p;
            }
            while (i > 0);


                long p = x_0 * x_0;
                zz_1 = ((c1 << 31) & 0xFFFFFFFFL) | (p >>> 33);
                a1[0] = (int)p;
                c1 = (int)(p >>> 32) & 1;

        }

        long x_1 = M[1] & 0xFFFFFFFFL;
        long zz_2 = a1[2] & 0xFFFFFFFFL;


            zz_1 += x_1 * x_0;
            w = (int)zz_1;
            a1[1] = (w << 1) | c1;
            c1 = w >>> 31;
            zz_2 += zz_1 >>> 32;


        long x_2 = M[2] & 0xFFFFFFFFL;
        long zz_3 = a1[3] & 0xFFFFFFFFL;
        long zz_4 = a1[4] & 0xFFFFFFFFL;

            zz_2 += x_2 * x_0;
            w = (int)zz_2;
            a1[2] = (w << 1) | c1;
            c1 = w >>> 31;
            zz_3 += (zz_2 >>> 32) + x_2 * x_1;
            zz_4 += zz_3 >>> 32;
            zz_3 &= 0xFFFFFFFFL;


        long x_3 = M[3] & 0xFFFFFFFFL;
        long zz_5 = (a1[5] & 0xFFFFFFFFL) + (zz_4 >>> 32);
        zz_4 &= 0xFFFFFFFFL;
        long zz_6 = (a1[6] & 0xFFFFFFFFL) + (zz_5 >>> 32);
        zz_5 &= 0xFFFFFFFFL;

            zz_3 += x_3 * x_0;
            w = (int)zz_3;
            a1[3] = (w << 1) | c1;
            c1 = w >>> 31;
            zz_4 += (zz_3 >>> 32) + x_3 * x_1;
            zz_5 += (zz_4 >>> 32) + x_3 * x_2;
            zz_4 &= 0xFFFFFFFFL;
            zz_6 += zz_5 >>> 32;
            zz_5 &= 0xFFFFFFFFL;


        long x_4 = M[4] & 0xFFFFFFFFL;
        long zz_7 = (a1[7] & 0xFFFFFFFFL) + (zz_6 >>> 32);
        zz_6 &= 0xFFFFFFFFL;
        long zz_8 = (a1[8] & 0xFFFFFFFFL) + (zz_7 >>> 32);
        zz_7 &= 0xFFFFFFFFL;

            zz_4 += x_4 * x_0;
            w = (int)zz_4;
            a1[4] = (w << 1) | c1;
            c1 = w >>> 31;
            zz_5 += (zz_4 >>> 32) + x_4 * x_1;
            zz_6 += (zz_5 >>> 32) + x_4 * x_2;
            zz_5 &= 0xFFFFFFFFL;
            zz_7 += (zz_6 >>> 32) + x_4 * x_3;
            zz_6 &= 0xFFFFFFFFL;
            zz_8 += zz_7 >>> 32;
            zz_7 &= 0xFFFFFFFFL;


        long x_5 = M[5] & 0xFFFFFFFFL;
        long zz_9 = (a1[9] & 0xFFFFFFFFL) + (zz_8 >>> 32);
        zz_8 &= 0xFFFFFFFFL;
        long zz_10 = (a1[10] & 0xFFFFFFFFL) + (zz_9 >>> 32);
        zz_9 &= 0xFFFFFFFFL;

            zz_5 += x_5 * x_0;
            w = (int)zz_5;
            a1[5] = (w << 1) | c1;
            c1 = w >>> 31;
            zz_6 += (zz_5 >>> 32) + x_5 * x_1;
            zz_7 += (zz_6 >>> 32) + x_5 * x_2;
            zz_6 &= 0xFFFFFFFFL;
            zz_8 += (zz_7 >>> 32) + x_5 * x_3;
            zz_7 &= 0xFFFFFFFFL;
            zz_9 += (zz_8 >>> 32) + x_5 * x_4;
            zz_8 &= 0xFFFFFFFFL;
            zz_10 += zz_9 >>> 32;
            zz_9 &= 0xFFFFFFFFL;


        long x_6 = M[6] & 0xFFFFFFFFL;
        long zz_11 = (a1[11] & 0xFFFFFFFFL) + (zz_10 >>> 32);
        zz_10 &= 0xFFFFFFFFL;
        long zz_12 = (a1[12] & 0xFFFFFFFFL) + (zz_11 >>> 32);
        zz_11 &= 0xFFFFFFFFL;

            zz_6 += x_6 * x_0;
            w = (int)zz_6;
            a1[6] = (w << 1) | c1;
            c1 = w >>> 31;
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


        long x_7 = M[7] & 0xFFFFFFFFL;
        long zz_13 = (a1[13] & 0xFFFFFFFFL) + (zz_12 >>> 32);
        zz_12 &= 0xFFFFFFFFL;
        long zz_14 = (a1[14] & 0xFFFFFFFFL) + (zz_13 >>> 32);
        zz_13 &= 0xFFFFFFFFL;

            zz_7 += x_7 * x_0;
            w = (int)zz_7;
            a1[7] = (w << 1) | c1;
            c1 = w >>> 31;
            zz_8 += (zz_7 >>> 32) + x_7 * x_1;
            zz_9 += (zz_8 >>> 32) + x_7 * x_2;
            zz_10 += (zz_9 >>> 32) + x_7 * x_3;
            zz_11 += (zz_10 >>> 32) + x_7 * x_4;
            zz_12 += (zz_11 >>> 32) + x_7 * x_5;
            zz_13 += (zz_12 >>> 32) + x_7 * x_6;
            zz_14 += zz_13 >>> 32;


        w = (int)zz_8;
        a1[8] = (w << 1) | c1;
        c1 = w >>> 31;
        w = (int)zz_9;
        a1[9] = (w << 1) | c1;
        c1 = w >>> 31;
        w = (int)zz_10;
        a1[10] = (w << 1) | c1;
        c1 = w >>> 31;
        w = (int)zz_11;
        a1[11] = (w << 1) | c1;
        c1 = w >>> 31;
        w = (int)zz_12;
        a1[12] = (w << 1) | c1;
        c1 = w >>> 31;
        w = (int)zz_13;
        a1[13] = (w << 1) | c1;
        c1 = w >>> 31;
        w = (int)zz_14;
        a1[14] = (w << 1) | c1;
        c1 = w >>> 31;
        w = a1[15] + (int)(zz_14 >>> 32);
        a1[15] = (w << 1) | c1;
        SecP256K1Field.reduce(a1, X3.x);
        SecP256K1Field.subtract(X3.x, Y1Squared, X3.x);
        SecP256K1Field.subtract(X3.x, Y1Squared, X3.x);

        SecP256K1FieldElement Y3 = new SecP256K1FieldElement(Y1Squared);
        SecP256K1Field.subtract(Y1Squared, X3.x, Y3.x);
        int[] a21 = new int[16];
        long y_01 = M[0] & 0xFFFFFFFFL;
        long y_11 = M[1] & 0xFFFFFFFFL;
        long y_21 = M[2] & 0xFFFFFFFFL;
        long y_31 = M[3] & 0xFFFFFFFFL;
        long y_41 = M[4] & 0xFFFFFFFFL;
        long y_51 = M[5] & 0xFFFFFFFFL;
        long y_61 = M[6] & 0xFFFFFFFFL;
        long y_71 = M[7] & 0xFFFFFFFFL;


            long c6 = 0, x_05 = Y3.x[0] & 0xFFFFFFFFL;
            c6 += x_05 * y_01;
            a21[0] = (int) c6;
            c6 >>>= 32;
            c6 += x_05 * y_11;
            a21[1] = (int) c6;
            c6 >>>= 32;
            c6 += x_05 * y_21;
            a21[2] = (int) c6;
            c6 >>>= 32;
            c6 += x_05 * y_31;
            a21[3] = (int) c6;
            c6 >>>= 32;
            c6 += x_05 * y_41;
            a21[4] = (int) c6;
            c6 >>>= 32;
            c6 += x_05 * y_51;
            a21[5] = (int) c6;
            c6 >>>= 32;
            c6 += x_05 * y_61;
            a21[6] = (int) c6;
            c6 >>>= 32;
            c6 += x_05 * y_71;
            a21[7] = (int) c6;
            c6 >>>= 32;
            a21[8] = (int) c6;


        for (int i1 = 1; i1 < 8; ++i1)
        {
            c6 = 0;
            long x_i1 = Y3.x[i1] & 0xFFFFFFFFL;
            c6 += x_i1 * y_01 + (a21[i1] & 0xFFFFFFFFL);
            a21[i1] = (int) c6;
            c6 >>>= 32;
            c6 += x_i1 * y_11 + (a21[i1 + 1] & 0xFFFFFFFFL);
            a21[i1 + 1] = (int) c6;
            c6 >>>= 32;
            c6 += x_i1 * y_21 + (a21[i1 + 2] & 0xFFFFFFFFL);
            a21[i1 + 2] = (int) c6;
            c6 >>>= 32;
            c6 += x_i1 * y_31 + (a21[i1 + 3] & 0xFFFFFFFFL);
            a21[i1 + 3] = (int) c6;
            c6 >>>= 32;
            c6 += x_i1 * y_41 + (a21[i1 + 4] & 0xFFFFFFFFL);
            a21[i1 + 4] = (int) c6;
            c6 >>>= 32;
            c6 += x_i1 * y_51 + (a21[i1 + 5] & 0xFFFFFFFFL);
            a21[i1 + 5] = (int) c6;
            c6 >>>= 32;
            c6 += x_i1 * y_61 + (a21[i1 + 6] & 0xFFFFFFFFL);
            a21[i1 + 6] = (int) c6;
            c6 >>>= 32;
            c6 += x_i1 * y_71 + (a21[i1 + 7] & 0xFFFFFFFFL);
            a21[i1 + 7] = (int) c6;
            c6 >>>= 32;
            a21[i1 + 8] = (int) c6;
        }
        SecP256K1Field.reduce(a21, Y3.x);
        SecP256K1Field.subtract(Y3.x, t1, Y3.x);

        SecP256K1FieldElement Z3 = new SecP256K1FieldElement(M);
        SecP256K1Field.twice(Y1.x, Z3.x);
        if (!Z1.isOne())
        {
            int[] a2 = new int[16];
            long y_0 = Z1.x[0] & 0xFFFFFFFFL;
            long y_1 = Z1.x[1] & 0xFFFFFFFFL;
            long y_2 = Z1.x[2] & 0xFFFFFFFFL;
            long y_3 = Z1.x[3] & 0xFFFFFFFFL;
            long y_4 = Z1.x[4] & 0xFFFFFFFFL;
            long y_5 = Z1.x[5] & 0xFFFFFFFFL;
            long y_6 = Z1.x[6] & 0xFFFFFFFFL;
            long y_7 = Z1.x[7] & 0xFFFFFFFFL;

            {
                long c5 = 0, x_04 = Z3.x[0] & 0xFFFFFFFFL;
                c5 += x_04 * y_0;
                a2[0] = (int) c5;
                c5 >>>= 32;
                c5 += x_04 * y_1;
                a2[1] = (int) c5;
                c5 >>>= 32;
                c5 += x_04 * y_2;
                a2[2] = (int) c5;
                c5 >>>= 32;
                c5 += x_04 * y_3;
                a2[3] = (int) c5;
                c5 >>>= 32;
                c5 += x_04 * y_4;
                a2[4] = (int) c5;
                c5 >>>= 32;
                c5 += x_04 * y_5;
                a2[5] = (int) c5;
                c5 >>>= 32;
                c5 += x_04 * y_6;
                a2[6] = (int) c5;
                c5 >>>= 32;
                c5 += x_04 * y_7;
                a2[7] = (int) c5;
                c5 >>>= 32;
                a2[8] = (int) c5;
            }

            for (int i = 1; i < 8; ++i)
            {
                long c5 = 0, x_i = Z3.x[i] & 0xFFFFFFFFL;
                c5 += x_i * y_0 + (a2[i] & 0xFFFFFFFFL);
                a2[i] = (int) c5;
                c5 >>>= 32;
                c5 += x_i * y_1 + (a2[i + 1] & 0xFFFFFFFFL);
                a2[i + 1] = (int) c5;
                c5 >>>= 32;
                c5 += x_i * y_2 + (a2[i + 2] & 0xFFFFFFFFL);
                a2[i + 2] = (int) c5;
                c5 >>>= 32;
                c5 += x_i * y_3 + (a2[i + 3] & 0xFFFFFFFFL);
                a2[i + 3] = (int) c5;
                c5 >>>= 32;
                c5 += x_i * y_4 + (a2[i + 4] & 0xFFFFFFFFL);
                a2[i + 4] = (int) c5;
                c5 >>>= 32;
                c5 += x_i * y_5 + (a2[i + 5] & 0xFFFFFFFFL);
                a2[i + 5] = (int) c5;
                c5 >>>= 32;
                c5 += x_i * y_6 + (a2[i + 6] & 0xFFFFFFFFL);
                a2[i + 6] = (int) c5;
                c5 >>>= 32;
                c5 += x_i * y_7 + (a2[i + 7] & 0xFFFFFFFFL);
                a2[i + 7] = (int) c5;
                c5 >>>= 32;
                a2[i + 8] = (int) c5;
            }
            SecP256K1Field.reduce(a2, Z3.x);
        }

        return new SecP256K1Point(curve, X3, Y3, new ECFieldElement[] { Z3 }, this.withCompression);
    }

    public ECPoint twicePlus(ECPoint b) {

        if (this.isInfinity())
        {
            return b;
        }




        return twice().add(b);
    }



    public ECPoint negate()
    {


        return new SecP256K1Point(curve, this.x, this.y.negate(), this.zs, this.withCompression);
    }

    public ECPoint subtract(ECPoint b) {



        return this.add(b.negate());
    }
}
