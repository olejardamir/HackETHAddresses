
import java.io.IOException;

/**
 * Parser for indefinite-length SETs.
 */
public class BERSetParser
        implements ASN1SetParser
{
    private final ASN1StreamParser _parser;

    BERSetParser(ASN1StreamParser parser)
    {
        this._parser = parser;
    }

    /**
     * Return an in-memory, encodable, representation of the SET.
     *
     * @return a BERSet.
     * @throws IOException if there is an issue loading the data.
     */
    public ASN1Primitive getLoadedObject()
            throws IOException
    {
        return new BERSet(_parser.readVector());
    }

    /**
     * Return an BERSet representing this parser and its contents.
     *
     * @return an BERSet
     */
    public ASN1Primitive toASN1Primitive()
    {
        try
        {
            return getLoadedObject();
        }
        catch (IOException e)
        {
          //  throw new ASN1ParsingException(e.getMessage(), e);
        }
        return null;
    }
}