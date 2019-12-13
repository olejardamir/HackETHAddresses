
/**
 * Class holding precomputation data for fixed-point multiplications.
 */
public class FixedPointPreCompInfo implements PreCompInfo
{
    private ECPoint offset = null;

    /**
     * Lookup table for the precomputed {@link ECPoint}s used for a fixed point multiplication.
     */
    private ECLookupTable lookupTable = null;

    /**
     * The width used for the precomputation. If a larger width precomputation
     * is already available this may be larger than was requested, so calling
     * code should refer to the actual width.
     */
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
