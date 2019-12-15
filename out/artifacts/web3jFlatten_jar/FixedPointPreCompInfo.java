public class FixedPointPreCompInfo {
   private ECPoint offset = null;
   private ECLookupTable lookupTable = null;
   private int width = -1;

   public FixedPointPreCompInfo() {
      super();
   }

   public ECLookupTable getLookupTable() {
      return this.lookupTable;
   }

   public void setLookupTable(ECLookupTable lookupTable) {
      this.lookupTable = lookupTable;
   }

   public ECPoint getOffset() {
      return this.offset;
   }

   public void setOffset(ECPoint offset) {
      this.offset = offset;
   }

   public int getWidth() {
      return this.width;
   }

   public void setWidth(int width) {
      this.width = width;
   }
}
