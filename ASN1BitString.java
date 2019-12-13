import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Base class for BIT STRING objects
 */
public abstract class ASN1BitString
        extends ASN1Primitive
        implements ASN1String
{
    private static final char[]  table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    final byte[]      data;
    final int         padBits;

    /**
     * @param bitString an int containing the BIT STRING
     * @return the correct number of pad bits for a bit string defined in
     * a 32 bit constant
     */
    static int getPadBits(
            int bitString)
    {
        int val = 0;
        for (int i = 3; i >= 0; i--)
        {
            //
            // this may look a little odd, but if it isn't done like this pre jdk1.2
            // JVM's break!
            //
            if (i != 0)
            {
                if ((bitString >> (i * 8)) != 0)
                {
                    val = (bitString >> (i * 8)) & 0xFF;
                    break;
                }
            }
            else
            {
                if (bitString != 0)
                {
                    val = bitString & 0xFF;
                    break;
                }
            }
        }

        if (val == 0)
        {
            return 0;
        }


        int bits = 1;

        while (((val <<= 1) & 0xFF) != 0)
        {
            bits++;
        }

        return 8 - bits;
    }

    /**
     * @param bitString an int containing the BIT STRING
     * @return the correct number of bytes for a bit string defined in
     * a 32 bit constant
     */
    static byte[] getBytes(int bitString)
    {
        if (bitString == 0)
        {
            return new byte[0];
        }

        int bytes = 4;
        for (int i = 3; i >= 1; i--)
        {
            if ((bitString & (0xFF << (i * 8))) != 0)
            {
                break;
            }
            bytes--;
        }

        byte[] result = new byte[bytes];
        for (int i = 0; i < bytes; i++)
        {
            result[i] = (byte) ((bitString >> (i * 8)) & 0xFF);
        }

        return result;
    }

    /**
     * Base constructor.
     *
     * @param data the octets making up the bit string.
     * @param padBits the number of extra bits at the end of the string.
     */
    ASN1BitString(
            byte[] data,
            int padBits)
    {
        if (data == null)
        {
            throw new NullPointerException("data cannot be null");
        }
        if (data.length == 0 && padBits != 0)
        {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (padBits > 7 || padBits < 0)
        {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }

        this.data = Arrays.clone(data);
        this.padBits = padBits;
    }

    /**
     * Return a String representation of this BIT STRING
     *
     * @return a String representation.
     */
    public String getString() throws IOException {
        StringBuilder buf = new StringBuilder("#");
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ASN1OutputStream aOut = new ASN1OutputStream(bOut);


            aOut.writeObject(this);

        byte[]    string = bOut.toByteArray();

        for (int i = 0; i != string.length; i++)
        {
            buf.append(table[(string[i] >>> 4) & 0xf]);
            buf.append(table[string[i] & 0xf]);
        }

        return buf.toString();
    }

    private byte[] getBytes()
    {
        return derForm(data, padBits);
    }

    int getPadBits()
    {
        return padBits;
    }

    public String toString()
    {
        try {
            return getString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int hashCode()
    {
        return padBits ^ Arrays.hashCode(this.getBytes());
    }

    protected boolean asn1Equals(
            ASN1Primitive o)
    {
        if (!(o instanceof ASN1BitString))
        {
            return false;
        }

        ASN1BitString other = (ASN1BitString)o;

        return this.padBits == other.padBits
                && Arrays.areEqual(this.getBytes(), other.getBytes());
    }

    static byte[] derForm(byte[] data, int padBits)
    {
        byte[] rv = Arrays.clone(data);
        // DER requires pad bits be zero
        if (padBits > 0)
        {
            rv[data.length - 1] &= 0xff << padBits;
        }

        return rv;
    }

    ASN1Primitive toDERObject()
    {
        return new DERBitString(data, padBits);
    }

    ASN1Primitive toDLObject()
    {
        return new DLBitString(data, padBits);
    }

    abstract void encode(ASN1OutputStream out)
            throws IOException;
}
