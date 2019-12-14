
import java.util.Enumeration;

class LazyConstructionEnumeration
        implements Enumeration
{
    private final ASN1InputStream aIn;
    private Object          nextObj;

    public LazyConstructionEnumeration(byte[] encoded)
    {
        aIn = new ASN1InputStream(encoded, true);
        nextObj = readObject();
    }

    public boolean hasMoreElements()
    {
        return nextObj != null;
    }

    public Object nextElement()
    {
        Object o = nextObj;

        nextObj = readObject();

        return o;
    }

    private Object readObject()
    {
        try
        {
            return aIn.readObject();
        }
        catch (Exception e)
        {
          //  throw new ASN1ParsingException("malformed DER construction: " + e, e);
        }
        return null;
    }
}
