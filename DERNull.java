
public class DERNull
        extends ASN1Primitive {
    public static final DERNull INSTANCE = new DERNull();


    
    public DERNull()
    {

    }




    public int hashCode()
    {
        return -1;
    }

     int encodedLength() throws Exception {
        return 0;
    }

     void encode(ASN1OutputStream out) throws Exception {

    }

     boolean asn1Equals(ASN1Primitive o) {
        return false;
    }


    public String toString()
    {
        return "NULL";
    }
}
