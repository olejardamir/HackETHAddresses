
import java.io.IOException;
import java.io.InputStream;

/**
 * Utility methods to assist with stream processing.
 */
final class Streams
{

    /**
     * Fully read in buf's length in data, or up to EOF, whichever occurs first,
     *
     * @param inStr the stream to be read.
     * @param buf the buffer to be read into.
     * @return the number of bytes read into the buffer.
     * @throws IOException in case of underlying IOException.
     */
    public static int readFully(InputStream inStr, byte[] buf)
            throws IOException
    {
        return readFully(inStr, buf, buf.length);
    }

    /**
     * Fully read in len's bytes of data into buf, or up to EOF, whichever occurs first,
     *
     * @param inStr the stream to be read.
     * @param buf the buffer to be read into.
     * @param len  the number of bytes to be read.
     * @return the number of bytes read into the buffer.
     * @throws IOException in case of underlying IOException.
     */
    private static int readFully(InputStream inStr, byte[] buf, int len)
            throws IOException
    {
        int totalRead = 0;
        while (totalRead < len)
        {
            int numRead = inStr.read(buf, totalRead, len - totalRead);
            if (numRead < 0)
            {
                break;
            }
            totalRead += numRead;
        }
        return totalRead;
    }

}
