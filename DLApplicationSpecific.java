
import java.io.IOException;

/**
 * A DER encoding version of an application specific object.
 */
public class DLApplicationSpecific
        extends ASN1ApplicationSpecific
{
    DLApplicationSpecific(
            boolean isConstructed,
            int     tag,
            byte[]  octets)
    {
        super(isConstructed, tag, octets);
    }

    @Override
    int encodedLength() throws IOException {
        return 0;
    }


    void encode(ASN1OutputStream out) throws IOException
    {
        int classBits = BERTags.APPLICATION;
        if (isConstructed)
        {
            classBits |= BERTags.CONSTRUCTED;
        }

        out.writeEncoded(classBits, tag, octets);
    }

    @Override
    boolean asn1Equals(ASN1Primitive o) {
        return false;
    }
}
