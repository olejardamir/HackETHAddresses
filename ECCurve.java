import java.util.Hashtable;
import java.math.BigInteger;

// 
// Decompiled by Procyon v0.5.36
// 

public abstract class ECCurve
{
    public static final int COORD_AFFINE = 0;
    public static final int COORD_HOMOGENEOUS = 1;
    public static final int COORD_JACOBIAN = 2;
    public static final int COORD_JACOBIAN_CHUDNOVSKY = 3;
    public static final int COORD_JACOBIAN_MODIFIED = 4;
    public static final int COORD_LAMBDA_AFFINE = 5;
    public static final int COORD_LAMBDA_PROJECTIVE = 6;
    private PrimeField field;
    ECFieldElement a;
    ECFieldElement b;
    BigInteger order;
    int coord;
    private FixedPointCombMultiplier multiplier;
    
    public ECCurve() {
        this.coord = 0;
        this.multiplier = null;
    }
    
    ECCurve(final PrimeField field) {
        this.coord = 0;
        this.multiplier = null;
        this.field = field;
    }
    
    public abstract int getFieldSize();
    
    public abstract ECFieldElement fromBigInteger(final BigInteger p0);
    
    public synchronized Config configure() {
        return new Config(this.coord);
    }
    
    private ECPoint validatePoint(final BigInteger x, final BigInteger y) {
        return this.createPoint(x, y);
    }
    
    private ECPoint createPoint(final BigInteger x, final BigInteger y) {
        return this.createPoint(x, y, false);
    }
    
    public ECPoint createPoint(final BigInteger x, final BigInteger y, final boolean withCompression) {
        return this.createRawPoint(this.fromBigInteger(x), this.fromBigInteger(y), withCompression);
    }
    
    protected abstract ECCurve cloneCurve() throws Exception;
    
    protected abstract ECPoint createRawPoint(final ECFieldElement p0, final ECFieldElement p1, final boolean p2);
    
    public FixedPointPreCompInfo precompute(final ECPoint point, final String name, final PreCompCallback callback) {
        Hashtable table = point.preCompTable;
        if (null == table) {
            table = (point.preCompTable = new Hashtable(4));
        }
        final FixedPointPreCompInfo existing = table.get(name);
        final FixedPointPreCompInfo result = callback.precompute(existing);
        if (result != existing) {
            table.put(name, result);
        }
        return result;
    }
    
    public ECPoint importPoint(ECPoint p) {
        if (this == p.getCurve()) {
            return p;
        }
        if (p.isInfinity()) {
            return this.getInfinity();
        }
        p = p.normalize();
        return this.createPoint(p.getXCoord().toBigInteger(), p.getYCoord().toBigInteger(), p.withCompression);
    }
    
    public void normalizeAll(final ECPoint[] points) {
        this.normalizeAll(points, points.length);
    }
    
    private void normalizeAll(final ECPoint[] points, final int len) {
        switch (this.getCoordinateSystem()) {
            case 0:
            case 5: {}
            default: {
                final ECFieldElement[] zs = new ECFieldElement[len];
                final int[] indices = new int[len];
                int count = 0;
                for (int i = 0; i < len; ++i) {
                    final ECPoint p = points[i];
                    if (null != p && p.isNormalized()) {
                        zs[count] = p.getZCoord(0);
                        indices[count++] = i;
                    }
                }
                if (count == 0) {
                    return;
                }
                ECAlgorithms.montgomeryTrick(zs, 0, count);
                for (int j = 0; j < count; ++j) {
                    final int index = indices[j];
                    points[index] = points[index].normalize(zs[j]);
                }
            }
        }
    }
    
    public abstract ECPoint getInfinity();
    
    public PrimeField getField() {
        return this.field;
    }
    
    public ECFieldElement getA() {
        return this.a;
    }
    
    public ECFieldElement getB() {
        return this.b;
    }
    
    public BigInteger getOrder() {
        return this.order;
    }
    
    public int getCoordinateSystem() {
        return this.coord;
    }
    
    protected abstract ECPoint decompressPoint(final int p0, final BigInteger p1);
    
    public ECPoint decodePoint(final byte[] encoded) {
        ECPoint p = null;
        final int expectedLength = (this.getFieldSize() + 7) / 8;
        final byte type = encoded[0];
        switch (type) {
            case 0: {
                p = this.getInfinity();
                break;
            }
            case 2:
            case 3: {
                final int yTilde = type & 0x1;
                final BigInteger X = BigIntegers.fromUnsignedByteArray(encoded, 1, expectedLength);
                p = this.decompressPoint(yTilde, X);
                break;
            }
            case 4:
            case 6:
            case 7: {
                final BigInteger X2 = BigIntegers.fromUnsignedByteArray(encoded, 1, expectedLength);
                final BigInteger Y = BigIntegers.fromUnsignedByteArray(encoded, 1 + expectedLength, expectedLength);
                p = this.validatePoint(X2, Y);
                break;
            }
        }
        return p;
    }
    
    public ECLookupTable createCacheSafeLookupTable(final ECPoint[] points, final int off, final int len) {
        final int FE_BYTES = this.getFieldSize() + 7 >>> 3;
        final byte[] table = new byte[len * FE_BYTES * 2];
        int pos = 0;
        for (int i = 0; i < len; ++i) {
            final ECPoint p = points[off + i];
            final byte[] px = p.getRawXCoord().toBigInteger().toByteArray();
            final byte[] py = p.getRawYCoord().toBigInteger().toByteArray();
            final int pxStart = (px.length > FE_BYTES) ? 1 : 0;
            final int pxLen = px.length - pxStart;
            final int pyStart = (py.length > FE_BYTES) ? 1 : 0;
            final int pyLen = py.length - pyStart;
            System.arraycopy(px, pxStart, table, pos + FE_BYTES - pxLen, pxLen);
            pos += FE_BYTES;
            System.arraycopy(py, pyStart, table, pos + FE_BYTES - pyLen, pyLen);
            pos += FE_BYTES;
        }
        return new ECLookupTable() {
            @Override
            public int getSize() {
                return len;
            }
            
            @Override
            public ECPoint lookup(final int index) {
                final byte[] x = new byte[FE_BYTES];
                final byte[] y = new byte[FE_BYTES];
                int pos = 0;
                for (int i = 0; i < len; ++i) {
                    final int MASK = (i ^ index) - 1 >> 31;
                    for (int j = 0; j < FE_BYTES; ++j) {
                        final byte[] array = x;
                        final int n = j;
                        array[n] ^= (byte)(table[pos + j] & MASK);
                        final byte[] array2 = y;
                        final int n2 = j;
                        array2[n2] ^= (byte)(table[pos + FE_BYTES + j] & MASK);
                    }
                    pos += FE_BYTES * 2;
                }
                return ECCurve.this.createRawPoint(ECCurve.this.fromBigInteger(new BigInteger(1, x)), ECCurve.this.fromBigInteger(new BigInteger(1, y)), false);
            }
        };
    }
    
    public boolean equals(final ECCurve other) {
        return this == other || (null != other && this.getField().equals(other.getField()) && this.getA().toBigInteger().equals(other.getA().toBigInteger()) && this.getB().toBigInteger().equals(other.getB().toBigInteger()));
    }
    
    @Override
    public boolean equals(final Object obj) {
        return this == obj || (obj instanceof ECCurve && this.equals((ECCurve)obj));
    }
    
    @Override
    public int hashCode() {
        return this.getField().hashCode() ^ Integer.rotateLeft(this.getA().toBigInteger().hashCode(), 8) ^ Integer.rotateLeft(this.getB().toBigInteger().hashCode(), 16);
    }
    
    public class Config
    {
        final int coord;
        
        Config(final int coord) {
            this.coord = coord;
        }
        
        public Config setEndomorphism() {
            return this;
        }
        
        public ECCurve create() throws Exception {
            final ECCurve c = ECCurve.this.cloneCurve();
            c.coord = this.coord;
            c.multiplier = ECCurve.this.multiplier;
            return c;
        }
    }
}
