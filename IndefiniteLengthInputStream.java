
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class IndefiniteLengthInputStream
        extends LimitedInputStream
{
    private int _b1;
    private int _b2;
    private boolean _eofReached = false;
    private boolean _eofOn00 = true;

    IndefiniteLengthInputStream(
            InputStream in)
            throws Exception
    {
        super();

        _b1 = in.read();
        _b2 = in.read();

        if (_b2 < 0)
        {
            // Corrupted stream
            throw new EOFException();
        }

        checkForEof();
    }

    void setEofOn00()
    {
        _eofOn00 = true;
        checkForEof();
    }

    private boolean checkForEof()
    {
        if (!_eofReached && _eofOn00 && (_b1 == 0x00 && _b2 == 0x00))
        {
            _eofReached = true;
            setParentEofDetect();
        }
        return _eofReached;
    }

    public int read(byte[] b, int off, int len) {
        // Only use this optimisation if we aren't checking for 00
        if (_eofOn00 || len < 3)
        {
            try {
                return super.read(b, off, len);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (_eofReached)
        {
            return -1;
        }

        int numRead = 0;
        try {
            numRead = _in.read(b, off + 2, len - 2);
        } catch (IOException e) {
            e.printStackTrace();
        }


        b[off] = (byte)_b1;
        b[off + 1] = (byte)_b2;

        try {
            _b1 = _in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            _b2 = _in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return numRead + 2;
    }

    public int read() throws IOException {
        if (checkForEof())
        {
            return -1;
        }

        int b = _in.read();


        int v = _b1;

        _b1 = _b2;
        _b2 = b;

        return v;
    }
}
