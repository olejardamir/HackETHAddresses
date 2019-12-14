public class Curve25519Point extends ECPoint.AbstractFp
{
    


    
    public Curve25519Point(ECCurve curve, ECFieldElement x, ECFieldElement y, boolean withCompression)
    {
        super(curve, x, y);

        if ((x == null) != (y == null))
        {
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        this.withCompression = withCompression;
    }

    Curve25519Point(ECCurve curve, ECFieldElement x, ECFieldElement y, ECFieldElement[] zs, boolean withCompression)
    {
        super(curve, x, y, zs);

        this.withCompression = withCompression;
    }


     public ECPoint add(ECPoint b) throws CloneNotSupportedException {
        return null;
    }

     public ECPoint negate() {
        return null;
    }

    public ECPoint twice()
    {
        if (this.isInfinity())
        {
            return this;
        }

        ECCurve curve = this.getCurve();

        if (this.y.isZero())
        {
            return curve.getInfinity();
        }

        return twiceJacobianModified(true);
    }





    private Curve25519FieldElement calculateJacobianModifiedW(Curve25519FieldElement Z, int[] ZSquared)
    {
        Curve25519FieldElement a4 = (Curve25519FieldElement)this.getCurve().getA();
        if (Z.isOne())
        {
            return a4;
        }

        Curve25519FieldElement W = new Curve25519FieldElement();
        if (ZSquared == null)
        {
            ZSquared = W.x;
            Curve25519Field.square(Z.x, ZSquared);
        }
        Curve25519Field.square(ZSquared, W.x);
        Curve25519Field.multiply(W.x, a4.x, W.x);
        return W;
    }

    private Curve25519FieldElement getJacobianModifiedW()
    {
        Curve25519FieldElement W = (Curve25519FieldElement)this.zs[1];
        if (W == null)
        {
            
            this.zs[1] = W = calculateJacobianModifiedW((Curve25519FieldElement)this.zs[0], null);
        }
        return W;
    }

    private Curve25519Point twiceJacobianModified(boolean calculateW)
    {
        Curve25519FieldElement X1 = (Curve25519FieldElement)this.x, Y1 = (Curve25519FieldElement)this.y,
                Z1 = (Curve25519FieldElement)this.zs[0], W1 = getJacobianModifiedW();

        int c;

        int[] M = Nat256.create();
        Curve25519Field.square(X1.x, M);
        c = Nat256.addBothTo(M, M, M);
        c += Nat256.addTo(W1.x, M);
        Curve25519Field.reduce27(c, M);

        int[] _2Y1 = Nat256.create();
        Curve25519Field.twice(Y1.x, _2Y1);

        int[] _2Y1Squared = Nat256.create();
        Curve25519Field.multiply(_2Y1, Y1.x, _2Y1Squared);

        int[] S = Nat256.create();
        Curve25519Field.multiply(_2Y1Squared, X1.x, S);
        Curve25519Field.twice(S, S);

        int[] _8T = Nat256.create();
        Curve25519Field.square(_2Y1Squared, _8T);
        Curve25519Field.twice(_8T, _8T);

        Curve25519FieldElement X3 = new Curve25519FieldElement(_2Y1Squared);
        Curve25519Field.square(M, X3.x);
        Curve25519Field.subtract(X3.x, S, X3.x);
        Curve25519Field.subtract(X3.x, S, X3.x);

        Curve25519FieldElement Y3 = new Curve25519FieldElement(S);
        Curve25519Field.subtract(S, X3.x, Y3.x);
        Curve25519Field.multiply(Y3.x, M, Y3.x);
        Curve25519Field.subtract(Y3.x, _8T, Y3.x);

        Curve25519FieldElement Z3 = new Curve25519FieldElement(_2Y1);
        if (!Nat256.isOne(Z1.x))
        {
            Curve25519Field.multiply(Z3.x, Z1.x, Z3.x);
        }

        Curve25519FieldElement W3 = null;
        if (calculateW)
        {
            W3 = new Curve25519FieldElement(_8T);
            Curve25519Field.multiply(W3.x, W1.x, W3.x);
            Curve25519Field.twice(W3.x, W3.x);
        }

        return new Curve25519Point(this.getCurve(), X3, Y3, new ECFieldElement[]{ Z3, W3 }, this.withCompression);
    }
}

