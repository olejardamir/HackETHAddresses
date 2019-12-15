import java.math.BigInteger;

class X9FieldID {
    

     private ASN1Primitive parameters;


    public X9FieldID(BigInteger primeP)
    {
         this.parameters = new ASN1Integer(primeP);
    }


    private ASN1Primitive toASN1Primitive()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

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


}
