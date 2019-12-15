
import java.math.BigInteger;


public class X9ECParameters {

     private final ECCurve             curve;
    private final ASN1Object g;
    private final BigInteger          n;
    private final BigInteger          h;



    public X9ECParameters(
            ECCurve curve,
            ASN1Object g,
            BigInteger n,
            BigInteger h)
    {
        this.curve = curve;
        this.g = g;
        this.n = n;
        this.h = h;





    }

    public ECCurve getCurve()
    {
        return curve;
    }

    public ECPoint getG() {
        return g.getPoint();
    }

    public BigInteger getN()
    {
        return n;
    }

    public BigInteger getH()
    {
        return h;
    }




    public boolean equals(
            Object  o)
    {
        if (this == o)
        {
            return true;
        }


            return false;

    }


}
