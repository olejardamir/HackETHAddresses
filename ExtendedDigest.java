
interface ExtendedDigest {
    /**
     * return the algorithm name
     *
     * @return the algorithm name
     */
    String getAlgorithmName();

    /**
     * return the size, in bytes, of the digest produced by this message digest.
     *
     * @return the size, in bytes, of the digest produced by this message digest.
     */
    int getDigestSize();

    /**
     * update the message digest with a single byte.
     *
     * @param in the input byte to be entered.
     */
    void update(byte in);

    /**
     * update the message digest with a block of bytes.
     *
     * @param in the byte array containing the data.
     * @param inOff the offset into the byte array where the data starts.
     * @param len the length of the data.
     */
    void update(byte[] in, int inOff, int len);

    /**
     * close the digest, producing the final digest value. The doFinal
     * call leaves the digest reset.
     *  @param out the array the digest is to be copied into.
     * @param outOff the offset into the out array the digest is to start at.
     */
    void doFinal(byte[] out, int outOff);

    /**
     * reset the digest back to it's initial state.
     */
    void reset();
}
