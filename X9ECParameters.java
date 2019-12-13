
import java.math.BigInteger;

/**
 * ASN.1 def for Elliptic-Curve ECParameters structure. See
 * X9.62, for further details.
 */
public class X9ECParameters
        extends ASN1Object
        implements X9ObjectIdentifiers
{
    private static final BigInteger   ONE = BigInteger.valueOf(1);

    private X9FieldID           fieldID;
    private ECCurve             curve;
    private X9ECPoint           g;
    private BigInteger          n;
    private BigInteger          h;
    private byte[]              seed;



    public X9ECParameters(
            ECCurve     curve,
            X9ECPoint   g,
            BigInteger  n,
            BigInteger  h,
            byte[]      seed)
    {
        this.curve = curve;
        this.g = g;
        this.n = n;
        this.h = h;
        this.seed = Arrays.clone(seed);

        if (ECAlgorithms.isFpCurve(curve))
        {
            this.fieldID = new X9FieldID(curve.getField().getCharacteristic());
        }
        else if (ECAlgorithms.isF2mCurve(curve))
        {
            PolynomialExtensionField field = (PolynomialExtensionField)curve.getField();
            int[] exponents = field.getMinimalPolynomial().getExponentsPresent();
            if (exponents.length == 3)
            {
                this.fieldID = new X9FieldID(exponents[2], exponents[1]);
            }
            else if (exponents.length == 5)
            {
                this.fieldID = new X9FieldID(exponents[4], exponents[1], exponents[2], exponents[3]);
            }
            else
            {
                throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
            }
        }
        else
        {
            throw new IllegalArgumentException("'curve' is of an unsupported type");
        }
    }

    public ECCurve getCurve()
    {
        return curve;
    }

    public ECPoint getG() throws CloneNotSupportedException {
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



    public ASN1Primitive toASN1Primitive()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(new ASN1Integer(ONE));
        v.add(fieldID);
        v.add(new X9Curve(curve, seed));
        v.add(g);
        v.add(new ASN1Integer(n));

        if (h != null)
        {
            v.add(new ASN1Integer(h));
        }

        return new DERSequence(v);
    }
}
