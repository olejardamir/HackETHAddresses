import java.math.BigInteger;

// 
// Decompiled by Procyon v0.5.36
// 

class SecP256K1Field
{
    static final int[] P;
    private static final int[] PExt;
    private static final int[] PExtInv;

    public static int[] fromBigInteger(final BigInteger x) {
        final int[] z = Nat256.fromBigInteger(x);
        if (z[7] == -1 && Nat256.gte(z, SecP256K1Field.P)) {
            Nat256.subFrom(SecP256K1Field.P, z);
        }
        return z;
    }
    
    public static void multiply(final int[] a, final int[] a0, final int[] a1) {
        final int[] a2 = Nat256.createExt();
        Nat256.mul(a, a0, a2);
        reduce(a2, a1);
    }
    
    public static void multiplyAddToExt(final int[] x, final int[] y, final int[] zz) {
        final int c = Nat256.mulAddTo(x, y, zz);
        if ((c != 0 || (zz[15] == -1 && Nat.gte(16, zz, SecP256K1Field.PExt))) && Nat.addTo(SecP256K1Field.PExtInv.length, SecP256K1Field.PExtInv, zz) != 0) {
            Nat.incAt(16, zz, SecP256K1Field.PExtInv.length);
        }
    }
    
    public static void negate(final int[] a, final int[] a0) {
        if (Nat256.isZero(a)) {
            Nat256.zero(a0);
        }
        else {
            Nat256.sub(SecP256K1Field.P, a, a0);
        }
    }
    
    public static void reduce(final int[] xx, final int[] z) {
        final long cc = Nat256.mul33Add(977, xx, 8, xx, 0, z, 0);
        final int c = Nat256.mul33DWordAdd(977, cc, z, 0);
        if (c != 0 || (z[7] == -1 && Nat256.gte(z, SecP256K1Field.P))) {
            Nat.add33To(8, 977, z);
        }
    }
    
    public static void reduce32(final int x, final int[] z) {
        if ((x != 0 && Nat256.mul33WordAdd(977, x, z, 0) != 0) || (z[7] == -1 && Nat256.gte(z, SecP256K1Field.P))) {
            Nat.add33To(8, 977, z);
        }
    }
    
    public static void square(final int[] a, final int[] a0) {
        final int[] a2 = Nat256.createExt();
        Nat256.square(a, a2);
        reduce(a2, a0);
    }
    
    public static void subtract(final int[] a, final int[] a0, final int[] a1) {
        if (Nat256.sub(a, a0, a1) != 0) {
            Nat.sub33From(8, 977, a1);
        }
    }
    
    public static void twice(final int[] x, final int[] z) {
        final int c = Nat.shiftUpBit(8, x, 0, z);
        if (c != 0 || (z[7] == -1 && Nat256.gte(z, SecP256K1Field.P))) {
            Nat.add33To(8, 977, z);
        }
    }
    
    static {
        P = new int[]{-977, -2, -1, -1, -1, -1, -1, -1};
        PExt = new int[]{954529, 1954, 1, 0, 0, 0, 0, 0, -1954, -3, -1, -1, -1, -1, -1, -1};
        PExtInv = new int[]{-954529, -1955, -2, -1, -1, -1, -1, -1, 1953, 2};
    }
}
