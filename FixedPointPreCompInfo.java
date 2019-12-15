

public class FixedPointPreCompInfo {
    private ECPoint offset = null;


    private ECLookupTable lookupTable = null;


    private int width = -1;

    public ECLookupTable getLookupTable()
    {
        return lookupTable;
    }

    public void setLookupTable(ECLookupTable lookupTable)
    {
        this.lookupTable = lookupTable;
    }

    public ECPoint getOffset()
    {
        return offset;
    }

    public void setOffset(ECPoint offset)
    {
        this.offset = offset;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }
}
