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

    public static int[] fromBigInteger(BigInteger x)
    {
        int[] z = Nat256.fromBigInteger(x);
        if (z[7] == P7 && Nat256.gte(z, P))
        {
            Nat256.subFrom(P, z);
        }
        return z;
    }

    public static void multiply(int[] a, int[] a0, int[] a1) {
        int[] a2 = Nat256.createExt();
        Nat256.mul(a, a0, a2);
        reduce(a2, a1);
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
        int c = Nat256.mul33DWordAdd(PInv33, cc, z, 0);



        if (c != 0 || (z[7] == P7 && Nat256.gte(z, P)))
        {
            Nat.add33To(8, PInv33, z);
        }
    }

    public static void reduce32(int x, int[] z)
    {
        if ((x != 0 && Nat256.mul33WordAdd(PInv33, x, z, 0) != 0)
                || (z[7] == P7 && Nat256.gte(z, P)))
        {
            Nat.add33To(8, PInv33, z);
        }
    }

    public static void square(int[] a, int[] a0) {
        int[] a1 = Nat256.createExt();
        Nat256.square(a, a1);
        SecP256K1Field.reduce(a1, a0);
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
