
/**
 * ASN.1 def for Elliptic-Curve Curve structure. See
 * X9.62, for further details.
 */
public class X9Curve
        extends ASN1Object {
    /** Base OID: 1.2.840.10045 */
    public static final ASN1ObjectIdentifier ansi_X9_62 = new ASN1ObjectIdentifier("1.2.840.10045");
    /** OID: 1.2.840.10045.1 */
    public static final ASN1ObjectIdentifier id_fieldType = ansi_X9_62.branch("1");
    /** OID: 1.2.840.10045.1.1 */
    public static final ASN1ObjectIdentifier prime_field = id_fieldType.branch("1");
    /** OID: 1.2.840.10045.1.2 */
    public static final ASN1ObjectIdentifier characteristic_two_field = id_fieldType.branch("2");
    private final ECCurve     curve;
    private final byte[]      seed;
    private ASN1ObjectIdentifier fieldIdentifier = null;


    public X9Curve(
            ECCurve     curve,
            byte[]      seed)
    {
        this.curve = curve;
        this.seed = Arrays.clone(seed);
        setFieldIdentifier();
    }



    private void setFieldIdentifier()
    {
        if (ECAlgorithms.isFpCurve(curve))
        {
            fieldIdentifier = prime_field;
        }
        else if (ECAlgorithms.isF2mCurve(curve))
        {
            fieldIdentifier = characteristic_two_field;
        }
        else
        {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
    }

    public ASN1Primitive toASN1Primitive()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        if (fieldIdentifier.equals(prime_field))
        {
            v.add(new X9FieldElement(curve.getA()).toASN1Primitive());
            v.add(new X9FieldElement(curve.getB()).toASN1Primitive());
        }
        else if (fieldIdentifier.equals(characteristic_two_field))
        {
            v.add(new X9FieldElement(curve.getA()).toASN1Primitive());
            v.add(new X9FieldElement(curve.getB()).toASN1Primitive());
        }

        if (seed != null)
        {
            v.add(new DERBitString(seed));
        }

        return new DERSequence(v);
    }
}
