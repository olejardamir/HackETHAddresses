import java.io.IOException;

/**
 * A DER encoding version of an application specific object.
 */
class DLApplicationSpecific
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
    int encodedLength() {
        return 0;
    }

    @Override
    void encode(ASN1OutputStream out) {

    }


    @Override
    boolean asn1Equals(ASN1Primitive o) {
        return false;
    }
}
