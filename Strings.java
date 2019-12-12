
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Vector;

/**
 * String utilities.
 */
public final class Strings
{
    private static String LINE_SEPARATOR;

    static
    {
        try
        {
            LINE_SEPARATOR = AccessController.doPrivileged(new PrivilegedAction<String>()
            {
                public String run()
                {
                    // the easy way
                    return System.getProperty("line.separator");
                }
            });

        }
        catch (Exception e)
        {
            try
            {
                // the harder way
                LINE_SEPARATOR = String.format("%n");
            }
            catch (Exception ef)
            {
                LINE_SEPARATOR = "\n";   // we're desperate use this...
            }
        }
    }





    public static void toUTF8ByteArray(char[] string, OutputStream sOut)
            throws IOException
    {
        char[] c = string;
        int i = 0;

        while (i < c.length)
        {
            char ch = c[i];

            if (ch < 0x0080)
            {
                sOut.write(ch);
            }
            else if (ch < 0x0800)
            {
                sOut.write(0xc0 | (ch >> 6));
                sOut.write(0x80 | (ch & 0x3f));
            }
            // surrogate pair
            else if (ch >= 0xD800 && ch <= 0xDFFF)
            {
                // in error - can only happen, if the Java String class has a
                // bug.
                if (i + 1 >= c.length)
                {
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                }
                char W1 = ch;
                ch = c[++i];
                char W2 = ch;
                // in error - can only happen, if the Java String class has a
                // bug.
                if (W1 > 0xDBFF)
                {
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                }
                int codePoint = (((W1 & 0x03FF) << 10) | (W2 & 0x03FF)) + 0x10000;
                sOut.write(0xf0 | (codePoint >> 18));
                sOut.write(0x80 | ((codePoint >> 12) & 0x3F));
                sOut.write(0x80 | ((codePoint >> 6) & 0x3F));
                sOut.write(0x80 | (codePoint & 0x3F));
            }
            else
            {
                sOut.write(0xe0 | (ch >> 12));
                sOut.write(0x80 | ((ch >> 6) & 0x3F));
                sOut.write(0x80 | (ch & 0x3F));
            }

            i++;
        }
    }


    public static String toUpperCase(String string)
    {
        boolean changed = false;
        char[] chars = string.toCharArray();

        for (int i = 0; i != chars.length; i++)
        {
            char ch = chars[i];
            if ('a' <= ch && 'z' >= ch)
            {
                changed = true;
                chars[i] = (char)(ch - 'a' + 'A');
            }
        }

        if (changed)
        {
            return new String(chars);
        }

        return string;
    }


    public static String toLowerCase(String string)
    {
        boolean changed = false;
        char[] chars = string.toCharArray();

        for (int i = 0; i != chars.length; i++)
        {
            char ch = chars[i];
            if ('A' <= ch && 'Z' >= ch)
            {
                changed = true;
                chars[i] = (char)(ch - 'A' + 'a');
            }
        }

        if (changed)
        {
            return new String(chars);
        }

        return string;
    }

    public static byte[] toByteArray(char[] chars)
    {
        byte[] bytes = new byte[chars.length];

        for (int i = 0; i != bytes.length; i++)
        {
            bytes[i] = (byte)chars[i];
        }

        return bytes;
    }


    public static byte[] toByteArray(String string)
    {
        byte[] bytes = new byte[string.length()];

        for (int i = 0; i != bytes.length; i++)
        {
            char ch = string.charAt(i);

            bytes[i] = (byte)ch;
        }

        return bytes;
    }

    public static int toByteArray(String s, byte[] buf, int off)
    {
        int count = s.length();
        for (int i = 0; i < count; ++i)
        {
            char c = s.charAt(i);
            buf[off + i] = (byte)c;
        }
        return count;
    }


    public static String fromByteArray(byte[] bytes)
    {
        return new String(asCharArray(bytes));
    }

    public static char[] asCharArray(byte[] bytes)
    {
        char[] chars = new char[bytes.length];

        for (int i = 0; i != chars.length; i++)
        {
            chars[i] = (char)(bytes[i] & 0xff);
        }

        return chars;
    }







}
