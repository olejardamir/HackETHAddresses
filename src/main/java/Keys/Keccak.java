package Keys;
import java.util.Objects;

class Keccak
{
    private Keccak()
    {

    }

    public static class Digest256 {
		KeccakDigest digest;

		public Digest256() {
			this.digest = new KeccakDigest(256);
		}

		public Object clone() throws CloneNotSupportedException {
			Digest256 d = (Digest256) (!(this instanceof Cloneable) ? null : super.clone());
			Objects.requireNonNull(d).digest = new KeccakDigest(digest);
			return d;
		}

		void engineUpdate(byte[] input, int offset, int len) {
			digest.update(input, offset, len);
		}

		byte[] engineDigest() {
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
