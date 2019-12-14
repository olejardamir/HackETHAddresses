import java.io.IOException;
import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Vector;

class CustomNamedCurves
{

    private static ECCurve configureCurveGLV(ECCurve c) throws IOException {
         return c.configure().setEndomorphism().create();
    }

    /*
     * secp256k1
     */
    private static final X9ECParametersHolder secp256k1 = new X9ECParametersHolder()
    {
        protected X9ECParameters createParameters() throws IOException {
            ECCurve curve = configureCurveGLV(new SecP256K1Curve());
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

    public static X9ECParameters getByName() throws IOException {
        X9ECParametersHolder holder = (X9ECParametersHolder)nameToCurve.get("secp256k1");
        return holder == null ? null : holder.getParameters();
    }


}
