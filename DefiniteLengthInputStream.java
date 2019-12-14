import java.io.InputStream;

/**
 * Parse data stream of expected ASN.1 data expecting definite-length encoding..
 */
class DefiniteLengthInputStream extends InputStream {
    private static final byte[] EMPTY_BYTES = new byte[0];

     private int _remaining;

    byte[] toByteArray()

    {
        if (_remaining == 0)
        {
            return EMPTY_BYTES;
        }

        byte[] bytes = new byte[_remaining];

         return bytes;
    }

     public int read()     {
        return 0;
    }
}
