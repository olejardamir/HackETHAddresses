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

	}


}
