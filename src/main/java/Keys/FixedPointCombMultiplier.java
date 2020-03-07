package Keys;
import java.math.BigInteger;

//checkpoint clean
class FixedPointCombMultiplier {
     private ECPoint multiplyPositive(ECPoint p, BigInteger k) {

        ECCurve c = p.getCurve();
        int size = FixedPointUtil.getCombSize(c);



        FixedPointPreCompInfo info = FixedPointUtil.precompute(p);
        ECLookupTable lookupTable = info.getLookupTable();
        int width = info.getWidth(), d = (size + width - 1) / width;

        ECPoint R = c.getInfinity();

        int fullComb = d * width;


         int[] z = new int[(fullComb + 31) >> 5];
         for (int i1 = 0; k.signum() != 0;) {
             z[i1++] = k.intValue();
             k = k.shiftRight(32);
         }
         int[] K = z;

        for (int top = fullComb - 1, i = 0; i < d; ++i) {
			int secretIndex = 0;
			for (int j = top - i; j >= 0; j -= d) {
				int secretBit = K[j >>> 5] >>> (j & 0x1F);
				secretIndex ^= secretBit >>> 1;
				secretIndex <<= 1;
				secretIndex ^= secretBit;
			}
			R = R.twicePlus(lookupTable.lookup(secretIndex));
		}

        return R.add(info.getOffset());
    }


    public ECPoint multiply(ECPoint p, BigInteger k) {
        ECPoint positive = multiplyPositive(p, k.abs());
        return checkResult((k.signum() > 0 ? positive : positive.negate()));
    }

    private ECPoint checkResult(ECPoint p) {


        return p;
    }
}
