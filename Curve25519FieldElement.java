import java.math.BigInteger;

public class Curve25519FieldElement extends ECFieldElement.AbstractFp
{
    private static final BigInteger Q = Curve25519.q;



    int[] x;



    public Curve25519FieldElement()
    {
        this.x = Nat256.create();
    }

     public BigInteger toBigInteger() {
        return null;
    }

     public int getFieldSize() {
        return 0;
    }

     public ECFieldElement add(ECFieldElement b) {
        return null;
    }

     public ECFieldElement multiply(ECFieldElement b) {
        return null;
    }

     public ECFieldElement negate() {
        return null;
    }

     public ECFieldElement square() {
        return null;
    }

     public ECFieldElement invert() {
        return null;
    }

     public ECFieldElement sqrt() {
        return null;
    }

    Curve25519FieldElement(int[] x)
    {
        this.x = x;
    }



    public boolean isOne()
    {
        return Nat256.isOne(x);
    }








    public boolean equals(Object other)
    {
        if (other == this)
        {
            return true;
        }

        if (!(other instanceof Curve25519FieldElement))
        {
            return false;
        }

        Curve25519FieldElement o = (Curve25519FieldElement)other;
        return Nat256.eq(x, o.x);
    }

    public int hashCode()
    {
        return Q.hashCode() ^ Arrays.hashCode(x, 0, 8);
    }
}
