
public class ASN1OctetString
        extends ASN1Primitive
 {
    byte[]  string;


    ASN1OctetString(
            byte[] string)
    {

        this.string = string;
    }




    public byte[] getOctets()
    {
        return string;
    }




}
