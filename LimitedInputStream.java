
import java.io.InputStream;

/**
 * Internal use stream that allows reading of a limited number of bytes from a wrapped stream.
 */
abstract class LimitedInputStream
        extends InputStream
{
    InputStream _in;


    int getRemaining()
    {
         return 0;
    }

    void setParentEofDetect()
    {
        if (_in instanceof IndefiniteLengthInputStream)
        {
            ((IndefiniteLengthInputStream)_in).setEofOn00(true);
        }
    }
}
