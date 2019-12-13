import java.math.BigInteger;

public class Curve25519FieldElement extends ECFieldElement.AbstractFp
{
    public static final BigInteger Q = Curve25519.q;

    // Calculated as ECConstants.TWO.modPow(Q.shiftRight(2), Q)
    private static final int[] PRECOMP_POW2 = new int[]{ 0x4a0ea0b0, 0xc4ee1b27, 0xad2fe478, 0x2f431806,
            0x3dfbd7a7, 0x2b4d0099, 0x4fc1df0b, 0x2b832480 };

    protected int[] x;

    public Curve25519FieldElement(BigInteger x)
    {
        if (x == null || x.signum() < 0 || x.compareTo(Q) >= 0)
        {
            throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
        }

        this.x = Curve25519Field.fromBigInteger(x);
    }

    public Curve25519FieldElement()
    {
        this.x = Nat256.create();
    }

    protected Curve25519FieldElement(int[] x)
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
        Curve25519Field.add(x, ((Curve25519FieldElement)b).x, z);
        return new Curve25519FieldElement(z);
    }

    public ECFieldElement addOne()
    {
        int[] z = Nat256.create();
        Curve25519Field.addOne(x, z);
        return new Curve25519FieldElement(z);
    }

    public ECFieldElement subtract(ECFieldElement b)
    {
        int[] z = Nat256.create();
        Curve25519Field.subtract(x, ((Curve25519FieldElement)b).x, z);
        return new Curve25519FieldElement(z);
    }

    public ECFieldElement multiply(ECFieldElement b)
    {
        int[] z = Nat256.create();
        Curve25519Field.multiply(x, ((Curve25519FieldElement)b).x, z);
        return new Curve25519FieldElement(z);
    }

    public ECFieldElement divide(ECFieldElement b)
    {
//        return multiply(b.invert());
        int[] z = Nat256.create();
        Mod.invert(Curve25519Field.P, ((Curve25519FieldElement)b).x, z);
        Curve25519Field.multiply(z, x, z);
        return new Curve25519FieldElement(z);
    }

    public ECFieldElement negate()
    {
        int[] z = Nat256.create();
        Curve25519Field.negate(x, z);
        return new Curve25519FieldElement(z);
    }

    public ECFieldElement square()
    {
        int[] z = Nat256.create();
        Curve25519Field.square(x, z);
        return new Curve25519FieldElement(z);
    }

    public ECFieldElement invert()
    {
//        return new Curve25519FieldElement(toBigInteger().modInverse(Q));
        int[] z = Nat256.create();
        Mod.invert(Curve25519Field.P, x, z);
        return new Curve25519FieldElement(z);
    }

    /**
     * return a sqrt root - the routine verifies that the calculation returns the right value - if
     * none exists it returns null.
     */
    public ECFieldElement sqrt()
    {
        /*
         * Q == 8m + 5, so we use Pocklington's method for this case.
         *
         * First, raise this element to the exponent 2^252 - 2^1 (i.e. m + 1)
         *
         * Breaking up the exponent's binary representation into "repunits", we get:
         * { 251 1s } { 1 0s }
         *
         * Therefore we need an addition chain containing 251 (the lengths of the repunits)
         * We use: 1, 2, 3, 4, 7, 11, 15, 30, 60, 120, 131, [251]
         */

        int[] x1 = this.x;
        if (Nat256.isZero(x1) || Nat256.isOne(x1))
        {
            return this;
        }

        int[] x2 = Nat256.create();
        Curve25519Field.square(x1, x2);
        Curve25519Field.multiply(x2, x1, x2);
        Curve25519Field.square(x2, x2);
        Curve25519Field.multiply(x2, x1, x2);
        int[] x4 = Nat256.create();
        Curve25519Field.square(x2, x4);
        Curve25519Field.multiply(x4, x1, x4);
        int[] x7 = Nat256.create();
        Curve25519Field.squareN(x4, 3, x7);
        Curve25519Field.multiply(x7, x2, x7);
        Curve25519Field.squareN(x7, 4, x2);
        Curve25519Field.multiply(x2, x4, x2);
        Curve25519Field.squareN(x2, 4, x7);
        Curve25519Field.multiply(x7, x4, x7);
        Curve25519Field.squareN(x7, 15, x4);
        Curve25519Field.multiply(x4, x7, x4);
        Curve25519Field.squareN(x4, 30, x7);
        Curve25519Field.multiply(x7, x4, x7);
        Curve25519Field.squareN(x7, 60, x4);
        Curve25519Field.multiply(x4, x7, x4);
        Curve25519Field.squareN(x4, 11, x7);
        Curve25519Field.multiply(x7, x2, x7);
        Curve25519Field.squareN(x7, 120, x2);
        Curve25519Field.multiply(x2, x4, x2);

        Curve25519Field.square(x2, x2);

        Curve25519Field.square(x2, x4);

        if (Nat256.eq(x1, x4))
        {
            return new Curve25519FieldElement(x2);
        }

        /*
         * If the first guess is incorrect, we multiply by a precomputed power of 2 to get the second guess,
         * which is ((4x)^(m + 1))/2 mod Q
         */
        Curve25519Field.multiply(x2, PRECOMP_POW2, x2);

        Curve25519Field.square(x2, x4);

        if (Nat256.eq(x1, x4))
        {
            return new Curve25519FieldElement(x2);
        }

        return null;
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
