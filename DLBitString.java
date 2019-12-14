/**
 * A Definite length BIT STRING
 */
class DLBitString
        extends ASN1BitString
{

    /**
     * @param data the octets making up the bit string.
     * @param padBits the number of extra bits at the end of the string.
     */
    public DLBitString(
            byte[]  data,
            int     padBits)
    {
        super(data, padBits);
    }

     void encode(ASN1OutputStream out)   {

    }

    int encodedLength()  {
        return 0;
    }

}
