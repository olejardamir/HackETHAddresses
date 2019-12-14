import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Random;

/**
 * base class for an elliptic curve
 */
public abstract class ECCurve
{
    public static final int COORD_AFFINE = 0;
    public static final int COORD_HOMOGENEOUS = 1;
    public static final int COORD_JACOBIAN = 2;
    public static final int COORD_JACOBIAN_CHUDNOVSKY = 3;
    public static final int COORD_JACOBIAN_MODIFIED = 4;
    public static final int COORD_LAMBDA_AFFINE = 5;
    public static final int COORD_LAMBDA_PROJECTIVE = 6;

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
            if (!supportsCoordinateSystem(coord))
            {
                throw new IllegalStateException("unsupported coordinate system");
            }

            ECCurve c = cloneCurve();
            if (c == ECCurve.this)
            {
                throw new IllegalStateException("implementation returned current curve");
            }


                c.coord = coord;
                 c.multiplier = multiplier;


            return c;
        }
    }

    private final GenericPolynomialExtensionField field;
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

    private ECPoint validatePoint(BigInteger x, BigInteger y) throws CloneNotSupportedException {
        ECPoint p = createPoint(x, y);
        if (p.isValid())
        {
            throw new IllegalArgumentException("Invalid point coordinates");
        }
        return p;
    }

    /**
     * @deprecated per-point compression property will be removed, use {@link #validatePoint(BigInteger, BigInteger)}
     * and refer {@link ECPoint#getEncoded(boolean)}
     */
    public ECPoint validatePoint(BigInteger x, BigInteger y, boolean withCompression) throws CloneNotSupportedException {
        ECPoint p = createPoint(x, y, withCompression);
        if (p.isValid())
        {
            throw new IllegalArgumentException("Invalid point coordinates");
        }
        return p;
    }

    private ECPoint createPoint(BigInteger x, BigInteger y)
    {
        return createPoint(x, y, false);
    }

    /**
     * @deprecated per-point compression property will be removed, use {@link #createPoint(BigInteger, BigInteger)}
     * and refer {@link ECPoint#getEncoded(boolean)}
     */
    public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression)
    {
        return createRawPoint(fromBigInteger(x), fromBigInteger(y), withCompression);
    }

    protected abstract ECCurve cloneCurve() throws Exception;

    protected abstract ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, boolean withCompression);

    protected abstract ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, ECFieldElement[] zs, boolean withCompression);

    boolean supportsCoordinateSystem(int coord)
    {
        return coord == COORD_AFFINE;
    }

    /**
     * Compute a <code>PreCompInfo</code> for a point on this curve, under a given name. Used by
     * <code>ECMultiplier</code>s to save the precomputation for this <code>ECPoint</code> for use
     * by subsequent multiplication.
     *
     * @param point
     *            The <code>ECPoint</code> to store precomputations for.
     * @param name
     *            A <code>String</code> used to index precomputations of different types.
     * @param callback
     *            Called to calculate the <code>PreCompInfo</code>.
     */
    public PreCompInfo precompute(ECPoint point, String name, PreCompCallback callback) throws CloneNotSupportedException {
        checkPoint(point);

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

    public ECPoint importPoint(ECPoint p) throws CloneNotSupportedException {
        if (this == p.getCurve())
        {
            return p;
        }
        if (p.isInfinity())
        {
            return getInfinity();
        }

        // TODO Default behaviour could be improved if the two curves have the same coordinate system by copying any Z coordinates.
        p = p.normalize();

        return createPoint(p.getXCoord().toBigInteger(), p.getYCoord().toBigInteger(), p.withCompression);
    }

    /**
     * Normalization ensures that any projective coordinate is 1, and therefore that the x, y
     * coordinates reflect those of the equivalent point in an affine coordinate system. Where more
     * than one point is to be normalized, this method will generally be more efficient than
     * normalizing each point separately.
     *
     * @param points
     *            An array of points that will be updated in place with their normalized versions,
     *            where necessary
     */
    public void normalizeAll(ECPoint[] points) throws CloneNotSupportedException {
        normalizeAll(points, points.length);
    }

    /**
     * Normalization ensures that any projective coordinate is 1, and therefore that the x, y
     * coordinates reflect those of the equivalent point in an affine coordinate system. Where more
     * than one point is to be normalized, this method will generally be more efficient than
     * normalizing each point separately. An (optional) z-scaling factor can be applied; effectively
     * each z coordinate is scaled by this value prior to normalization (but only one
     * actual multiplication is needed).
     * @param points
     *            An array of points that will be updated in place with their normalized versions,
     *            where necessary
     * @param len
     */
    private void normalizeAll(ECPoint[] points, int len) throws CloneNotSupportedException {
        checkPoints(points, 0, len);

        switch (this.getCoordinateSystem())
        {
            case ECCurve.COORD_AFFINE:
            case ECCurve.COORD_LAMBDA_AFFINE:
            {
                if (null != null)
                {
                    throw new IllegalArgumentException("'iso' not valid for affine coordinates");
                }
                return;
            }
        }

        /*
         * Figure out which of the points actually need to be normalized
         */
        ECFieldElement[] zs = new ECFieldElement[len];
        int[] indices = new int[len];
        int count = 0;
        for (int i = 0; i < len; ++i)
        {
            ECPoint p = points[0 + i];
            if (null != p && (null != null || p.isNormalized()))
            {
                zs[count] = p.getZCoord(0);
                indices[count++] = 0 + i;
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

    protected abstract ECPoint decompressPoint(int yTilde, BigInteger X1) throws CloneNotSupportedException;

    /**
     * Decode a point on this curve from its ASN.1 encoding. The different
     * encodings are taken account of, including point compression for
     * <code>F<sub>p</sub></code> (X9.62 s 4.2.1 pg 17).
     * @return The decoded point.
     */
    public ECPoint decodePoint(byte[] encoded) throws CloneNotSupportedException {
        ECPoint p;
        int expectedLength = (getFieldSize() + 7) / 8;

        byte type = encoded[0];
        switch (type)
        {
            case 0x00: // infinity
            {
                if (encoded.length != 1)
                {
                    throw new IllegalArgumentException("Incorrect length for infinity encoding");
                }

                p = getInfinity();
                break;
            }
            case 0x02: // compressed
            case 0x03: // compressed
            {
                if (encoded.length != (expectedLength + 1))
                {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }

                int yTilde = type & 1;
                BigInteger X = BigIntegers.fromUnsignedByteArray(encoded, 1, expectedLength);

                p = decompressPoint(yTilde, X);
                if (!p.implIsValid(true, true))
                {
                    throw new IllegalArgumentException("Invalid point");
                }

                break;
            }
            case 0x04: // uncompressed
            {
                if (encoded.length != (2 * expectedLength + 1))
                {
                    throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
                }

                BigInteger X = BigIntegers.fromUnsignedByteArray(encoded, 1, expectedLength);
                BigInteger Y = BigIntegers.fromUnsignedByteArray(encoded, 1 + expectedLength, expectedLength);

                p = validatePoint(X, Y);
                break;
            }
            case 0x06: // hybrid
            case 0x07: // hybrid
            {
                if (encoded.length != (2 * expectedLength + 1))
                {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }

                BigInteger X = BigIntegers.fromUnsignedByteArray(encoded, 1, expectedLength);
                BigInteger Y = BigIntegers.fromUnsignedByteArray(encoded, 1 + expectedLength, expectedLength);

                if (Y.testBit(0) != (type == 0x07))
                {
                    throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                }

                p = validatePoint(X, Y);
                break;
            }
            default:
                throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(type, 16));
        }

        if (type != 0x00 && p.isInfinity())
        {
            throw new IllegalArgumentException("Invalid infinity encoding");
        }

        return p;
    }

    /**
     * Create a cache-safe lookup table for the specified sequence of points. All the points MUST
     * belong to this {@link ECCurve} instance, and MUST already be normalized.
     */
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

    private void checkPoint(ECPoint point)
    {
        if (null == point || (this != point.getCurve()))
        {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
    }

    private void checkPoints(ECPoint[] points, int off, int len)
    {
        if (points == null)
        {
            throw new IllegalArgumentException("'points' cannot be null");
        }
        if (off < 0 || len < 0 || (off > (points.length - len)))
        {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        }

        for (int i = 0; i < len; ++i)
        {
            ECPoint point = points[off + i];
            if (null != point && this != point.getCurve())
            {
                throw new IllegalArgumentException("'points' entries must be null or on this curve");
            }
        }
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

        protected ECPoint decompressPoint(int yTilde, BigInteger X1) throws CloneNotSupportedException {
            ECFieldElement x = this.fromBigInteger(X1);
            ECFieldElement rhs = x.square().add(this.a).multiply(x).add(this.b);
            ECFieldElement y = rhs.sqrt();

            /*
             * If y is not a square, then we haven't got a point on the curve
             */
            if (y == null)
            {
                throw new IllegalArgumentException("Invalid point compression");
            }

            if (y.testBitZero() != (yTilde == 1))
            {
                // Use the other root
                y = y.negate();
            }

            return this.createRawPoint(x, y, true);
        }
    }

    /**
     * Elliptic curve over Fp
     */
    public static class Fp extends AbstractFp
    {
        private static final int FP_DEFAULT_COORDS = ECCurve.COORD_JACOBIAN_MODIFIED;

        final BigInteger q;
        final BigInteger r;
        final ECPoint.Fp infinity;

        /**
         * @deprecated use constructor taking order/cofactor
         */
        public Fp(BigInteger q, BigInteger a, BigInteger b)
        {
            this(q, a, b, null);
        }

        Fp(BigInteger q, BigInteger a, BigInteger b, BigInteger order)
        {
            super(q);

            this.q = q;
            this.r = ECFieldElement.Fp.calculateResidue(q);
            this.infinity = new ECPoint.Fp(this, null, null, false);

            this.a = fromBigInteger(a);
            this.b = fromBigInteger(b);
            this.order = order;
            this.cofactor = null;
            this.coord = FP_DEFAULT_COORDS;
        }

        /**
         * @deprecated use constructor taking order/cofactor
         */
        protected Fp(BigInteger q, BigInteger r, ECFieldElement a, ECFieldElement b)
        {
            this(q, r, a, b, null, null);
        }

        Fp(BigInteger q, BigInteger r, ECFieldElement a, ECFieldElement b, BigInteger order, BigInteger cofactor)
        {
            super(q);

            this.q = q;
            this.r = r;
            this.infinity = new ECPoint.Fp(this, null, null, false);

            this.a = a;
            this.b = b;
            this.order = order;
            this.cofactor = cofactor;
            this.coord = FP_DEFAULT_COORDS;
        }

        protected ECCurve cloneCurve()
        {
            return new Fp(this.q, this.r, this.a, this.b, this.order, this.cofactor);
        }

        public boolean supportsCoordinateSystem(int coord)
        {
            switch (coord)
            {
                case ECCurve.COORD_AFFINE:
                case ECCurve.COORD_HOMOGENEOUS:
                case ECCurve.COORD_JACOBIAN:
                case ECCurve.COORD_JACOBIAN_MODIFIED:
                    return true;
                default:
                    return false;
            }
        }

        public int getFieldSize()
        {
            return q.bitLength();
        }

        public ECFieldElement fromBigInteger(BigInteger x)
        {
            return new ECFieldElement.Fp(this.q, this.r, x);
        }

        protected ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, boolean withCompression)
        {
            return new ECPoint.Fp(this, x, y, withCompression);
        }

        protected ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, ECFieldElement[] zs, boolean withCompression)
        {
            return new ECPoint.Fp(this, x, y, zs, withCompression);
        }

        public ECPoint importPoint(ECPoint p) throws CloneNotSupportedException {
            if (this != p.getCurve() && this.getCoordinateSystem() == ECCurve.COORD_JACOBIAN && !p.isInfinity())
            {
                switch (p.getCurve().getCoordinateSystem())
                {
                    case ECCurve.COORD_JACOBIAN:
                    case ECCurve.COORD_JACOBIAN_CHUDNOVSKY:
                    case ECCurve.COORD_JACOBIAN_MODIFIED:
                        return new ECPoint.Fp(this,
                                fromBigInteger(p.x.toBigInteger()),
                                fromBigInteger(p.y.toBigInteger()),
                                new ECFieldElement[]{ fromBigInteger(p.zs[0].toBigInteger()) },
                                p.withCompression);
                    default:
                        break;
                }
            }

            return super.importPoint(p);
        }

        public ECPoint getInfinity()
        {
            return infinity;
        }
    }

    public static abstract class AbstractF2m extends ECCurve
    {

        private static GenericPolynomialExtensionField buildField(int m, int k1, int k2, int k3)
        {

            if (k2 == 0)
            {


                return   FiniteFields.getBinaryExtensionField(new int[]{ 0, k1, m });
            }





            return   FiniteFields.getBinaryExtensionField(new int[]{ 0, k1, k2, k3, m });
        }

        AbstractF2m(int m, int k1, int k2, int k3)
        {
            super(buildField(m, k1, k2, k3));
        }

        /**
         * Decompresses a compressed point P = (xp, yp) (X9.62 s 4.2.2).
         *
         * @param yTilde
         *            ~yp, an indication bit for the decompression of yp.
         * @param X1
         *            The field element xp.
         * @return the decompressed point.
         */
        protected ECPoint decompressPoint(int yTilde, BigInteger X1) throws CloneNotSupportedException {
            ECFieldElement x = this.fromBigInteger(X1), y = null;
            if (x.isZero())
            {
                y = this.getB().sqrt();
            }
            else
            {
                ECFieldElement beta = x.square().invert().multiply(this.getB()).add(this.getA()).add(x);
                ECFieldElement z = solveQuadraticEquation(beta);
                if (z != null)
                {
                    if (z.testBitZero() != (yTilde == 1))
                    {
                        z = z.addOne();
                    }

                    switch (this.getCoordinateSystem())
                    {
                        case ECCurve.COORD_LAMBDA_AFFINE:
                        case ECCurve.COORD_LAMBDA_PROJECTIVE:
                        {
                            y = z.add(x);
                            break;
                        }
                        default:
                        {
                            y = z.multiply(x);
                            break;
                        }
                    }
                }
            }

            if (y == null)
            {
                throw new IllegalArgumentException("Invalid point compression");
            }

            return this.createRawPoint(x, y, true);
        }

        /**
         * Solves a quadratic equation <code>z<sup>2</sup> + z = beta</code>(X9.62
         * D.1.6) The other solution is <code>z + 1</code>.
         *
         * @param beta
         *            The value to solve the quadratic equation for.
         * @return the solution for <code>z<sup>2</sup> + z = beta</code> or
         *         <code>null</code> if no solution exists.
         */
        ECFieldElement solveQuadraticEquation(ECFieldElement beta) throws CloneNotSupportedException {
            if (beta.isZero())
            {
                return beta;
            }

            ECFieldElement gamma, z, zeroElement = this.fromBigInteger(ECConstants.ZERO);

            int m = this.getFieldSize();
            Random rand = new Random();
            do
            {
                ECFieldElement t = this.fromBigInteger(new BigInteger(m, rand));
                z = zeroElement;
                ECFieldElement w = beta;
                for (int i = 1; i < m; i++)
                {
                    ECFieldElement w2 = w.square();
                    z = z.square().add(w2.multiply(t));
                    w = w2.add(beta);
                }
                if (!w.isZero())
                {
                    return null;
                }
                gamma = z.square().add(z);
            }
            while (gamma.isZero());

            return z;
        }

    }

    /**
     * Elliptic curves over F2m. The Weierstrass equation is given by
     * <code>y<sup>2</sup> + xy = x<sup>3</sup> + ax<sup>2</sup> + b</code>.
     */
    public static class F2m extends AbstractF2m
    {
        private static final int F2M_DEFAULT_COORDS = ECCurve.COORD_LAMBDA_PROJECTIVE;

        /**
         * The exponent <code>m</code> of <code>F<sub>2<sup>m</sup></sub></code>.
         */
        private final int m;  // can't be final - JDK 1.1

        /**
         * TPB: The integer <code>k</code> where <code>x<sup>m</sup> +
         * x<sup>k</sup> + 1</code> represents the reduction polynomial
         * <code>f(z)</code>.<br>
         * PPB: The integer <code>k1</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.<br>
         */
        private final int k1;  // can't be final - JDK 1.1

        /**
         * TPB: Always set to <code>0</code><br>
         * PPB: The integer <code>k2</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.<br>
         */
        private final int k2;  // can't be final - JDK 1.1

        /**
         * TPB: Always set to <code>0</code><br>
         * PPB: The integer <code>k3</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.<br>
         */
        private final int k3;  // can't be final - JDK 1.1

        /**
         * The point at infinity on this curve.
         */
        private final ECPoint.F2m infinity;  // can't be final - JDK 1.1

        /**
         * Constructor for Trinomial Polynomial Basis (TPB).
         * @param m  The exponent <code>m</code> of
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param k The integer <code>k</code> where <code>x<sup>m</sup> +
         * x<sup>k</sup> + 1</code> represents the reduction
         * polynomial <code>f(z)</code>.
         * @param a The coefficient <code>a</code> in the Weierstrass equation
         * for non-supersingular elliptic curves over
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param b The coefficient <code>b</code> in the Weierstrass equation
         * for non-supersingular elliptic curves over
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @deprecated use constructor taking order/cofactor
         */
        public F2m(
                int m,
                int k,
                BigInteger a,
                BigInteger b)
        {
            this(m, k, 0, 0, a, b, null);
        }

        /**
         * Constructor for Pentanomial Polynomial Basis (PPB).
         * @param m  The exponent <code>m</code> of
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param k1 The integer <code>k1</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.
         * @param k2 The integer <code>k2</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.
         * @param k3 The integer <code>k3</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.
         * @param a The coefficient <code>a</code> in the Weierstrass equation
         * for non-supersingular elliptic curves over
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param b The coefficient <code>b</code> in the Weierstrass equation
         * for non-supersingular elliptic curves over
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @deprecated use constructor taking order/cofactor
         */
        public F2m(
                int m,
                int k1,
                int k2,
                int k3,
                BigInteger a,
                BigInteger b)
        {
            this(m, k1, k2, k3, a, b, null);
        }

        /**
         * Constructor for Pentanomial Polynomial Basis (PPB).
         * @param m  The exponent <code>m</code> of
         * <code>F<sub>2<sup>m</sup></sub></code>.
         * @param k1 The integer <code>k1</code> where <code>x<sup>m</sup> +
         * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
         * represents the reduction polynomial <code>f(z)</code>.
         * @param k2 The integer <code>k2</code> where <code>x<sup>m</sup> +
 * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
 * represents the reduction polynomial <code>f(z)</code>.
         * @param k3 The integer <code>k3</code> where <code>x<sup>m</sup> +
* x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
* represents the reduction polynomial <code>f(z)</code>.
         * @param a The coefficient <code>a</code> in the Weierstrass equation
* for non-supersingular elliptic curves over
* <code>F<sub>2<sup>m</sup></sub></code>.
         * @param b The coefficient <code>b</code> in the Weierstrass equation
* for non-supersingular elliptic curves over
* <code>F<sub>2<sup>m</sup></sub></code>.
         * @param order The order of the main subgroup of the elliptic curve.
         */
        F2m(
                int m,
                int k1,
                int k2,
                int k3,
                BigInteger a,
                BigInteger b,
                BigInteger order)
        {
            super(m, k1, k2, k3);

            this.m = m;
            this.k1 = k1;
            this.k2 = k2;
            this.k3 = k3;
            this.order = order;
            this.cofactor = null;

            this.infinity = new ECPoint.F2m(this, null, null, false);
            this.a = fromBigInteger(a);
            this.b = fromBigInteger(b);
            this.coord = F2M_DEFAULT_COORDS;
        }

        F2m(int m, int k1, int k2, int k3, ECFieldElement a, ECFieldElement b, BigInteger order, BigInteger cofactor)
        {
            super(m, k1, k2, k3);

            this.m = m;
            this.k1 = k1;
            this.k2 = k2;
            this.k3 = k3;
            this.order = order;
            this.cofactor = cofactor;

            this.infinity = new ECPoint.F2m(this, null, null, false);
            this.a = a;
            this.b = b;
            this.coord = F2M_DEFAULT_COORDS;
        }

        protected ECCurve cloneCurve()
        {
            return new F2m(this.m, this.k1, this.k2, this.k3, this.a, this.b, this.order, this.cofactor);
        }

        public boolean supportsCoordinateSystem(int coord)
        {
            switch (coord)
            {
                case ECCurve.COORD_AFFINE:
                case ECCurve.COORD_HOMOGENEOUS:
                case ECCurve.COORD_LAMBDA_PROJECTIVE:
                    return true;
                default:
                    return false;
            }
        }

        public int getFieldSize()
        {
            return m;
        }

        public ECFieldElement fromBigInteger(BigInteger x)
        {
            return new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, x);
        }

        protected ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, boolean withCompression)
        {
            return new ECPoint.F2m(this, x, y, withCompression);
        }

        protected ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, ECFieldElement[] zs, boolean withCompression)
        {
            return new ECPoint.F2m(this, x, y, zs, withCompression);
        }

        public ECPoint getInfinity()
        {
            return infinity;
        }

        /**
         * Return true if curve uses a Trinomial basis.
         *
         * @return true if curve Trinomial, false otherwise.
         */
        boolean isTrinomial()
        {
            return k2 == 0 && k3 == 0;
        }

        public ECLookupTable createCacheSafeLookupTable(ECPoint[] points, int off, final int len)
        {
            final int FE_LONGS = (m + 63) >>> 6;
            final int[] ks = isTrinomial() ? new int[]{ k1 } : new int[]{ k1, k2, k3 };

            final long[] table = new long[len * FE_LONGS * 2];
            {
                int pos = 0;
                for (int i = 0; i < len; ++i)
                {
                    ECPoint p = points[off + i];
                    ((ECFieldElement.F2m)p.getRawXCoord()).x.copyTo(table, pos); pos += FE_LONGS;
                    ((ECFieldElement.F2m)p.getRawYCoord()).x.copyTo(table, pos); pos += FE_LONGS;
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
                    long[] x = Nat.create64(FE_LONGS), y = Nat.create64(FE_LONGS);
                    int pos = 0;

                    for (int i = 0; i < len; ++i)
                    {
                        long MASK = ((i ^ index) - 1) >> 31;

                        for (int j = 0; j < FE_LONGS; ++j)
                        {
                            x[j] ^= table[pos + j] & MASK;
                            y[j] ^= table[pos + FE_LONGS + j] & MASK;
                        }

                        pos += (FE_LONGS * 2);
                    }

                    return createRawPoint(new ECFieldElement.F2m(m, ks, new LongArray(x)), new ECFieldElement.F2m(m, ks, new LongArray(y)), false);
                }
            };
        }
    }
}