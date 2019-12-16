
import java.math.BigInteger;

abstract class FiniteFields
{

    public static Object getPrimeField(BigInteger a) {
        int i = a.bitLength();
        if (a.signum() > 0 && i >= 2) {

            BigInteger characteristic1 = a;
            return new Object() {
                private final BigInteger characteristic = characteristic1;

                public int hashCode()
                {
                    return characteristic.hashCode();
                }
            };
        }
        return null;
    }
}
