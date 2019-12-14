
import java.io.IOException;
import java.io.InputStream;

/**
 * A basic parser for an OCTET STRING object
 */
public interface ASN1OctetStringParser
        extends ASN1Encodable {
    /**
     * Return the content of the OCTET STRING as an InputStream.
     *
     * @return an InputStream representing the OCTET STRING's content.
     */
    InputStream getOctetStream();

    ASN1Primitive getLoadedObject() throws IOException;
}

