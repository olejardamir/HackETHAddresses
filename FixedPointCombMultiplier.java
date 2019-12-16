import java.math.BigInteger;

public class FixedPointCombMultiplier {
     protected ECPoint multiplyPositive(ECPoint p, BigInteger k) {

        ECCurve c;
		c = p.getCurve();
		int size;
		size = FixedPointUtil.getCombSize(c);
		FixedPointPreCompInfo info;
		info = FixedPointUtil.precompute(p);
		ECLookupTable lookupTable;
		lookupTable = info.getLookupTable();
		int width;
		width = info.getWidth();
		int d;
		d = ((size + width) - 1) / width;
		ECPoint R;
		R = c.getInfinity();
		int fullComb;
		fullComb = d * width;
		int[] K;
		K = Nat.fromBigInteger(fullComb, k);
		for (int top = fullComb - 1, i = 0; i < d; i += 1) {
			int secretIndex;
			secretIndex = 0;
			for (int j = top - i; j >= 0; j -= d) {
				int secretBit;
				secretBit = K[j >>> 5] >>> (j & 0x1F);
				secretIndex ^= secretBit >>> 1;
				secretIndex <<= 1;
				secretIndex ^= secretBit;
			}
			R = R.twicePlus(lookupTable.lookup(secretIndex));
		}

        return R.add(info.getOffset());
    }


    public ECPoint multiply(ECPoint p, BigInteger k) {
        ECPoint positive;
		positive = multiplyPositive(p, k.abs());
		return checkResult((k.signum() > 0 ? positive : positive.negate()));
    }

    private ECPoint checkResult(ECPoint p) {


        return p;
    }
}
