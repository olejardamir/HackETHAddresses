
import java.math.BigInteger;

public class FiniteFields
{
    static final PrimeField GF_2 = new PrimeField(BigInteger.valueOf(2));
    private static final PrimeField GF_3 = new PrimeField(BigInteger.valueOf(3));




    public static PrimeField getPrimeField(BigInteger a) {
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
