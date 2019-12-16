
import java.math.BigInteger;

public class SecP256K1FieldElement extends ECFieldElement {
    private static final BigInteger Q = SecP256K1Curve.q;

    int[] x;

    public SecP256K1FieldElement(BigInteger x)
    {


        this.x = SecP256K1Field.fromBigInteger(x);
    }

    SecP256K1FieldElement(int[] x)
    {
        this.x = x;
    }

    public boolean isZero()
    {
        return Nat256.isZero(x);
    }

    public boolean isOne()
    {
        return Nat256.isOne(x);
    }

    public boolean testBitZero()
    {
        return Nat256.getBit(x, 0) == 1;
    }

    public BigInteger toBigInteger()
    {
        return Nat256.toBigInteger(x);
    }

    public int getFieldSize()
    {
        return Q.bitLength();
    }

    public ECFieldElement add(ECFieldElement b)
    {
        int[] z = Nat256.create();
        SecP256K1Field.add(x, ((SecP256K1FieldElement)b).x, z);
        return new SecP256K1FieldElement(z);
    }



    public ECFieldElement multiply(ECFieldElement b)
    {
        int[] z = Nat256.create();
        SecP256K1Field.multiply(x, ((SecP256K1FieldElement)b).x, z);
        return new SecP256K1FieldElement(z);
    }


    public ECFieldElement negate()
    {
        int[] z = Nat256.create();
        SecP256K1Field.negate(x, z);
        return new SecP256K1FieldElement(z);
    }

    public ECFieldElement square()
    {
        int[] z = Nat256.create();
        SecP256K1Field.square(x, z);
        return new SecP256K1FieldElement(z);
    }

    public ECFieldElement invert()
    {

        int[] z = Nat256.create();
        Mod.invert(SecP256K1Field.P, x, z);
        return new SecP256K1FieldElement(z);
    }

    
    
    public ECFieldElement sqrt()
    {
        

        int[] x1 = this.x;
        if (Nat256.isZero(x1) || Nat256.isOne(x1))
        {
            return this;
        }

        int[] x2 = Nat256.create();
        SecP256K1Field.square(x1, x2);
        SecP256K1Field.multiply(x2, x1, x2);
        int[] x3 = Nat256.create();
        SecP256K1Field.square(x2, x3);
        SecP256K1Field.multiply(x3, x1, x3);
        int[] x6 = Nat256.create();
        SecP256K1Field.squareN(x3, 3, x6);
        SecP256K1Field.multiply(x6, x3, x6);
        SecP256K1Field.squareN(x6, 3, x6);
        SecP256K1Field.multiply(x6, x3, x6);
        SecP256K1Field.squareN(x6, 2, x6);
        SecP256K1Field.multiply(x6, x2, x6);
        int[] x22 = Nat256.create();
        SecP256K1Field.squareN(x6, 11, x22);
        SecP256K1Field.multiply(x22, x6, x22);
        SecP256K1Field.squareN(x22, 22, x6);
        SecP256K1Field.multiply(x6, x22, x6);
        int[] x88 = Nat256.create();
        SecP256K1Field.squareN(x6, 44, x88);
        SecP256K1Field.multiply(x88, x6, x88);
        int[] x176 = Nat256.create();
        SecP256K1Field.squareN(x88, 88, x176);
        SecP256K1Field.multiply(x176, x88, x176);
        SecP256K1Field.squareN(x176, 44, x88);
        SecP256K1Field.multiply(x88, x6, x88);
        SecP256K1Field.squareN(x88, 3, x6);
        SecP256K1Field.multiply(x6, x3, x6);

        SecP256K1Field.squareN(x6, 23, x6);
        SecP256K1Field.multiply(x6, x22, x6);
        SecP256K1Field.squareN(x6, 6, x6);
        SecP256K1Field.multiply(x6, x2, x6);
        SecP256K1Field.squareN(x6, 2, x6);

        SecP256K1Field.square(x6, x2);

        return Nat256.eq(x1, x2) ? new SecP256K1FieldElement(x6) : null;
    }




}
