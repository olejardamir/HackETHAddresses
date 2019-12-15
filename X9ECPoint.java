class X9ECPoint {
   private final ASN1OctetString encoding;
   private final ECCurve c;
   private ECPoint p;

   public X9ECPoint(ECCurve c, byte[] encoding) {
      super();
      this.c = c;
      byte[] result;
      if (encoding == null) {
         result = null;
      } else {
         byte[] copy = new byte[encoding.length];
         System.arraycopy(encoding, 0, copy, 0, encoding.length);
         result = copy;
      }
      this.encoding = new ASN1OctetString(result);
   }

   public synchronized ECPoint getPoint() {
      if (this.p == null) {
         this.p = this.c.decodePoint(this.encoding.getOctets()).normalize();
      }

      return this.p;
   }

   private ASN1OctetString toASN1Primitive() {
      return this.encoding;
   }

   public int hashCode() {
      return this.toASN1Primitive().hashCode();
   }
}
