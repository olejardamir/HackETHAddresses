
import java.math.BigInteger;

class PrimeField {
    private final BigInteger characteristic;

    PrimeField(BigInteger characteristic)
    {

        this.characteristic = characteristic;
    }





    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof PrimeField))
        {
            return false;
        }
        PrimeField other = (PrimeField)obj;
        return characteristic.equals(other.characteristic);
    }

    public int hashCode()
    {
        return characteristic.hashCode();
    }
}
