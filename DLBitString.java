
class DLBitString
        extends ASN1BitString
{

    
    public DLBitString(
            byte[]  data,
            int     padBits)
    {
        super(data, padBits);
    }

     int encodedLength() {
        return 0;
    }

     void encode(ASN1OutputStream out) {

    }

}
