import java.util.Vector;
import java.util.Hashtable;

// 
// Decompiled by Procyon v0.5.36
// 

class CustomNamedCurves
{
    private static final Hashtable<String, X9ECParametersHolder> nameToCurve;
    private static final Hashtable<String, ASN1ObjectIdentifier> nameToOID;
    private static final Hashtable<ASN1ObjectIdentifier, X9ECParametersHolder> oidToCurve;
    private static final Hashtable<ASN1ObjectIdentifier, String> oidToName;
    private static final Vector<String> names;
    
    private static ECCurve configureCurveGLV(final ECCurve c) throws Exception {
        return c.configure().setEndomorphism().create();
    }
    
    private static void defineCurveWithOID() {
        final String name = "secp256k1";
        CustomNamedCurves.names.addElement(name);
        CustomNamedCurves.oidToName.put(new ASN1ObjectIdentifier("1.3.132.0").branch("10"), name);
        CustomNamedCurves.oidToCurve.put(new ASN1ObjectIdentifier("1.3.132.0").branch("10"), new X9ECParametersHolder() {
            @Override
            protected X9ECParameters createParameters() throws Exception {
                return getX9ECParameters();
            }
        });
        CustomNamedCurves.nameToOID.put(name, new ASN1ObjectIdentifier("1.3.132.0").branch("10"));
        CustomNamedCurves.nameToCurve.put(name, new X9ECParametersHolder() {
            @Override
            protected X9ECParameters createParameters() throws Exception {
                return getX9ECParameters();
            }
        });
    }
    
    private static X9ECParameters getX9ECParameters() throws Exception {
        final ECCurve curve = configureCurveGLV(new SecP256K1Curve());
        final X9ECPoint G = new X9ECPoint(curve, Hex.decode("0479BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8"));
        return new X9ECParameters(curve, G);
    }
    
    public static X9ECParameters getByName() throws Exception {
        final X9ECParametersHolder holder = CustomNamedCurves.nameToCurve.get("secp256k1");
        return (holder == null) ? null : holder.createParameters();
    }
    
    static {
        nameToCurve = new Hashtable<String, X9ECParametersHolder>();
        nameToOID = new Hashtable<String, ASN1ObjectIdentifier>();
        oidToCurve = new Hashtable<ASN1ObjectIdentifier, X9ECParametersHolder>();
        oidToName = new Hashtable<ASN1ObjectIdentifier, String>();
        names = new Vector<String>();
        defineCurveWithOID();
    }
}
