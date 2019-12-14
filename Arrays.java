
import java.util.NoSuchElementException;


final class Arrays
{

    public static boolean areEqual(
            byte[]  a,
            byte[]  b)
    {
        if (a == b)
        {
            return true;
        }

        if (a == null || b == null)
        {
            return false;
        }

        if (a.length != b.length)
        {
            return false;
        }

        for (int i = 0; i != a.length; i++)
        {
            if (a[i] != b[i])
            {
                return false;
            }
        }

        return true;
    }

    public static boolean areEqual(
            int[]  a,
            int[]  b)
    {
        if (a == b)
        {
            return true;
        }

        if (a == null || b == null)
        {
            return false;
        }

        if (a.length != b.length)
        {
            return false;
        }

        for (int i = 0; i != a.length; i++)
        {
            if (a[i] != b[i])
            {
                return false;
            }
        }

        return true;
    }

    public static void fill(
            byte[] array,
            byte value)
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = value;
        }
    }

    public static int hashCode(byte[] data)
    {
        if (data == null)
        {
            return 0;
        }

        int i = data.length;
        int hc = i + 1;

        while (--i >= 0)
        {
            hc *= 257;
            hc ^= data[i];
        }

        return hc;
    }

    public static int hashCode(int[] data)
    {
        if (data == null)
        {
            return 0;
        }

        int i = data.length;
        int hc = i + 1;

        while (--i >= 0)
        {
            hc *= 257;
            hc ^= data[i];
        }

        return hc;
    }

    public static int hashCode(int[] data, int off, int len)
    {
        if (data == null)
        {
            return 0;
        }

        int i = len;
        int hc = i + 1;

        while (--i >= 0)
        {
            hc *= 257;
            hc ^= data[off + i];
        }

        return hc;
    }

    public static byte[] clone(byte[] data)
    {
        if (data == null)
        {
            return null;
        }
        byte[] copy = new byte[data.length];

        System.arraycopy(data, 0, copy, 0, data.length);

        return copy;
    }

    public static int[] clone(int[] data)
    {
        if (data == null)
        {
            return null;
        }
        int[] copy = new int[data.length];

        System.arraycopy(data, 0, copy, 0, data.length);

        return copy;
    }

    public static long[] clone(long[] data)
    {
        if (data == null)
        {
            return null;
        }
        long[] copy = new long[data.length];

        System.arraycopy(data, 0, copy, 0, data.length);

        return copy;
    }


    /**
     * Iterator backed by a specific array.
     */
    public static class Iterator<T>
            implements java.util.Iterator<T>
    {
        private final T[] dataArray;

        private int position = 0;

        /**
         * Base constructor.
         * <p>
         * Note: the array is not cloned, changes to it will affect the values returned by next().
         * </p>
         *
         * @param dataArray array backing the iterator.
         */
        public Iterator(T[] dataArray)
        {
            this.dataArray = dataArray;
        }

        public boolean hasNext()
        {
            return position < dataArray.length;
        }

        public T next()
        {
            if (position == dataArray.length)
            {
                throw new NoSuchElementException("Out of elements: " + position);
            }

            return dataArray[position++];
        }

        public void remove()
        {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }
    }

}
