import java.math.BigInteger;

public abstract class ECFieldElement {
   public static final BigInteger ZERO = BigInteger.valueOf(0L);
   public static final BigInteger ONE = BigInteger.valueOf(1L);

   ECFieldElement() {
      super();
   }

   public abstract BigInteger toBigInteger();

   public abstract ECFieldElement multiply(ECFieldElement var1);

   public abstract ECFieldElement negate();

   public abstract ECFieldElement square();

   public abstract ECFieldElement invert();

   public abstract ECFieldElement sqrt();

   public int bitLength() {
      return this.toBigInteger().bitLength();
   }

   public boolean isOne() {
      return this.bitLength() == 1;
   }

   public boolean isZero() {
      return 0 == this.toBigInteger().signum();
   }

   public boolean testBitZero() {
      return this.toBigInteger().testBit(0);
   }

   public String toString() {
      return this.toBigInteger().toString(16);
   }

   public byte[] getEncoded() {
      return BigIntegers.asUnsignedByteArray(this.toBigInteger());
   }
}
