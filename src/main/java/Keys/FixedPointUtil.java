package Keys;

import java.math.BigInteger;
import java.util.HashMap;

class FixedPointUtil {
    private static final String PRECOMP_NAME = "bc_fixed_point";

    static FixedPointPreCompInfo precompute(final ECPoint p) {
        final ECCurve c = p.curve;

        @SuppressWarnings("unchecked")
		HashMap<String, FixedPointPreCompInfo> table = (HashMap<String, FixedPointPreCompInfo>) p.preCompTable;
        if (table == null) {
			p.preCompTable = table = new HashMap<>(4);
		}

        table.get(PRECOMP_NAME);

        BigInteger order = c.order;
        int bits = order != null ? order.bitLength() : c.getFieldSize() + 1, minWidth = bits > 250 ? 6 : 5,
                n = 1 << minWidth, d = (bits + minWidth - 1) / minWidth;

        ECPoint[] pow2Table = new ECPoint[minWidth + 1];
        pow2Table[0] = p;
        extracted0(minWidth, d, pow2Table);

        pow2Table[minWidth] = pow2Table[0].subtract(pow2Table[1]);

        ECFieldElement[] zs1 = new ECFieldElement[pow2Table.length];
        int[] indices1 = new int[pow2Table.length];
        int count1 = extracted9(pow2Table, zs1, indices1, 0);
        ECFieldElement[] c2 = new ECFieldElement[count1];
        c2[0] = zs1[0];

        int i1 = extracted8(zs1, count1, c2, 0) - 1;
        zs1[0] = extracted7(zs1, c2, i1, c2[i1].invert());

        extracted7(pow2Table, zs1, indices1, count1);

        ECPoint[] lookupTable = new ECPoint[n];
        lookupTable[0] = pow2Table[0];

        extracted6(minWidth, n, pow2Table, lookupTable);

        ECFieldElement[] zs = new ECFieldElement[lookupTable.length];
        int[] indices = new int[lookupTable.length];
        int count = extracted9(lookupTable, zs, indices, 0);
        ECFieldElement[] c1 = new ECFieldElement[count];
        c1[0] = zs[0];

        int i = extracted8(zs, count, c1, 0) - 1;
        zs[0] = extracted7(zs, c1, i, c1[i].invert());

        extracted7(lookupTable, zs, indices, count);

        FixedPointPreCompInfo result = new FixedPointPreCompInfo();
        result.setLookupTable(c.createCacheSafeLookupTable(lookupTable, 0, lookupTable.length));
        result.setOffset(pow2Table[minWidth]);
        result.setWidth(minWidth);
        extracted4(table, result);

        return result;
    }

	private static void extracted4(HashMap<String, FixedPointPreCompInfo> table, FixedPointPreCompInfo result) {
		if (result != table.get(PRECOMP_NAME)) {
            table.put(PRECOMP_NAME, result);
        }
	}

	private static void extracted6(int minWidth, int n, ECPoint[] pow2Table, ECPoint[] lookupTable) {
		for (int bit = minWidth - 1; bit >= 0; --bit) {
            extracted5(n, lookupTable, bit, pow2Table[bit]);
        }
	}

	private static void extracted5(int n, ECPoint[] lookupTable, int bit, ECPoint pow2) {
		for (int i = 1 << bit; i < n; i += (1 << bit) << 1) {
		    lookupTable[i] = lookupTable[i - (1 << bit)].add(pow2);
		}
	}

	private static void extracted7(ECPoint[] pow2Table, ECFieldElement[] zs1, int[] indices1, int count1) {
		for (int j2 = 0; j2 < count1; ++j2) {
            pow2Table[indices1[j2]] = pow2Table[indices1[j2]].normalize(zs1[j2]);
        }
	}

	private static ECFieldElement extracted7(ECFieldElement[] zs1, ECFieldElement[] c2, int i1, ECFieldElement u1) {
		while (i1 > 0) {
            int j11 = i1--;
            ECFieldElement tmp1 = zs1[j11];
            zs1[j11] = c2[i1].multiply(u1);
            u1 = u1.multiply(tmp1);
        }
		return u1;
	}

	private static int extracted8(ECFieldElement[] zs1, int count1, ECFieldElement[] c2, int i1) {
		while (++i1 < count1) {
            c2[i1] = c2[i1 - 1].multiply(zs1[i1]);
        }
		return i1;
	}

	private static int extracted9(ECPoint[] pow2Table, ECFieldElement[] zs1, int[] indices1, int count1) {
		for (int i1 = 0; i1 < pow2Table.length; ++i1) {
            count1 = extracted3(pow2Table, zs1, indices1, count1, i1);
        }
		return count1;
	}

	private static int extracted3(ECPoint[] pow2Table, ECFieldElement[] zs1, int[] indices1, int count1, int i1) {
		if (pow2Table[i1] == null || !pow2Table[i1].isNormalized())
			return count1;
		zs1[count1] = (pow2Table[i1].zs.length <= 0) ? null : pow2Table[i1].zs[0];
		indices1[count1++] = i1;
		return count1;
	}

	private static void extracted0(int minWidth, int d, ECPoint[] pow2Table) {
		for (int i = 1; i < minWidth; ++i) {
            pow2Table[i] = pow2Table[i - 1].timesPow2(d);
        }
	}
}
