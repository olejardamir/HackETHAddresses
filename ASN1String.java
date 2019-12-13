import java.io.IOException;

/**
 * General interface implemented by ASN.1 STRING objects for extracting the content String.
 */
interface ASN1String
{
    /**
     * Return a Java String representation of this STRING type's content.
     * @return a Java String representation of this STRING.
     */
    String getString() throws IOException;
}
