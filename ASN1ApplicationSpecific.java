import java.io.IOException;

/**
 * Base class for an ASN.1 ApplicationSpecific object
 */
public abstract class ASN1ApplicationSpecific
        extends ASN1Primitive
{
    final boolean   isConstructed;
    final int       tag;
    final byte[]    octets;

    ASN1ApplicationSpecific(
            boolean isConstructed,
            int tag,
            byte[] octets)
    {
        this.isConstructed = isConstructed;
        this.tag = tag;
        this.octets = Arrays.clone(octets);
    }

    /**
     * Return true if the object is marked as constructed, false otherwise.
     *
     * @return true if constructed, otherwise false.
     */
    private boolean isConstructed()
    {
        return isConstructed;
    }

    /**
     * Return the tag number associated with this object,
     *
     * @return the application tag number.
     */
    private int getApplicationTag()
    {
        return tag;
    }

    public int hashCode()
    {
        return (isConstructed ? 1 : 0) ^ tag ^ Arrays.hashCode(octets);
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
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
