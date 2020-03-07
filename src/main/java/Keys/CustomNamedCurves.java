package Keys;

//done checkpoint clean
class CustomNamedCurves
{

    private static ECCurve configureCurveGLV(ECCurve c) throws Exception {
         return c.configure().setEndomorphism().create();
    }


    static X9ECParameters getByName(String decodeString) throws Exception {
        ECCurve curve = configureCurveGLV(new SecP256K1Curve());
        X9ECPoint G = new X9ECPoint(curve, Hex.decode(decodeString));
        return new X9ECParameters(G);
    }



}
