import java.util.Hashtable;
import java.util.Vector;

class CustomNamedCurves
{

    private static ECCurve configureCurveGLV(ECCurve c) throws Exception {
         return c.configure().setEndomorphism().create();
    }

    
    private static final X9ECParametersHolder secp256k1 = new X9ECParametersHolder()
    {
        protected X9ECParameters createParameters() throws Exception {
            ECCurve curve = configureCurveGLV(new SecP256K1Curve());
            X9ECPoint G = new X9ECPoint(curve, Hex.decode("04"
                    + "79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798"
                    + "483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8"));
            return new X9ECParameters(curve, G, curve.getOrder(), curve.getCofactor());
        }
    };


    private static final Hashtable<String, X9ECParametersHolder> nameToCurve = new Hashtable<>();
    private static final Hashtable<String, ASN1ObjectIdentifier> nameToOID = new Hashtable<>();
    private static final Hashtable<ASN1ObjectIdentifier, X9ECParametersHolder> oidToCurve = new Hashtable<>();
    private static final Hashtable<ASN1ObjectIdentifier, String> oidToName = new Hashtable<>();
    private static final Vector<String> names = new Vector<>();

    private static void defineCurveWithOID()
    {
        String name = "secp256k1";
        names.addElement(name);
        oidToName.put(SECObjectIdentifiers.secp256k1, name);
        oidToCurve.put(SECObjectIdentifiers.secp256k1, CustomNamedCurves.secp256k1);
         nameToOID.put(name, SECObjectIdentifiers.secp256k1);
        nameToCurve.put(name, CustomNamedCurves.secp256k1);
    }

    static
    {

        defineCurveWithOID();

    }

    public static X9ECParameters getByName() throws Exception {
        X9ECParametersHolder holder = nameToCurve.get("secp256k1");
        return holder == null ? null : holder.getParameters();
    }


}
