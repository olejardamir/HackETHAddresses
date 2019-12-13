import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Class for describing an ECPoint as a DER object.
 */
public class X9ECPoint {
    private final ASN1OctetString encoding;

    private final ECCurve c;
    private ECPoint p;



    public X9ECPoint(
            ECCurve          c,
            byte[]           encoding)
    {
        this.c = c;
        this.encoding = new DEROctetString(Arrays.clone(encoding));
    }



    public synchronized ECPoint getPoint() throws CloneNotSupportedException {
        if (p == null)
        {
            p = c.decodePoint(encoding.getOctets()).normalize();
        }

        return p;
    }


    public ASN1Primitive toASN1Primitive()
    {
        return encoding;
    }

    /**
     * Return the default BER or DER encoding for this object.
     *
     * @return BER/DER byte encoded object.
     * @throws java.io.IOException on encoding error.
     */
    byte[] getEncoded()
            throws IOException
    {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ASN1OutputStream      aOut = new ASN1OutputStream(bOut);

        aOut.writeObject((ASN1Encodable) this);

        return bOut.toByteArray();
    }

    /**
     * Return either the default for "BER" or a DER encoding if "DER" is specified.
     *
     * @param encoding name of encoding to use.
     * @return byte encoded object.
     * @throws IOException on encoding error.
     */
    byte[] getEncoded(
            String encoding)
            throws IOException
    {
        if (encoding.equals(ASN1Encoding.DER))
        {
            ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
            DEROutputStream         dOut = new DEROutputStream(bOut);

            dOut.writeObject((ASN1Encodable) this);

            return bOut.toByteArray();
        }
        else if (encoding.equals(ASN1Encoding.DL))
        {
            ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
            DLOutputStream          dOut = new DLOutputStream(bOut);

            dOut.writeObject((ASN1Encodable) this);

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

        if (!(o instanceof X9ECPoint))
        {
            return false;
        }

        X9ECPoint other = (X9ECPoint)o;

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
}
