import java.math.BigInteger;

public class X9FieldID
        extends ASN1Object
        implements X9ObjectIdentifiers
{
    private ASN1ObjectIdentifier     id;
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
}
