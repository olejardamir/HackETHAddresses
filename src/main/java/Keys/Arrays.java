package Keys;

//done checkpoint clean
final class Arrays
{




    public static byte[] clone(byte[] data)
    {
        byte[] copy = new byte[data.length];

        System.arraycopy(data, 0, copy, 0, data.length);

        return copy;
    }




}
