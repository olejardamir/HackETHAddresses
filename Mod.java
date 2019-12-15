// 
// Decompiled by Procyon v0.5.36
// 

public class Mod
{
    public static void invert(final int[] p, final int[] x, final int[] z) {
        final int len = p.length;
        if (Nat.isOne(len, x)) {
            System.arraycopy(x, 0, z, 0, len);
            return;
        }
        final int[] u = Nat.copy(len, x);
        final int[] a = Nat.create(len);
        a[0] = 1;
        int ac = 0;
        if ((u[0] & 0x1) == 0x0) {
            ac = inversionStep(p, u, len, a, ac);
        }
        if (Nat.isOne(len, u)) {
            inversionResult(p, ac, a, z);
            return;
        }
        final int[] v = Nat.copy(len, p);
        final int[] b = Nat.create(len);
        int bc = 0;
        int uvLen = len;
        while (true) {
            if (u[uvLen - 1] == 0 && v[uvLen - 1] == 0) {
                --uvLen;
            }
            else if (Nat.gte(uvLen, u, v)) {
                Nat.subFrom(uvLen, v, u);
                ac += Nat.subFrom(len, b, a) - bc;
                ac = inversionStep(p, u, uvLen, a, ac);
                if (Nat.isOne(uvLen, u)) {
                    inversionResult(p, ac, a, z);
                    return;
                }
            }
            else {
                Nat.subFrom(uvLen, u, v);
                bc += Nat.subFrom(len, a, b) - ac;
                bc = inversionStep(p, v, uvLen, b, bc);
                if (Nat.isOne(uvLen, v)) {
                    inversionResult(p, bc, b, z);
                    return;
                }
            }
        }
    }
    
    private static void inversionResult(final int[] p, final int ac, final int[] a, final int[] z) {
        if (ac < 0) {
            Nat.add(p.length, a, p, z);
        }
        else {
            System.arraycopy(a, 0, z, 0, p.length);
        }
    }
    
    private static int inversionStep(final int[] p, final int[] u, final int uLen, final int[] x, int xc) {
        final int len = p.length;
        int count = 0;
        while (u[0] == 0) {
            Nat.shiftDownWord(uLen, u, 0);
            count += 32;
        }
        final int zeroes = getTrailingZeroes(u[0]);
        if (zeroes > 0) {
            Nat.shiftDownBits(uLen, u, zeroes, 0);
            count += zeroes;
        }
        for (int i = 0; i < count; ++i) {
            if ((x[0] & 0x1) != 0x0) {
                if (xc < 0) {
                    xc += Nat.addTo(len, p, x);
                }
                else {
                    xc += Nat.subFrom(len, p, x);
                }
            }
            Nat.shiftDownBit(len, x, xc);
        }
        return xc;
    }
    
    private static int getTrailingZeroes(int x) {
        int count;
        for (count = 0; (x & 0x1) == 0x0; x >>>= 1, ++count) {}
        return count;
    }
}
