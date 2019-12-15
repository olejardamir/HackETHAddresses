class Keccak {
   private Keccak() {
      super();
   }

   public static class Digest256 extends BCMessageDigest {
      public Digest256() {
         super(new KeccakDigest(256));
      }
   }
}
