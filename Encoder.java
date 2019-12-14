
import java.io.OutputStream;


interface Encoder
{
    void encode(byte[] data, int off, int length, OutputStream out) throws Exception;

    void decode(String data, OutputStream out) throws Exception;
}
