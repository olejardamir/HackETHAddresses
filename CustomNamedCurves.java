import java.io.ByteArrayOutputStream;
import java.util.Hashtable;
import java.util.Vector;

class CustomNamedCurves
{


    public static final Hashtable<String, X9ECParametersHolder> nameToCurve = new Hashtable<>();
    private static final Vector<String> names = new Vector<>();

    private static void defineCurveWithOID()
    {
        String name = "secp256k1";
        names.addElement(name);

         nameToCurve.put(name, new X9ECParametersHolder()
        {
            protected X9ECParameters createParameters() throws Exception {
                ECCurve curve = new SecP256K1Curve().configure().setEndomorphism().create();
                HexEncoder encoder = new HexEncoder();
                ByteArrayOutputStream bOut = new ByteArrayOutputStream();
                encoder.decode("04"
                            + "79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798"
                            + "483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8", bOut);
                X9ECPoint G = new X9ECPoint(curve, bOut.toByteArray());
                return new X9ECParameters(curve, G);
            }
        });
    }

    static
    {
        defineCurveWithOID();
    }


}
