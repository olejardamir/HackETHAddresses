
import java.math.BigInteger;

abstract class FiniteFields
{
    static final Object GF_2 = new Object() {
        private final BigInteger characteristic = BigInteger.valueOf(2);

        public int hashCode()
        {
            return characteristic.hashCode();
        }
    };
    private static final Object GF_3 = new Object() {
        private final BigInteger characteristic = BigInteger.valueOf(3);

        public int hashCode()
        {
            return characteristic.hashCode();
        }
    };




    public static Object getPrimeField(BigInteger a) {
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
