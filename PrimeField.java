
import java.math.BigInteger;

class PrimeField extends GenericPolynomialExtensionField {
    private final BigInteger characteristic;

    PrimeField(BigInteger characteristic)
    {
        super();
        this.characteristic = characteristic;
    }



    public int hashCode()
    {
        return characteristic.hashCode();
    }
}
