
import java.io.IOException;

/**
 * Parser class for DER SETs.
 */
public class DERSetParser
        implements ASN1SetParser
{
    private ASN1StreamParser _parser;

    /**
     * Return an in memory, encodable, representation of the SET.
     *
     * @return a DERSet.
     * @throws IOException if there is an issue loading the data.
     */
    public ASN1Primitive getLoadedObject()
            throws IOException
    {
        return null;
    }

    /**
     * Return a DERSet representing this parser and its contents.
     *
     * @return a DERSet
     */
    public ASN1Primitive toASN1Primitive()
    {
        try
        {
            return getLoadedObject();
        }
        catch (IOException e)
        {
           // throw new ASN1ParsingException(e.getMessage(), e);
        }

        return null;
    }
}
