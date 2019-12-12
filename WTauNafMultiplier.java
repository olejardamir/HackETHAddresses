
import java.math.BigInteger;


public class WTauNafMultiplier extends AbstractECMultiplier
{
     static final String PRECOMP_NAME = "bc_wtnaf";

    protected ECPoint multiplyPositive(ECPoint point, BigInteger k)
    {
        if (!(point instanceof ECPoint.AbstractF2m))
        {
            throw new IllegalArgumentException("Only ECPoint.AbstractF2m can be " +
                    "used in WTauNafMultiplier");
        }

        ECPoint.AbstractF2m p = (ECPoint.AbstractF2m)point;
        ECCurve.AbstractF2m curve = (ECCurve.AbstractF2m)p.getCurve();
        int m = curve.getFieldSize();
        byte a = curve.getA().toBigInteger().byteValue();
        byte mu = Tnaf.getMu(a);
        BigInteger[] s = curve.getSi();

        ZTauElement rho = Tnaf.partModReduction(k, m, a, s, mu, (byte)10);

        return multiplyWTnaf(p, rho, a, mu);
    }


    private ECPoint.AbstractF2m multiplyWTnaf(ECPoint.AbstractF2m p, ZTauElement lambda, byte a, byte mu)
    {
        ZTauElement[] alpha = (a == 0) ? Tnaf.alpha0 : Tnaf.alpha1;

        BigInteger tw = Tnaf.getTw(mu, Tnaf.WIDTH);

        byte[]u = Tnaf.tauAdicWNaf(mu, lambda, Tnaf.WIDTH,
                BigInteger.valueOf(Tnaf.POW_2_WIDTH), tw, alpha);

        return multiplyFromWTnaf(p, u);
    }


    private static ECPoint.AbstractF2m multiplyFromWTnaf(final ECPoint.AbstractF2m p, byte[] u)
    {
        ECCurve.AbstractF2m curve = (ECCurve.AbstractF2m)p.getCurve();
        final byte a = curve.getA().toBigInteger().byteValue();

        WTauNafPreCompInfo preCompInfo = (WTauNafPreCompInfo)curve.precompute(p, PRECOMP_NAME, new PreCompCallback()
        {
            public PreCompInfo precompute(PreCompInfo existing)
            {
                if (existing instanceof WTauNafPreCompInfo)
                {
                    return existing;
                }

                WTauNafPreCompInfo result = new WTauNafPreCompInfo();
                result.setPreComp(Tnaf.getPreComp(p, a));
                return result;
            }
        });

        ECPoint.AbstractF2m[] pu = preCompInfo.getPreComp();

         ECPoint.AbstractF2m[] puNeg = new ECPoint.AbstractF2m[pu.length];
        for (int i = 0; i < pu.length; ++i)
        {
            puNeg[i] = (ECPoint.AbstractF2m)pu[i].negate();
        }


         ECPoint.AbstractF2m q = (ECPoint.AbstractF2m) p.getCurve().getInfinity();

        int tauCount = 0;
        for (int i = u.length - 1; i >= 0; i--)
        {
            ++tauCount;
            int ui = u[i];
            if (ui != 0)
            {
                q = q.tauPow(tauCount);
                tauCount = 0;

                ECPoint x = ui > 0 ? pu[ui >>> 1] : puNeg[(-ui) >>> 1];
                q = (ECPoint.AbstractF2m)q.add(x);
            }
        }
        if (tauCount > 0)
        {
            q = q.tauPow(tauCount);
        }
        return q;
    }
}
