package Keys;

import java.math.BigInteger;
import java.util.HashMap;

class FixedPointUtil {
    private static final String PRECOMP_NAME = "bc_fixed_point";

      static FixedPointPreCompInfo precompute(final ECPoint p) {
        final ECCurve c = p.curve;


        HashMap table = p.preCompTable;
        if (table == null)
            p.preCompTable = table = new HashMap(4);


        table.get(PRECOMP_NAME);

        BigInteger order = c.order;
        int bits = order != null ? order.bitLength() : c.getFieldSize() + 1, minWidth = bits > 250 ? 6 : 5, n = 1 << minWidth;

        int d = (bits + minWidth - 1) / minWidth;

        ECPoint[] pow2Table = new ECPoint[minWidth + 1];
        pow2Table[0] = p;
        for (int i = 1; i < minWidth; ++i)
            pow2Table[i] = pow2Table[i - 1].timesPow2(d);


        pow2Table[minWidth] = pow2Table[0].subtract(pow2Table[1]);


        ECFieldElement[] zs1 = new ECFieldElement[pow2Table.length];
        int[] indices1 = new int[pow2Table.length];
        int count1 = 0;
        for (int i1 = 0; i1 < pow2Table.length; ++i1)
            if (null != pow2Table[i1] && pow2Table[i1].isNormalized()) {
                zs1[count1] = (0 >= pow2Table[i1].zs.length) ? null : pow2Table[i1].zs[0];
                indices1[count1++] = i1;
            }


        ECFieldElement[] c2 = new ECFieldElement[count1];
        c2[0] = zs1[0];

        int i1 = 0;
        while (++i1 < count1)
            c2[i1] = c2[i1 - 1].multiply(zs1[i1]);

        --i1;

        ECFieldElement u1 = c2[i1].invert();

        while (i1 > 0) {
            int j11 = i1--;
            ECFieldElement tmp1 = zs1[j11];
            zs1[j11] = c2[i1].multiply(u1);
            u1 = u1.multiply(tmp1);
        }

        zs1[0] = u1;

        for (int j2 = 0; j2 < count1; ++j2)
            pow2Table[indices1[j2]] = pow2Table[indices1[j2]].normalize(zs1[j2]);

        ECPoint[] lookupTable = new ECPoint[n];
        lookupTable[0] = pow2Table[0];

        for (int bit = minWidth - 1; bit >= 0; --bit) {
            ECPoint pow2 = pow2Table[bit];

            for (int i = 1 << bit; i < n; i += ((1 << bit) << 1))
                lookupTable[i] = lookupTable[i - (1 << bit)].add(pow2);
        }


        ECFieldElement[] zs = new ECFieldElement[lookupTable.length];
        int[] indices = new int[lookupTable.length];
        int count = 0;
        for (int i = 0; i < lookupTable.length; ++i)
            if (null != lookupTable[i] && lookupTable[i].isNormalized()) {
                zs[count] = (0 >= lookupTable[i].zs.length) ? null : lookupTable[i].zs[0];
                indices[count++] = i;
            }


        ECFieldElement[] c1 = new ECFieldElement[count];
        c1[0] = zs[0];

        int i = 0;
        while (++i < count)
            c1[i] = c1[i - 1].multiply(zs[i]);

        --i;

        ECFieldElement u = c1[i].invert();

        while (i > 0) {
            int j1 = i--;
            ECFieldElement tmp = zs[j1];
            zs[j1] = c1[i].multiply(u);
            u = u.multiply(tmp);
        }

        zs[0] = u;

        for (int j = 0; j < count; ++j)
            lookupTable[indices[j]] = lookupTable[indices[j]].normalize(zs[j]);

        FixedPointPreCompInfo result = new FixedPointPreCompInfo();
        result.setLookupTable(c.createCacheSafeLookupTable(lookupTable, 0, lookupTable.length));
        result.setOffset(pow2Table[minWidth]);
        result.setWidth(minWidth);
        if (result != table.get(PRECOMP_NAME))
            table.put(PRECOMP_NAME, result);

        return result;

    }


}
