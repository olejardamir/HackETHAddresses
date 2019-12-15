
public abstract class ASN1Primitive
        extends ASN1Object
{
    ASN1Primitive()
    {
        super();

    }

    public final boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }

        return (o instanceof ASN1Object) && asn1Equals(((ASN1Object)o).toASN1Primitive());
    }

    public ASN1Primitive toASN1Primitive()
    {
        return this;
    }

    
    ASN1Primitive toDERObject()
    {
        return this;
    }



    public abstract int hashCode();

    
    abstract int encodedLength() throws Exception;

    abstract void encode(ASN1OutputStream out) throws Exception;

    
    abstract boolean asn1Equals(ASN1Primitive o);
}