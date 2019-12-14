
import java.io.IOException;

/**
 * Parser for indefinite-length tagged objects.
 */
public class BERTaggedObjectParser
        implements ASN1Encodable {
    private final boolean _constructed;

    BERTaggedObjectParser(
            boolean constructed)
    {
        _constructed = constructed;
    }

    /**
     * Return true if this tagged object is marked as constructed.
     *
     * @return true if constructed, false otherwise.
     */
    public boolean isConstructed()
    {
        return _constructed;
    }

    /**
     * Return an in-memory, encodable, representation of the tagged object.
     *
     * @return an ASN1TaggedObject.
     * @throws IOException if there is an issue loading the data.
     */
    public ASN1Primitive getLoadedObject()
            throws IOException
    {
        return null;
    }

    /**
     * Return an ASN1TaggedObject representing this parser and its contents.
     *
     * @return an ASN1TaggedObject
     */
    public ASN1Primitive toASN1Primitive()
    {
        try
        {
            return this.getLoadedObject();
        }
        catch (IOException e)
        {
         //   throw new ASN1ParsingException(e.getMessage());
        }
        return null;
    }
}