import java.math.BigInteger;

// 
// Decompiled by Procyon v0.5.36
// 

class PrimeField
{
    private final BigInteger characteristic;
    
    PrimeField(final BigInteger characteristic) {
        this.characteristic = characteristic;
    }
    
    @Override
    public int hashCode() {
        return this.characteristic.hashCode();
    }
}
