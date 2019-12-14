class DLSequence
        extends ASN1Sequence
{

    /**
     * Create an empty sequence
     */
    public DLSequence()
    {
    }

     int encodedLength() throws Exception {
        return 0;
    }

    /**
     * create a sequence containing a vector of objects.
     * @param v the vector of objects to make up the sequence.
     */
    public DLSequence(
            ASN1EncodableVector v)
    {
        super(v);
    }

     void encode(ASN1OutputStream out) throws Exception {

    }


}