
import java.math.BigInteger;

abstract class AbstractECMultiplier implements ECMultiplier
{
    public ECPoint multiply(ECPoint p, BigInteger k) throws CloneNotSupportedException {
        int sign = k.signum();
        if (sign == 0 || p.isInfinity())
        {
            return p.getCurve().getInfinity();
        }

        ECPoint positive = multiplyPositive(p, k.abs());
        ECPoint result = sign > 0 ? positive : positive.negate();

        /*
         * Although the various multipliers ought not to produce invalid output under normal
         * circumstances, a final check here is advised to guard against fault attacks.
         */
        return checkResult(result);
    }

    protected abstract ECPoint multiplyPositive(ECPoint p, BigInteger k) throws CloneNotSupportedException;

    private ECPoint checkResult(ECPoint p) throws CloneNotSupportedException {
        return ECAlgorithms.implCheckResult(p);
    }
}
