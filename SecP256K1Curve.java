import java.math.BigInteger;

// 
// Decompiled by Procyon v0.5.36
// 

public class SecP256K1Curve extends ECCurve
{
    public static BigInteger q;
    private SecP256K1Point infinity;
    
    public SecP256K1Curve() throws Exception {
        super(FiniteFields.getPrimeField(SecP256K1Curve.q));
        this.infinity = new SecP256K1Point(this, null, null);
        this.a = this.fromBigInteger(ECFieldElement.ZERO);
        this.b = this.fromBigInteger(BigInteger.valueOf(7L));
        this.order = new BigInteger(1, Hex.decode("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
        this.coord = 2;
    }
    
    @Override
    protected ECCurve cloneCurve() throws Exception {
        return new SecP256K1Curve();
    }
    
    @Override
    public int getFieldSize() {
        return SecP256K1Curve.q.bitLength();
    }
    
    @Override
    public ECFieldElement fromBigInteger(final BigInteger x) {
        return new SecP256K1FieldElement(x);
    }
    
    @Override
    protected ECPoint createRawPoint(final ECFieldElement x, final ECFieldElement y, final boolean withCompression) {
        return new SecP256K1Point(this, x, y, withCompression);
    }
    
    @Override
    public ECPoint getInfinity() {
        return this.infinity;
    }
    
    @Override
    public ECLookupTable createCacheSafeLookupTable(final ECPoint[] points, final int off, final int len) {
        final int[] table = new int[len * 8 * 2];
        int pos = 0;
        for (int i = 0; i < len; ++i) {
            final ECPoint p = points[off + i];
            Nat256.copy(((SecP256K1FieldElement)p.getRawXCoord()).x, 0, table, pos);
            pos += 8;
            Nat256.copy(((SecP256K1FieldElement)p.getRawYCoord()).x, 0, table, pos);
            pos += 8;
        }
        return new ECLookupTable() {
            @Override
            public int getSize() {
                return len;
            }
            
            @Override
            public ECPoint lookup(final int index) {
                final int[] x = Nat256.create();
                final int[] y = Nat256.create();
                int pos = 0;
                for (int i = 0; i < len; ++i) {
                    final int MASK = (i ^ index) - 1 >> 31;
                    for (int j = 0; j < 8; ++j) {
                        x[j] ^= (table[pos + j] & MASK);
                        y[j] ^= (table[pos + 8 + j] & MASK);
                    }
                    pos += 16;
                }
                return SecP256K1Curve.this.createRawPoint(new SecP256K1FieldElement(x), new SecP256K1FieldElement(y), false);
            }
        };
    }
    
    @Override
    protected ECPoint decompressPoint(final int yTilde, final BigInteger X1) {
        final ECFieldElement x = this.fromBigInteger(X1);
        final ECFieldElement rhs = x.square().multiply(x);
        ECFieldElement y = rhs.sqrt();
        if (y.testBitZero() != (yTilde == 1)) {
            y = y.negate();
        }
        return this.createRawPoint(x, y, true);
    }
    
    static {
        try {
            SecP256K1Curve.q = new BigInteger(1, Hex.decode("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
