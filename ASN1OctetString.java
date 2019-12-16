public class ASN1OctetString {
    private final byte[] string;


    ASN1OctetString(
            byte[] string) {

        this.string = string;
    }


    public byte[] getOctets() {
        return string;
    }


    public final boolean equals(Object o) {
        return this == o;
    }

    public ASN1OctetString toASN1Primitive() {
        return this;
    }

    public int hashCode() {
        return this.toASN1Primitive().hashCode();
    }
}
