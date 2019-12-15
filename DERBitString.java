import java.io.ByteArrayOutputStream;

class DERBitString
        extends ASN1Primitive {


    private static final char[]  table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    final byte[]      data;
    final int         padBits;

    public DERBitString(
            byte[]  data,
            int     padBits)
    {

        this.data = Arrays.clone(data);
        this.padBits = padBits;
    }

    public DERBitString(
            byte[]  data)
    {
        this(data, 0);
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

    int encodedLength()
    {
        return 1 + StreamUtil.calculateBodyLength(data.length + 1) + data.length + 1;
    }

    void encode(
            ASN1OutputStream out)
            throws Exception
    {
        byte[] string = derForm(data, padBits);
        byte[] bytes = new byte[string.length + 1];

        bytes[0] = (byte)getPadBits();
        System.arraycopy(string, 0, bytes, 1, bytes.length - 1);

        out.writeEncoded(ASN1InputStream.BIT_STRING, bytes);
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
        if (!(o instanceof DERBitString))
        {
            return false;
        }

        DERBitString other = (DERBitString)o;

        return this.padBits == other.padBits
                && Arrays.areEqual(this.getBytes(), other.getBytes());
    }

    ASN1Primitive toDERObject()
    {
        return new DERBitString(data, padBits);
    }
}
