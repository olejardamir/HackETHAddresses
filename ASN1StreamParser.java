
import java.io.IOException;

/**
 * A parser for ASN.1 streams which also returns, where possible, parsers for the objects it encounters.
 */
class ASN1StreamParser
{
    private final byte[][] tmpBuffers;

    public ASN1StreamParser()
    {

        this.tmpBuffers = new byte[11][];
    }


    public ASN1Encodable readObject() {

        return null;
    }


}
