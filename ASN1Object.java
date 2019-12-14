
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Base class for defining an ASN.1 object.
 */
public abstract class ASN1Object
        implements ASN1Encodable {
    /**
     * Return the default BER or DER encoding for this object.
     *
     * @return BER/DER byte encoded object.
     * @throws java.io.IOException on encoding error.
     */
    private byte[] getEncoded()
            throws Exception
    {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ASN1OutputStream      aOut = new ASN1OutputStream(bOut);

        aOut.writeObject(this);

        return bOut.toByteArray();
    }

    /**
     * Return either the default for "BER" or a DER encoding if "DER" is specified.
     *
     * @param encoding name of encoding to use.
     * @return byte encoded object.
     * @throws Exception on encoding error.
     */
    byte[] getEncoded(
            String encoding)
            throws Exception
    {
        if (encoding.equals("DER"))
        {
            ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
            DEROutputStream         dOut = new DEROutputStream(bOut);

            dOut.writeObject(this);

            return bOut.toByteArray();
        }
        else if (encoding.equals("DL"))
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
