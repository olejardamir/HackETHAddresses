
class BERFactory
{
    private static final BERSequence EMPTY_SEQUENCE = new BERSequence();

    static BERSequence createSequence(ASN1EncodableVector v)
    {
        return v.size() < 1 ? EMPTY_SEQUENCE : new BERSequence(v);
    }

}
