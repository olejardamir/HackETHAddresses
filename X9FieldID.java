import java.math.BigInteger;

class X9FieldID {
    /** Base OID: 1.2.840.10045 */
    private static final ASN1ObjectIdentifier ansi_X9_62 = new ASN1ObjectIdentifier("1.2.840.10045");
    /** OID: 1.2.840.10045.1 */
    private static final ASN1ObjectIdentifier id_fieldType = ansi_X9_62.branch("1");
    /** OID: 1.2.840.10045.1.1 */
    private static final ASN1ObjectIdentifier prime_field = id_fieldType.branch("1");
    /** OID: 1.2.840.10045.1.2 */
    private static final ASN1ObjectIdentifier characteristic_two_field = id_fieldType.branch("2");
    /** OID: 1.2.840.10045.1.2.3.2 */
    private static final ASN1ObjectIdentifier tpBasis = characteristic_two_field.branch("3.2");
    /** OID: 1.2.840.10045.1.2.3.3 */
    private static final ASN1ObjectIdentifier ppBasis = characteristic_two_field.branch("3.3");
    private final ASN1ObjectIdentifier     id;
    private ASN1Primitive parameters;


    public X9FieldID(BigInteger primeP)
    {
        this.id = prime_field;
        this.parameters = new ASN1Integer(primeP);
    }


    private ASN1Primitive toASN1Primitive()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(this.id);
        v.add(this.parameters);

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

        if (!(o instanceof X9FieldID))
        {
            return false;
        }

        X9FieldID other = (X9FieldID)o;

        return this.toASN1Primitive().equals(other.toASN1Primitive());
    }

    /**
     * @deprecated use toASN1Primitive()
     * @return the underlying primitive type.
     */
    public ASN1Primitive toASN1Object()
    {
        return this.toASN1Primitive();
    }
}
