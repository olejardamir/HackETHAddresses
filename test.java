package Wallet;

import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.math.ec.custom.sec.SecP256K1Curve;
import org.bouncycastle.math.ec.endo.GLVTypeBEndomorphism;
import org.bouncycastle.math.ec.endo.GLVTypeBParameters;
import org.bouncycastle.math.ec.endo.ScalarSplitParameters;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Vector;

import static java.lang.Character.digit;
import static java.lang.System.arraycopy;
import static java.lang.System.out;

public class testt {

    public static void main(String[] args) throws UnsupportedOperationException {

        String privatekey = "a392604efc2fad9c0b3da43b5f698a2e3f270f170d859912be0d54742275c5f6";

        ECPoint point = new FixedPointCombMultiplier().multiply(
                getEcDomainParameters((X9ECParametersHolder) nameToCurve.get("secp256k1")).getG(),
                getBigInteger(privatekey)
        );


        String address1 = getStringg(point);

        //0xef678007d18427e6022059dbc264f27507cd1ffc
        out.println(address1);
    }

    private static BigInteger getBigInteger(String privatekey) {
        return getBigInteger(new BigInteger(privatekey, 16));
    }

    private static ECDomainParameters getEcDomainParameters(X9ECParametersHolder secp256k1) {
        return new ECDomainParameters(
                secp256k1.getParameters().getCurve(),
                secp256k1.getParameters().getG(),
                secp256k1.getParameters().getN(),
                secp256k1.getParameters().getH(),
                null);
    }

    private static String getStringg(ECPoint point) {
        Keccak.DigestKeccak kecc = getDigestKeccak(getString345(point));
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("0x");
        for (byte element : kecc.digest()) {
            stringBuilder1.append(String.format("%02x", element & 0xFF));
        }

        String address1 = "0x" + stringBuilder1.toString();
        return address1;
    }

    private static String getString345(ECPoint point) {
        return ("0x" + new BigInteger(1, getBytesdfg(point)).toString(16)).substring(2);
    }

    private static byte[] getBytesdfg(ECPoint point) {
        byte[] copy = new byte[point.getEncoded(false).length - 1];
        arraycopy(point.getEncoded(false), 1, copy, 0,
                Math.min(point.getEncoded(false).length - 1, point.getEncoded(false).length - 1));
        return copy;
    }


    private static StringBuilder getStringBuilder() {
        StringBuilder stringBuilder8 = new StringBuilder();
        stringBuilder8.append("0x");
        for (byte element : new Keccak.Digest256().digest()) {
            stringBuilder8.append(String.format("%02x", element & 0xFF));
        }
        return stringBuilder8;
    }

    private static byte[] getBytest(String cleanInput3, int len3) {
        byte[] data3 = new byte[len3 / 2];
        forhex(cleanInput3, len3, data3, 0);
        return data3;
    }

    private static BigInteger getBigInteger(BigInteger privKey) {
        X9ECParametersHolder holder = (X9ECParametersHolder) nameToCurve.get("secp256k1");
        privKey = privKey.mod(getEcDomainParameters(holder).getN());
        return privKey;
    }

    private static void forhex(String cleanInput2, int len2, byte[] data2, int startIdx2) {
        for (int i3 = startIdx2; i3 < len2; i3 += 2) {
            data2[(i3 + 1) / 2] =
                    (byte)
                            ((digit((int) cleanInput2.charAt(i3), 16) << 4)
                                    + digit((int) cleanInput2.charAt(i3 + 1), 16));
        }
    }

    private static Keccak.DigestKeccak getDigestKeccak(String publicKeyNoPrefix) {
        Keccak.DigestKeccak kecc = new Keccak.Digest256();
        kecc.update(getBytest(publicKeyNoPrefix, publicKeyNoPrefix.length()), 0, getBytest(publicKeyNoPrefix, publicKeyNoPrefix.length()).length);
        return kecc;
    }

    //---------------------------------------------------------------------------------------------------



    private static X9ECPoint configureBasepoint(ECCurve curve)
    {
        WNafUtil.configureBasepoint(new X9ECPoint(curve, Hex.decodeStrict("0479BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8")).getPoint());
        return new X9ECPoint(curve, Hex.decodeStrict("0479BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8"));
    }


    static X9ECParametersHolder secp256k1 = new X9ECParametersHolder()
    {
        protected X9ECParameters createParameters()
        {
            byte[] S = null;
            GLVTypeBParameters glv = new GLVTypeBParameters(
                    new BigInteger("7ae96a2b657c07106e64479eac3434e99cf0497512f58995c1396c28719501ee", 16),
                    new BigInteger("5363ad4cc05c30e0a5261c028812645a122e22ea20816678df02967c1b23bd72", 16),
                    new ScalarSplitParameters(
                            new BigInteger[]{
                                    new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16),
                                    new BigInteger("-e4437ed6010e88286f547fa90abfe4c3", 16) },
                            new BigInteger[]{
                                    new BigInteger("114ca50f7a8e2f3f657c1108d9d44cfd8", 16),
                                    new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16) },
                            new BigInteger("3086d221a7d46bcde86c90e49284eb153dab", 16),
                            new BigInteger("e4437ed6010e88286f547fa90abfe4c42212", 16),
                            272));
            return new X9ECParameters(
                getConfig(glv).create(), configureBasepoint(
                getConfig(glv).create()
            ),
                getConfig(glv).create().getOrder(),
                getConfig(glv).create().getCofactor(), S);
        }
    };

    private static ECCurve.Config getConfig(GLVTypeBParameters glv) {
        return new SecP256K1Curve().configure().setEndomorphism(
                new GLVTypeBEndomorphism(new SecP256K1Curve(), glv)
        );
    }


    static final Hashtable nameToCurve = new Hashtable();

    static {
        String name = "secp256k1";
        new Vector().addElement(name);
        new Hashtable().put(SECObjectIdentifiers.secp256k1, name);
        new Hashtable().put(SECObjectIdentifiers.secp256k1, secp256k1);
        name = Strings.toLowerCase(name);
        new Hashtable().put(name, SECObjectIdentifiers.secp256k1);
        nameToCurve.put(name, secp256k1);
    }



}
