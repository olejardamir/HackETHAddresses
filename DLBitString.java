import java.io.ByteArrayOutputStream;

class DLBitString
        extends ASN1Primitive {


    private static final char[]  table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    final byte[]      data;
    final int         padBits;

    public DLBitString(
            byte[]  data,
            int     padBits)
    {



        this.data = Arrays.clone(data);
        this.padBits = padBits;
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

    int encodedLength() {
        return 0;
    }

     void encode(ASN1OutputStream out) {

    }

     boolean asn1Equals(ASN1Primitive o) {
        return false;
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




    ASN1Primitive toDERObject()
    {
        return new DERBitString(data, padBits);
    }

}
