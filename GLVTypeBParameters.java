
import java.math.BigInteger;

class GLVTypeBParameters
{
    private static void checkVector(BigInteger[] v, String name)
    {
        if (v == null || v.length != 2 || v[0] == null || v[1] == null)
        {
            throw new IllegalArgumentException("'" + name + "' must consist of exactly 2 (non-null) values");
        }
    }



    public GLVTypeBParameters(BigInteger bigInteger, BigInteger[] v1, BigInteger[] v2)
    {
        checkVector(v1, "v1");
        checkVector(v2, "v2");


    }


}
