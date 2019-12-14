
import java.io.ByteArrayOutputStream;

class DLExternal
        extends ASN1External
{

    public DLExternal(ASN1EncodableVector vector)
    {
        super(vector);
    }

    int encodedLength() {
        return 0;
    }

    void encode(ASN1OutputStream out)
            throws Exception
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (directReference != null)
        {
            baos.write(directReference.getEncoded());
        }
        if (indirectReference != null)
        {
            baos.write(indirectReference.getEncoded());
        }
        if (dataValueDescriptor != null)
        {
            baos.write(dataValueDescriptor.getEncoded());
        }
        DERTaggedObject obj = new DERTaggedObject(true, encoding, externalContent);
        baos.write(obj.getEncoded());
        out.writeEncoded(ASN1InputStream.CONSTRUCTED, baos.toByteArray());
    }

    boolean asn1Equals(ASN1Primitive o) {
        return false;
    }
}
