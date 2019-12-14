
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;


class BEROctetString
        extends ASN1OctetString
{
    final private int chunkSize;
    final private ASN1OctetString[] octs;

    /**
     * Convert a vector of octet strings into a single byte string
     */
    static private byte[] toBytes(
            ASN1OctetString[]  octs)
    {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        for (int i = 0; i != octs.length; i++)
        {
            try
            {
                DEROctetString o = (DEROctetString)octs[i];

                bOut.write(o.getOctets());
            }
            catch (ClassCastException e)
            {
                throw new IllegalArgumentException(octs[i].getClass().getName() + " found in input should only contain DEROctetString");
            }
            catch (Exception e)
            {
                throw new IllegalArgumentException("exception converting octets " + e.toString());
            }
        }

        return bOut.toByteArray();
    }

    public BEROctetString(ASN1OctetString[] a) {
        this(a, 1000);
    }

    private BEROctetString(ASN1OctetString[] a, int i) {
        this(BEROctetString.toBytes(a), a, i);
    }

    private BEROctetString(byte[] string, ASN1OctetString[] octs, int chunkSize)
    {
        super(string);
        this.octs = octs;
        this.chunkSize = chunkSize;
    }

    /**
     * Return the OCTET STRINGs that make up this string.
     *
     * @return an Enumeration of the component OCTET STRINGs.
     */
    private Enumeration getObjects()
    {
        if (octs == null)
        {
            return generateOcts().elements();
        }

        return new Enumeration()
        {
            int counter = 0;

            public boolean hasMoreElements()
            {
                return counter < octs.length;
            }

            public Object nextElement()
            {
                return octs[counter++];
            }
        };
    }

    private Vector generateOcts()
    {
        Vector vec = new Vector();
        for (int i = 0; i < string.length; i += chunkSize)
        {
            int end;

            if (i + chunkSize > string.length)
            {
                end = string.length;
            }
            else
            {
                end = i + chunkSize;
            }

            byte[] nStr = new byte[end - i];

            System.arraycopy(string, i, nStr, 0, nStr.length);

            vec.addElement(new DEROctetString(nStr));
        }

        return vec;
    }

    int encodedLength()
            throws Exception
    {
        int length = 0;
        for (Enumeration e = getObjects(); e.hasMoreElements();)
        {
            length += ((ASN1Encodable)e.nextElement()).toASN1Primitive().encodedLength();
        }

        return 2 + length + 2;
    }

    public void encode(ASN1OutputStream a) throws Exception {
        a.write(36);
        a.write(128);
        Object a0 = this.getObjects();
        while(((java.util.Enumeration)a0).hasMoreElements()) {
            a.writeObject((ASN1Encodable)((java.util.Enumeration)a0).nextElement());
        }
        a.write(0);
        a.write(0);
    }

}
