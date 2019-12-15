import java.math.BigInteger;
import java.util.Objects;

class test {

    public static void main(String[] args) throws Exception {

        {
            String privatekey = "134fa95e1cfde003767f2f1bbf1af0d9c0bd31dcc04fa1fe0faf4eda375af0e7";
            //EXPECTED: a053c735c7ebcc368f48d9adf4a3ef3709cfc45c54ff8b8948ec97cf92019ce4



            BigInteger privKey = new BigInteger(privatekey, 16);


            ECPoint point = new FixedPointCombMultiplier().multiply(new ECDomainParameters(
                    Objects.requireNonNull(CustomNamedCurves.getByName()).getCurve(),
                    CustomNamedCurves.getByName().getG(),
                    CustomNamedCurves.getByName().getN(),
                    CustomNamedCurves.getByName().getH()).getG(), privKey);

            byte[] encoded = point.getEncoded(false);
            int newLength = encoded.length - 1;

            byte[] copy = new byte[newLength];
            System.arraycopy(encoded, 1, copy, 0, Math.min(encoded.length - 1, newLength));
            BigInteger value = new BigInteger(1, copy);
            String publicKeyNoPrefix = value.toString(16);


            byte[] bytes7;


            int len2 = Objects.requireNonNull(publicKeyNoPrefix).length();
            int startIdx2 = 0;
            byte[] data2 = new byte[len2 / 2];

            for (int i3 = startIdx2; i3 < len2; i3 += 2) {
                data2[(i3 + 1) / 2] =
                        (byte)
                                ((Character.digit(publicKeyNoPrefix.charAt(i3), 16) << 4)
                                        + Character.digit(publicKeyNoPrefix.charAt(i3 + 1), 16));
            }
            bytes7 = data2;


            Keccak.DigestKeccak kecc2 = new Keccak.Digest256();
            kecc2.update(bytes7, 0, bytes7.length);
            byte[] result7 = kecc2.digest();


            StringBuilder stringBuilder7 = new StringBuilder();
            for (byte element : result7) {
                stringBuilder7.append(String.format("%02x", element & 0xFF));
            }


            System.out.println(stringBuilder7.toString());

        }

    }


}
