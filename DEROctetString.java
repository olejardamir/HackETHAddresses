
class DEROctetString
        extends ASN1OctetString
{
    
    public DEROctetString(
            byte[]  string)
    {
        super(string);
    }

    int encodedLength()
    {
        return 1 + StreamUtil.calculateBodyLength(string.length) + string.length;
    }

    void encode(
            ASN1OutputStream out)
            throws Exception
    {
        out.writeEncoded(ASN1InputStream.OCTET_STRING, string);
    }

}
