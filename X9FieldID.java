import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class X9FieldID {
    /** Base OID: 1.2.840.10045 */
    public static final ASN1ObjectIdentifier ansi_X9_62 = new ASN1ObjectIdentifier("1.2.840.10045");
    /** OID: 1.2.840.10045.1 */
    public static final ASN1ObjectIdentifier id_fieldType = ansi_X9_62.branch("1");
    /** OID: 1.2.840.10045.1.1 */
    public static final ASN1ObjectIdentifier prime_field = id_fieldType.branch("1");
    /** OID: 1.2.840.10045.1.2 */
    public static final ASN1ObjectIdentifier characteristic_two_field = id_fieldType.branch("2");
    /** OID: 1.2.840.10045.1.2.3.2 */
    public static final ASN1ObjectIdentifier tpBasis = characteristic_two_field.branch("3.2");
    /** OID: 1.2.840.10045.1.2.3.3 */
    public static final ASN1ObjectIdentifier ppBasis = characteristic_two_field.branch("3.3");
    public static final ASN1ObjectIdentifier ellipticCurve = ansi_X9_62.branch("3");
    private final ASN1ObjectIdentifier     id;
    private ASN1Primitive parameters;


    public X9FieldID(BigInteger primeP)
    {
        this.id = prime_field;
        this.parameters = new ASN1Integer(primeP);
    }


    public X9FieldID(int m, int k1)
    {
        this(m, k1, 0, 0);
    }


    public X9FieldID(int m, int k1, int k2, int k3)
    {
        this.id = characteristic_two_field;
        ASN1EncodableVector fieldIdParams = new ASN1EncodableVector();
        fieldIdParams.add(new ASN1Integer(m));

        if (k2 == 0)
        {
            if (k3 != 0)
            {
                throw new IllegalArgumentException("inconsistent k values");
            }

            fieldIdParams.add(tpBasis);
            fieldIdParams.add(new ASN1Integer(k1));
        }
        else
        {
            if (k2 <= k1 || k3 <= k2)
            {
                throw new IllegalArgumentException("inconsistent k values");
            }

            fieldIdParams.add(ppBasis);
            ASN1EncodableVector pentanomialParams = new ASN1EncodableVector();
            pentanomialParams.add(new ASN1Integer(k1));
            pentanomialParams.add(new ASN1Integer(k2));
            pentanomialParams.add(new ASN1Integer(k3));
            fieldIdParams.add(new DERSequence(pentanomialParams));
        }

        this.parameters = new DERSequence(fieldIdParams);
    }



    public ASN1Primitive toASN1Primitive()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(this.id);
        v.add(this.parameters);

        return new DERSequence(v);
    }

    /**
     * Return the default BER or DER encoding for this object.
     *
     * @return BER/DER byte encoded object.
     * @throws java.io.IOException on encoding error.
     */
    byte[] getEncoded()
            throws IOException
    {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ASN1OutputStream      aOut = new ASN1OutputStream(bOut);

        aOut.writeObject((ASN1Encodable) this);

        return bOut.toByteArray();
    }

    /**
     * Return either the default for "BER" or a DER encoding if "DER" is specified.
     *
     * @param encoding name of encoding to use.
     * @return byte encoded object.
     * @throws IOException on encoding error.
     */
    byte[] getEncoded(
            String encoding)
            throws IOException
    {
        if (encoding.equals(ASN1Encoding.DER))
        {
            ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
            DEROutputStream         dOut = new DEROutputStream(bOut);

            dOut.writeObject((ASN1Encodable) this);

            return bOut.toByteArray();
        }
        else if (encoding.equals(ASN1Encoding.DL))
        {
            ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
            DLOutputStream          dOut = new DLOutputStream(bOut);

            dOut.writeObject((ASN1Encodable) this);

            return bOut.toByteArray();
        }

        return this.getEncoded();
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
