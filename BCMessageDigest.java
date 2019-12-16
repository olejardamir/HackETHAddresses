import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class BCMessageDigest {
    private static final int INITIAL = 0;
    private static final int IN_PROGRESS = 1;
    KeccakDigest digest;
    private int state = INITIAL;


    BCMessageDigest(
            KeccakDigest digest) {

        this.digest = digest;
    }




    private void engineUpdate(
            byte[] input,
            int offset,
            int len) {
        digest.update(input, offset, len);
    }

    private byte[] engineDigest() {
        byte[] digestBytes = new byte[digest.getDigestSize()];

        digest.doFinal(digestBytes, 0);

        return digestBytes;
    }




    public void update(byte[] input, int offset, int len) {
        if (input == null) {
            throw new IllegalArgumentException("No input buffer given");
        }
        if (input.length - offset < len) {
            throw new IllegalArgumentException("Input buffer too short");
        }
        engineUpdate(input, offset, len);
        state = IN_PROGRESS;
    }


    public byte[] digest() {

        byte[] result = engineDigest();
        state = INITIAL;
        return result;
    }


    public String toString() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream p = new PrintStream(baos);
         switch (state) {
            case INITIAL:
                p.print("<initialized>");
                break;
            case IN_PROGRESS:
                p.print("<in progress>");
                break;
        }
        p.println();
        return (baos.toString());
    }

    public Object clone() throws CloneNotSupportedException {
        if (this instanceof Cloneable) {
            return super.clone();
        } else {
            throw new CloneNotSupportedException();
        }
    }



}
