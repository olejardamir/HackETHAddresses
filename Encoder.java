
import java.io.IOException;
import java.io.OutputStream;

/**
 * Encode and decode byte arrays (typically from binary to 7-bit ASCII
 * encodings).
 */
interface Encoder
{
    void encode(byte[] data, int off, int length, OutputStream out) throws Exception;

    void decode(String data, OutputStream out) throws Exception;
}
