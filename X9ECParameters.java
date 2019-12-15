// 
// Decompiled by Procyon v0.5.36
// 

public class X9ECParameters
{
    private final ECCurve curve;
    private final X9ECPoint g;
    
    public X9ECParameters(final ECCurve curve, final X9ECPoint g) {
        this.curve = curve;
        this.g = g;
    }
    
    public ECCurve getCurve() {
        return this.curve;
    }
    
    public ECPoint getG() {
        return this.g.getPoint();
    }
}
