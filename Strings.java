
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * String utilities.
 */
final class Strings
{

    static
    {
        String LINE_SEPARATOR;
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
            catch (Exception ignored)
            {
            }
        }
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


    public static String fromByteArray(byte[] bytes)
    {
        return new String(asCharArray(bytes));
    }

    private static char[] asCharArray(byte[] bytes)
    {
        char[] chars = new char[bytes.length];

        for (int i = 0; i != chars.length; i++)
        {
            chars[i] = (char)(bytes[i] & 0xff);
        }

        return chars;
    }







}
