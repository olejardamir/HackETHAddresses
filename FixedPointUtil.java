import java.math.BigInteger;

// 
// Decompiled by Procyon v0.5.36
// 

class FixedPointUtil
{
    public static int getCombSize(final ECCurve c) {
        final BigInteger order = c.getOrder();
        return (order == null) ? (c.getFieldSize() + 1) : order.bitLength();
    }
    
    public static FixedPointPreCompInfo precompute(final ECPoint p) {
        final ECCurve c = p.getCurve();
        return c.precompute(p, "bc_fixed_point", new PreCompCallback() {
            @Override
            public FixedPointPreCompInfo precompute(final FixedPointPreCompInfo existing) {
                final FixedPointPreCompInfo existingFP = (existing instanceof FixedPointPreCompInfo) ? existing : null;
                final int bits = FixedPointUtil.getCombSize(c);
                final int minWidth = (bits > 250) ? 6 : 5;
                final int n = 1 << minWidth;
                if (this.checkExisting(existingFP, n)) {
                    return existingFP;
                }
                final int d = (bits + minWidth - 1) / minWidth;
                final ECPoint[] pow2Table = new ECPoint[minWidth + 1];
                pow2Table[0] = p;
                for (int i = 1; i < minWidth; ++i) {
                    pow2Table[i] = pow2Table[i - 1].timesPow2(d);
                }
                pow2Table[minWidth] = pow2Table[0].subtract(pow2Table[1]);
                c.normalizeAll(pow2Table);
                final ECPoint[] lookupTable = new ECPoint[n];
                lookupTable[0] = pow2Table[0];
                for (int bit = minWidth - 1; bit >= 0; --bit) {
                    final ECPoint pow2 = pow2Table[bit];
                    int step;
                    for (int j = step = 1 << bit; j < n; j += step << 1) {
                        lookupTable[j] = lookupTable[j - step].add(pow2);
                    }
                }
                c.normalizeAll(lookupTable);
                final FixedPointPreCompInfo result = new FixedPointPreCompInfo();
                result.setLookupTable(c.createCacheSafeLookupTable(lookupTable, 0, lookupTable.length));
                result.setOffset(pow2Table[minWidth]);
                result.setWidth(minWidth);
                return result;
            }
            
            private boolean checkExisting(final FixedPointPreCompInfo existingFP, final int n) {
                return existingFP != null && this.checkTable(existingFP.getLookupTable(), n);
            }
            
            private boolean checkTable(final ECLookupTable table, final int n) {
                return table != null && table.getSize() >= n;
            }
        });
    }
}
