
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

       return false;
    }

    public ASN1Primitive toASN1Primitive()
    {
        return this;
    }

    



    public abstract int hashCode();



    
 }