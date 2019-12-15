
public class ASN1OctetString {
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
