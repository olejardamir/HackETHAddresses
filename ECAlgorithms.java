// 
// Decompiled by Procyon v0.5.36
// 

class ECAlgorithms
{
    public static ECPoint importPoint(final ECCurve c, final ECPoint p) {
        return c.importPoint(p);
    }
    
    public static void montgomeryTrick(final ECFieldElement[] zs, final int off, final int len) {
        final ECFieldElement[] c = new ECFieldElement[len];
        c[0] = zs[off];
        int i = 0;
        while (++i < len) {
            c[i] = c[i - 1].multiply(zs[off + i]);
        }
        --i;
        ECFieldElement u;
        int j;
        ECFieldElement tmp;
        for (u = c[i].invert(); i > 0; j = off + i--, tmp = zs[j], zs[j] = c[i].multiply(u), u = u.multiply(tmp)) {}
        zs[off] = u;
    }
    
    static ECPoint implCheckResult(final ECPoint p) {
        return p;
    }
}
