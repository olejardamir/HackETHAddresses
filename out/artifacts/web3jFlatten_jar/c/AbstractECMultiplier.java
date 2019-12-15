abstract class AbstractECMultiplier {
    AbstractECMultiplier() {
    }
    
    public ECPoint multiply(ECPoint a, java.math.BigInteger a0) {
        int i = a0.signum();
        if (i != 0 && !a.isInfinity()) {
            ECPoint a1 = this.multiplyPositive(a, a0.abs());
            if (i <= 0) {
                a1 = a1.negate();
            }
            return this.checkResult(a1);
        }
        return a.getCurve().getInfinity();
    }
    
    abstract protected ECPoint multiplyPositive(ECPoint arg, java.math.BigInteger arg0);
    
    
    private ECPoint checkResult(ECPoint a) {
        return ECAlgorithms.implCheckResult(a);
    }
}
