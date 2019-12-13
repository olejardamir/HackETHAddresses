
import java.io.IOException;

/**
 * Parser class for DER SEQUENCEs.
 */
public class DERSequenceParser
        implements ASN1SequenceParser
{
    private final ASN1StreamParser _parser;

    DERSequenceParser(ASN1StreamParser parser)
    {
        this._parser = parser;
    }

    /**
     * Return an in memory, encodable, representation of the SEQUENCE.
     *
     * @return a DERSequence.
     * @throws IOException if there is an issue loading the data.
     */
    public ASN1Primitive getLoadedObject()
            throws IOException
    {
        return new DERSequence(_parser.readVector());
    }

    /**
     * Return a DERSequence representing this parser and its contents.
     *
     * @return a DERSequence.
     */
    public ASN1Primitive toASN1Primitive()
    {
        try
        {
            return getLoadedObject();
        }
        catch (IOException e)
        {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
