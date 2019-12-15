
public class ASN1OctetString
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
