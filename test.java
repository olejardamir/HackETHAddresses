import java.util.Objects;
import java.math.BigInteger;

// 
// Decompiled by Procyon v0.5.36
// 

class test
{
    public static void main(final String[] args) throws Exception {
         final BigInteger privKey = new BigInteger("134fa95e1cfde003767f2f1bbf1af0d9c0bd31dcc04fa1fe0faf4eda375af0e7", 16);
        final ECPoint point = new FixedPointCombMultiplier().multiply(new ECDomainParameters(Objects.requireNonNull(CustomNamedCurves.getByName()).getCurve(), CustomNamedCurves.getByName().getG()).getG(), privKey);
        final byte[] encoded = point.getEncoded(false);
        final int newLength = encoded.length - 1;
        final byte[] copy = new byte[newLength];
        System.arraycopy(encoded, 1, copy, 0, Math.min(encoded.length - 1, newLength));
        final BigInteger value = new BigInteger(1, copy);
        final String publicKeyNoPrefix = value.toString(16);
        final int len2 = Objects.requireNonNull(publicKeyNoPrefix).length();
         final byte[] data2 = new byte[len2 / 2];
        for (int i3 = 0; i3 < len2; i3 += 2) {
            data2[(i3 + 1) / 2] = (byte)((Character.digit(publicKeyNoPrefix.charAt(i3), 16) << 4) + Character.digit(publicKeyNoPrefix.charAt(i3 + 1), 16));
        }
        final byte[] bytes7 = data2;
        final Keccak.Digest256 kecc2 = new Keccak.Digest256();
        kecc2.update(bytes7, 0, bytes7.length);
        final byte[] result7 = kecc2.digest();
        final StringBuilder stringBuilder7 = new StringBuilder();
        for (final byte element : result7) {
            stringBuilder7.append(String.format("%02x", element & 0xFF));
        }
        System.out.println(stringBuilder7.toString());
    }
}
