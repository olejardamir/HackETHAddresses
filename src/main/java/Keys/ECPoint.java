package Keys;

import java.util.Hashtable;


public abstract class ECPoint
{
    private static final ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];

    private static ECFieldElement[] getInitialZCoords(ECCurve curve)
    {
        
        int coord = curve == null ? ECCurve.COORD_AFFINE : curve.getCoordinateSystem();

        switch (coord)
        {
            case ECCurve.COORD_AFFINE:
            case ECCurve.COORD_LAMBDA_AFFINE:
                return EMPTY_ZS;
            default:
                break;
        }

        ECFieldElement one = curve.fromBigInteger(ECFieldElement.ONE);

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
        }
        return null;
    }

    final ECCurve curve;
    final ECFieldElement x;
    final ECFieldElement y;
    final ECFieldElement[] zs;

    boolean withCompression;

    
    Hashtable preCompTable;

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






    public ECCurve getCurve()
    {
        return curve;
    }

    int getCurveCoordinateSystem()
    {
        
        return curve == null ? ECCurve.COORD_AFFINE : curve.getCoordinateSystem();
    }

    
    ECFieldElement getAffineYCoord() {
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
			return this;

        switch (this.getCurveCoordinateSystem())
        {
            case ECCurve.COORD_AFFINE:
            case ECCurve.COORD_LAMBDA_AFFINE:
            return this;
            default:
            {
				ECFieldElement Z1 = getZCoord(0);
				return Z1.isOne() ? this : normalize(Z1.invert());
			}
        }
    }

    ECPoint normalize(ECFieldElement zInv)
    {
        switch (this.getCurveCoordinateSystem())
        {
            case ECCurve.COORD_HOMOGENEOUS:
            case ECCurve.COORD_LAMBDA_PROJECTIVE:
            return createScaledPoint(zInv, zInv);
            case ECCurve.COORD_JACOBIAN:
            case ECCurve.COORD_JACOBIAN_CHUDNOVSKY:
            case ECCurve.COORD_JACOBIAN_MODIFIED:
            {
                ECFieldElement zInv2 = zInv.square();
                return createScaledPoint(zInv2, zInv2.multiply(zInv));
            }
            default:
            {

            }
        }
        return null;
    }

    private ECPoint createScaledPoint(ECFieldElement sx, ECFieldElement sy)
    {
        return this.getCurve().createRawPoint(getRawXCoord().multiply(sx), getRawYCoord().multiply(sy), this.withCompression);
    }

    public boolean isInfinity()
    {
        return x == null || y == null || (zs.length > 0 && zs[0].isZero());
    }



    

    
    public byte[] getEncoded(boolean compressed) {
        if (this.isInfinity())
			return new byte[1];

        ECPoint normed = normalize();

        byte[] X = normed.getXCoord().getEncoded();

        if (compressed)
        {
            byte[] PO = new byte[X.length + 1];
            PO[0] = (byte)(normed.getCompressionYTilde() ? 0x03 : 0x02);
            System.arraycopy(X, 0, PO, 1, X.length);
            return PO;
        }

        byte[] Y = normed.getYCoord().getEncoded(), PO = new byte[X.length + Y.length + 1];

        PO[0] = 0x04;
        System.arraycopy(X, 0, PO, 1, X.length);
        System.arraycopy(Y, 0, PO, X.length + 1, Y.length);
        return PO;
    }

    protected abstract boolean getCompressionYTilde();

    public abstract ECPoint add(ECPoint b);

    public abstract ECPoint negate();

    public abstract ECPoint subtract(ECPoint b);

    public ECPoint timesPow2(int e) {


        ECPoint p = this;
        while (--e >= 0)
			p = p.twice();
        return p;
    }

    public abstract ECPoint twice();

    public ECPoint twicePlus(ECPoint b) {
        return twice().add(b);
    }


}
