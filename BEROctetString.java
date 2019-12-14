
import java.util.Enumeration;
import java.util.Vector;


class BEROctetString
        extends ASN1OctetString
{
      private int chunkSize;
      private ASN1OctetString[] octs;

    public BEROctetString() {
        super();

    }

     int encodedLength() throws Exception {
        return 0;
    }

     void encode(ASN1OutputStream out) throws Exception {

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

}
