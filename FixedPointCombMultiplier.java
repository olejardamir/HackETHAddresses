import java.math.BigInteger;

class FixedPointCombMultiplier {
     private ECPoint multiplyPositive(ECPoint p, BigInteger k) {

        ECCurve c = p.getCurve();
        int size = FixedPointUtil.getCombSize(c);



        FixedPointPreCompInfo info = FixedPointUtil.precompute(p);
        ECLookupTable lookupTable = info.getLookupTable();
        int width = info.getWidth();

        int d = (size + width - 1) / width;

        ECPoint R = c.getInfinity();

        int fullComb = d * width;
        int[] K = Nat.fromBigInteger(fullComb, k);

        int top = fullComb - 1;
        for (int i = 0; i < d; ++i)
        {
            int secretIndex = 0;

            for (int j = top - i; j >= 0; j -= d)
            {
                int secretBit = K[j >>> 5] >>> (j & 0x1F);
                secretIndex ^= secretBit >>> 1;
                secretIndex <<= 1;
                secretIndex ^= secretBit;
            }

            ECPoint add = lookupTable.lookup(secretIndex);

            R = R.twicePlus(add);
        }

        return R.add(info.getOffset());
    }


    public ECPoint multiply(ECPoint p, BigInteger k) {
        int sign = k.signum();
        if (sign == 0 || p.isInfinity())
        {
            return p.getCurve().getInfinity();
        }

        ECPoint positive = multiplyPositive(p, k.abs());
        ECPoint result = sign > 0 ? positive : positive.negate();


        return checkResult(result);
    }

    private ECPoint checkResult(ECPoint p) {
        return ECAlgorithms.implCheckResult(p);
    }
}
