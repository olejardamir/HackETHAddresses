
import java.util.Enumeration;

class LazyConstructionEnumeration
        implements Enumeration
{
    private  ASN1InputStream aIn;
    private Object          nextObj;

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
          
        }
        return null;
    }
}
