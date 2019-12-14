
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Class representing the Definite-Length-type External
 */
class DLExternal
        extends ASN1External
{
    /**
     * Construct a Definite-Length EXTERNAL object, the input encoding vector must have exactly two elements on it.
     * <p>
     * Acceptable input formats are:
     * <ul>
     * <li> {@link ASN1ObjectIdentifier} + data {@link DERTaggedObject} (direct reference form)</li>
     * <li> {@link ASN1Integer} + data {@link DERTaggedObject} (indirect reference form)</li>
     * <li> Anything but {@link DERTaggedObject} + data {@link DERTaggedObject} (data value form)</li>
     * </ul>
     *
     * @throws IllegalArgumentException if input size is wrong, or
     */
    public DLExternal(ASN1EncodableVector vector)
    {
        super(vector);
    }

    int encodedLength() {
        return 0;
    }

    void encode(ASN1OutputStream out)
            throws IOException
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
