abstract class X9ECParametersHolder {
    X9ECParametersHolder() {
    }
    
    public synchronized X9ECParameters getParameters() throws Exception {
        return this.createParameters();
    }
    
    abstract protected X9ECParameters createParameters() throws Exception;
}
