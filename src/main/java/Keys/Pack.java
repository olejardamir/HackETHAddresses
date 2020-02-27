package Keys;


abstract class Pack
{

    public static void intToBigEndian(int n, byte[] bs, int off)
    {
		bs[off] = (byte) (n >>> 24); off++;
		bs[off] = (byte) (n >>> 16); off++;
		bs[off] = (byte) (n >>> 8); off++;
		bs[off] = (byte)n;
    }

    private static int littleEndianToInt(byte[] bs, int off)
    {
        return bs[off] & 0xff | (bs[++off] & 0xff) << 8 | (bs[++off] & 0xff) << 16 | bs[++off] << 24;
    }

    private static void intToLittleEndian(int n, byte[] bs, int off)
    {
        bs[off] = (byte)n; off++;
		bs[off] = (byte) (n >>> 8); off++;
		bs[off] = (byte) (n >>> 16); off++;
		bs[off] = (byte) (n >>> 24);
    }

    public static long littleEndianToLong(byte[] bs, int off)
    {
		return littleEndianToInt(bs, off) & 0xffffffffL | (littleEndianToInt(bs, off + 4) & 0xffffffffL) << 32;
    }

    private static void longToLittleEndian(long n, byte[] bs, int off)
    {
        intToLittleEndian((int)(n & 0xffffffffL), bs, off);
        intToLittleEndian((int)(n >>> 32), bs, off + 4);
    }

    public static void longToLittleEndian(long[] ns, int nsOff, int nsLen, byte[] bs, int bsOff)
    {
        for (int i = 0; i < nsLen; i += 1)
        {
            longToLittleEndian(ns[i + nsOff], bs, bsOff);
            bsOff += 8;
        }
    }
}
