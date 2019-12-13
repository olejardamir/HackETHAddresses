import java.io.IOException;
import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Vector;

class CustomNamedCurves
{

    private static ECCurve configureCurveGLV(ECCurve c, GLVTypeBParameters p) throws IOException {
        return c.configure().setEndomorphism(new GLVTypeBEndomorphism(c, p)).create();
    }

    /*
     * secp256k1
     */
    private static final X9ECParametersHolder secp256k1 = new X9ECParametersHolder()
    {
        protected X9ECParameters createParameters() throws IOException {
            byte[] S = null;
            GLVTypeBParameters glv = new GLVTypeBParameters(
                    new BigInteger("7ae96a2b657c07106e64479eac3434e99cf0497512f58995c1396c28719501ee", 16),
                    new BigInteger("5363ad4cc05c30e0a5261c028812645a122e22ea20816678df02967c1b23bd72", 16),
                    new BigInteger[]{
                            new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16),
                            new BigInteger("-e4437ed6010e88286f547fa90abfe4c3", 16) },
                    new BigInteger[]{
                            new BigInteger("114ca50f7a8e2f3f657c1108d9d44cfd8", 16),
                            new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16) },
                    new BigInteger("3086d221a7d46bcde86c90e49284eb153dab", 16),
                    new BigInteger("e4437ed6010e88286f547fa90abfe4c42212", 16),
                    272);
            ECCurve curve = configureCurveGLV(new SecP256K1Curve(), glv);
            X9ECPoint G = new X9ECPoint(curve, Hex.decode("04"
                    + "79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798"
                    + "483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8"));
            return new X9ECParameters(curve, G, curve.getOrder(), curve.getCofactor(), null);
        }
    };


    private static final Hashtable nameToCurve = new Hashtable();
    private static final Hashtable nameToOID = new Hashtable();
    private static final Hashtable oidToCurve = new Hashtable();
    private static final Hashtable oidToName = new Hashtable();
    private static final Vector names = new Vector();

    private static void defineCurveWithOID(String name, X9ECParametersHolder holder)
    {
        names.addElement(name);
        oidToName.put(SECObjectIdentifiers.secp256k1, name);
        oidToCurve.put(SECObjectIdentifiers.secp256k1, holder);
        name = Strings.toLowerCase(name);
        nameToOID.put(name, SECObjectIdentifiers.secp256k1);
        nameToCurve.put(name, holder);
    }

    static
    {

        defineCurveWithOID("secp256k1", secp256k1);

    }

    public static X9ECParameters getByName(String name) throws IOException {
        X9ECParametersHolder holder = (X9ECParametersHolder)nameToCurve.get(Strings.toLowerCase(name));
        return holder == null ? null : holder.getParameters();
    }


}
