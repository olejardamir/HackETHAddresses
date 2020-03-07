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

    private static void intToLittleEndian(int n, byte[] bs, int off)
    {
        bs[off] = (byte)n; off++;
		bs[off] = (byte) (n >>> 8); off++;
		bs[off] = (byte) (n >>> 16); off++;
		bs[off] = (byte) (n >>> 24);
    }

    static long littleEndianToLong(byte[] bs, int off)
    {
        int off1 = off + 4;
        int off2 = off;
        return (bs[off2] & 0xff | (bs[++off2] & 0xff) << 8 | (bs[++off2] & 0xff) << 16 | bs[++off2] << 24) & 0xffffffffL | ((bs[off1] & 0xff | (bs[++off1] & 0xff) << 8 | (bs[++off1] & 0xff) << 16 | bs[++off1] << 24) & 0xffffffffL) << 32;
    }

    private static void longToLittleEndian(long n, byte[] bs, int off)
    {
        intToLittleEndian((int)(n & 0xffffffffL), bs, off);
        intToLittleEndian((int)(n >>> 32), bs, off + 4);
    }

    static void longToLittleEndian(long[] ns, int nsOff, int nsLen, byte[] bs, int bsOff)
    {
        for (int i = 0; i < nsLen; i += 1)
        {
            longToLittleEndian(ns[i], bs, bsOff);
            bsOff += 8;
        }
    }
}
