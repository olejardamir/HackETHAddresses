
import java.math.BigInteger;


class Tnaf
{
    private static final BigInteger MINUS_ONE = ECConstants.ONE.negate();
    private static final BigInteger MINUS_TWO = ECConstants.TWO.negate();
    private static final BigInteger MINUS_THREE = ECConstants.THREE.negate();


    public static final byte WIDTH = 4;


    public static final byte POW_2_WIDTH = 16;


    public static final ZTauElement[] alpha0 = {
            null,
            new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null,
            new ZTauElement(MINUS_THREE, MINUS_ONE), null,
            new ZTauElement(MINUS_ONE, MINUS_ONE), null,
            new ZTauElement(ECConstants.ONE, MINUS_ONE), null
    };


    private static final byte[][] alpha0Tnaf = {
            null, {1}, null, {-1, 0, 1}, null, {1, 0, 1}, null, {-1, 0, 0, 1}
    };


    public static final ZTauElement[] alpha1 = {null,
            new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null,
            new ZTauElement(MINUS_THREE, ECConstants.ONE), null,
            new ZTauElement(MINUS_ONE, ECConstants.ONE), null,
            new ZTauElement(ECConstants.ONE, ECConstants.ONE), null
    };


    private static final byte[][] alpha1Tnaf = {
            null, {1}, null, {-1, 0, 1}, null, {1, 0, 1}, null, {-1, 0, 0, -1}
    };


    private static BigInteger norm(final byte mu, ZTauElement lambda)
    {
        BigInteger norm;

        // s1 = u^2
        BigInteger s1 = lambda.u.multiply(lambda.u);

        // s2 = u * v
        BigInteger s2 = lambda.u.multiply(lambda.v);

        // s3 = 2 * v^2
        BigInteger s3 = lambda.v.multiply(lambda.v).shiftLeft(1);

        if (mu == 1)
        {
            norm = s1.add(s2).add(s3);
        }
        else if (mu == -1)
        {
            norm = s1.subtract(s2).add(s3);
        }
        else
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }

        return norm;
    }



    private static ZTauElement round(SimpleBigDecimal lambda0,
                                     SimpleBigDecimal lambda1, byte mu)
    {
        int scale = lambda0.getScale();
        if (lambda1.getScale() != scale)
        {
            throw new IllegalArgumentException("lambda0 and lambda1 do not " +
                    "have same scale");
        }

        if (!((mu == 1) || (mu == -1)))
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }

        BigInteger f0 = lambda0.round();
        BigInteger f1 = lambda1.round();

        SimpleBigDecimal eta0 = lambda0.subtract(f0);
        SimpleBigDecimal eta1 = lambda1.subtract(f1);

        // eta = 2*eta0 + mu*eta1
        SimpleBigDecimal eta = eta0.add(eta0);
        if (mu == 1)
        {
            eta = eta.add(eta1);
        }
        else
        {
            // mu == -1
            eta = eta.subtract(eta1);
        }

        // check1 = eta0 - 3*mu*eta1
        // check2 = eta0 + 4*mu*eta1
        SimpleBigDecimal threeEta1 = eta1.add(eta1).add(eta1);
        SimpleBigDecimal fourEta1 = threeEta1.add(eta1);
        SimpleBigDecimal check1;
        SimpleBigDecimal check2;
        if (mu == 1)
        {
            check1 = eta0.subtract(threeEta1);
            check2 = eta0.add(fourEta1);
        }
        else
        {
            // mu == -1
            check1 = eta0.add(threeEta1);
            check2 = eta0.subtract(fourEta1);
        }

        byte h0 = 0;
        byte h1 = 0;

        // if eta >= 1
        if (eta.compareTo(ECConstants.ONE) >= 0)
        {
            if (check1.compareTo(MINUS_ONE) < 0)
            {
                h1 = mu;
            }
            else
            {
                h0 = 1;
            }
        }
        else
        {
            // eta < 1
            if (check2.compareTo(ECConstants.TWO) >= 0)
            {
                h1 = mu;
            }
        }

        // if eta < -1
        if (eta.compareTo(MINUS_ONE) < 0)
        {
            if (check1.compareTo(ECConstants.ONE) >= 0)
            {
                h1 = (byte)-mu;
            }
            else
            {
                h0 = -1;
            }
        }
        else
        {
            // eta >= -1
            if (check2.compareTo(MINUS_TWO) < 0)
            {
                h1 = (byte)-mu;
            }
        }

        BigInteger q0 = f0.add(BigInteger.valueOf(h0));
        BigInteger q1 = f1.add(BigInteger.valueOf(h1));
        return new ZTauElement(q0, q1);
    }


    private static SimpleBigDecimal approximateDivisionByN(BigInteger k,
                                                           BigInteger s, BigInteger vm, byte a, int m, int c)
    {
        int _k = (m + 5)/2 + c;
        BigInteger ns = k.shiftRight(m - _k - 2 + a);

        BigInteger gs = s.multiply(ns);

        BigInteger hs = gs.shiftRight(m);

        BigInteger js = vm.multiply(hs);

        BigInteger gsPlusJs = gs.add(js);
        BigInteger ls = gsPlusJs.shiftRight(_k-c);
        if (gsPlusJs.testBit(_k-c-1))
        {
            // round up
            ls = ls.add(ECConstants.ONE);
        }

        return new SimpleBigDecimal(ls, c);
    }


    public static byte getMu(int curveA)
    {
        return (byte)(curveA == 0 ? -1 : 1);
    }


    private static BigInteger[] getLucas(byte mu, int k, boolean doV)
    {
        if (!((mu == 1) || (mu == -1)))
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }

        BigInteger u0;
        BigInteger u1;
        BigInteger u2;

        if (doV)
        {
            u0 = ECConstants.TWO;
            u1 = BigInteger.valueOf(mu);
        }
        else
        {
            u0 = ECConstants.ZERO;
            u1 = ECConstants.ONE;
        }

        for (int i = 1; i < k; i++)
        {
            // u2 = mu*u1 - 2*u0;
            BigInteger s;
            if (mu == 1)
            {
                s = u1;
            }
            else
            {
                // mu == -1
                s = u1.negate();
            }

            u2 = s.subtract(u0.shiftLeft(1));
            u0 = u1;
            u1 = u2;
//            System.out.println(i + ": " + u2);
//            System.out.println();
        }

        return new BigInteger[]{u0, u1};
    }


    public static BigInteger getTw(byte mu, int w)
    {
        if (w == 4)
        {
            if (mu == 1)
            {
                return BigInteger.valueOf(6);
            }
            else
            {
                // mu == -1
                return BigInteger.valueOf(10);
            }
        }
        else
        {
            // For w <> 4, the values must be computed
            BigInteger[] us = getLucas(mu, w, false);
            BigInteger twoToW = ECConstants.ZERO.setBit(w);
            BigInteger u1invert = us[1].modInverse(twoToW);
            BigInteger tw;
            tw = ECConstants.TWO.multiply(us[0]).multiply(u1invert).mod(twoToW);
//            System.out.println("mu = " + mu);
//            System.out.println("tw = " + tw);
            return tw;
        }
    }

    /**
 blitz curve (Anomalous Binary Curve, ABC).
     */
    public static BigInteger[] getSi(ECCurve.AbstractF2m curve)
    {
        if (!curve.isKoblitz())
        {
            throw new IllegalArgumentException("si is defined for Koblitz curves only");
        }

        int m = curve.getFieldSize();
        int a = curve.getA().toBigInteger().intValue();
        byte mu = getMu(a);
        int shifts = getShiftsForCofactor(curve.getCofactor());
        int index = m + 3 - a;
        BigInteger[] ui = getLucas(mu, index, false);
        if (mu == 1)
        {
            ui[0] = ui[0].negate();
            ui[1] = ui[1].negate();
        }

        BigInteger dividend0 = ECConstants.ONE.add(ui[1]).shiftRight(shifts);
        BigInteger dividend1 = ECConstants.ONE.add(ui[0]).shiftRight(shifts).negate();

        return new BigInteger[] { dividend0, dividend1 };
    }

    private static int getShiftsForCofactor(BigInteger h)
    {
        if (h != null)
        {
            if (h.equals(ECConstants.TWO))
            {
                return 1;
            }
            if (h.equals(ECConstants.FOUR))
            {
                return 2;
            }
        }

        throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
    }


    public static ZTauElement partModReduction(BigInteger k, int m, byte a,
                                               BigInteger[] s, byte mu, byte c)
    {
        // d0 = s[0] + mu*s[1]; mu is either 1 or -1
        BigInteger d0;
        if (mu == 1)
        {
            d0 = s[0].add(s[1]);
        }
        else
        {
            d0 = s[0].subtract(s[1]);
        }

        BigInteger[] v = getLucas(mu, m, true);
        BigInteger vm = v[1];

        SimpleBigDecimal lambda0 = approximateDivisionByN(
                k, s[0], vm, a, m, c);

        SimpleBigDecimal lambda1 = approximateDivisionByN(
                k, s[1], vm, a, m, c);

        // r0 = n - d0*q0 - 2*s1*q1
        BigInteger r0 = k.subtract(d0.multiply(round(lambda0, lambda1, mu).u)).subtract(
                BigInteger.valueOf(2).multiply(s[1]).multiply(round(lambda0, lambda1, mu).v));

        // r1 = s1*q0 - s0*q1
        BigInteger r1 = s[1].multiply(round(lambda0, lambda1, mu).u).subtract(s[0].multiply(round(lambda0, lambda1, mu).v));

        return new ZTauElement(r0, r1);
    }


    private static ECPoint.AbstractF2m multiplyFromTnaf(ECPoint.AbstractF2m p, byte[] u) throws CloneNotSupportedException {
        ECCurve curve = p.getCurve();
        ECPoint.AbstractF2m q = (ECPoint.AbstractF2m)curve.getInfinity();
        ECPoint.AbstractF2m pNeg = (ECPoint.AbstractF2m)p.negate();
        int tauCount = 0;
        for (int i = u.length - 1; i >= 0; i--)
        {
            ++tauCount;
            byte ui = u[i];
            if (ui != 0)
            {
                q = q.tauPow(tauCount);
                tauCount = 0;

                ECPoint x = ui > 0 ? p : pNeg;
                q = (ECPoint.AbstractF2m)q.add(x);
            }
        }
        if (tauCount > 0)
        {
            q = q.tauPow(tauCount);
        }
        return q;
    }


    public static byte[] tauAdicWNaf(byte mu, ZTauElement lambda,
                                     byte width, BigInteger pow2w, BigInteger tw, ZTauElement[] alpha)
    {
        if (!((mu == 1) || (mu == -1)))
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }

        BigInteger norm = norm(mu, lambda);

        // Ceiling of log2 of the norm
        int log2Norm = norm.bitLength();

        // If length(TNAF) > 30, then length(TNAF) < log2Norm + 3.52
        int maxLength = log2Norm > 30 ? log2Norm + 4 + width : 34 + width;

        // The array holding the TNAF
        byte[] u = new byte[maxLength];

        // 2^(width - 1)
        BigInteger pow2wMin1 = pow2w.shiftRight(1);

        // Split lambda into two BigIntegers to simplify calculations
        BigInteger r0 = lambda.u;
        BigInteger r1 = lambda.v;
        int i = 0;

        // while lambda <> (0, 0)
        while (!((r0.equals(ECConstants.ZERO))&&(r1.equals(ECConstants.ZERO))))
        {
            // if r0 is odd
            if (r0.testBit(0))
            {
                // uUnMod = r0 + r1*tw mod 2^width
                BigInteger uUnMod
                        = r0.add(r1.multiply(tw)).mod(pow2w);

                byte uLocal;
                // if uUnMod >= 2^(width - 1)
                if (uUnMod.compareTo(pow2wMin1) >= 0)
                {
                    uLocal = (byte) uUnMod.subtract(pow2w).intValue();
                }
                else
                {
                    uLocal = (byte) uUnMod.intValue();
                }
                // uLocal is now in [-2^(width-1), 2^(width-1)-1]

                u[i] = uLocal;
                boolean s = true;
                if (uLocal < 0)
                {
                    s = false;
                    uLocal = (byte)-uLocal;
                }
                // uLocal is now >= 0

                if (s)
                {
                    r0 = r0.subtract(alpha[uLocal].u);
                    r1 = r1.subtract(alpha[uLocal].v);
                }
                else
                {
                    r0 = r0.add(alpha[uLocal].u);
                    r1 = r1.add(alpha[uLocal].v);
                }
            }
            else
            {
                u[i] = 0;
            }

            BigInteger t = r0;

            if (mu == 1)
            {
                r0 = r1.add(r0.shiftRight(1));
            }
            else
            {
                // mu == -1
                r0 = r1.subtract(r0.shiftRight(1));
            }
            r1 = t.shiftRight(1).negate();
            i++;
        }
        return u;
    }


    public static ECPoint.AbstractF2m[] getPreComp(ECPoint.AbstractF2m p, byte a) throws CloneNotSupportedException {
        byte[][] alphaTnaf = (a == 0) ? Tnaf.alpha0Tnaf : Tnaf.alpha1Tnaf;

        ECPoint.AbstractF2m[] pu = new ECPoint.AbstractF2m[(alphaTnaf.length + 1) >>> 1];
        pu[0] = p;

        int precompLen = alphaTnaf.length;
        for (int i = 3; i < precompLen; i += 2)
        {
            pu[i >>> 1] = Tnaf.multiplyFromTnaf(p, alphaTnaf[i]);
        }

        p.getCurve().normalizeAll(pu);

        return pu;
    }
}
