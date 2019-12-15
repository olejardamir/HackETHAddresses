import java.security.MessageDigest;

// 
// Decompiled by Procyon v0.5.36
// 

class BCMessageDigest extends MessageDigest
{
    KeccakDigest digest;
    
    BCMessageDigest(final KeccakDigest digest) {
        super(digest.getAlgorithmName());
        this.digest = digest;
    }
    
    public void engineReset() {
    }
    
    public void engineUpdate(final byte input) {
    }
    
    public void engineUpdate(final byte[] input, final int offset, final int len) {
        this.digest.update(input, offset, len);
    }
    
    public byte[] engineDigest() {
        final byte[] digestBytes = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(digestBytes, 0);
        return digestBytes;
    }
}
