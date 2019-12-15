import java.math.BigInteger;

class PrimeField {
   private final BigInteger characteristic;

   PrimeField(BigInteger characteristic) {
      super();
      this.characteristic = characteristic;
   }

   public int hashCode() {
      return this.characteristic.hashCode();
   }
}
