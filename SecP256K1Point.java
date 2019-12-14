
public class SecP256K1Point extends ECPoint.AbstractFp
{

    public SecP256K1Point(ECCurve curve, ECFieldElement x, ECFieldElement y)
    {
        this(curve, x, y, false);
    }



    public SecP256K1Point(ECCurve curve, ECFieldElement x, ECFieldElement y, boolean withCompression)
    {
        super(curve, x, y);

        if ((x == null) != (y == null))
        {
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        this.withCompression = withCompression;
    }

    SecP256K1Point(ECCurve curve, ECFieldElement x, ECFieldElement y, ECFieldElement[] zs,
                   boolean withCompression)
    {
        super(curve, x, y, zs);

        this.withCompression = withCompression;
    }

     public ECPoint add(ECPoint b) throws CloneNotSupportedException {
        if (this.isInfinity())
        {
            return b;
        }
        if (b.isInfinity())
        {
            return this;
        }
        if (this == b)
        {
            return twice();
        }

        ECCurve curve = this.getCurve();

        SecP256K1FieldElement X1 = (SecP256K1FieldElement)this.x, Y1 = (SecP256K1FieldElement)this.y;
        SecP256K1FieldElement X2 = (SecP256K1FieldElement)b.getXCoord(), Y2 = (SecP256K1FieldElement)b.getYCoord();

        SecP256K1FieldElement Z1 = (SecP256K1FieldElement)this.zs[0];
        SecP256K1FieldElement Z2 = (SecP256K1FieldElement)b.getZCoord(0);

        int c;
        int[] tt1 = Nat256.createExt();
        int[] t2 = Nat256.create();
        int[] t3 = Nat256.create();
        int[] t4 = Nat256.create();

        boolean Z1IsOne = Z1.isOne();
        int[] U2, S2;
        if (Z1IsOne)
        {
            U2 = X2.x;
            S2 = Y2.x;
        }
        else
        {
            S2 = t3;
            SecP256K1Field.square(Z1.x, S2);

            U2 = t2;
            SecP256K1Field.multiply(S2, X2.x, U2);

            SecP256K1Field.multiply(S2, Z1.x, S2);
            SecP256K1Field.multiply(S2, Y2.x, S2);
        }

        boolean Z2IsOne = Z2.isOne();
        int[] U1, S1;
        if (Z2IsOne)
        {
            U1 = X1.x;
            S1 = Y1.x;
        }
        else
        {
            S1 = t4;
            SecP256K1Field.square(Z2.x, S1);

            U1 = tt1;
            SecP256K1Field.multiply(S1, X1.x, U1);

            SecP256K1Field.multiply(S1, Z2.x, S1);
            SecP256K1Field.multiply(S1, Y1.x, S1);
        }

        int[] H = Nat256.create();
        SecP256K1Field.subtract(U1, U2, H);

        SecP256K1Field.subtract(S1, S2, t2);

        // Check if b == this or b == -this
        if (Nat256.isZero(H))
        {
            if (Nat256.isZero(t2))
            {
                // this == b, i.e. this must be doubled
                return this.twice();
            }

            // this == -b, i.e. the result is the point at infinity
            return curve.getInfinity();
        }

        SecP256K1Field.square(H, t3);

        int[] G = Nat256.create();
        SecP256K1Field.multiply(t3, H, G);

        SecP256K1Field.multiply(t3, U1, t3);

        SecP256K1Field.negate(G, G);
        Nat256.mul(S1, G, tt1);

        c = Nat256.addBothTo(t3, t3, G);
        SecP256K1Field.reduce32(c, G);

        SecP256K1FieldElement X3 = new SecP256K1FieldElement(t4);
        SecP256K1Field.square(t2, X3.x);
        SecP256K1Field.subtract(X3.x, G, X3.x);

        SecP256K1FieldElement Y3 = new SecP256K1FieldElement(G);
        SecP256K1Field.subtract(t3, X3.x, Y3.x);
        SecP256K1Field.multiplyAddToExt(Y3.x, t2, tt1);
        SecP256K1Field.reduce(tt1, Y3.x);

        SecP256K1FieldElement Z3 = new SecP256K1FieldElement(H);
        if (!Z1IsOne)
        {
            SecP256K1Field.multiply(Z3.x, Z1.x, Z3.x);
        }
        if (!Z2IsOne)
        {
            SecP256K1Field.multiply(Z3.x, Z2.x, Z3.x);
        }

        ECFieldElement[] zs = new ECFieldElement[] { Z3 };

        return new SecP256K1Point(curve, X3, Y3, zs, this.withCompression);
    }

    // B.3 pg 62
    public ECPoint twice()
    {
        if (this.isInfinity())
        {
            return this;
        }

        ECCurve curve = this.getCurve();

        SecP256K1FieldElement Y1 = (SecP256K1FieldElement)this.y;
        if (Y1.isZero())
        {
            return curve.getInfinity();
        }

        SecP256K1FieldElement X1 = (SecP256K1FieldElement)this.x, Z1 = (SecP256K1FieldElement)this.zs[0];

        int c;

        int[] Y1Squared = Nat256.create();
        SecP256K1Field.square(Y1.x, Y1Squared);

        int[] T = Nat256.create();
        SecP256K1Field.square(Y1Squared, T);

        int[] M = Nat256.create();
        SecP256K1Field.square(X1.x, M);
        c = Nat256.addBothTo(M, M, M);
        SecP256K1Field.reduce32(c, M);

        SecP256K1Field.multiply(Y1Squared, X1.x, Y1Squared);
        c = Nat.shiftUpBits(8, Y1Squared, 2, 0);
        SecP256K1Field.reduce32(c, Y1Squared);

        int[] t1 = Nat256.create();
        c = Nat.shiftUpBits(8, T, 3, 0, t1);
        SecP256K1Field.reduce32(c, t1);

        SecP256K1FieldElement X3 = new SecP256K1FieldElement(T);
        SecP256K1Field.square(M, X3.x);
        SecP256K1Field.subtract(X3.x, Y1Squared, X3.x);
        SecP256K1Field.subtract(X3.x, Y1Squared, X3.x);

        SecP256K1FieldElement Y3 = new SecP256K1FieldElement(Y1Squared);
        SecP256K1Field.subtract(Y1Squared, X3.x, Y3.x);
        SecP256K1Field.multiply(Y3.x, M, Y3.x);
        SecP256K1Field.subtract(Y3.x, t1, Y3.x);

        SecP256K1FieldElement Z3 = new SecP256K1FieldElement(M);
        SecP256K1Field.twice(Y1.x, Z3.x);
        if (!Z1.isOne())
        {
            SecP256K1Field.multiply(Z3.x, Z1.x, Z3.x);
        }

        return new SecP256K1Point(curve, X3, Y3, new ECFieldElement[] { Z3 }, this.withCompression);
    }

    public ECPoint twicePlus(ECPoint b) throws CloneNotSupportedException {
        if (this == b)
        {
            return threeTimes();
        }
        if (this.isInfinity())
        {
            return b;
        }
        if (b.isInfinity())
        {
            return twice();
        }

        if (this.y.isZero())
        {
            return b;
        }

        return twice().add(b);
    }

    public ECPoint threeTimes() throws CloneNotSupportedException {
        if (this.isInfinity() || this.y.isZero())
        {
            return this;
        }

        // NOTE: Be careful about recursions between twicePlus and threeTimes
        return twice().add(this);
    }

    public ECPoint negate()
    {
        if (this.isInfinity())
        {
            return this;
        }

        return new SecP256K1Point(curve, this.x, this.y.negate(), this.zs, this.withCompression);
    }
}
