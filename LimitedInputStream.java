
import java.io.InputStream;

/**
 * Internal use stream that allows reading of a limited number of bytes from a wrapped stream.
 */
abstract class LimitedInputStream
        extends InputStream
{
    InputStream _in;
    private int _limit;

    public LimitedInputStream() {
    }

    int getRemaining()
    {
        // TODO: maybe one day this can become more accurate
        return _limit;
    }

    void setParentEofDetect()
    {
        if (_in instanceof IndefiniteLengthInputStream)
        {
            ((IndefiniteLengthInputStream)_in).setEofOn00(true);
        }
    }
}
