
import java.math.BigInteger;
import java.util.Hashtable;


public abstract class ECPoint
{
    private final static ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];

    private static ECFieldElement[] getInitialZCoords(ECCurve curve)
    {
        
        int coord = null == curve ? ECCurve.COORD_AFFINE : curve.getCoordinateSystem();

        switch (coord)
        {
            case ECCurve.COORD_AFFINE:
            case ECCurve.COORD_LAMBDA_AFFINE:
                return EMPTY_ZS;
            default:
                break;
        }

        ECFieldElement one = curve.fromBigInteger(ECConstants.ONE);

        switch (coord)
        {
            case ECCurve.COORD_HOMOGENEOUS:
            case ECCurve.COORD_JACOBIAN:
            case ECCurve.COORD_LAMBDA_PROJECTIVE:
                return new ECFieldElement[]{ one };
            case ECCurve.COORD_JACOBIAN_CHUDNOVSKY:
                return new ECFieldElement[]{ one, one, one };
            case ECCurve.COORD_JACOBIAN_MODIFIED:
                return new ECFieldElement[]{ one, curve.getA() };
            default:
                throw new IllegalArgumentException("unknown coordinate system");
        }
    }

    final ECCurve curve;
    final ECFieldElement x;
    final ECFieldElement y;
    final ECFieldElement[] zs;

    boolean withCompression;

    
    Hashtable preCompTable = null;

    ECPoint(ECCurve curve, ECFieldElement x, ECFieldElement y)
    {
        this(curve, x, y, getInitialZCoords(curve));
    }

    ECPoint(ECCurve curve, ECFieldElement x, ECFieldElement y, ECFieldElement[] zs)
    {
        this.curve = curve;
        this.x = x;
        this.y = y;
        this.zs = zs;
    }

    protected abstract boolean satisfiesCurveEquation();














    public ECCurve getCurve()
    {
        return curve;
    }

    int getCurveCoordinateSystem()
    {
        
        return null == curve ? ECCurve.COORD_AFFINE : curve.getCoordinateSystem();
    }

    
    ECFieldElement getAffineYCoord() throws CloneNotSupportedException {
        checkNormalized();
        return getYCoord();
    }

    
    public ECFieldElement getXCoord()
    {
        return x;
    }

    
    public ECFieldElement getYCoord() {
        return y;
    }

    public ECFieldElement getZCoord(int index)
    {
        return (index < 0 || index >= zs.length) ? null : zs[index];
    }

    public final ECFieldElement getRawXCoord()
    {
        return x;
    }

    public final ECFieldElement getRawYCoord()
    {
        return y;
    }

    private void checkNormalized()
    {
        if (isNormalized())
        {
            throw new IllegalStateException("point not in normal form");
        }
    }

    public boolean isNormalized()
    {
        int coord = this.getCurveCoordinateSystem();

        return coord != ECCurve.COORD_AFFINE
                && coord != ECCurve.COORD_LAMBDA_AFFINE
                && !isInfinity()
                && !zs[0].isOne();
    }

    
    public ECPoint normalize() {
        if (this.isInfinity())
        {
            return this;
        }

        switch (this.getCurveCoordinateSystem())
        {
            case ECCurve.COORD_AFFINE:
            case ECCurve.COORD_LAMBDA_AFFINE:
            {
                return this;
            }
            default:
            {
                ECFieldElement Z1 = getZCoord(0);
                if (Z1.isOne())
                {
                    return this;
                }

                return normalize(Z1.invert());
            }
        }
    }

    ECPoint normalize(ECFieldElement zInv)
    {
        switch (this.getCurveCoordinateSystem())
        {
            case ECCurve.COORD_HOMOGENEOUS:
            case ECCurve.COORD_LAMBDA_PROJECTIVE:
            {
                return createScaledPoint(zInv, zInv);
            }
            case ECCurve.COORD_JACOBIAN:
            case ECCurve.COORD_JACOBIAN_CHUDNOVSKY:
            case ECCurve.COORD_JACOBIAN_MODIFIED:
            {
                ECFieldElement zInv2 = zInv.square(), zInv3 = zInv2.multiply(zInv);
                return createScaledPoint(zInv2, zInv3);
            }
            default:
            {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
    }

    private ECPoint createScaledPoint(ECFieldElement sx, ECFieldElement sy)
    {
        return this.getCurve().createRawPoint(getRawXCoord().multiply(sx), getRawYCoord().multiply(sy), this.withCompression);
    }

    public boolean isInfinity()
    {
        return x == null || y == null || (zs.length > 0 && zs[0].isZero());
    }



    public boolean isValid() throws CloneNotSupportedException {
        return !implIsValid(false, true);
    }

    boolean isValidPartial() throws CloneNotSupportedException {
        return implIsValid(false, false);
    }

    boolean implIsValid(final boolean decompressed, final boolean checkOrder) throws CloneNotSupportedException {
        if (isInfinity())
        {
            return true;
        }

        ValidityPrecompInfo validity = (ValidityPrecompInfo)getCurve().precompute(this, ValidityPrecompInfo.PRECOMP_NAME, new PreCompCallback()
        {
            public PreCompInfo precompute(PreCompInfo existing) {
                ValidityPrecompInfo info = (existing instanceof ValidityPrecompInfo) ? (ValidityPrecompInfo)existing : null;
                if (info == null)
                {
                    info = new ValidityPrecompInfo();
                }

                if (info.hasFailed())
                {
                    return info;
                }
                if (!info.hasCurveEquationPassed())
                {
                    if (!decompressed && !satisfiesCurveEquation())
                    {
                        info.reportFailed();
                        return info;
                    }
                    info.reportCurveEquationPassed();
                }
                if (checkOrder && !info.hasOrderPassed())
                {





                    info.reportOrderPassed();
                }
                return info;
            }
        });

        return !validity.hasFailed();
    }

    public boolean equals(ECPoint other) throws CloneNotSupportedException {
        if (null == other)
        {
            return false;
        }

        ECCurve c1 = this.getCurve(), c2 = other.getCurve();
        boolean n1 = (null == c1), n2 = (null == c2);
        boolean i1 = isInfinity(), i2 = other.isInfinity();

        if (i1 || i2)
        {
            return (i1 && i2) && (n1 || n2 || c1.equals(c2));
        }

        ECPoint p1 = this, p2 = other;

          if (n1)
        {
            p2 = p2.normalize();
        }
        else if (n2)
        {
            p1 = p1.normalize();
        }
        else if (!c1.equals(c2))
        {
            return false;
        }
        else
        {
            

            ECPoint[] points = new ECPoint[]{ this, c1.importPoint(p2) };

            
            c1.normalizeAll(points);

            p1 = points[0];
            p2 = points[1];
        }

        return p1.getXCoord().equals(p2.getXCoord()) && p1.getYCoord().equals(p2.getYCoord());
    }

    public boolean equals(Object other)
    {
        if (other == this)
        {
            return true;
        }

        if (!(other instanceof ECPoint))
        {
            return false;
        }

        try {
            return equals((ECPoint)other);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int hashCode()
    {
        ECCurve c = this.getCurve();
        int hc = (null == c) ? 0 : ~c.hashCode();

        if (!this.isInfinity())
        {
            

            ECPoint p = null;
                 p = normalize();


            assert p != null;
            hc ^= p.getXCoord().hashCode() * 17;

                hc ^= p.getYCoord().hashCode() * 257;

        }

        return hc;
    }

    public String toString()
    {
        if (this.isInfinity())
        {
            return "INF";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(getRawXCoord());
        sb.append(',');
        sb.append(getRawYCoord());
        for (ECFieldElement z : zs) {
            sb.append(',');
            sb.append(z);
        }
        sb.append(')');
        return sb.toString();
    }

    

    
    public byte[] getEncoded(boolean compressed) throws CloneNotSupportedException {
        if (this.isInfinity())
        {
            return new byte[1];
        }

        ECPoint normed = normalize();

        byte[] X = normed.getXCoord().getEncoded();

        if (compressed)
        {
            byte[] PO = new byte[X.length + 1];
            PO[0] = (byte)(normed.getCompressionYTilde() ? 0x03 : 0x02);
            System.arraycopy(X, 0, PO, 1, X.length);
            return PO;
        }

        byte[] Y = normed.getYCoord().getEncoded();

        byte[] PO = new byte[X.length + Y.length + 1];
        PO[0] = 0x04;
        System.arraycopy(X, 0, PO, 1, X.length);
        System.arraycopy(Y, 0, PO, X.length + 1, Y.length);
        return PO;
    }

    protected abstract boolean getCompressionYTilde() throws CloneNotSupportedException;

    public abstract ECPoint add(ECPoint b) throws CloneNotSupportedException;

    public abstract ECPoint negate();

    public abstract ECPoint subtract(ECPoint b) throws CloneNotSupportedException;

    public ECPoint timesPow2(int e) throws CloneNotSupportedException {
        if (e < 0)
        {
            throw new IllegalArgumentException("'e' cannot be negative");
        }

        ECPoint p = this;
        while (--e >= 0)
        {
            p = p.twice();
        }
        return p;
    }

    public abstract ECPoint twice() throws CloneNotSupportedException;

    public ECPoint twicePlus(ECPoint b) throws CloneNotSupportedException {
        return twice().add(b);
    }

    public static abstract class AbstractFp extends ECPoint
    {
        AbstractFp(ECCurve curve, ECFieldElement x, ECFieldElement y)
        {
            super(curve, x, y);
        }

        AbstractFp(ECCurve curve, ECFieldElement x, ECFieldElement y, ECFieldElement[] zs)
        {
            super(curve, x, y, zs);
        }

        protected boolean getCompressionYTilde() throws CloneNotSupportedException {
            return this.getAffineYCoord().testBitZero();
        }

        protected boolean satisfiesCurveEquation() {
            ECFieldElement X = this.x, A = curve.getA(), B = curve.getB();
            ECFieldElement lhs = this.y.square();

            switch (this.getCurveCoordinateSystem())
            {
                case ECCurve.COORD_AFFINE:
                    break;
                case ECCurve.COORD_HOMOGENEOUS:
                {
                    ECFieldElement Z = this.zs[0];
                    if (!Z.isOne())
                    {
                        ECFieldElement Z2 = Z.square(), Z3 = Z.multiply(Z2);
                        lhs = lhs.multiply(Z);
                        A = A.multiply(Z2);
                        B = B.multiply(Z3);
                    }
                    break;
                }
                case ECCurve.COORD_JACOBIAN:
                case ECCurve.COORD_JACOBIAN_CHUDNOVSKY:
                case ECCurve.COORD_JACOBIAN_MODIFIED:
                {
                    ECFieldElement Z = this.zs[0];
                    if (!Z.isOne())
                    {
                        ECFieldElement Z2 = Z.square(), Z4 = Z2.square(), Z6 = Z2.multiply(Z4);
                        A = A.multiply(Z4);
                        B = B.multiply(Z6);
                    }
                    break;
                }
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }

            ECFieldElement rhs = X.square().add(A).multiply(X).add(B);
            return lhs.equals(rhs);
        }

        public ECPoint subtract(ECPoint b) throws CloneNotSupportedException {
            if (b.isInfinity())
            {
                return this;
            }

            
            return this.add(b.negate());
        }
    }


}
