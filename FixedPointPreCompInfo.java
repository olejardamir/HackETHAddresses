// 
// Decompiled by Procyon v0.5.36
// 

public class FixedPointPreCompInfo
{
    private ECPoint offset;
    private ECLookupTable lookupTable;
    private int width;
    
    public FixedPointPreCompInfo() {
        this.offset = null;
        this.lookupTable = null;
        this.width = -1;
    }
    
    public ECLookupTable getLookupTable() {
        return this.lookupTable;
    }
    
    public void setLookupTable(final ECLookupTable lookupTable) {
        this.lookupTable = lookupTable;
    }
    
    public ECPoint getOffset() {
        return this.offset;
    }
    
    public void setOffset(final ECPoint offset) {
        this.offset = offset;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
}
