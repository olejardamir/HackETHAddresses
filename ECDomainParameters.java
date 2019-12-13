import java.math.BigInteger;

public class ECDomainParameters
        implements ECConstants
{
    private ECCurve     curve;
    private byte[]      seed;
    private ECPoint     G;
    private BigInteger  n;
    private BigInteger  h;

    public ECDomainParameters(
            ECCurve     curve,
            ECPoint     G,
            BigInteger  n,
            BigInteger  h)
    {
        this(curve, G, n, h, null);
    }

    public ECDomainParameters(
            ECCurve     curve,
            ECPoint     G,
            BigInteger  n,
            BigInteger  h,
            byte[]      seed)
    {
        if (curve == null)
        {
            throw new NullPointerException("curve");
        }
        if (n == null)
        {
            throw new NullPointerException("n");
        }
        // we can't check for h == null here as h is optional in X9.62 as it is not required for ECDSA

        this.curve = curve;
        this.G = validate(curve, G);
        this.n = n;
        this.h = h;
        this.seed = Arrays.clone(seed);
    }

    public ECPoint getG()
    {
        return G;
    }

    public BigInteger getN()
    {
        return n;
    }

    public boolean equals(
            Object  obj)
    {
        if (this == obj)
        {
            return true;
        }

        if ((obj instanceof ECDomainParameters))
        {
            ECDomainParameters other = (ECDomainParameters)obj;

            return this.curve.equals(other.curve) && this.G.equals(other.G) && this.n.equals(other.n) && this.h.equals(other.h);
        }

        return false;
    }

    public int hashCode()
    {
        int hc = curve.hashCode();
        hc *= 37;
        hc ^= G.hashCode();
        hc *= 37;
        hc ^= n.hashCode();
        hc *= 37;
        hc ^= h.hashCode();
        return hc;
    }

    static ECPoint validate(ECCurve c, ECPoint q)
    {
        if (q == null)
        {
            throw new IllegalArgumentException("Point has null value");
        }

        q = ECAlgorithms.importPoint(c, q).normalize();

        if (q.isInfinity())
        {
            throw new IllegalArgumentException("Point at infinity");
        }

        if (q.isValid())
        {
            throw new IllegalArgumentException("Point not on curve");
        }

        return q;
    }
}
