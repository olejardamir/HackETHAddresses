public class ASN1OctetString {
   private final byte[] string;

   ASN1OctetString(byte[] string) {
      super();
      this.string = string;
   }

   public byte[] getOctets() {
      return this.string;
   }
}
