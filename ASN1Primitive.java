
import java.io.IOException;

/**
 * Base class for ASN.1 primitive objects. These are the actual objects used to generate byte encodings.
 */
public abstract class ASN1Primitive
        extends ASN1Object
{
    ASN1Primitive()
    {

    }

    public final boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }

        return (o instanceof ASN1Encodable) && asn1Equals(((ASN1Encodable)o).toASN1Primitive());
    }

    public ASN1Primitive toASN1Primitive()
    {
        return this;
    }

    /**
     * Return the current object as one which encodes using Distinguished Encoding Rules.
     *
     * @return a DER version of this.
     */
    ASN1Primitive toDERObject()
    {
        return this;
    }

    /**
     * Return the current object as one which encodes using Definite Length encoding.
     *
     * @return a DL version of this.
     */
    ASN1Primitive toDLObject()
    {
        return this;
    }

    public abstract int hashCode();

    /**
     * Return the length of the encoding this object will produce.
     * @return the length of the object's encoding.
     * @throws Exception if the encoding length cannot be calculated.
     */
    abstract int encodedLength() throws Exception;

    abstract void encode(ASN1OutputStream out) throws Exception;

    /**
     * Equality (similarity) comparison for two ASN1Primitive objects.
     */
    abstract boolean asn1Equals(ASN1Primitive o);
}