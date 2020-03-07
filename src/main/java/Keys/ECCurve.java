package Keys;

import java.math.BigInteger;

//Done checkpoint clean
public abstract class ECCurve {
    public static final int COORD_AFFINE = 0;
    public static final int COORD_HOMOGENEOUS = 1;
    public static final int COORD_JACOBIAN = 2;
    public static final int COORD_JACOBIAN_CHUDNOVSKY = 3;
    public static final int COORD_JACOBIAN_MODIFIED = 4;
    public static final int COORD_LAMBDA_AFFINE = 5;
    public static final int COORD_LAMBDA_PROJECTIVE = 6;
    BigInteger order;
    int coord = COORD_AFFINE;


    ECCurve() {

    }

    public abstract int getFieldSize();

    public abstract ECFieldElement fromBigInteger(BigInteger x);

    public synchronized Config configure() {
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

        public ECCurve create() throws Exception {
            ECCurve c = cloneCurve();
            c.coord = coord;
            return c;
        }
    }
}
