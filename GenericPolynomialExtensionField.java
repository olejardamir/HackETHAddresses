
import java.math.BigInteger;

class GenericPolynomialExtensionField implements PolynomialExtensionField
{
    private final FiniteField subfield;
    private final Polynomial minimalPolynomial;

    GenericPolynomialExtensionField(Polynomial polynomial)
    {
        this.subfield = FiniteFields.GF_2;
        this.minimalPolynomial = polynomial;
    }

    public BigInteger getCharacteristic()
    {
        return subfield.getCharacteristic();
    }

    public int getDimension()
    {
        return subfield.getDimension() * minimalPolynomial.getDegree();
    }

    public Polynomial getMinimalPolynomial()
    {
        return minimalPolynomial;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof GenericPolynomialExtensionField))
        {
            return false;
        }
        GenericPolynomialExtensionField other = (GenericPolynomialExtensionField)obj;
        return subfield.equals(other.subfield) && minimalPolynomial.equals(other.minimalPolynomial);
    }

    public int hashCode()
    {
        return subfield.hashCode()
                ^ Integers.rotateLeft(minimalPolynomial.hashCode(), 16);
    }
}
