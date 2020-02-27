package Keys;

//done checkpoint clean
class CustomNamedCurves
{

    private static ECCurve configureCurveGLV(ECCurve c) throws Exception {
         return c.configure().setEndomorphism().create();
    }


    public static X9ECParameters getByName(String decodeString) throws Exception {
        ECCurve curve = configureCurveGLV(new SecP256K1Curve());
        X9ECPoint G = new X9ECPoint(curve, Hex.decode(decodeString));
        return new X9ECParameters(G);
    }

//    "04"+"79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798"+"483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8"


}
