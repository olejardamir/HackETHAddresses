

public class X9Curve
        extends ASN1Object {
    

     final private byte[] seed;




    public X9Curve(
            byte[] seed)
    {
         this.seed = Arrays.clone(seed);
     }


    public ASN1Primitive toASN1Primitive()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();




        if (seed != null)
        {
            v.add(new DERBitString(seed));
        }

        return new DERSequence(v);
    }
}
