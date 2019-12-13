
import java.math.BigInteger;


public class GLVMultiplier extends AbstractECMultiplier
{
    private ECCurve curve;
    private GLVEndomorphism glvEndomorphism;

    protected ECPoint multiplyPositive(ECPoint p, BigInteger k) throws CloneNotSupportedException {
        if (!curve.equals(p.getCurve()))
        {
            throw new IllegalStateException();
        }

        BigInteger n = p.getCurve().getOrder();
        BigInteger[] ab = glvEndomorphism.decomposeScalar(k.mod(n));
        BigInteger a = ab[0], b = ab[1];

        ECPointMap pointMap = glvEndomorphism.getPointMap();
        if (glvEndomorphism.hasEfficientPointMap())
        {
            return ECAlgorithms.implShamirsTrickWNaf(p, a, pointMap, b);
        }

        return ECAlgorithms.implShamirsTrickWNaf(p, a, pointMap.map(p), b);
    }
}
