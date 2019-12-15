
import java.io.OutputStream;


interface Encoder
{

    void decode(String data, OutputStream out) throws Exception;
}
