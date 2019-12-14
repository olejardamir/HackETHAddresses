import java.io.ByteArrayOutputStream;


public abstract class ASN1BitString
        extends ASN1Primitive {
    private static final char[]  table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    final byte[]      data;
    final int         padBits;

    
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

    
    private String getString() throws Exception {
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
        } catch (Exception e) {
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
            throws Exception;
}
