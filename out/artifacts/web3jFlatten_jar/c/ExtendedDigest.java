abstract interface ExtendedDigest {
    abstract public String getAlgorithmName();
    
    
    abstract public int getDigestSize();
    
    
    abstract public void update(byte arg);
    
    
    abstract public void update(byte[] arg, int arg0, int arg1);
    
    
    abstract public void doFinal(byte[] arg, int arg0);
    
    
    abstract public void reset();
}
