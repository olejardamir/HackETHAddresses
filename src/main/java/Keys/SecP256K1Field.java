package Keys;

import java.math.BigInteger;

class SecP256K1Field {
    final static int[] P;
    final private static int[] PExt;
    final private static int[] PExtInv;


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


    static int[] fromBigInteger(BigInteger x) {
        int[] z1 = new int[8];
        for (int i = 0; x.signum() != 0; ) {
            z1[i++] = x.intValue();
            x = x.shiftRight(32);
        }
        if (z1[7] == -1 && Nat256.gte(z1))
            Nat256.subFrom(z1);
        return z1;
    }

    static void multiplyAddToExt(int[] x, int[] y, int[] zz) {
        if ((Nat256.mulAddTo(x, y, zz) != 0 || (zz[15] == -1 && Nat.gte(16, zz, PExt)))
                && Nat.addTo(PExtInv.length, PExtInv, zz) != 0)
            for (int i = PExtInv.length; i < 16; ++i)
                if (++zz[i] != 0)
                    return;
    }

    static void reduce(int[] xx, int[] z) {
        Nat256.mul33DWordAdd(Nat256.mul33Add(xx, xx, z), z);
    }

    static void reduce32(int x, int[] z) {
        if ((x != 0 && Nat256.mul33WordAdd(x, z) != 0)
                || (z[7] == -1 && Nat256.gte(z))) {
            Nat.add33To(z);
        }
    }

    static void twice(int[] x, int[] z) {
        int c = 0;
        for (int i = 0; i < 8; ++i) {
            int next = x[i];
            z[i] = c >>> 31 | next << 1;
            c = next;
        }
        if (c >>> 31 != 0 || (z[7] == -1 && Nat256.gte(z)))
            Nat.add33To(z);
    }
}