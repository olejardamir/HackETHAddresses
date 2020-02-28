package Keys;
import java.math.BigInteger;

public class SecP256K1Curve extends ECCurve {
    public static BigInteger q;

    static {
        try {
            q = new BigInteger(1,
                    Hex.decode("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final int SECP256K1_DEFAULT_COORDS = COORD_JACOBIAN;

    private SecP256K1Point infinity;

    public SecP256K1Curve() throws Exception {


        this.infinity = new SecP256K1Point(this, null, null);

        this.a = fromBigInteger(ECFieldElement.ZERO);
        this.b = fromBigInteger(BigInteger.valueOf(7));
        this.order = new BigInteger(1, Hex.decode("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
        this.coord = SECP256K1_DEFAULT_COORDS;
    }

    protected ECCurve cloneCurve() throws Exception {
        return new SecP256K1Curve();
    }



    public int getFieldSize()
    {
        return q.bitLength();
    }

    public ECFieldElement fromBigInteger(BigInteger x)
    {
        return new SecP256K1FieldElement(x);
    }

    protected ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, boolean withCompression)
    {
        return new SecP256K1Point(this, x, y, withCompression);
    }

    public ECPoint getInfinity()
    {
        return infinity;
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] points, int off, final int len)
    {
		final int FE_INTS = 8;
		final int[] table = new int[2 * FE_INTS * len];
		for (int pos = 0, i = 0; i < len; ++i) {
			ECPoint p = points[i + off];
			Nat256.copy(((SecP256K1FieldElement) p.getRawXCoord()).x, 0, table, pos);
			pos += FE_INTS;
			Nat256.copy(((SecP256K1FieldElement) p.getRawYCoord()).x, 0, table, pos);
			pos += FE_INTS;
		}
		return new ECLookupTable() {


            @Override
            public int getSize() {
                return 0;
            }

            public ECPoint lookup(int index) {
				int[] x = new int[8], y = new int[8];
				for (int pos = 0, i = 0; i < len; ++i) {
					for (int MASK = ((i ^ index) - 1) >> 31, j = 0; j < FE_INTS; ++j) {
						x[j] ^= table[j + pos] & MASK;
						y[j] ^= table[j + pos + FE_INTS] & MASK;
					}
					pos += (2 * FE_INTS);
				}
				return createRawPoint(new SecP256K1FieldElement(x), new SecP256K1FieldElement(y), false);
			}
		};
	}

}