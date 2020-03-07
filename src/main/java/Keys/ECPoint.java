package Keys;

import java.util.HashMap;

//checkpoint clean
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

            default:
        }
        return null;
    }

    final ECCurve curve;
    final ECFieldElement x;
    final ECFieldElement y;
    final ECFieldElement[] zs;

    boolean withCompression;

    
    HashMap preCompTable;

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






    ECCurve getCurve()
    {
        return curve;
    }

    private int getCurveCoordinateSystem()
    {
        
        return curve == null ? ECCurve.COORD_AFFINE : curve.getCoordinateSystem();
    }



    
    ECFieldElement getXCoord()
    {
        return x;
    }

    
    ECFieldElement getYCoord() {
        return y;
    }

    ECFieldElement getZCoord(int index)
    {
        return (0 >= zs.length) ? null : zs[index];
    }

    final ECFieldElement getRawXCoord()
    {
        return x;
    }

    final ECFieldElement getRawYCoord()
    {
        return y;
    }


    boolean isNormalized()
    {
        int coord = this.getCurveCoordinateSystem();

        return coord != ECCurve.COORD_AFFINE
                && coord != ECCurve.COORD_LAMBDA_AFFINE
                && !isInfinity()
                && !zs[0].isOne();
    }

    
    ECPoint normalize() {


        ECFieldElement Z1 = getZCoord(0);
        return Z1.isOne() ? this : normalize(Z1.invert());
    }

    ECPoint normalize(ECFieldElement zInv)
    {
        switch (this.getCurveCoordinateSystem())
        {
            case ECCurve.COORD_HOMOGENEOUS:
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

    boolean isInfinity()
    {
        return x == null || y == null || (zs.length > 0 && zs[0].isZero());
    }


    public abstract ECPoint add(ECPoint b);

    public abstract ECPoint negate();

    public abstract ECPoint subtract(ECPoint b);

    protected abstract ECPoint twice();


}
