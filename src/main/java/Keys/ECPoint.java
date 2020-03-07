package Keys;

import java.util.HashMap;

//checkpoint clean
public abstract class ECPoint {
    private static final ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];
    final ECCurve curve;
    final ECFieldElement x;
    final ECFieldElement y;
    final ECFieldElement[] zs;
    boolean withCompression;
    HashMap preCompTable;


    ECPoint(ECCurve curve, ECFieldElement x, ECFieldElement y) {
        this(curve, x, y, getInitialZCoords(curve));
    }

    ECPoint(ECCurve curve, ECFieldElement x, ECFieldElement y, ECFieldElement[] zs) {
        this.curve = curve;
        this.x = x;
        this.y = y;
        this.zs = zs;
    }

    private static ECFieldElement[] getInitialZCoords(ECCurve curve) {

        int coord = curve == null ? ECCurve.COORD_AFFINE : curve.coord;

        switch (coord) {
            case ECCurve.COORD_AFFINE:
            case ECCurve.COORD_LAMBDA_AFFINE:
                return EMPTY_ZS;
            default:
                break;
        }

        ECFieldElement one = curve.fromBigInteger(ECFieldElement.ONE);

        switch (coord) {
            case ECCurve.COORD_HOMOGENEOUS:
            case ECCurve.COORD_JACOBIAN:
            case ECCurve.COORD_LAMBDA_PROJECTIVE:
                return new ECFieldElement[]{one};

            default:
        }
        return null;
    }

    boolean isNormalized() {

        int coord = curve == null ? ECCurve.COORD_AFFINE : curve.coord;

        return coord != ECCurve.COORD_AFFINE
                && coord != ECCurve.COORD_LAMBDA_AFFINE
                && !(x == null || y == null || (zs.length > 0 && zs[0].toBigInteger().signum() == 0))
                && !(zs[0].toBigInteger().bitLength() == 1);
    }


    ECPoint normalize(ECFieldElement zInv) {

        switch (curve == null ? ECCurve.COORD_AFFINE : curve.coord) {
            case ECCurve.COORD_HOMOGENEOUS:
            case ECCurve.COORD_JACOBIAN:
            case ECCurve.COORD_JACOBIAN_CHUDNOVSKY:
            case ECCurve.COORD_JACOBIAN_MODIFIED: {
                ECFieldElement zInv2 = zInv.square();
                return createScaledPoint(zInv2, zInv2.multiply(zInv));
            }
            default: {

            }
        }
        return null;
    }

    private ECPoint createScaledPoint(ECFieldElement sx, ECFieldElement sy) {
        return curve.createRawPoint(x.multiply(sx), y.multiply(sy), this.withCompression);
    }


    public abstract ECPoint add(ECPoint b);

    public abstract ECPoint negate();

    public abstract ECPoint subtract(ECPoint b);

    ECPoint timesPow2(int e) {
        ECPoint p = this;
        while (--e >= 0)
            p = p.twice();
        return p;
    }

    protected abstract ECPoint twice();

    public ECPoint twicePlus(ECPoint b) {
        return null;
    }


}
