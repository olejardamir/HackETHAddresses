import java.io.IOException;

/**
 * A holding class that allows for X9ECParameters to be lazily constructed.
 */
abstract class X9ECParametersHolder
{
    private X9ECParameters params;

    public synchronized X9ECParameters getParameters() throws IOException {
        if (params == null)
        {
            params = createParameters();
        }

        return params;
    }

    protected abstract X9ECParameters createParameters() throws IOException;
}
