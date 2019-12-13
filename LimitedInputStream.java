
import java.io.InputStream;

/**
 * Internal use stream that allows reading of a limited number of bytes from a wrapped stream.
 */
abstract class LimitedInputStream
        extends InputStream
{
    protected final InputStream _in;
    private int _limit;

    protected LimitedInputStream(InputStream in) {
        _in = in;
    }

    int getRemaining()
    {
        // TODO: maybe one day this can become more accurate
        return _limit;
    }

    protected void setParentEofDetect(boolean on)
    {
        if (_in instanceof IndefiniteLengthInputStream)
        {
            ((IndefiniteLengthInputStream)_in).setEofOn00(on);
        }
    }
}
