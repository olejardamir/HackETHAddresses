final class Arrays
{




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




}
