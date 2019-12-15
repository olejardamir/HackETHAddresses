// 
// Decompiled by Procyon v0.5.36
// 

class Keccak
{
    private Keccak() {
    }
    
    public static class Digest256 extends BCMessageDigest
    {
        public Digest256() {
            super(new KeccakDigest(256));
        }
    }
}
