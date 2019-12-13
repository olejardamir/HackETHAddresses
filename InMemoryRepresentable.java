
import java.io.IOException;

/**
 * Interface implemented by objects that can be converted from streaming to in-memory objects.
 */
interface InMemoryRepresentable
{

    ASN1Primitive getLoadedObject() throws IOException;
}
