
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

    /**
     * Creates a new instance of Definite-Length External.
     * See X.690 for more informations about the meaning of these parameters
     * @param directReference The direct reference or <code>null</code> if not set.
     * @param indirectReference The indirect reference or <code>null</code> if not set.
     * @param dataValueDescriptor The data value descriptor or <code>null</code> if not set.
     * @param encoding The encoding to be used for the external data
     * @param externalData The external data
     */
    private DLExternal(ASN1ObjectIdentifier directReference, ASN1Integer indirectReference, ASN1Primitive dataValueDescriptor, int encoding, ASN1Primitive externalData)
    {
        super(directReference, indirectReference, dataValueDescriptor, encoding, externalData);
    }

    @Override
    int encodedLength() {
        return 0;
    }

    /* (non-Javadoc)
     * @see org.bouncycastle.asn1.ASN1Primitive#encode(org.bouncycastle.asn1.DEROutputStream)
     */
    void encode(ASN1OutputStream out)
            throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (directReference != null)
        {
            baos.write(directReference.getEncoded(ASN1Encoding.DL));
        }
        if (indirectReference != null)
        {
            baos.write(indirectReference.getEncoded(ASN1Encoding.DL));
        }
        if (dataValueDescriptor != null)
        {
            baos.write(dataValueDescriptor.getEncoded(ASN1Encoding.DL));
        }
        DERTaggedObject obj = new DERTaggedObject(true, encoding, externalContent);
        baos.write(obj.getEncoded(ASN1Encoding.DL));
        out.writeEncoded(BERTags.CONSTRUCTED, BERTags.EXTERNAL, baos.toByteArray());
    }

    @Override
    boolean asn1Equals(ASN1Primitive o) {
        return false;
    }
}
