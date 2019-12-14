
import java.io.ByteArrayOutputStream;

/**
 * Base class for defining an ASN.1 object.
 */
public abstract class ASN1Object
        implements ASN1Encodable {

    /**
     * Return either the default for "BER" or a DER encoding if "DER" is specified.
     *
     * @return byte encoded object.
     * @throws Exception on encoding error.
     */
    byte[] getEncoded()
            throws Exception
    {
        if ("DL".equals("DER"))
        {
            ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
            DEROutputStream         dOut = new DEROutputStream(bOut);

            dOut.writeObject(this);

            return bOut.toByteArray();
        }
        else if ("DL".equals("DL"))
        {
            ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
            DLOutputStream          dOut = new DLOutputStream(bOut);

            dOut.writeObject(this);

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

        if (!(o instanceof ASN1Encodable))
        {
            return false;
        }

        ASN1Encodable other = (ASN1Encodable)o;

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

    /**
     * Method providing a primitive representation of this object suitable for encoding.
     * @return a primitive representation of this object.
     */
    public abstract ASN1Primitive toASN1Primitive();
}
