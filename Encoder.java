
import java.io.IOException;
import java.io.OutputStream;

/**
 * Encode and decode byte arrays (typically from binary to 7-bit ASCII
 * encodings).
 */
public interface Encoder
{
    void encode(byte[] data, int off, int length, OutputStream out) throws IOException;

    void decode(String data, OutputStream out) throws IOException;
}
