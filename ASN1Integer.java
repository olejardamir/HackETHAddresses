
import java.io.IOException;
import java.math.BigInteger;

/**
 * Class representing the ASN.1 INTEGER type.
 */
public class ASN1Integer
        extends ASN1Primitive
{
    private final byte[] bytes;

    /**
     * Construct an INTEGER from the passed in long value.
     *
     * @param value the long representing the value desired.
     */
    public ASN1Integer(
            long value)
    {
        bytes = BigInteger.valueOf(value).toByteArray();
    }

    /**
     * Construct an INTEGER from the passed in BigInteger value.
     *
     * @param value the BigInteger representing the value desired.
     */
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
