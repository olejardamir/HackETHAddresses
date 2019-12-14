
import java.math.BigInteger;


public class ASN1Integer
        extends ASN1Primitive
{
    private final byte[] bytes;

    
    public ASN1Integer(
            BigInteger value)
    {
        bytes = value.toByteArray();
    }

    private BigInteger getValue()
    {
        return new BigInteger(bytes);
    }

    int encodedLength()
    {
        return 1 + StreamUtil.calculateBodyLength(bytes.length) + bytes.length;
    }

    void encode(
            ASN1OutputStream out)
            throws Exception
    {
        out.writeEncoded(ASN1InputStream.INTEGER, bytes);
    }

    public int hashCode()
    {
        int value = 0;

        for (int i = 0; i != bytes.length; i++)
        {
            value ^= (bytes[i] & 0xff) << (i % 4);
        }

        return value;
    }

    boolean asn1Equals(
            ASN1Primitive o)
    {
        if (!(o instanceof ASN1Integer))
        {
            return false;
        }

        ASN1Integer other = (ASN1Integer)o;

        return Arrays.areEqual(bytes, other.bytes);
    }

    public String toString()
    {
        return getValue().toString();
    }

}
