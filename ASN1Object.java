
public abstract class ASN1Object {



    public ASN1Object() {

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

        if (!(o instanceof ASN1Object))
        {
            return false;
        }

        ASN1Object other = (ASN1Object)o;

        return this.toASN1Primitive().equals(other.toASN1Primitive());
    }



    
    public abstract ASN1Primitive toASN1Primitive();

    public ECPoint getPoint() {
        return null;
    }
}
