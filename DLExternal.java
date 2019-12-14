
import java.io.ByteArrayOutputStream;

class DLExternal
        extends ASN1External
{

    public DLExternal(ASN1EncodableVector vector)
    {
        super(vector);
    }

     int encodedLength() throws Exception {
        return 0;
    }

     void encode(ASN1OutputStream out) throws Exception {

    }

     boolean asn1Equals(ASN1Primitive o) {
        return false;
    }
}
