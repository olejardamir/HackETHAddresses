
import java.math.BigInteger;
import java.util.Hashtable;

class FixedPointUtil
{
    private static final String PRECOMP_NAME = "bc_fixed_point";

    public static int getCombSize(ECCurve c)
    {
        BigInteger order;
		order = c.getOrder();
		if (order != null) {
			return order.bitLength();
		}
		return c.getFieldSize() + 1;
    }

    public static FixedPointPreCompInfo precompute(final ECPoint p) {
        final ECCurve c;
		c = p.getCurve();
		Hashtable table;
		table = p.preCompTable;
		if (table == null) {
			table = new Hashtable(4);
			p.preCompTable = table;
		}


        FixedPointPreCompInfo result;
		result = new FixedPointPreCompInfo() {
			private FixedPointPreCompInfo precompute(FixedPointPreCompInfo existing) {
				int bits;
				bits = getCombSize(c);
				int minWidth;
				if (bits > 250) {
					minWidth = 6;
				} else {
					minWidth = 5;
				}
				int n;
				n = 1 << minWidth;
				if (checkExisting(existing, n)) {
					return existing;
				}
				int d;
				d = ((bits + minWidth) - 1) / minWidth;
				ECPoint[] pow2Table;
				pow2Table = new ECPoint[minWidth + 1];
				pow2Table[0] = p;
				for (int i = 1; i < minWidth; i += 1) {
					pow2Table[i] = pow2Table[i - 1].timesPow2(d);
				}
				pow2Table[minWidth] = pow2Table[0].subtract(pow2Table[1]);
				c.normalizeAll(pow2Table);
				ECPoint[] lookupTable;
				lookupTable = new ECPoint[n];
				lookupTable[0] = pow2Table[0];
				for (int bit = minWidth - 1; bit >= 0; bit -= 1) {
					ECPoint pow2;
					pow2 = pow2Table[bit];
					for (int i = 1 << bit; i < n; i += ((1 << bit) << 1)) {
						lookupTable[i] = lookupTable[i - (1 << bit)].add(pow2);
					}
				}
				c.normalizeAll(lookupTable);
				FixedPointPreCompInfo result1;
				result1 = new FixedPointPreCompInfo();
				result1.setLookupTable(c.createCacheSafeLookupTable(lookupTable, 0, lookupTable.length));
				result1.setOffset(pow2Table[minWidth]);
				result1.setWidth(minWidth);
				return result1;
			}

			private boolean checkExisting(FixedPointPreCompInfo existingFP, int n) {
				return (existingFP != null) && checkTable(existingFP.getLookupTable(), n);
			}

			private boolean checkTable(ECLookupTable table1, int n) {
				return (table1 != null) && (table1.getSize() >= n);
			}
		}.precompute((FixedPointPreCompInfo) table.get(PRECOMP_NAME));
		if (result != table.get(PRECOMP_NAME)) {
			table.put(PRECOMP_NAME, result);
		}

        return result;

    }
}
