import java.math.BigInteger;

final class BigIntegers {
   BigIntegers() {
      super();
   }

   public static byte[] asUnsignedByteArray(BigInteger value) {
      return value.toByteArray();
   }

   public static BigInteger fromUnsignedByteArray(byte[] buf, int off, int length) {
      byte[] mag = buf;
      if (off != 0 || length != buf.length) {
         mag = new byte[length];
         System.arraycopy(buf, off, mag, 0, length);
      }

      return new BigInteger(1, mag);
   }
}
