
class X9FieldElement {
    private final ECFieldElement  f;

    private static final X9IntegerConverter converter = new X9IntegerConverter();

    public X9FieldElement(ECFieldElement f)
    {
        this.f = f;
    }


    public ASN1Primitive toASN1Primitive()
    {
        int byteCount = converter.getByteLength(f);
        byte[] paddedBigInteger = converter.integerToBytes(f.toBigInteger(), byteCount);

        return new DEROctetString(paddedBigInteger);
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

        if (!(o instanceof X9FieldElement))
        {
            return false;
        }

        X9FieldElement other = (X9FieldElement)o;

        return this.toASN1Primitive().equals(other.toASN1Primitive());
    }


}
