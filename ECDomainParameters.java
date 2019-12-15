// 
// Decompiled by Procyon v0.5.36
// 

class ECDomainParameters
{
    private ECPoint G;
    
    public ECDomainParameters(final ECCurve curve, final ECPoint G) {
        this.G = validate(curve, G);
    }
    
    private static ECPoint validate(final ECCurve c, ECPoint q) {
        q = ECAlgorithms.importPoint(c, q).normalize();
        return q;
    }
    
    public ECPoint getG() {
        return this.G;
    }
}
