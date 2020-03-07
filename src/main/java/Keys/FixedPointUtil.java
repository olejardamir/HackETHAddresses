package Keys;

import java.math.BigInteger;

//checkpoint clean
class FixedPointUtil
{
    private static final String PRECOMP_NAME = "bc_fixed_point";

    public static int getCombSize(ECCurve c)
    {
        BigInteger order = c.getOrder();
        return order != null ? order.bitLength() : c.getFieldSize() + 1;
    }

    public static FixedPointPreCompInfo precompute(final ECPoint p) {
        final ECCurve c = p.getCurve();

        return c.precompute(p, PRECOMP_NAME, existing -> {

            int bits = getCombSize(c), minWidth = bits > 250 ? 6 : 5, n = 1 << minWidth;

            int d = (bits + minWidth - 1) / minWidth;

            ECPoint[] pow2Table = new ECPoint[minWidth + 1];
            pow2Table[0] = p;
            for (int i = 1; i < minWidth; ++i) {
                ECPoint p1 = pow2Table[i - 1];
                while (--d >= 0)
                    p1 = p1.twice();
                pow2Table[i] = p1;
            }


            pow2Table[minWidth] = pow2Table[0].subtract(pow2Table[1]);

            c.normalizeAll(pow2Table);

            ECPoint[] lookupTable = new ECPoint[n];
            lookupTable[0] = pow2Table[0];

            for (int bit = minWidth - 1; bit >= 0; --bit)
            {
                ECPoint pow2 = pow2Table[bit];

                for (int i = 1 << bit; i < n; i += ((1 << bit) << 1))
                    lookupTable[i] = lookupTable[i - (1 << bit)].add(pow2);
            }

            c.normalizeAll(lookupTable);

            FixedPointPreCompInfo result = new FixedPointPreCompInfo();
            result.setLookupTable(c.createCacheSafeLookupTable(lookupTable, 0, lookupTable.length));
            result.setOffset(pow2Table[minWidth]);
            result.setWidth(minWidth);
            return result;
        });
    }
}
