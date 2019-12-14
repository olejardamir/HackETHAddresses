
import java.util.Enumeration;

/**
 * Note: this class is for processing DER/DL encoded sequences only.
 */
class LazyEncodedSequence
        extends ASN1Sequence
{
    private byte[] encoded;

    LazyEncodedSequence(
            byte[] encoded) {
        this.encoded = encoded;
    }

    private void parse()
    {
        Enumeration en = new LazyConstructionEnumeration(encoded);

        while (en.hasMoreElements())
        {
            seq.addElement(en.nextElement());
        }

        encoded = null;
    }

    ASN1Primitive toDLObject()
    {
        if (encoded != null)
        {
            parse();
        }

        return super.toDLObject();
    }

     void encode(ASN1OutputStream out) throws Exception {

    }

    int encodedLength() throws Exception {
        return 0;
    }

}
