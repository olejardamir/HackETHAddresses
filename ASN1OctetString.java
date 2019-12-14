import java.io.IOException;

/**
 * Abstract base for the ASN.1 OCTET STRING data type
 * <p>
 * This supports BER, and DER forms of the data.
 * </p><p>
 * DER form is always primitive single OCTET STRING, while
 * BER support includes the constructed forms.
 * </p>
 * <p><b>X.690</b></p>
 * <p><b>8: Basic encoding rules</b></p>
 * <p><b>8.7 Encoding of an octetstring value</b></p>
 * <p>
 * <b>8.7.1</b> The encoding of an octetstring value shall be
 * either primitive or constructed at the option of the sender.
 * <blockquote>
 * NOTE &mdash; Where it is necessary to transfer part of an octet string
 * before the entire OCTET STRING is available, the constructed encoding
 * is used.
 * </blockquote>
 * <p>
 * <b>8.7.2</b> The primitive encoding contains zero,
 * one or more contents octets equal in value to the octets
 * in the data value, in the order they appear in the data value,
 * and with the most significant bit of an octet of the data value
 * aligned with the most significant bit of an octet of the contents octets.
 * </p>
 * <p>
 * <b>8.7.3</b> The contents octets for the constructed encoding shall consist
 * of zero, one, or more encodings.
 * </p>
 * <blockquote>
 * NOTE &mdash; Each such encoding includes identifier, length, and contents octets,
 * and may include end-of-contents octets if it is constructed.
 * </blockquote>
 * <p>
 * <b>8.7.3.1</b> To encode an octetstring value in this way,
 * it is segmented. Each segment shall consist of a series of
 * consecutive octets of the value. There shall be no significance
 * placed on the segment boundaries.</p>
 * <blockquote>
 * NOTE &mdash; A segment may be of size zero, i.e. contain no octets.
 * </blockquote>
 * <p>
 * <b>8.7.3.2</b> Each encoding in the contents octets shall represent
 * a segment of the overall octetstring, the encoding arising from
 * a recursive application of this subclause.
 * In this recursive application, each segment is treated as if it were
 * a octetstring value. The encodings of the segments shall appear in the contents
 * octets in the order in which their octets appear in the overall value.
 * </p>
 * <blockquote>
 * NOTE 1 &mdash; As a consequence of this recursion,
 * each encoding in the contents octets may itself
 * be primitive or constructed.
 * However, such encodings will usually be primitive.
 * </blockquote>
 * <blockquote>
 * NOTE 2 &mdash; In particular, the tags in the contents octets are always universal class, number 4.
 * </blockquote>
 * <p><b>9: Canonical encoding rules</b></p>
 * <p><b>9.1 Length forms</b></p>
 * <p>
 * If the encoding is constructed, it shall employ the indefinite-length form.
 * If the encoding is primitive, it shall include the fewest length octets necessary.
 * [Contrast with 8.1.3.2 b).]
 * </p>
 * <p><b>9.2 String encoding forms</b></p>
 * <p>
 * BIT STRING, OCTET STRING,and restricted character string
 * values shall be encoded with a primitive encoding if they would
 * require no more than 1000 contents octets, and as a constructed
 * encoding otherwise. The string fragments contained in
 * the constructed encoding shall be encoded with a primitive encoding.
 * The encoding of each fragment, except possibly
 * the last, shall have 1000 contents octets. (Contrast with 8.21.6.)
 * </p><p>
 * <b>10: Distinguished encoding rules</b>
 * </p><p>
 * <b>10.1 Length forms</b>
 * The definite form of length encoding shall be used,
 * encoded in the minimum number of octets.
 * [Contrast with 8.1.3.2 b).]
 * </p><p>
 * <b>10.2 String encoding forms</b>
 * For BIT STRING, OCTET STRING and restricted character string types,
 * the constructed form of encoding shall not be used.
 * (Contrast with 8.21.6.)
 */
public abstract class ASN1OctetString
        extends ASN1Primitive
 {
    byte[]  string;

    /**
     * Base constructor.
     *
     * @param string the octets making up the octet string.
     */
    ASN1OctetString(
            byte[] string)
    {
        if (string == null)
        {
            throw new NullPointerException("string cannot be null");
        }
        this.string = string;
    }

     /**
     * Return the content of the OCTET STRING as a byte array.
     *
     * @return the byte[] representing the OCTET STRING's content.
     */
    public byte[] getOctets()
    {
        return string;
    }

    public int hashCode()
    {
        return Arrays.hashCode(this.getOctets());
    }

    boolean asn1Equals(
            ASN1Primitive o)
    {
        if (!(o instanceof ASN1OctetString))
        {
            return false;
        }

        ASN1OctetString  other = (ASN1OctetString)o;

        return Arrays.areEqual(string, other.string);
    }

    ASN1Primitive toDERObject()
    {
        return new DEROctetString(string);
    }

    ASN1Primitive toDLObject()
    {
        return new DEROctetString(string);
    }

    abstract void encode(ASN1OutputStream out)
            throws Exception;

    public String toString()
    {
        try {
            return "#" + Strings.fromByteArray(Hex.encode(string));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}