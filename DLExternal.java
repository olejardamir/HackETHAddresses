
import java.io.ByteArrayOutputStream;
import java.io.IOException;

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
            baos.write(directReference.getEncoded("DL"));
        }
        if (indirectReference != null)
        {
            baos.write(indirectReference.getEncoded("DL"));
        }
        if (dataValueDescriptor != null)
        {
            baos.write(dataValueDescriptor.getEncoded("DL"));
        }
        DERTaggedObject obj = new DERTaggedObject(true, encoding, externalContent);
        baos.write(obj.getEncoded("DL"));
        out.writeEncoded(ASN1InputStream.CONSTRUCTED, ASN1InputStream.EXTERNAL, baos.toByteArray());
    }

    boolean asn1Equals(ASN1Primitive o) {
        return false;
    }
}
