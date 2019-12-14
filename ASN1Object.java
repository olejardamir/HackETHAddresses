
import java.io.ByteArrayOutputStream;


public abstract class ASN1Object
        implements ASN1Encodable {

    
    byte[] getEncoded()
            throws Exception
    {
        if ("DL".equals("DL"))
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

    
    public ASN1Primitive toASN1Object()
    {
        return this.toASN1Primitive();
    }

    
    public abstract ASN1Primitive toASN1Primitive();
}
