// 
// Decompiled by Procyon v0.5.36
// 

class X9ECPoint
{
    private final ASN1OctetString encoding;
    private final ECCurve c;
    private ECPoint p;
    
    public X9ECPoint(final ECCurve c, final byte[] encoding) {
        this.c = c;
        this.encoding = new ASN1OctetString(Arrays.clone(encoding));
    }
    
    public synchronized ECPoint getPoint() {
        if (this.p == null) {
            this.p = this.c.decodePoint(this.encoding.getOctets()).normalize();
        }
        return this.p;
    }
    
    public ASN1OctetString toASN1Primitive() {
        return this.encoding;
    }
    
    @Override
    public int hashCode() {
        return this.toASN1Primitive().hashCode();
    }
}
