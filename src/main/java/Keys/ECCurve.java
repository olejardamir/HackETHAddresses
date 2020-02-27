package Keys;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Hashtable;

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

    public ECCurve() {

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

     ECFieldElement a;
    ECFieldElement b;
    BigInteger order;

    int coord = COORD_AFFINE;
     private FixedPointCombMultiplier multiplier;



    public abstract int getFieldSize();

    public abstract ECFieldElement fromBigInteger(BigInteger x);

    public synchronized Config configure()
    {
        return new Config(this.coord);
    }

    private ECPoint validatePoint(BigInteger x, BigInteger y) {

        return createPoint(x, y);
    }


    private ECPoint createPoint(BigInteger x, BigInteger y)
    {
        return createPoint(x, y, false);
    }

    
    public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression)
    {
        return createRawPoint(fromBigInteger(x), fromBigInteger(y), withCompression);
    }

    protected abstract ECCurve cloneCurve() throws Exception;

    protected abstract ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, boolean withCompression);


    
    public FixedPointPreCompInfo precompute(ECPoint point, String name, PreCompCallback callback) {


        HashMap<String, FixedPointPreCompInfo> table = point.preCompTable;
            if (table == null)
				point.preCompTable = table = new HashMap(4);



            FixedPointPreCompInfo result = callback.precompute(table.get(name));
            if (result != table.get(name))
				table.put(name, result);

            return result;

    }


    public void normalizeAll(ECPoint[] points) {
        normalizeAll(points, points.length);
    }


    private void normalizeAll(ECPoint[] points, int len) {


        
        ECFieldElement[] zs = new ECFieldElement[len];
        int[] indices = new int[len];
        int count = 0;
        for (int i = 0; i < len; ++i)
			if (null != points[i] && points[i].isNormalized()) {
				zs[count] = points[i].getZCoord(0);
				indices[count++] = i;
			}



        ECFieldElement[] c = new ECFieldElement[count];
        c[0] = zs[0];

        int i = 0;
        while (++i < count)
			c[i] = c[i - 1].multiply(zs[i]);

        --i;

        ECFieldElement u = c[i].invert();

        while (i > 0)
        {
            int j1 = i--;
            ECFieldElement tmp = zs[j1];
            zs[j1] = c[i].multiply(u);
            u = u.multiply(tmp);
        }

        zs[0] = u;

        for (int j = 0; j < count; ++j)
			points[indices[j]] = points[indices[j]].normalize(zs[j]);
    }

    public abstract ECPoint getInfinity();


    public ECFieldElement getA()
    {
        return a;
    }



    public BigInteger getOrder()
    {
        return order;
    }



    public int getCoordinateSystem()
    {
        return coord;
    }


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
                p = validatePoint(X, new BigInteger(1, mag));
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
