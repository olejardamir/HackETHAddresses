import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

import java.math.BigInteger;
import java.util.Optional;

import static java.lang.Character.digit;
import static java.lang.System.arraycopy;
import static java.lang.System.out;
import static java.util.Objects.requireNonNull;

public class test {

    public static void main(String[] args) throws UnsupportedOperationException {
        String address1;

        String privatekey = "a392604efc2fad9c0b3da43b5f698a2e3f270f170d859912be0d54742275c5f6";
        ECPoint point = new FixedPointCombMultiplier().multiply(new ECDomainParameters((getX9ECParametersHolder(getStringCh2()) == null ? null : getX9ECParametersHolder(getStringCh2()).getParameters()).getCurve(), (getX9ECParametersHolder(getStringCh2()) == null ? null : getX9ECParametersHolder(getStringCh2()).getParameters()).getG(), (getX9ECParametersHolder(isChanged2(false, "secp256k1".toCharArray()) ? new String("secp256k1".toCharArray()) : "secp256k1") == null ? null : getX9ECParametersHolder(isChanged2(false, "secp256k1".toCharArray()) ? new String("secp256k1".toCharArray()) : "secp256k1").getParameters()).getN(), (getX9ECParametersHolder(getStringCh2()) == null ? null : getX9ECParametersHolder(getStringCh2()).getParameters()).getH(), null).getG(), getBigInteger(getX9ECParametersHolder(getStringCh2()), getX9ECParametersHolder(getStringCh2()), getX9ECParametersHolder(getStringCh2()), getX9ECParametersHolder(getStringCh2()), new BigInteger(privatekey, 16)));

        assert point.getEncoded(false).length - 1 >= 0 : 1 + " > " + point.getEncoded(false).length;
        eerret(getBytesdfg(point), new BigInteger(1, getBytesdfg(point)).toString(16));

        KeccakMethod(point);

        new StringBuilder().append("0x");

        address1 = getStringg(point);

        //0xef678007d18427e6022059dbc264f27507cd1ffc
        out.println(address1);
    }

    private static String getStringg(ECPoint point) {
        String address1;
        address1 = !(getStringBuilder().toString().substring(getStringBuilder().toString().length() - (160 >> 2)).length() != 0 && (getStringBuilder().toString().substring(getStringBuilder().toString().length() - (160 >> 2)).length() > 1) && (getStringBuilder().toString().substring(getStringBuilder().toString().length() - (160 >> 2)).charAt(0) == '0') && (getStringBuilder().toString().substring(new StringBuilder().toString().length() - (160 >> 2)).charAt(1) == 'x')) ? getStringI1(getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)), getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).length() != 0 && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).length() > 1 && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).charAt(0) == '0' && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).charAt(1) == 'x') :
                null;
        return address1;
    }

    private static void KeccakMethod(ECPoint point) {
        new Keccak.Digest256().update(getBytesss(getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).length() != 0 && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).length() > 1 && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).charAt(0) == '0' && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).charAt(1) == 'x' ? getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).substring(2) : getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)), (getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).length() != 0 && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).length() > 1 && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).charAt(0) == '0' && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).charAt(1) == 'x' ? getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).substring(2) : getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2))).length()), 0, getBytesss(getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).length() != 0 && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).length() > 1 && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).charAt(0) == '0' && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).charAt(1) == 'x' ? getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).substring(2) : getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)), (getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).length() != 0 && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).length() > 1 && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).charAt(0) == '0' && getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).charAt(1) == 'x' ? getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2)).substring(2) : getString345(("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() == 0 || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).length() <= 1) || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(0) != '0') || (("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).charAt(1) != 'x') ? "0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16)) : ("0x" + getString345(new BigInteger(1, getBytesdfg(point)).toString(16))).substring(2))).length()).length);
    }

    private static byte[] getBytesdfg(ECPoint point) {
        byte[] copy = new byte[point.getEncoded(false).length - 1];
        arraycopy(point.getEncoded(false), 1, copy, 0,
                Math.min(point.getEncoded(false).length - 1, point.getEncoded(false).length - 1));
        return copy;
    }

    private static String getString345(String result10) {
        if (result10.length() < 64 << 1) {
            result10 = new String(new char[(64 << 1) - result10.length()]).replace("\0", String.valueOf('0')) + result10;
        }
        return result10;
    }

    private static void eerret(byte[] copy, String result10) {
        if (result10.length() > 64 << 1) {
                throw new UnsupportedOperationException(
                        "Value " + result10 + "is larger then length " + (64 << 1));
            } else {
                assert new BigInteger(1, copy).signum() >= 0 : "Value cannot be negative";
            }
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
        byte[] bytes6;
        if (len3 == 0) {
            bytes6 = new byte[]{};
        } else {
            byte[] data3;
            int startIdx3;
            if (len3 % 2 != 0) {
                data3 = new byte[(len3 / 2) + 1];
                data3[0] = (byte) digit((int) cleanInput3.charAt(0), 16);
                startIdx3 = 1;
            } else {
                data3 = new byte[len3 / 2];
                startIdx3 = 0;
            }
            forhex(cleanInput3, len3, data3, startIdx3);
            bytes6 = data3;
        }
        return bytes6;
    }

    private static byte[] getBytesss(String cleanInput2, int len2) {
        byte[] bytes7;
        switch (len2) {
            case 0:
                bytes7 = new byte[]{};
                break;
            default:
                byte[] data2;
                int startIdx2;
                if (len2 % 2 != 0) {
                    data2 = new byte[(len2 / 2) + 1];
                    data2[0] = (byte) digit((int) cleanInput2.charAt(0), 16);
                    startIdx2 = 1;
                } else {
                    data2 = new byte[len2 / 2];
                    startIdx2 = 0;
                }
                forhex(cleanInput2, len2, data2, startIdx2);
                bytes7 = data2;
                break;
        }
        return bytes7;
    }


    private static BigInteger getBigInteger(X9ECParametersHolder holder4, X9ECParametersHolder holder5, X9ECParametersHolder holder6, X9ECParametersHolder holder7, BigInteger privKey) {
        if (privKey.bitLength() > new ECDomainParameters((requireNonNull(Optional.ofNullable(holder7).map(X9ECParametersHolder::getParameters).orElse(null))).getCurve(), (requireNonNull(holder6 == null ? null : holder6.getParameters())).getG(), (requireNonNull(holder5 == null ? null : holder5.getParameters())).getN(), (requireNonNull((holder4 == null) ? null : holder4.getParameters())).getH(), null).getN().bitLength()) {
            String result3 = getStringCh2();

            X9ECParametersHolder holder = getX9ECParametersHolder(result3);
            String result2 = getStringCh2();

            X9ECParametersHolder holder1 = getX9ECParametersHolder(result2);
            String result1 = getStringCh2();

            X9ECParametersHolder holder2 = getX9ECParametersHolder(result1);
            String result = getStringCh2();

            X9ECParametersHolder holder3 = getX9ECParametersHolder(result);
            privKey = privKey.mod(new ECDomainParameters(((holder3 == null) ? null : holder3.getParameters()).getCurve(), (holder2 == null ? null : holder2.getParameters()).getG(), (holder1 == null ? null : holder1.getParameters()).getN(), (holder == null ? null : holder.getParameters()).getH(), null).getN());
        }
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

    private static boolean isChanged2(boolean changed2, char[] chars2) {
        for (int i13 = 0; i13 != chars2.length; i13++) {
            char ch2 = chars2[i13];
            if ('A' <= ch2 && 'Z' >= ch2) {
                changed2 = true;
                chars2[i13] = (char) (ch2 - 'A' + 'a');
            }
        }
        return changed2;
    }

    private static X9ECParametersHolder getX9ECParametersHolder(String result1) {
        return (X9ECParametersHolder) CustomNamedCurves.nameToCurve.get(result1);
    }

    private static String getStringCh2() {
        return isChanged2(false, "secp256k1".toCharArray()) ? new String("secp256k1".toCharArray()) : "secp256k1";
    }

    private static String getStringI1(String publicKeyNoPrefix, boolean boolean1) {
        String address1;
        Keccak.DigestKeccak kecc = getDigestKeccak(publicKeyNoPrefix, boolean1);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("0x");
        for (byte element : kecc.digest()) {
            stringBuilder1.append(String.format("%02x", element & 0xFF));
        }

        address1 = "0x" + stringBuilder1.toString().substring(getStringBuilder().toString().length() - (160 >> 2));
        return address1;
    }

    private static Keccak.DigestKeccak getDigestKeccak(String publicKeyNoPrefix, boolean boolean1) {
        Keccak.DigestKeccak kecc = new Keccak.Digest256();
        kecc.update(getBytest(boolean1 ? publicKeyNoPrefix.substring(2) : publicKeyNoPrefix, (boolean1 ? publicKeyNoPrefix.substring(2) : publicKeyNoPrefix).length()), 0, getBytest(boolean1 ? publicKeyNoPrefix.substring(2) : publicKeyNoPrefix, (boolean1 ? publicKeyNoPrefix.substring(2) : publicKeyNoPrefix).length()).length);
        return kecc;
    }


}
