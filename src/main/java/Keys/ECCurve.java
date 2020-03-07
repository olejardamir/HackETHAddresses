package Keys;
import java.math.BigInteger;

//Done checkpoint clean
public abstract class ECCurve
{
    public static final int COORD_AFFINE = 0;
    public static final int COORD_HOMOGENEOUS = 1;
    public static final int COORD_JACOBIAN = 2;
    public static final int COORD_JACOBIAN_CHUDNOVSKY = 3;
    public static final int COORD_JACOBIAN_MODIFIED = 4;
    public static final int COORD_LAMBDA_AFFINE = 5;
    public static final int COORD_LAMBDA_PROJECTIVE = 6;

    ECCurve() {

    }

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


            ECCurve c = cloneCurve();


                c.coord = coord;
                 c.multiplier = multiplier;


            return c;
        }
    }


    BigInteger order;

    int coord = COORD_AFFINE;
     private FixedPointCombMultiplier multiplier;



    public abstract int getFieldSize();

    public abstract ECFieldElement fromBigInteger(BigInteger x);

    public synchronized Config configure()
    {
        return new Config(this.coord);
    }


    private ECPoint createPoint(BigInteger x, BigInteger y)
    {
        return createPoint(x, y, false);
    }

    
    private ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression)
    {
        return createRawPoint(fromBigInteger(x), fromBigInteger(y), withCompression);
    }

    protected abstract ECCurve cloneCurve() throws Exception;

    protected abstract ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, boolean withCompression);


    public abstract ECPoint getInfinity();


    public ECPoint decodePoint(byte[] encoded) {
        ECPoint p = null;
        int expectedLength = (getFieldSize() + 7) / 8;

        byte type = encoded[0];
        switch (type)
        {
            case 0x00:
            case 0x02:
            case 0x03:
            case 0x04:
            case 0x06:
            case 0x07: {


                byte[] mag1 = new byte[expectedLength];
                System.arraycopy(encoded, 1, mag1, 0, expectedLength);
                BigInteger X = new BigInteger(1, mag1);
                byte[] mag = new byte[expectedLength];
                System.arraycopy(encoded, expectedLength + 1, mag, 0, expectedLength);

                p = createPoint(X, new BigInteger(1, mag));
                break;
            }
            default:
         }



        return p;
    }


    public ECLookupTable createCacheSafeLookupTable(final ECPoint[] points, int off, final int len)
    {
        return null;
	}










}
