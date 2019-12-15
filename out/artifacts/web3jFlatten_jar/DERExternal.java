import java.io.ByteArrayOutputStream;
import java.io.IOException;

class DERExternal extends ASN1External {
   public DERExternal(ASN1EncodableVector vector) {
      super(vector);
   }

   public DERExternal(ASN1ObjectIdentifier directReference, ASN1Integer indirectReference, ASN1Primitive dataValueDescriptor, DERTaggedObject externalData) {
      this(directReference, indirectReference, dataValueDescriptor, externalData.getTagNo(), externalData.toASN1Primitive());
   }

   private DERExternal(ASN1ObjectIdentifier directReference, ASN1Integer indirectReference, ASN1Primitive dataValueDescriptor, int encoding, ASN1Primitive externalData) {
      super(directReference, indirectReference, dataValueDescriptor, encoding, externalData);
   }

   int encodedLength() throws IOException {
      return this.getEncoded().length;
   }

   void encode(ASN1OutputStream out) throws IOException {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      if (this.directReference != null) {
         baos.write(this.directReference.getEncoded("DER"));
      }

      if (this.indirectReference != null) {
         baos.write(this.indirectReference.getEncoded("DER"));
      }

      if (this.dataValueDescriptor != null) {
         baos.write(this.dataValueDescriptor.getEncoded("DER"));
      }

      DERTaggedObject obj = new DERTaggedObject(true, this.encoding, this.externalContent);
      baos.write(obj.getEncoded("DER"));
      out.writeEncoded(32, 8, baos.toByteArray());
   }

   boolean asn1Equals(ASN1Primitive o) {
      return false;
   }
}
