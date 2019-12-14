
import java.math.BigInteger;

abstract class FiniteFields
{
    static final PrimeField GF_2 = new PrimeField(BigInteger.valueOf(2));
    private static final PrimeField GF_3 = new PrimeField(BigInteger.valueOf(3));

    public static GenericPolynomialExtensionField getBinaryExtensionField(int[] exponents)
    {
        if (exponents[0] != 0)
        {
            throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
        }
        for (int i = 1; i < exponents.length; ++i)
        {
            if (exponents[i] <= exponents[i - 1])
            {
                throw new IllegalArgumentException("Polynomial exponents must be montonically increasing");
            }
        }

        return new GenericPolynomialExtensionField(new GF2Polynomial(exponents));
    }



    public static GenericPolynomialExtensionField getPrimeField(BigInteger a) {
        int i = a.bitLength();
        if (a.signum() > 0 && i >= 2) {
            if (i < 3) {
                switch(a.intValue()) {
                    case 3: {
                        return GF_3;
                    }
                    case 2: {
                        return GF_2;
                    }
                }
            }
            return new PrimeField(a);
        }
        return null;
    }
}
