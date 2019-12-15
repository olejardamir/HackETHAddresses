import java.math.BigInteger;

public class FiniteFields {
   static final PrimeField GF_2 = new PrimeField(BigInteger.valueOf(2L));
   private static final PrimeField GF_3 = new PrimeField(BigInteger.valueOf(3L));



   public static PrimeField getPrimeField(BigInteger a) {
      int i = a.bitLength();
      if (a.signum() > 0 && i >= 2) {
         if (i < 3) {
            switch(a.intValue()) {
            case 2:
               return GF_2;
            case 3:
               return GF_3;
            }
         }

         return new PrimeField(a);
      } else {
         return null;
      }
   }
}
