abstract public interface ECLookupTable {
    abstract public int getSize();
    
    
    abstract public ECPoint lookup(int arg);
}
