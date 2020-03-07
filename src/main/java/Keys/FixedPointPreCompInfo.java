package Keys;

class FixedPointPreCompInfo {
    private ECPoint offset;

    private ECLookupTable lookupTable;

    private int width = -1;

    ECLookupTable getLookupTable() {
        return lookupTable;
    }

    void setLookupTable(ECLookupTable lookupTable) {
        this.lookupTable = lookupTable;
    }

    ECPoint getOffset() {
        return offset;
    }

    void setOffset(ECPoint offset) {
        this.offset = offset;
    }

    int getWidth() {
        return width;
    }

    void setWidth(int width) {
        this.width = width;
    }
}
