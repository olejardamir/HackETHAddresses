

class ECAlgorithms
{


    public static ECPoint importPoint(ECCurve c, ECPoint p) {

        return c.importPoint(p);
    }


    public static void montgomeryTrick(ECFieldElement[] zs, int off, int len, ECFieldElement scale) {


        ECFieldElement[] c = new ECFieldElement[len];
        c[0] = zs[off];

        int i = 0;
        while (++i < len)
        {
            c[i] = c[i - 1].multiply(zs[off + i]);
        }

        --i;

        if (scale != null)
        {
            c[i] = c[i].multiply(scale);
        }

        ECFieldElement u = c[i].invert();

        while (i > 0)
        {
            int j = off + i--;
            ECFieldElement tmp = zs[j];
            zs[j] = c[i].multiply(u);
            u = u.multiply(tmp);
        }

        zs[off] = u;
    }



    static ECPoint implCheckResult(ECPoint p) {


        return p;
    }


}
