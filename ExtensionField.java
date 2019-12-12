public interface ExtensionField extends FiniteField
{
    FiniteField getSubfield();

    int getDegree();
}
