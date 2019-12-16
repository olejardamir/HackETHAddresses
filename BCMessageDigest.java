import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class BCMessageDigest {
    private static final int INITIAL = 0;
    private static final int IN_PROGRESS = 1;
    KeccakDigest digest;
    private String algorithm;
    private int state = INITIAL;


    BCMessageDigest(
            KeccakDigest digest) {
        this.algorithm = digest.getAlgorithmName();

        this.digest = digest;
    }

    public static boolean isEqual(byte[] digesta, byte[] digestb) {
        if (digesta == digestb) return true;
        if (digesta == null || digestb == null) {
            return false;
        }
        if (digesta.length != digestb.length) {
            return false;
        }

        int result = 0;

        for (int i = 0; i < digesta.length; i++) {
            result |= digesta[i] ^ digestb[i];
        }
        return result == 0;
    }

    public void engineReset() {

    }

    public void engineUpdate(
            byte input) {

    }

    public void engineUpdate(
            byte[] input,
            int offset,
            int len) {
        digest.update(input, offset, len);
    }

    public byte[] engineDigest() {
        byte[] digestBytes = new byte[digest.getDigestSize()];

        digest.doFinal(digestBytes, 0);

        return digestBytes;
    }

 

    public void update(byte input) {
        engineUpdate(input);
        state = IN_PROGRESS;
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

    public void update(byte[] input) {
        engineUpdate(input, 0, input.length);
        state = IN_PROGRESS;
    }

    public byte[] digest() {

        byte[] result = engineDigest();
        state = INITIAL;
        return result;
    }

    public byte[] digest(byte[] input) {
        update(input);
        return digest();
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
            if (this instanceof Cloneable) {
                return super.clone();
            } else {
                throw new CloneNotSupportedException();
            }
        } else {
            throw new CloneNotSupportedException();
        }
    }

    protected int engineGetDigestLength() {
        return 0;
    }

    protected int engineDigest(byte[] buf, int offset, int len)
             {

        byte[] digest = engineDigest();

        System.arraycopy(digest, 0, buf, offset, digest.length);
        return digest.length;
    }
}
