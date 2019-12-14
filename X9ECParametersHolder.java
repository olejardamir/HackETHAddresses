import java.io.IOException;

abstract class X9ECParametersHolder
{
    private X9ECParameters params;

    public synchronized X9ECParameters getParameters() throws IOException {
        params = createParameters();
        return params;
    }

    protected abstract X9ECParameters createParameters() throws IOException;
}
