final class CustomNamedCurves$1 extends X9ECParametersHolder {
    CustomNamedCurves$1() {
    }
    
    protected X9ECParameters createParameters() {
        ECCurve a = CustomNamedCurves.access$000((ECCurve)new SecP256K1Curve());
        return new X9ECParameters(a, new X9ECPoint(a, Hex.decode((String)None)), a.getOrder(), a.getCofactor(), (byte[])null);
    }
}
