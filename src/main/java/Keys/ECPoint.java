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






    public ECCurve getCurve()
    {
        return curve;
    }

    int getCurveCoordinateSystem()
    {
        
        return curve == null ? ECCurve.COORD_AFFINE : curve.getCoordinateSystem();
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


        switch (this.getCurveCoordinateSystem())
        {
            case ECCurve.COORD_AFFINE:

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



    

    
    public byte[] getEncoded() {


        ECPoint normed = normalize();

        byte[] X = normed.getXCoord().getEncoded();



        byte[] Y = normed.getYCoord().getEncoded(), PO = new byte[X.length + Y.length + 1];

        PO[0] = 0x04;
        System.arraycopy(X, 0, PO, 1, X.length);
        System.arraycopy(Y, 0, PO, X.length + 1, Y.length);
        return PO;
    }


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
        return null;
    }


}
