package Keys;


public class FixedPointPreCompInfo {
    private ECPoint offset;


    private ECLookupTable lookupTable;


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
