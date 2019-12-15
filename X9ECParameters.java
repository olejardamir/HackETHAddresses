
import java.math.BigInteger;


public class X9ECParameters {
    private static final BigInteger   ONE = BigInteger.valueOf(1);

    private ASN1Object fieldID;
    private final ECCurve             curve;
    private final ASN1Object g;
    private final BigInteger          n;
    private final BigInteger          h;
    private final byte[]              seed;



    public X9ECParameters(
            ECCurve     curve,
            ASN1Object g,
            BigInteger  n,
            BigInteger  h,
            byte[]      seed)
    {
        this.curve = curve;
        this.g = g;
        this.n = n;
        this.h = h;
        this.seed = Arrays.clone(seed);


            this.fieldID = new ASN1Object(curve.getField().getCharacteristic()) {
                @Override
                public ASN1Primitive toASN1Primitive() {
                    return null;
                }
            };



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



    private ASN1Primitive toASN1Primitive()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(new ASN1Integer(ONE));
        v.add( fieldID);
        v.add(new X9Curve(seed));
        v.add( g);
        v.add(new ASN1Integer(n));

        if (h != null)
        {
            v.add(new ASN1Integer(h));
        }

        return new DERSequence(v);
    }

    public int hashCode()
    {
        return this.toASN1Primitive().hashCode();
    }

    public boolean equals(
            Object  o)
    {
        if (this == o)
        {
            return true;
        }

        if (!(o instanceof X9ECParameters))
        {
            return false;
        }

        X9ECParameters other = (X9ECParameters)o;

        return this.toASN1Primitive().equals(other.toASN1Primitive());
    }


}
