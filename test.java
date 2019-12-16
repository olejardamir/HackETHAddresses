import java.math.BigInteger;
import java.util.Objects;

class test {

    public static void main(String[] args) throws Exception {

        {
            String privatekey = "134fa95e1cfde003767f2f1bbf1af0d9c0bd31dcc04fa1fe0faf4eda375af0e7";
            //EXPECTED: 116fb0ac9844bc943f4b6e76b5deff89a4854b4053f4435a85acd33419d5912e


            String cleanValue;
            cleanValue = privatekey;
            BigInteger privKey = new BigInteger(cleanValue, 16);


            ECPoint point = new FixedPointCombMultiplier().multiply(new ECDomainParameters(
                    Objects.requireNonNull(CustomNamedCurves.getByName()).getCurve(),
                    CustomNamedCurves.getByName().getG(),
                    CustomNamedCurves.getByName().getN(),
                    CustomNamedCurves.getByName().getH()).getG(), privKey);

            byte[] encoded = point.getEncoded(false);
            int newLength = encoded.length - 1;

            byte[] copy = new byte[newLength];
            System.arraycopy(encoded, 1, copy, 0,
                    Math.min(encoded.length - 1, newLength));
            BigInteger value = new BigInteger(1, copy);
            String publicKeyNoPrefix = null;
            String input;
            String result10 = value.toString(16);


            input = "0x" + result10;
            if (!(input.length() == 0) && input.length() > 1 && input.charAt(0) == '0' && input.charAt(1) == 'x') {
                publicKeyNoPrefix = input.substring(2);
            }


            byte[] bytes8;
            String cleanInput9;

            cleanInput9 = publicKeyNoPrefix;


            int len9 = Objects.requireNonNull(cleanInput9).length();


            byte[] data9;
            int startIdx9;

            data9 = new byte[len9 / 2];
            startIdx9 = 0;

            for (int i10 = startIdx9; i10 < len9; i10 += 2) {
                data9[(i10 + 1) / 2] =
                        (byte)
                                ((Character.digit(cleanInput9.charAt(i10), 16) << 4)
                                        + Character.digit(cleanInput9.charAt(i10 + 1), 16));
            }
            bytes8 = data9;


            Keccak.Digest256 kecc9 = new Keccak.Digest256();
            kecc9.update(bytes8, 0, bytes8.length);
            byte[] result8 = kecc9.digest();
            byte[] bytes9 = new byte[0];


            Keccak.Digest256 kecc8 = new Keccak.Digest256();
            kecc8.update(bytes9, 0, bytes9.length);
            byte[] result9 = kecc8.digest();
            StringBuilder stringBuilder8 = new StringBuilder();
            stringBuilder8.append("0x");
            for (byte b7 : result8) {
                stringBuilder8.append(String.format("%02x", b7 & 0xFF));
            }

            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder9.append("0x");
            for (byte b6 : result9) {
                stringBuilder9.append(String.format("%02x", b6 & 0xFF));
            }

            byte[] bytes2;
            String cleanInput7;

            cleanInput7 = publicKeyNoPrefix;


            int len7 = Objects.requireNonNull(cleanInput7).length();


            byte[] data7;
            int startIdx7;

            data7 = new byte[len7 / 2];
            startIdx7 = 0;

            for (int i8 = startIdx7; i8 < len7; i8 += 2) {
                data7[(i8 + 1) / 2] =
                        (byte)
                                ((Character.digit(cleanInput7.charAt(i8), 16) << 4)
                                        + Character.digit(cleanInput7.charAt(i8 + 1), 16));
            }
            bytes2 = data7;


            Keccak.Digest256 kecc7 = new Keccak.Digest256();
            kecc7.update(bytes2, 0, bytes2.length);
            byte[] result2 = kecc7.digest();
            byte[] bytes3;
            String cleanInput6;

            cleanInput6 = publicKeyNoPrefix;


            int len6 = Objects.requireNonNull(cleanInput6).length();


            byte[] data6;
            int startIdx6;

            data6 = new byte[len6 / 2];
            startIdx6 = 0;

            for (int i7 = startIdx6; i7 < len6; i7 += 2) {
                data6[(i7 + 1) / 2] =
                        (byte)
                                ((Character.digit(cleanInput6.charAt(i7), 16) << 4)
                                        + Character.digit(cleanInput6.charAt(i7 + 1), 16));
            }
            bytes3 = data6;


            Keccak.Digest256 kecc6 = new Keccak.Digest256();
            kecc6.update(bytes3, 0, bytes3.length);
            byte[] result3 = kecc6.digest();
            byte[] bytes4 = new byte[0];


            Keccak.Digest256 kecc5 = new Keccak.Digest256();
            kecc5.update(bytes4, 0, bytes4.length);
            byte[] result4 = kecc5.digest();
            byte[] bytes5 = new byte[0];


            Keccak.Digest256 kecc4 = new Keccak.Digest256();
            kecc4.update(bytes5, 0, bytes5.length);
            byte[] result5 = kecc4.digest();
            byte[] bytes6 = new byte[0];


            Keccak.Digest256 kecc3 = new Keccak.Digest256();
            kecc3.update(bytes6, 0, bytes6.length);
            byte[] result6 = kecc3.digest();
            byte[] bytes7;
            String cleanInput2;

            cleanInput2 = publicKeyNoPrefix;


            int len2 = Objects.requireNonNull(cleanInput2).length();


            byte[] data2;
            int startIdx2;

            data2 = new byte[len2 / 2];
            startIdx2 = 0;

            for (int i3 = startIdx2; i3 < len2; i3 += 2) {
                data2[(i3 + 1) / 2] =
                        (byte)
                                ((Character.digit(cleanInput2.charAt(i3), 16) << 4)
                                        + Character.digit(cleanInput2.charAt(i3 + 1), 16));
            }
            bytes7 = data2;


            Keccak.Digest256 kecc2 = new Keccak.Digest256();
            kecc2.update(bytes7, 0, bytes7.length);
            byte[] result7 = kecc2.digest();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("0x");
            for (byte b5 : result2) {
                stringBuilder2.append(String.format("%02x", b5 & 0xFF));
            }

            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("0x");
            for (byte b4 : result3) {
                stringBuilder3.append(String.format("%02x", b4 & 0xFF));
            }

            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("0x");
            for (byte b3 : result4) {
                stringBuilder4.append(String.format("%02x", b3 & 0xFF));
            }

            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("0x");
            for (byte b2 : result5) {
                stringBuilder5.append(String.format("%02x", b2 & 0xFF));
            }

            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append("0x");
            for (byte b1 : result6) {
                stringBuilder6.append(String.format("%02x", b1 & 0xFF));
            }

            StringBuilder stringBuilder7 = new StringBuilder();
            for (byte element : result7) {
                stringBuilder7.append(String.format("%02x", element & 0xFF));
            }


            //0xef678007d18427e6022059dbc264f27507cd1ffc
            System.out.println(stringBuilder7.toString());

        }

    }


}
