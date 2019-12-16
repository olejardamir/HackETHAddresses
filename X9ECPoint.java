class X9ECPoint {

    public final ECCurve c;
    public ECPoint p;
    byte[]  string;

    public X9ECPoint(
            ECCurve c,
            byte[] encoding) {

        this.c = c;
        byte[] result;
		result = null;
		if (encoding != null) {
            byte[] copy;
			copy = new byte[encoding.length];
			System.arraycopy(encoding, 0, copy, 0, encoding.length);
            result = copy;
        }
        string = result;
    }
}
