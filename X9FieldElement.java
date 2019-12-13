/**
 * class for processing an FieldElement as a DER object.
 */
public class X9FieldElement
        extends ASN1Object
{
    private ECFieldElement  f;

    private static X9IntegerConverter converter = new X9IntegerConverter();

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
}
