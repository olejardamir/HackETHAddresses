package Keys;


abstract class Pack
{

    public static void intToBigEndian(int n, byte[] bs, int off)
    {
        int i1;
		i1 = n >>> 24;
		bs[off] = (byte) (i1);
		int i2;
		i2 = n >>> 16;
		off = off + 1;
		bs[off] = (byte) (i2);
		int i3;
		i3 = n >>> 8;
		off = off + 1;
		bs[off] = (byte) (i3);
		off = off + 1;
		bs[off] = (byte)n;
    }

    private static int littleEndianToInt(byte[] bs, int off)
    {
        return bs[off] & 0xff | (bs[++off] & 0xff) << 8 | (bs[++off] & 0xff) << 16 | bs[++off] << 24;
    }

    private static void intToLittleEndian(int n, byte[] bs, int off)
    {
        bs[  off] = (byte)n;
        int i1;
		i1 = n >>> 8;
		off = off + 1;
		bs[off] = (byte) (i1);
		int i2;
		i2 = n >>> 16;
		off = off + 1;
		bs[off] = (byte) (i2);
		int i3;
		i3 = n >>> 24;
		off = off + 1;
		bs[off] = (byte) (i3);
    }

    public static long littleEndianToLong(byte[] bs, int off)
    {
        int lo;
		lo = littleEndianToInt(bs, off);
		int hi;
		int i1;
		i1 = off + 4;
		hi = littleEndianToInt(bs, i1);
		long l1;
		long l2;
		l2 = lo & 0xffffffffL;
		long l3;
		long l4;
		l4 = hi & 0xffffffffL;
		l3 = (l4) << 32;
		l1 = l2 | l3;
		return l1;
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
