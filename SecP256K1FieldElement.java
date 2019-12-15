import java.math.BigInteger;

public class SecP256K1FieldElement extends ECFieldElement {
   final int[] x;

   public SecP256K1FieldElement(BigInteger x) {
      super();
      this.x = SecP256K1Field.fromBigInteger(x);
   }

   SecP256K1FieldElement(int[] x) {
      super();
      this.x = x;
   }

   public boolean isZero() {
      return Nat256.isZero(this.x);
   }

   public boolean isOne() {
      return Nat256.isOne(this.x);
   }

   public boolean testBitZero() {
      return Nat256.getBit(this.x, 0) == 1;
   }

   public BigInteger toBigInteger() {
      return Nat256.toBigInteger(this.x);
   }

   public ECFieldElement multiply(ECFieldElement b) {
      int[] z = Nat256.create();
      SecP256K1Field.multiply(this.x, ((SecP256K1FieldElement)b).x, z);
      return new SecP256K1FieldElement(z);
   }

   public ECFieldElement negate() {
      int[] z = Nat256.create();
      SecP256K1Field.negate(this.x, z);
      return new SecP256K1FieldElement(z);
   }

   public ECFieldElement square() {
      int[] z = Nat256.create();
      SecP256K1Field.square(this.x, z);
      return new SecP256K1FieldElement(z);
   }

   public ECFieldElement invert() {
      int[] z = Nat256.create();
      Mod.invert(SecP256K1Field.P, this.x, z);
      return new SecP256K1FieldElement(z);
   }

   public ECFieldElement sqrt() {
      int[] x1 = this.x;
      int[] x2 = Nat256.create();
      SecP256K1Field.square(x1, x2);
      SecP256K1Field.multiply(x2, x1, x2);
      int[] x3 = Nat256.create();
      SecP256K1Field.square(x2, x3);
      SecP256K1Field.multiply(x3, x1, x3);
      int[] x4 = Nat256.create();
      SecP256K1Field.multiply(x4, x3, x4);
      SecP256K1Field.multiply(x4, x3, x4);
      SecP256K1Field.multiply(x4, x2, x4);
      int[] x5 = Nat256.create();
      SecP256K1Field.multiply(x5, x4, x5);
      SecP256K1Field.multiply(x4, x5, x4);
      int[] x6 = Nat256.create();
      SecP256K1Field.multiply(x6, x4, x6);
      int[] x7 = Nat256.create();
      SecP256K1Field.multiply(x7, x6, x7);
      SecP256K1Field.multiply(x6, x4, x6);
      SecP256K1Field.multiply(x4, x3, x4);
      SecP256K1Field.multiply(x4, x5, x4);
      SecP256K1Field.multiply(x4, x2, x4);
      SecP256K1Field.square(x4, x2);
      return Nat256.eq(x1, x2) ? new SecP256K1FieldElement(x4) : null;
   }
}
