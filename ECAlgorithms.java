import java.math.BigInteger;

class ECAlgorithms
{
    public static boolean isF2mCurve(ECCurve c)
    {
        return isF2mField(c.getField());
    }

    private static boolean isF2mField(FiniteField field)
    {
        return field.getDimension() > 1 && field.getCharacteristic().equals(ECConstants.TWO)
                && field instanceof PolynomialExtensionField;
    }

    public static boolean isFpCurve(ECCurve c)
    {
        return isFpField(c.getField());
    }

    private static boolean isFpField(FiniteField field)
    {
        return field.getDimension() == 1;
    }

    public static ECPoint importPoint(ECCurve c, ECPoint p) throws CloneNotSupportedException {
        ECCurve cp = p.getCurve();
        if (!c.equals(cp))
        {
            throw new IllegalArgumentException("Point must be on the same curve");
        }
        return c.importPoint(p);
    }


    public static void montgomeryTrick(ECFieldElement[] zs, int off, int len, ECFieldElement scale) throws CloneNotSupportedException {
        /*
         * Uses the "Montgomery Trick" to invert many field elements, with only a single actual
         * field inversion. See e.g. the paper:
         * "Fast Multi-scalar Multiplication Methods on Elliptic Curves with Precomputation Strategy Using Montgomery Trick"
         * by Katsuyuki Okeya, Kouichi Sakurai.
         */

        ECFieldElement[] c = new ECFieldElement[len];
        c[0] = zs[off];

        int i = 0;
        while (++i < len)
        {
            c[i] = c[i - 1].multiply(zs[off + i]);
        }

        --i;

        if (scale != null)
        {
            c[i] = c[i].multiply(scale);
        }

        ECFieldElement u = c[i].invert();

        while (i > 0)
        {
            int j = off + i--;
            ECFieldElement tmp = zs[j];
            zs[j] = c[i].multiply(u);
            u = u.multiply(tmp);
        }

        zs[off] = u;
    }

    /**
     * Simple shift-and-add multiplication. Serves as reference implementation
     * to verify (possibly faster) implementations, and for very small scalars.
     *
     * @param p
     *            The point to multiply.
     * @param k
     *            The multiplier.
     * @return The result of the point multiplication <code>kP</code>.
     */
    public static ECPoint referenceMultiply(ECPoint p, BigInteger k) throws CloneNotSupportedException {
        BigInteger x = k.abs();
        ECPoint q = p.getCurve().getInfinity();
        int t = x.bitLength();
        if (t > 0)
        {
            if (x.testBit(0))
            {
                q = p;
            }
            for (int i = 1; i < t; i++)
            {
                p = p.twice();
                if (x.testBit(i))
                {
                    q = q.add(p);
                }
            }
        }
        return k.signum() < 0 ? q.negate() : q;
    }





    static ECPoint implCheckResult(ECPoint p) throws CloneNotSupportedException {
        if (!p.isValidPartial())
        {
            throw new IllegalStateException("Invalid result");
        }

        return p;
    }


}
