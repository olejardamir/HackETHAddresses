public class SecP256K1Point extends ECPoint {
   public SecP256K1Point(ECCurve curve, ECFieldElement x, ECFieldElement y) {
      this(curve, x, y, false);
   }

   public SecP256K1Point(ECCurve curve, ECFieldElement x, ECFieldElement y, boolean withCompression) {
      super(curve, x, y);
      this.withCompression = withCompression;
   }

   SecP256K1Point(ECCurve curve, ECFieldElement x, ECFieldElement y, ECFieldElement[] zs, boolean withCompression) {
      super(curve, x, y, zs);
      this.withCompression = withCompression;
   }

   public ECPoint add(ECPoint b) {
      if (this.isInfinity()) {
         return b;
      } else if (b.isInfinity()) {
         return this;
      } else if (this == b) {
         return this.twice();
      } else {
         ECCurve curve = this.getCurve();
         SecP256K1FieldElement X1 = (SecP256K1FieldElement)this.x;
         SecP256K1FieldElement Y1 = (SecP256K1FieldElement)this.y;
         SecP256K1FieldElement X2 = (SecP256K1FieldElement)b.getXCoord();
         SecP256K1FieldElement Y2 = (SecP256K1FieldElement)b.getYCoord();
         SecP256K1FieldElement Z1 = (SecP256K1FieldElement)this.zs[0];
         SecP256K1FieldElement Z2 = (SecP256K1FieldElement)b.getZCoord(0);
         int[] tt1 = Nat256.createExt();
         int[] t2 = Nat256.create();
         int[] t3 = Nat256.create();
         int[] t4 = Nat256.create();
         boolean Z1IsOne = Z1.isOne();
         int[] U2;
         int[] S2;
         if (Z1IsOne) {
            U2 = X2.x;
            S2 = Y2.x;
         } else {
            S2 = t3;
            SecP256K1Field.square(Z1.x, t3);
            U2 = t2;
            SecP256K1Field.multiply(t3, X2.x, t2);
            SecP256K1Field.multiply(t3, Z1.x, t3);
            SecP256K1Field.multiply(t3, Y2.x, t3);
         }

         boolean Z2IsOne = Z2.isOne();
         int[] U3;
         int[] S3;
         if (Z2IsOne) {
            U3 = X1.x;
            S3 = Y1.x;
         } else {
            S3 = t4;
            SecP256K1Field.square(Z2.x, t4);
            U3 = tt1;
            SecP256K1Field.multiply(t4, X1.x, tt1);
            SecP256K1Field.multiply(t4, Z2.x, t4);
            SecP256K1Field.multiply(t4, Y1.x, t4);
         }

         int[] H = Nat256.create();
         SecP256K1Field.subtract(U3, U2, H);
         SecP256K1Field.subtract(S3, S2, t2);
         if (!Nat256.isZero(H)) {
            SecP256K1Field.square(H, t3);
            int[] G = Nat256.create();
            SecP256K1Field.multiply(t3, H, G);
            SecP256K1Field.multiply(t3, U3, t3);
            SecP256K1Field.negate(G, G);
            Nat256.mul(S3, G, tt1);
            int c = Nat256.addBothTo(t3, t3, G);
            SecP256K1Field.reduce32(c, G);
            SecP256K1FieldElement X3 = new SecP256K1FieldElement(t4);
            SecP256K1Field.square(t2, X3.x);
            SecP256K1Field.subtract(X3.x, G, X3.x);
            SecP256K1FieldElement Y3 = new SecP256K1FieldElement(G);
            SecP256K1Field.subtract(t3, X3.x, Y3.x);
            SecP256K1Field.multiplyAddToExt(Y3.x, t2, tt1);
            SecP256K1Field.reduce(tt1, Y3.x);
            SecP256K1FieldElement Z3 = new SecP256K1FieldElement(H);
            if (!Z1IsOne) {
               SecP256K1Field.multiply(Z3.x, Z1.x, Z3.x);
            }

            if (!Z2IsOne) {
               SecP256K1Field.multiply(Z3.x, Z2.x, Z3.x);
            }

            ECFieldElement[] zs = new ECFieldElement[]{Z3};
            return new SecP256K1Point(curve, X3, Y3, zs, this.withCompression);
         } else {
            return Nat256.isZero(t2) ? this.twice() : curve.getInfinity();
         }
      }
   }

   public ECPoint twice() {
      if (this.isInfinity()) {
         return this;
      } else {
         ECCurve curve = this.getCurve();
         SecP256K1FieldElement Y1 = (SecP256K1FieldElement)this.y;
         if (Y1.isZero()) {
            return curve.getInfinity();
         } else {
            SecP256K1FieldElement X1 = (SecP256K1FieldElement)this.x;
            SecP256K1FieldElement Z1 = (SecP256K1FieldElement)this.zs[0];
            int[] Y1Squared = Nat256.create();
            SecP256K1Field.square(Y1.x, Y1Squared);
            int[] T = Nat256.create();
            SecP256K1Field.square(Y1Squared, T);
            int[] M = Nat256.create();
            SecP256K1Field.square(X1.x, M);
            int c = Nat256.addBothTo(M, M, M);
            SecP256K1Field.reduce32(c, M);
            SecP256K1Field.multiply(Y1Squared, X1.x, Y1Squared);
            c = Nat.shiftUpBits(8, Y1Squared, 2, 0);
            SecP256K1Field.reduce32(c, Y1Squared);
            int[] t1 = Nat256.create();
            c = Nat.shiftUpBits(8, T, 3, 0, t1);
            SecP256K1Field.reduce32(c, t1);
            SecP256K1FieldElement X2 = new SecP256K1FieldElement(T);
            SecP256K1Field.square(M, X2.x);
            SecP256K1Field.subtract(X2.x, Y1Squared, X2.x);
            SecP256K1Field.subtract(X2.x, Y1Squared, X2.x);
            SecP256K1FieldElement Y2 = new SecP256K1FieldElement(Y1Squared);
            SecP256K1Field.subtract(Y1Squared, X2.x, Y2.x);
            SecP256K1Field.multiply(Y2.x, M, Y2.x);
            SecP256K1Field.subtract(Y2.x, t1, Y2.x);
            SecP256K1FieldElement Z2 = new SecP256K1FieldElement(M);
            SecP256K1Field.twice(Y1.x, Z2.x);
            if (!Z1.isOne()) {
               SecP256K1Field.multiply(Z2.x, Z1.x, Z2.x);
            }

            return new SecP256K1Point(curve, X2, Y2, new ECFieldElement[]{Z2}, this.withCompression);
         }
      }
   }

   public ECPoint twicePlus(ECPoint b) {
      if (this.isInfinity()) {
         return b;
      } else if (b.isInfinity()) {
         return this.twice();
      } else {
         return this.y.isZero() ? b : this.twice().add(b);
      }
   }

   public ECPoint negate() {
      return this.isInfinity() ? this : new SecP256K1Point(this.curve, this.x, this.y.negate(), this.zs, this.withCompression);
   }

   public ECPoint subtract(ECPoint b) {
      return (ECPoint)(b.isInfinity() ? this : this.add(b.negate()));
   }
}
