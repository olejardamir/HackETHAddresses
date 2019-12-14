
interface ExtendedDigest {
    
    String getAlgorithmName();

    
    int getDigestSize();

    
    void update(byte in);

    
    void update(byte[] in, int inOff, int len);

    
    void doFinal(byte[] out, int outOff);

    
    void reset();
}
