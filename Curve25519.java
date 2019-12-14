import java.math.BigInteger;

public class Curve25519 extends ECCurve.AbstractFp
{
    public static final BigInteger q = Nat256.toBigInteger(Curve25519Field.P);



    private Curve25519() throws Exception {
        super(q);


        this.a = fromBigInteger(new BigInteger(1,
                Hex.decode("2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144")));
        this.b = fromBigInteger(new BigInteger(1,
                Hex.decode("7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864")));
        this.order = new BigInteger(1, Hex.decode("1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED"));
        this.cofactor = BigInteger.valueOf(8);

     }

     public int getFieldSize() {
        return 0;
    }

     public ECFieldElement fromBigInteger(BigInteger x) {
        return null;
    }

     protected ECCurve cloneCurve()  {
        return null;
    }

     protected ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, boolean withCompression) {
        return null;
    }


    public ECPoint getInfinity() {
        return null;
    }







    public ECLookupTable createCacheSafeLookupTable(ECPoint[] points, int off, final int len)
    {
        final int FE_INTS = 8;

        final int[] table = new int[len * FE_INTS * 2];
        {
            int pos = 0;
            for (int i = 0; i < len; ++i)
            {
                ECPoint p = points[off + i];
                Nat256.copy(((Curve25519FieldElement)p.getRawXCoord()).x, 0, table, pos); pos += FE_INTS;
                Nat256.copy(((Curve25519FieldElement)p.getRawYCoord()).x, 0, table, pos); pos += FE_INTS;
            }
        }

        return new ECLookupTable()
        {


             public int getSize() {
                return 0;
            }

             public ECPoint lookup(int index) {
                return null;
            }
        };
    }
}
