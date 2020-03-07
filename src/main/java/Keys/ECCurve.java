package Keys;

import java.math.BigInteger;

//Done checkpoint clean
public abstract class ECCurve {
    static final int COORD_AFFINE = 0;
    static final int COORD_HOMOGENEOUS = 1;
    static final int COORD_JACOBIAN = 2;
    static final int COORD_JACOBIAN_CHUDNOVSKY = 3;
    static final int COORD_JACOBIAN_MODIFIED = 4;
    static final int COORD_LAMBDA_AFFINE = 5;
    static final int COORD_LAMBDA_PROJECTIVE = 6;
    BigInteger order;
    int coord = COORD_AFFINE;


    ECCurve() {

    }

    public abstract int getFieldSize();

    public abstract ECFieldElement fromBigInteger(BigInteger x);

    synchronized Config configure() {
        return new Config(this.coord);
    }

    protected abstract ECCurve cloneCurve() throws Exception;

    protected abstract ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, boolean withCompression);

    public abstract ECPoint getInfinity();

    public ECLookupTable createCacheSafeLookupTable(final ECPoint[] points, int off, final int len) {
        return null;
    }

    public class Config {
        final int coord;

        Config(int coord) {
            this.coord = coord;
        }

        ECCurve create() throws Exception {
            ECCurve c = cloneCurve();
            c.coord = coord;
            return c;
        }
    }
}
