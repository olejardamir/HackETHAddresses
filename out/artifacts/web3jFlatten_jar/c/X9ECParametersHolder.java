abstract class X9ECParametersHolder {
    X9ECParametersHolder() {
    }
    
    public synchronized X9ECParameters getParameters() {
        return this.createParameters();
    }
    
    abstract protected X9ECParameters createParameters();
}
