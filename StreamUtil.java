
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

class StreamUtil
{
    private static final long  MAX_MEMORY = Runtime.getRuntime().maxMemory();

    /**
     * Find out possible longest length...
     *
     * @param in input stream of interest
     * @return length calculation or MAX_VALUE.
     */
    static int findLimit(InputStream in)
    {
        if (in instanceof LimitedInputStream)
        {
            return ((LimitedInputStream)in).getRemaining();
        }
        else if (in instanceof ASN1InputStream)
        {
            return ((ASN1InputStream)in).getLimit();
        }
        else if (in instanceof ByteArrayInputStream)
        {
            return ((ByteArrayInputStream)in).available();
        }
        else if (in instanceof FileInputStream)
        {
            try
            {
                FileChannel channel = ((FileInputStream)in).getChannel();
                long  size = (channel != null) ? channel.size() : Integer.MAX_VALUE;

                if (size < Integer.MAX_VALUE)
                {
                    return (int)size;
                }
            }
            catch (Exception e)
            {
                // ignore - they'll find out soon enough!
            }
        }

        if (MAX_MEMORY > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }

        return (int)MAX_MEMORY;
    }

    static int calculateBodyLength(int i) {
        int i0 = 0;
        if (i <= 127) {
            i0 = 1;
        } else {
            int i1 = 1;
            while(true) {
                int i2 = i >>> 8;
                if (i2 == 0) {
                    break;
                }
                i1 = i1 + 1;
                i = i2;
            }
            int i3 = (i1 - 1) * 8;
            i0 = 1;
            for(; i3 >= 0; i3 = i3 + -8) {
                i0 = i0 + 1;
            }
        }
        return i0;
    }

    static int calculateTagLength(int tagNo) {
        int length = 1;

        if (tagNo >= 31)
        {
            if (tagNo < 128)
            {
                length++;
            }
            else
            {
                byte[] stack = new byte[5];
                int pos = stack.length;

                stack[--pos] = (byte)(tagNo & 0x7F);

                do
                {
                    tagNo >>= 7;
                    stack[--pos] = (byte)(tagNo & 0x7F | 0x80);
                }
                while (tagNo > 127);

                length += stack.length - pos;
            }
        }

        return length;
    }
}
