import java.util.Hashtable;

// 
// Decompiled by Procyon v0.5.36
// 

public abstract class ECPoint
{
    private static final ECFieldElement[] EMPTY_ZS;
    final ECCurve curve;
    final ECFieldElement x;
    final ECFieldElement y;
    final ECFieldElement[] zs;
    boolean withCompression;
    Hashtable preCompTable;
    
    ECPoint(final ECCurve curve, final ECFieldElement x, final ECFieldElement y) {
        this(curve, x, y, getInitialZCoords(curve));
    }
    
    ECPoint(final ECCurve curve, final ECFieldElement x, final ECFieldElement y, final ECFieldElement[] zs) {
        this.preCompTable = null;
        this.curve = curve;
        this.x = x;
        this.y = y;
        this.zs = zs;
    }
    
    private static ECFieldElement[] getInitialZCoords(final ECCurve curve) {
        final int coord = (null == curve) ? 0 : curve.getCoordinateSystem();
        switch (coord) {
            case 0:
            case 5: {
                return ECPoint.EMPTY_ZS;
            }
            default: {
                final ECFieldElement one = curve.fromBigInteger(ECFieldElement.ONE);
                switch (coord) {
                    case 1:
                    case 2:
                    case 6: {
                        return new ECFieldElement[] { one };
                    }
                    case 3: {
                        return new ECFieldElement[] { one, one, one };
                    }
                    case 4: {
                        return new ECFieldElement[] { one, curve.getA() };
                    }
                    default: {
                        return null;
                    }
                }
            }
        }
    }
    
    public ECCurve getCurve() {
        return this.curve;
    }
    
    int getCurveCoordinateSystem() {
        return (null == this.curve) ? 0 : this.curve.getCoordinateSystem();
    }
    
    public ECFieldElement getXCoord() {
        return this.x;
    }
    
    public ECFieldElement getYCoord() {
        return this.y;
    }
    
    public ECFieldElement getZCoord(final int index) {
        return (index < 0 || index >= this.zs.length) ? null : this.zs[index];
    }
    
    public final ECFieldElement getRawXCoord() {
        return this.x;
    }
    
    public final ECFieldElement getRawYCoord() {
        return this.y;
    }
    
    public boolean isNormalized() {
        final int coord = this.getCurveCoordinateSystem();
        return coord != 0 && coord != 5 && !this.isInfinity() && !this.zs[0].isOne();
    }
    
    public ECPoint normalize() {
        if (this.isInfinity()) {
            return this;
        }
        switch (this.getCurveCoordinateSystem()) {
            case 0:
            case 5: {
                return this;
            }
            default: {
                final ECFieldElement Z1 = this.getZCoord(0);
                if (Z1.isOne()) {
                    return this;
                }
                return this.normalize(Z1.invert());
            }
        }
    }
    
    ECPoint normalize(final ECFieldElement zInv) {
        switch (this.getCurveCoordinateSystem()) {
            case 1:
            case 6: {
                return this.createScaledPoint(zInv, zInv);
            }
            case 2:
            case 3:
            case 4: {
                final ECFieldElement zInv2 = zInv.square();
                final ECFieldElement zInv3 = zInv2.multiply(zInv);
                return this.createScaledPoint(zInv2, zInv3);
            }
            default: {
                return null;
            }
        }
    }
    
    private ECPoint createScaledPoint(final ECFieldElement sx, final ECFieldElement sy) {
        return this.getCurve().createRawPoint(this.getRawXCoord().multiply(sx), this.getRawYCoord().multiply(sy), this.withCompression);
    }
    
    public boolean isInfinity() {
        return this.x == null || this.y == null || (this.zs.length > 0 && this.zs[0].isZero());
    }
    
    public boolean equals(final ECPoint other) {
        if (null == other) {
            return false;
        }
        final ECCurve c1 = this.getCurve();
        final ECCurve c2 = other.getCurve();
        final boolean n1 = null == c1;
        final boolean n2 = null == c2;
        final boolean i1 = this.isInfinity();
        final boolean i2 = other.isInfinity();
        if (i1 || i2) {
            return i1 && i2 && (n1 || n2 || c1.equals(c2));
        }
        ECPoint p1 = this;
        ECPoint p2 = other;
        if (n1) {
            p2 = p2.normalize();
        }
        else if (n2) {
            p1 = p1.normalize();
        }
        else {
            if (!c1.equals(c2)) {
                return false;
            }
            final ECPoint[] points = { this, c1.importPoint(p2) };
            c1.normalizeAll(points);
            p1 = points[0];
            p2 = points[1];
        }
        return p1.getXCoord().equals(p2.getXCoord()) && p1.getYCoord().equals(p2.getYCoord());
    }
    
    @Override
    public boolean equals(final Object other) {
        return other == this || (other instanceof ECPoint && this.equals((ECPoint)other));
    }
    
    @Override
    public int hashCode() {
        final ECCurve c = this.getCurve();
        int hc = (null == c) ? 0 : (~c.hashCode());
        if (!this.isInfinity()) {
            final ECPoint p = this.normalize();
            assert p != null;
            hc ^= p.getXCoord().hashCode() * 17;
            hc ^= p.getYCoord().hashCode() * 257;
        }
        return hc;
    }
    
    @Override
    public String toString() {
        if (this.isInfinity()) {
            return "INF";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(this.getRawXCoord());
        sb.append(',');
        sb.append(this.getRawYCoord());
        for (final ECFieldElement z : this.zs) {
            sb.append(',');
            sb.append(z);
        }
        sb.append(')');
        return sb.toString();
    }
    
    public byte[] getEncoded(final boolean compressed) {
        if (this.isInfinity()) {
            return new byte[1];
        }
        final ECPoint normed = this.normalize();
        final byte[] X = normed.getXCoord().getEncoded();
        if (compressed) {
            final byte[] PO = new byte[X.length + 1];
            PO[0] = 2;
            System.arraycopy(X, 0, PO, 1, X.length);
            return PO;
        }
        final byte[] Y = normed.getYCoord().getEncoded();
        final byte[] PO2 = new byte[X.length + Y.length + 1];
        PO2[0] = 4;
        System.arraycopy(X, 0, PO2, 1, X.length);
        System.arraycopy(Y, 0, PO2, X.length + 1, Y.length);
        return PO2;
    }
    
    public abstract ECPoint add(final ECPoint p0);
    
    public abstract ECPoint negate();
    
    public abstract ECPoint subtract(final ECPoint p0);
    
    public ECPoint timesPow2(int e) {
        ECPoint p = this;
        while (--e >= 0) {
            p = p.twice();
        }
        return p;
    }
    
    public abstract ECPoint twice();
    
    public ECPoint twicePlus(final ECPoint b) {
        return this.twice().add(b);
    }
    
    static {
        EMPTY_ZS = new ECFieldElement[0];
    }
}
