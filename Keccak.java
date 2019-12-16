import java.util.Objects;

class Keccak
{
    private Keccak()
    {

    }

    static public class Digest256 {

        KeccakDigest digest;

        public Digest256()
        {

            this.digest = new KeccakDigest(256);
        }

        public Object clone()
                throws CloneNotSupportedException
        {
            Object result = null;
            if (this instanceof Cloneable) {
                result = super.clone();
            }
            Digest256 d = (Digest256) result;
            Objects.requireNonNull(d).digest = new KeccakDigest(digest);

            return d;
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

        public void update(byte[] input, int offset, int len) {


            engineUpdate(input, offset, len);
        }

        public byte[] digest() {

            return engineDigest();
        }

     }


}
