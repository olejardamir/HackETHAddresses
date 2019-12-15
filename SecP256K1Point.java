// 
// Decompiled by Procyon v0.5.36
// 

public class SecP256K1Point extends ECPoint
{
    public SecP256K1Point(final ECCurve curve, final ECFieldElement x, final ECFieldElement y) {
        this(curve, x, y, false);
    }
    
    public SecP256K1Point(final ECCurve curve, final ECFieldElement x, final ECFieldElement y, final boolean withCompression) {
        super(curve, x, y);
        this.withCompression = withCompression;
    }
    
    SecP256K1Point(final ECCurve curve, final ECFieldElement x, final ECFieldElement y, final ECFieldElement[] zs, final boolean withCompression) {
        super(curve, x, y, zs);
        this.withCompression = withCompression;
    }
    
    @Override
    public ECPoint add(final ECPoint b) {
        if (this.isInfinity()) {
            return b;
        }
        if (b.isInfinity()) {
            return this;
        }
        if (this == b) {
            return this.twice();
        }
        final ECCurve curve = this.getCurve();
        final SecP256K1FieldElement X1 = (SecP256K1FieldElement)this.x;
        final SecP256K1FieldElement Y1 = (SecP256K1FieldElement)this.y;
        final SecP256K1FieldElement X2 = (SecP256K1FieldElement)b.getXCoord();
        final SecP256K1FieldElement Y2 = (SecP256K1FieldElement)b.getYCoord();
        final SecP256K1FieldElement Z1 = (SecP256K1FieldElement)this.zs[0];
        final SecP256K1FieldElement Z2 = (SecP256K1FieldElement)b.getZCoord(0);
        final int[] tt1 = Nat256.createExt();
        final int[] t2 = Nat256.create();
        final int[] t3 = Nat256.create();
        final int[] t4 = Nat256.create();
        final boolean Z1IsOne = Z1.isOne();
        int[] U2;
        int[] S2;
        if (Z1IsOne) {
            U2 = X2.x;
            S2 = Y2.x;
        }
        else {
            S2 = t3;
            SecP256K1Field.square(Z1.x, S2);
            U2 = t2;
            SecP256K1Field.multiply(S2, X2.x, U2);
            SecP256K1Field.multiply(S2, Z1.x, S2);
            SecP256K1Field.multiply(S2, Y2.x, S2);
        }
        final boolean Z2IsOne = Z2.isOne();
        int[] U3;
        int[] S3;
        if (Z2IsOne) {
            U3 = X1.x;
            S3 = Y1.x;
        }
        else {
            S3 = t4;
            SecP256K1Field.square(Z2.x, S3);
            U3 = tt1;
            SecP256K1Field.multiply(S3, X1.x, U3);
            SecP256K1Field.multiply(S3, Z2.x, S3);
            SecP256K1Field.multiply(S3, Y1.x, S3);
        }
        final int[] H = Nat256.create();
        SecP256K1Field.subtract(U3, U2, H);
        SecP256K1Field.subtract(S3, S2, t2);
        if (!Nat256.isZero(H)) {
            SecP256K1Field.square(H, t3);
            final int[] G = Nat256.create();
            SecP256K1Field.multiply(t3, H, G);
            SecP256K1Field.multiply(t3, U3, t3);
            SecP256K1Field.negate(G, G);
            Nat256.mul(S3, G, tt1);
            final int c = Nat256.addBothTo(t3, t3, G);
            SecP256K1Field.reduce32(c, G);
            final SecP256K1FieldElement X3 = new SecP256K1FieldElement(t4);
            SecP256K1Field.square(t2, X3.x);
            SecP256K1Field.subtract(X3.x, G, X3.x);
            final SecP256K1FieldElement Y3 = new SecP256K1FieldElement(G);
            SecP256K1Field.subtract(t3, X3.x, Y3.x);
            SecP256K1Field.multiplyAddToExt(Y3.x, t2, tt1);
            SecP256K1Field.reduce(tt1, Y3.x);
            final SecP256K1FieldElement Z3 = new SecP256K1FieldElement(H);
            if (!Z1IsOne) {
                SecP256K1Field.multiply(Z3.x, Z1.x, Z3.x);
            }
            if (!Z2IsOne) {
                SecP256K1Field.multiply(Z3.x, Z2.x, Z3.x);
            }
            final ECFieldElement[] zs = { Z3 };
            return new SecP256K1Point(curve, X3, Y3, zs, this.withCompression);
        }
        if (Nat256.isZero(t2)) {
            return this.twice();
        }
        return curve.getInfinity();
    }
    
    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        final ECCurve curve = this.getCurve();
        final SecP256K1FieldElement Y1 = (SecP256K1FieldElement)this.y;
        if (Y1.isZero()) {
            return curve.getInfinity();
        }
        final SecP256K1FieldElement X1 = (SecP256K1FieldElement)this.x;
        final SecP256K1FieldElement Z1 = (SecP256K1FieldElement)this.zs[0];
        final int[] Y1Squared = Nat256.create();
        SecP256K1Field.square(Y1.x, Y1Squared);
        final int[] T = Nat256.create();
        SecP256K1Field.square(Y1Squared, T);
        final int[] M = Nat256.create();
        SecP256K1Field.square(X1.x, M);
        int c = Nat256.addBothTo(M, M, M);
        SecP256K1Field.reduce32(c, M);
        SecP256K1Field.multiply(Y1Squared, X1.x, Y1Squared);
        c = Nat.shiftUpBits(8, Y1Squared, 2, 0);
        SecP256K1Field.reduce32(c, Y1Squared);
        final int[] t1 = Nat256.create();
        c = Nat.shiftUpBits(8, T, 3, 0, t1);
        SecP256K1Field.reduce32(c, t1);
        final SecP256K1FieldElement X2 = new SecP256K1FieldElement(T);
        SecP256K1Field.square(M, X2.x);
        SecP256K1Field.subtract(X2.x, Y1Squared, X2.x);
        SecP256K1Field.subtract(X2.x, Y1Squared, X2.x);
        final SecP256K1FieldElement Y2 = new SecP256K1FieldElement(Y1Squared);
        SecP256K1Field.subtract(Y1Squared, X2.x, Y2.x);
        SecP256K1Field.multiply(Y2.x, M, Y2.x);
        SecP256K1Field.subtract(Y2.x, t1, Y2.x);
        final SecP256K1FieldElement Z2 = new SecP256K1FieldElement(M);
        SecP256K1Field.twice(Y1.x, Z2.x);
        if (!Z1.isOne()) {
            SecP256K1Field.multiply(Z2.x, Z1.x, Z2.x);
        }
        return new SecP256K1Point(curve, X2, Y2, new ECFieldElement[] { Z2 }, this.withCompression);
    }
    
    @Override
    public ECPoint twicePlus(final ECPoint b) {
        if (this.isInfinity()) {
            return b;
        }
        if (b.isInfinity()) {
            return this.twice();
        }
        if (this.y.isZero()) {
            return b;
        }
        return this.twice().add(b);
    }
    
    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        return new SecP256K1Point(this.curve, this.x, this.y.negate(), this.zs, this.withCompression);
    }
    
    @Override
    public ECPoint subtract(final ECPoint b) {
        if (b.isInfinity()) {
            return this;
        }
        return this.add(b.negate());
    }
}
