
import java.math.BigInteger;

class PrimeField {
    private final BigInteger characteristic;

    PrimeField(BigInteger characteristic)
    {

        this.characteristic = characteristic;
    }



    public int hashCode()
    {
        return characteristic.hashCode();
    }
}
