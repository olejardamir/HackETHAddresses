package Wallet;

import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

import java.math.BigInteger;

import static java.lang.Character.digit;
import static java.lang.System.arraycopy;
import static java.lang.System.out;

public class testt {

    public static void main(String[] args) throws UnsupportedOperationException {

        String privatekey = "a392604efc2fad9c0b3da43b5f698a2e3f270f170d859912be0d54742275c5f6";

        ECPoint point = new FixedPointCombMultiplier().multiply(
                getEcDomainParameters((X9ECParametersHolder) CNC.nameToCurve.get("secp256k1")).getG(),
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

        String address1 = "0x" + stringBuilder1.toString().substring(getStringBuilder().toString().length() - (160 >> 2));
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
        X9ECParametersHolder holder = (X9ECParametersHolder) CNC.nameToCurve.get("secp256k1");
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


}
