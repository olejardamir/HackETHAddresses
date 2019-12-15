import java.math.BigInteger;
import java.util.Hashtable;


public abstract class ECCurve
{
    public static final int COORD_AFFINE = 0;
    public static final int COORD_HOMOGENEOUS = 1;
    public static final int COORD_JACOBIAN = 2;
    public static final int COORD_JACOBIAN_CHUDNOVSKY = 3;
    public static final int COORD_JACOBIAN_MODIFIED = 4;
    public static final int COORD_LAMBDA_AFFINE = 5;
    public static final int COORD_LAMBDA_PROJECTIVE = 6;

    public ECCurve() {

    }

    public class Config
    {
        final int coord;

        Config(int coord)
        {
            this.coord = coord;
         }

        public Config setEndomorphism()
        {
             return this;
        }

        public ECCurve create() throws Exception {


            ECCurve c = cloneCurve();


                c.coord = coord;
                 c.multiplier = multiplier;


            return c;
        }
    }

    private   GenericPolynomialExtensionField field;
    ECFieldElement a;
    ECFieldElement b;
    BigInteger order;
    BigInteger cofactor;

    int coord = COORD_AFFINE;
     private AbstractECMultiplier multiplier = null;

    ECCurve(GenericPolynomialExtensionField field)
    {
        this.field = field;
    }

    public abstract int getFieldSize();

    public abstract ECFieldElement fromBigInteger(BigInteger x);

    public synchronized Config configure()
    {
        return new Config(this.coord);
    }

    private ECPoint validatePoint(BigInteger x, BigInteger y) {
        ECPoint p = createPoint(x, y);

        return p;
    }


    private ECPoint createPoint(BigInteger x, BigInteger y)
    {
        return createPoint(x, y, false);
    }

    
    public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression)
    {
        return createRawPoint(fromBigInteger(x), fromBigInteger(y), withCompression);
    }

    protected abstract ECCurve cloneCurve() throws Exception;

    protected abstract ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, boolean withCompression);


    
    public PreCompInfo precompute(ECPoint point, String name, PreCompCallback callback) {


        Hashtable table;

            table = point.preCompTable;
            if (null == table)
            {
                point.preCompTable = table = new Hashtable(4);
            }



            PreCompInfo existing = (PreCompInfo)table.get(name);
            PreCompInfo result = callback.precompute(existing);

            if (result != existing)
            {
                table.put(name, result);
            }

            return result;

    }

    public ECPoint importPoint(ECPoint p) {
        if (this == p.getCurve())
        {
            return p;
        }
        if (p.isInfinity())
        {
            return getInfinity();
        }

        
        p = p.normalize();

        return createPoint(p.getXCoord().toBigInteger(), p.getYCoord().toBigInteger(), p.withCompression);
    }

    
    public void normalizeAll(ECPoint[] points) {
        normalizeAll(points, points.length);
    }


    private void normalizeAll(ECPoint[] points, int len) {

        switch (this.getCoordinateSystem())
        {
            case ECCurve.COORD_AFFINE:
            case ECCurve.COORD_LAMBDA_AFFINE:
            {
                return;
            }
        }

        
        ECFieldElement[] zs = new ECFieldElement[len];
        int[] indices = new int[len];
        int count = 0;
        for (int i = 0; i < len; ++i)
        {
            ECPoint p = points[i];
            if (null != p && p.isNormalized())
            {
                zs[count] = p.getZCoord(0);
                indices[count++] = i;
            }
        }

        if (count == 0)
        {
            return;
        }

        ECAlgorithms.montgomeryTrick(zs, 0, count, null);

        for (int j = 0; j < count; ++j)
        {
            int index = indices[j];
            points[index] = points[index].normalize(zs[j]);
        }
    }

    public abstract ECPoint getInfinity();

    public GenericPolynomialExtensionField getField()
    {
        return field;
    }

    public ECFieldElement getA()
    {
        return a;
    }

    public ECFieldElement getB()
    {
        return b;
    }

    public BigInteger getOrder()
    {
        return order;
    }

    public BigInteger getCofactor()
    {
        return cofactor;
    }

    public int getCoordinateSystem()
    {
        return coord;
    }

    protected abstract ECPoint decompressPoint(int yTilde, BigInteger X1);

    
    public ECPoint decodePoint(byte[] encoded) {
        ECPoint p;
        int expectedLength = (getFieldSize() + 7) / 8;

        byte type = encoded[0];
        switch (type)
        {
            case 0x00: 
            {

                p = getInfinity();
                break;
            }
            case 0x02: 
            case 0x03: 
            {


                int yTilde = type & 1;
                BigInteger X = BigIntegers.fromUnsignedByteArray(encoded, 1, expectedLength);

                p = decompressPoint(yTilde, X);


                break;
            }
            case 0x04:
            case 0x06:
            case 0x07: {


                BigInteger X = BigIntegers.fromUnsignedByteArray(encoded, 1, expectedLength);
                BigInteger Y = BigIntegers.fromUnsignedByteArray(encoded, 1 + expectedLength, expectedLength);

                p = validatePoint(X, Y);
                break;
            }
            default:
                throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(type, 16));
        }



        return p;
    }

    
    public ECLookupTable createCacheSafeLookupTable(final ECPoint[] points, int off, final int len)
    {
        final int FE_BYTES = (getFieldSize() + 7) >>> 3;

        final byte[] table = new byte[len * FE_BYTES * 2];
        {
            int pos = 0;
            for (int i = 0; i < len; ++i)
            {
                ECPoint p = points[off + i];
                byte[] px = p.getRawXCoord().toBigInteger().toByteArray();
                byte[] py = p.getRawYCoord().toBigInteger().toByteArray();

                int pxStart = px.length > FE_BYTES ? 1 : 0, pxLen = px.length - pxStart;
                int pyStart = py.length > FE_BYTES ? 1 : 0, pyLen = py.length - pyStart;

                System.arraycopy(px, pxStart, table, pos + FE_BYTES - pxLen, pxLen); pos += FE_BYTES;
                System.arraycopy(py, pyStart, table, pos + FE_BYTES - pyLen, pyLen); pos += FE_BYTES;
            }
        }

        return new ECLookupTable()
        {
            public int getSize()
            {
                return len;
            }

            public ECPoint lookup(int index)
            {
                byte[] x = new byte[FE_BYTES], y = new byte[FE_BYTES];
                int pos = 0;

                for (int i = 0; i < len; ++i)
                {
                    int MASK = ((i ^ index) - 1) >> 31;

                    for (int j = 0; j < FE_BYTES; ++j)
                    {
                        x[j] ^= table[pos + j] & MASK;
                        y[j] ^= table[pos + FE_BYTES + j] & MASK;
                    }

                    pos += (FE_BYTES * 2);
                }

                return createRawPoint(fromBigInteger(new BigInteger(1, x)), fromBigInteger(new BigInteger(1, y)), false);
            }
        };
    }





    public boolean equals(ECCurve other)
    {
        return this == other
                || (null != other
                && getField().equals(other.getField())
                && getA().toBigInteger().equals(other.getA().toBigInteger())
                && getB().toBigInteger().equals(other.getB().toBigInteger()));
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof ECCurve && equals((ECCurve)obj));
    }

    public int hashCode()
    {
        return getField().hashCode()
                ^ Integers.rotateLeft(getA().toBigInteger().hashCode(), 8)
                ^ Integers.rotateLeft(getB().toBigInteger().hashCode(), 16);
    }

    protected static abstract class AbstractFp extends ECCurve
    {
        AbstractFp(BigInteger q)
        {
            super(FiniteFields.getPrimeField(q));
        }


        protected ECPoint decompressPoint(int yTilde, BigInteger X1) {
            ECFieldElement x = this.fromBigInteger(X1);
            ECFieldElement rhs = x.square().add(this.a).multiply(x).add(this.b);
            ECFieldElement y = rhs.sqrt();

            


            if (y.testBitZero() != (yTilde == 1))
            {
                
                y = y.negate();
            }

            return this.createRawPoint(x, y, true);
        }
    }


}
