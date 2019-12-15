// 
// Decompiled by Procyon v0.5.36
// 

public class Pack
{
    public static void intToBigEndian(final int n, final byte[] bs, int off) {
        bs[off] = (byte)(n >>> 24);
        bs[++off] = (byte)(n >>> 16);
        bs[++off] = (byte)(n >>> 8);
        bs[++off] = (byte)n;
    }
    
    private static int littleEndianToInt(final byte[] bs, int off) {
        int n = bs[off] & 0xFF;
        n |= (bs[++off] & 0xFF) << 8;
        n |= (bs[++off] & 0xFF) << 16;
        n |= bs[++off] << 24;
        return n;
    }
    
    private static void intToLittleEndian(final int n, final byte[] bs, int off) {
        bs[off] = (byte)n;
        bs[++off] = (byte)(n >>> 8);
        bs[++off] = (byte)(n >>> 16);
        bs[++off] = (byte)(n >>> 24);
    }
    
    public static long littleEndianToLong(final byte[] bs, final int off) {
        final int lo = littleEndianToInt(bs, off);
        final int hi = littleEndianToInt(bs, off + 4);
        return ((long)hi & 0xFFFFFFFFL) << 32 | ((long)lo & 0xFFFFFFFFL);
    }
    
    private static void longToLittleEndian(final long n, final byte[] bs, final int off) {
        intToLittleEndian((int)(n & 0xFFFFFFFFL), bs, off);
        intToLittleEndian((int)(n >>> 32), bs, off + 4);
    }
    
    public static void longToLittleEndian(final long[] ns, final int nsOff, final int nsLen, final byte[] bs, int bsOff) {
        for (int i = 0; i < nsLen; ++i) {
            longToLittleEndian(ns[nsOff + i], bs, bsOff);
            bsOff += 8;
        }
    }
}
