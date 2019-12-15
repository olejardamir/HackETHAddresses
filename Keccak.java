import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.attribute.UserPrincipalNotFoundException;

class Keccak {
   private Keccak() {
      super();
   }

   public static class Digest256 {
      private static final int INITIAL = 0;
      private static final int IN_PROGRESS = 1;
      private final KeccakDigest digest;
      private int state = INITIAL;

      public Digest256() {
         this.digest = new KeccakDigest(256);
      }

      public void engineUpdate(byte[] input, int offset, int len) {
         this.digest.update(input, offset, len);
      }

      public byte[] engineDigest() {
         byte[] digestBytes = new byte[this.digest.getDigestSize()];
         this.digest.doFinal(digestBytes, 0);
         return digestBytes;
      }

      public void update(byte[] input, int offset, int len) {

          engineUpdate(input, offset, len);
          state = IN_PROGRESS;
      }

      public byte[] digest() {
           byte[] result = engineDigest();
          state = INITIAL;
          return result;
      }

      public String toString() {
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          PrintStream p = new PrintStream(baos);
          UserPrincipalNotFoundException provider = null;
          switch (state) {
              case INITIAL:
                  p.print("<initialized>");
                  break;
              case IN_PROGRESS:
                  p.print("<in progress>");
                  break;
          }
          p.println();
          return (baos.toString());
      }

      public Object clone() throws CloneNotSupportedException {
          if (this instanceof Cloneable) {
              return super.clone();
          } else {
              throw new CloneNotSupportedException();
          }
      }
   }
}
