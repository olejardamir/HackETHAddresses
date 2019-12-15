import java.util.Hashtable;
import java.util.Vector;

class CustomNamedCurves {
   private static final Hashtable nameToCurve = new Hashtable();
   private static final Hashtable nameToOID = new Hashtable();
   private static final Hashtable oidToCurve = new Hashtable();
   private static final Hashtable oidToName = new Hashtable();
   private static final Vector names = new Vector();



   private static ECCurve configureCurveGLV(ECCurve c) throws Exception {
      return c.configure().setEndomorphism().create();
   }

   private static void defineCurveWithOID() {
      names.addElement("secp256k1");
      oidToName.put((new ASN1ObjectIdentifier("1.3.132.0")).branch("10"), "secp256k1");
      oidToCurve.put((new ASN1ObjectIdentifier("1.3.132.0")).branch("10"), new X9ECParametersHolder() {
         protected X9ECParameters createParameters() throws Exception {
            return CustomNamedCurves.getX9ECParameters();
         }
      });
      nameToOID.put("secp256k1", (new ASN1ObjectIdentifier("1.3.132.0")).branch("10"));
      nameToCurve.put("secp256k1", new X9ECParametersHolder() {
         protected X9ECParameters createParameters() throws Exception {
            return CustomNamedCurves.getX9ECParameters();
         }
      });
   }

   private static X9ECParameters getX9ECParameters() throws Exception {
      ECCurve curve = configureCurveGLV(new SecP256K1Curve());
      X9ECPoint G = new X9ECPoint(curve, Hex.decode("0479BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8"));
      return new X9ECParameters(curve, G);
   }

   public static X9ECParameters getByName() throws Exception {
      X9ECParametersHolder holder = (X9ECParametersHolder)nameToCurve.get("secp256k1");
      return holder == null ? null : holder.createParameters();
   }

   static {
      defineCurveWithOID();
   }
}
