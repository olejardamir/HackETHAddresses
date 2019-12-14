/**
 * A DER encoding version of an application specific object.
 */
class DLApplicationSpecific
        extends ASN1ApplicationSpecific
{

    DLApplicationSpecific(boolean isConstructed, int tag, byte[] octets) {
        super(isConstructed, tag, octets);
    }

    int encodedLength() {
        return 0;
    }

     void encode(ASN1OutputStream out)   {

    }

    boolean asn1Equals(ASN1Primitive o) {
        return false;
    }
}
