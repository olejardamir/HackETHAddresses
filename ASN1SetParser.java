
import java.io.IOException;

/**
 * A basic parser for a SET object
 */
public interface ASN1SetParser
        extends ASN1Encodable {
    ASN1Primitive getLoadedObject() throws IOException;
}
