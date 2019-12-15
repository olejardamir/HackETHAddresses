import java.math.BigInteger;
import java.util.Objects;

public class PublicFromPrivate {

    private X9ECParameters customNamedCurves = new CustomNamedCurves().getByName();
    private FixedPointCombMultiplier fixedPointCombMultiplier = new FixedPointCombMultiplier();

    public PublicFromPrivate() throws Exception {
    }

    public StringBuilder getPublicFromPrivate(String privateKey) throws Exception {
        BigInteger privKey = new BigInteger(privateKey, 16);
        ECPoint point = getEcPoint(privKey);
        byte[] encoded = point.getEncoded(false);
        byte[] copy = copyBytesArray(encoded);
        byte[] data2 = getBytes(copy);
        byte[] result7 = getBytes2(data2);
        return getStringBuilder(result7);
    }

    private StringBuilder getStringBuilder(byte[] result7) {
        StringBuilder stringBuilder7 = new StringBuilder();
        int var14 = result7.length;

        for(int var15 = 0; var15 < var14; ++var15) {
            byte element = result7[var15];
            stringBuilder7.append(String.format("%02x", element & 255));
        }
        return stringBuilder7;
    }

    private byte[] getBytes2(byte[] data2) {
        Keccak.Digest256 kecc2 = new Keccak.Digest256();
        kecc2.update(data2, 0, data2.length);
        return kecc2.digest();
    }

    private byte[] getBytes(byte[] copy) {
        BigInteger value = new BigInteger(1, copy);
        String publicKeyNoPrefix = value.toString(16);
        int len2 = publicKeyNoPrefix.length();
        byte[] data2 = new byte[len2 / 2];

        for(int i3 = 0; i3 < len2; i3 += 2) {
            data2[(i3 + 1) / 2] = (byte)((Character.digit(publicKeyNoPrefix.charAt(i3), 16) << 4) + Character.digit(publicKeyNoPrefix.charAt(i3 + 1), 16));
        }
        return data2;
    }

    private byte[] copyBytesArray(byte[] encoded) {
        int newLength = encoded.length - 1;
        byte[] copy = new byte[newLength];
        System.arraycopy(encoded, 1, copy, 0,65);
        return copy;
    }

    private ECPoint getEcPoint(BigInteger privKey) throws Exception {
        ECCurve curve = customNamedCurves.getCurve();
        ECPoint point = Objects.requireNonNull(CustomNamedCurves.getByName()).getG();
        ECDomainParameters ecDomainParameters = new ECDomainParameters(curve, point);
        ECPoint gpoint = ecDomainParameters.getG();
        return fixedPointCombMultiplier.multiply(gpoint, privKey);
    }

}
