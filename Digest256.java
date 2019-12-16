import java.util.Objects;

public class Digest256 {

    KeccakDigest digest;

    public Digest256() {
        this.digest = new KeccakDigest(256);
    }

    public Object clone() throws CloneNotSupportedException {
        Digest256 d;
		Object o1;
		if (!(this instanceof Cloneable)) {
			o1 = null;
		} else {
			o1 = super.clone();
		}
		d = (Digest256) (o1);
		Digest256 d1;
		d1 = Objects.requireNonNull(d);
		d1.digest = new KeccakDigest(digest);
		return d;
    }

    public void engineUpdate(byte[] input, int offset, int len) {
        digest.update(input, offset, len);
    }

    public byte[] engineDigest() {
        byte[] digestBytes;
		int i1;
		i1 = digest.getDigestSize();
		digestBytes = new byte[i1];
		digest.doFinal(digestBytes, 0);
        return digestBytes;
    }

    public void update(byte[] input, int offset, int len) {
        engineUpdate(input, offset, len);
    }

    public byte[] digest() {
        byte[] bs1;
		bs1 = engineDigest();
		return bs1;
    }


}
