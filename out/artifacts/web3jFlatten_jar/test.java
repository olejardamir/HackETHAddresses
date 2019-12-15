import java.math.BigInteger;
import java.util.Objects;

class test {
   test() {
      super();
   }

   public static void main(String[] args) throws Exception {
      BigInteger privKey = new BigInteger("134fa95e1cfde003767f2f1bbf1af0d9c0bd31dcc04fa1fe0faf4eda375af0e7", 16);
      ECPoint point = (new FixedPointCombMultiplier()).multiply((new ECDomainParameters(((X9ECParameters)Objects.requireNonNull(CustomNamedCurves.getByName())).getCurve(), CustomNamedCurves.getByName().getG())).getG(), privKey);
      byte[] encoded = point.getEncoded(false);
      int newLength = encoded.length - 1;
      byte[] copy = new byte[newLength];
      System.arraycopy(encoded, 1, copy, 0, Math.min(encoded.length - 1, newLength));
      BigInteger value = new BigInteger(1, copy);
      String publicKeyNoPrefix = value.toString(16);
      int len2 = ((String)Objects.requireNonNull(publicKeyNoPrefix)).length();
      byte[] data2 = new byte[len2 / 2];

      for(int i3 = 0; i3 < len2; i3 += 2) {
         data2[(i3 + 1) / 2] = (byte)((Character.digit(publicKeyNoPrefix.charAt(i3), 16) << 4) + Character.digit(publicKeyNoPrefix.charAt(i3 + 1), 16));
      }

      Keccak.Digest256 kecc2 = new Keccak.Digest256();
      kecc2.update(data2, 0, data2.length);
      byte[] result7 = kecc2.digest();
      StringBuilder stringBuilder7 = new StringBuilder();
      byte[] var13 = result7;
      int var14 = result7.length;

      for(int var15 = 0; var15 < var14; ++var15) {
         byte element = var13[var15];
         stringBuilder7.append(String.format("%02x", element & 255));
      }

      System.out.println(stringBuilder7.toString());
   }
}
