
/**
 * Utility methods for converting byte arrays into ints and longs, and back again.
 */
abstract class Pack
{

    public static void intToBigEndian(int n, byte[] bs, int off)
    {
        bs[  off] = (byte)(n >>> 24);
        bs[++off] = (byte)(n >>> 16);
        bs[++off] = (byte)(n >>>  8);
        bs[++off] = (byte)(n       );
    }

    private static int littleEndianToInt(byte[] bs, int off)
    {
        int n = bs[  off] & 0xff;
        n |= (bs[++off] & 0xff) << 8;
        n |= (bs[++off] & 0xff) << 16;
        n |= bs[++off] << 24;
        return n;
    }

    private static void intToLittleEndian(int n, byte[] bs, int off)
    {
        bs[  off] = (byte)(n       );
        bs[++off] = (byte)(n >>>  8);
        bs[++off] = (byte)(n >>> 16);
        bs[++off] = (byte)(n >>> 24);
    }

    public static long littleEndianToLong(byte[] bs, int off)
    {
        int lo = littleEndianToInt(bs, off);
        int hi = littleEndianToInt(bs, off + 4);
        return ((hi & 0xffffffffL) << 32) | (lo & 0xffffffffL);
    }

    private static void longToLittleEndian(long n, byte[] bs, int off)
    {
        intToLittleEndian((int)(n & 0xffffffffL), bs, off);
        intToLittleEndian((int)(n >>> 32), bs, off + 4);
    }

    public static void longToLittleEndian(long[] ns, int nsOff, int nsLen, byte[] bs, int bsOff)
    {
        for (int i = 0; i < nsLen; ++i)
        {
            longToLittleEndian(ns[nsOff + i], bs, bsOff);
            bsOff += 8;
        }
    }
}
