import java.math.BigInteger;

class GenericPolynomialExtensionField {
    private   PrimeField subfield;
    private   GF2Polynomial minimalPolynomial;



    public GenericPolynomialExtensionField() {

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

    public BigInteger getCharacteristic() {
        return null;
    }
}
