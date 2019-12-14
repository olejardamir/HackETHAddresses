
import java.io.IOException;

/**
 * A parser for indefinite-length ASN.1 ApplicationSpecific objects.
 */
public class BERApplicationSpecificParser
        implements ASN1Encodable {


    /**
     * Return an in-memory, encodable, representation of the application specific object.
     *
     * @return a BERApplicationSpecific.
     * @throws IOException if there is an issue loading the data.
     */
    public ASN1Primitive getLoadedObject()

    {
        return  null;
    }

    /**
     * Return a BERApplicationSpecific representing this parser and its contents.
     *
     * @return a BERApplicationSpecific
     */
    public ASN1Primitive toASN1Primitive()
    {

            return getLoadedObject();


    }
}
