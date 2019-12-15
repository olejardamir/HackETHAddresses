import java.math.BigInteger;

// 
// Decompiled by Procyon v0.5.36
// 

public class FixedPointCombMultiplier
{
    protected ECPoint multiplyPositive(final ECPoint p, final BigInteger k) {
        final ECCurve c = p.getCurve();
        final int size = FixedPointUtil.getCombSize(c);
        final FixedPointPreCompInfo info = FixedPointUtil.precompute(p);
        final ECLookupTable lookupTable = info.getLookupTable();
        final int width = info.getWidth();
        final int d = (size + width - 1) / width;
        ECPoint R = c.getInfinity();
        final int fullComb = d * width;
        final int[] K = Nat.fromBigInteger(fullComb, k);
        final int top = fullComb - 1;
        for (int i = 0; i < d; ++i) {
            int secretIndex = 0;
            for (int j = top - i; j >= 0; j -= d) {
                final int secretBit = K[j >>> 5] >>> (j & 0x1F);
                secretIndex ^= secretBit >>> 1;
                secretIndex <<= 1;
                secretIndex ^= secretBit;
            }
            final ECPoint add = lookupTable.lookup(secretIndex);
            R = R.twicePlus(add);
        }
        return R.add(info.getOffset());
    }
    
    public ECPoint multiply(final ECPoint p, final BigInteger k) {
        final int sign = k.signum();
        if (sign == 0 || p.isInfinity()) {
            return p.getCurve().getInfinity();
        }
        final ECPoint positive = this.multiplyPositive(p, k.abs());
        final ECPoint result = (sign > 0) ? positive : positive.negate();
        return this.checkResult(result);
    }
    
    private ECPoint checkResult(final ECPoint p) {
        return ECAlgorithms.implCheckResult(p);
    }
}
