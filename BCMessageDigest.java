import java.security.MessageDigest;

class BCMessageDigest extends MessageDigest {
   private final KeccakDigest digest;

   BCMessageDigest(KeccakDigest digest) {
      super(digest.getAlgorithmName());
      this.digest = digest;
   }

   public void engineReset() {
   }

   public void engineUpdate(byte input) {
   }

   public void engineUpdate(byte[] input, int offset, int len) {
      this.digest.update(input, offset, len);
   }

   public byte[] engineDigest() {
      byte[] digestBytes = new byte[this.digest.getDigestSize()];
      this.digest.doFinal(digestBytes, 0);
      return digestBytes;
   }
}
