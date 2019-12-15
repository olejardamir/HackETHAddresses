public class Pack {

   public static void intToBigEndian(int n, byte[] bs, int off) {
      bs[off] = (byte)(n >>> 24);
      ++off;
      bs[off] = (byte)(n >>> 16);
      ++off;
      bs[off] = (byte)(n >>> 8);
      ++off;
      bs[off] = (byte)n;
   }

   private static int littleEndianToInt(byte[] bs, int off) {
      int n = bs[off] & 255;
      ++off;
      n |= (bs[off] & 255) << 8;
      ++off;
      n |= (bs[off] & 255) << 16;
      ++off;
      n |= bs[off] << 24;
      return n;
   }

   private static void intToLittleEndian(int n, byte[] bs, int off) {
      bs[off] = (byte)n;
      ++off;
      bs[off] = (byte)(n >>> 8);
      ++off;
      bs[off] = (byte)(n >>> 16);
      ++off;
      bs[off] = (byte)(n >>> 24);
   }

   public static long littleEndianToLong(byte[] bs, int off) {
      int lo = littleEndianToInt(bs, off);
      int hi = littleEndianToInt(bs, off + 4);
      return ((long)hi & 4294967295L) << 32 | (long)lo & 4294967295L;
   }

   private static void longToLittleEndian(long n, byte[] bs, int off) {
      intToLittleEndian((int)(n & 4294967295L), bs, off);
      intToLittleEndian((int)(n >>> 32), bs, off + 4);
   }

   public static void longToLittleEndian(long[] ns, int nsOff, int nsLen, byte[] bs, int bsOff) {
      for(int i = 0; i < nsLen; ++i) {
         longToLittleEndian(ns[nsOff + i], bs, bsOff);
         bsOff += 8;
      }

   }
}
