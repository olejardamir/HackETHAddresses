import java.io.IOException;

/**
 * Base class for an ASN.1 ApplicationSpecific object
 */
public abstract class ASN1ApplicationSpecific
        extends ASN1Primitive
{
    protected final boolean   isConstructed;
    protected final int       tag;
    protected final byte[]    octets;

    ASN1ApplicationSpecific(
            boolean isConstructed,
            int tag,
            byte[] octets)
    {
        this.isConstructed = isConstructed;
        this.tag = tag;
        this.octets = Arrays.clone(octets);
    }

    protected static int getLengthOfHeader(byte[] data)
    {
        int length = data[1] & 0xff; // TODO: assumes 1 byte tag

        if (length == 0x80)
        {
            return 2;      // indefinite-length encoding
        }

        if (length > 127)
        {
            int size = length & 0x7f;

            // Note: The invalid long form "0xff" (see X.690 8.1.3.5c) will be caught here
            if (size > 4)
            {
                throw new IllegalStateException("DER length more than 4 bytes: " + size);
            }

            return size + 2;
        }

        return 2;
    }

    /**
     * Return true if the object is marked as constructed, false otherwise.
     *
     * @return true if constructed, otherwise false.
     */
    public boolean isConstructed()
    {
        return isConstructed;
    }

    /**
     * Return the tag number associated with this object,
     *
     * @return the application tag number.
     */
    public int getApplicationTag()
    {
        return tag;
    }

    /* (non-Javadoc)
     * @see org.bouncycastle.asn1.ASN1Primitive#encode(org.bouncycastle.asn1.DEROutputStream)
     */
    void encode(ASN1OutputStream out) throws IOException
    {
        int classBits = BERTags.APPLICATION;
        if (isConstructed)
        {
            classBits |= BERTags.CONSTRUCTED;
        }

        out.writeEncoded(classBits, tag, octets);
    }

    public int hashCode()
    {
        return (isConstructed ? 1 : 0) ^ tag ^ Arrays.hashCode(octets);
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        if (isConstructed())
        {
            sb.append("CONSTRUCTED ");
        }
        sb.append("APPLICATION ");
        sb.append(getApplicationTag());
        sb.append("]");
        // @todo content encoding somehow?
        if (this.octets != null)
        {
            sb.append(" #");
            try {
                sb.append(Hex.toHexString(this.octets));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            sb.append(" #null");
        }
        sb.append(" ");
        return sb.toString();
    }
}
