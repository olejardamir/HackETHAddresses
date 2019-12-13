
import java.io.IOException;
import java.math.BigInteger;

public class test {

    public static void main(String[] args) throws IOException {

        {
            String privatekey = "8da4ef21b864d2cc526dbdb2a120bd2874c36c9d0a1fb7f8c63d7f7a8b41de8f";
            //EXPECTED: 63FaC9201494f0bd17B9892B9fae4d52fe3BD377


            String cleanValue;
            if (!(privatekey == null || privatekey.length() == 0)
                    && privatekey.length() > 1
                    && privatekey.charAt(0) == '0'
                    && privatekey.charAt(1) == 'x') {
                cleanValue = privatekey.substring(2);
            } else {
                cleanValue = privatekey;
            }
            BigInteger privKey = new BigInteger(cleanValue, 16);
            /*
             * TODO: FixedPointCombMultiplier currently doesn't support scalars longer than the group
             * order, but that could change in future versions.
             */
            if (privKey.bitLength() > new ECDomainParameters(
                    CustomNamedCurves.getByName("secp256k1").getCurve(),
                    CustomNamedCurves.getByName("secp256k1").getG(),
                    CustomNamedCurves.getByName("secp256k1").getN(),
                    CustomNamedCurves.getByName("secp256k1").getH()).getN().bitLength()) {
                privKey = privKey.mod(new ECDomainParameters(
                        CustomNamedCurves.getByName("secp256k1").getCurve(),
                        CustomNamedCurves.getByName("secp256k1").getG(),
                        CustomNamedCurves.getByName("secp256k1").getN(),
                        CustomNamedCurves.getByName("secp256k1").getH()).getN());
            }
            ECPoint point = new FixedPointCombMultiplier().multiply(new ECDomainParameters(
                    CustomNamedCurves.getByName("secp256k1").getCurve(),
                    CustomNamedCurves.getByName("secp256k1").getG(),
                    CustomNamedCurves.getByName("secp256k1").getN(),
                    CustomNamedCurves.getByName("secp256k1").getH()).getG(), privKey);

            byte[] encoded = point.getEncoded(false);
            int newLength = encoded.length - 1;
            if (newLength < 0)
                throw new IllegalArgumentException(1 + " > " + encoded.length);
            byte[] copy = new byte[newLength];
            System.arraycopy(encoded, 1, copy, 0,
                    Math.min(encoded.length - 1, newLength));
            BigInteger value = new BigInteger(1, copy);
            String publicKeyNoPrefix;
            String input;
            String result10 = value.toString(16);

            int length = result10.length();
            if (length > 64 << 1) {
                throw new UnsupportedOperationException(
                        "Value " + result10 + "is larger then length " + (64 << 1));
            } else if (value.signum() < 0) {
                throw new UnsupportedOperationException("Value cannot be negative");
            }

            if (length < 64 << 1) {
                result10 = new String(new char[(64 << 1) - length]).replace("\0", String.valueOf('0')) + result10;
            }

            if (true) {
                input = "0x" + result10;
            } else {
                input = result10;
            }
            if (!(input == null || input.length() == 0)
                    && input.length() > 1
                    && input.charAt(0) == '0'
                    && input.charAt(1) == 'x') {
                publicKeyNoPrefix = input.substring(2);
            } else {
                publicKeyNoPrefix = input;
            }

            if (publicKeyNoPrefix.length() < 64 << 1) {
                publicKeyNoPrefix =
                        new String(new char[(64 << 1) - publicKeyNoPrefix.length()]).replace("\0", String.valueOf('0'))
                                + publicKeyNoPrefix;
            }
            String address1;
            byte[] bytes8;
            String cleanInput9;
            final boolean boolean1 = !(publicKeyNoPrefix == null || publicKeyNoPrefix.length() == 0)
                    && publicKeyNoPrefix.length() > 1
                    && publicKeyNoPrefix.charAt(0) == '0'
                    && publicKeyNoPrefix.charAt(1) == 'x';
            if (boolean1) {
                cleanInput9 = publicKeyNoPrefix.substring(2);
            } else {
                cleanInput9 = publicKeyNoPrefix;
            }

            int len9 = cleanInput9.length();

            if (len9 == 0) {
                bytes8 = new byte[]{};
            } else {
                byte[] data9;
                int startIdx9;
                if (len9 % 2 != 0) {
                    data9 = new byte[(len9 / 2) + 1];
                    data9[0] = (byte) Character.digit(cleanInput9.charAt(0), 16);
                    startIdx9 = 1;
                } else {
                    data9 = new byte[len9 / 2];
                    startIdx9 = 0;
                }
                for (int i10 = startIdx9; i10 < len9; i10 += 2) {
                    data9[(i10 + 1) / 2] =
                            (byte)
                                    ((Character.digit(cleanInput9.charAt(i10), 16) << 4)
                                            + Character.digit(cleanInput9.charAt(i10 + 1), 16));
                }
                bytes8 = data9;
            }

            Keccak.DigestKeccak kecc9 = new Keccak.Digest256();
            kecc9.update(bytes8, 0, bytes8.length);
            byte[] result8 = kecc9.digest();
            byte[] bytes9;
            String cleanInput8;
            if (boolean1) {
                cleanInput8 = publicKeyNoPrefix.substring(2);
            } else {
                cleanInput8 = publicKeyNoPrefix;
            }

            int len8 = cleanInput8.length();

            if (len8 == 0) {
                bytes9 = new byte[]{};
            } else {
                byte[] data8;
                int startIdx8;
                if (len8 % 2 != 0) {
                    data8 = new byte[(len8 / 2) + 1];
                    data8[0] = (byte) Character.digit(cleanInput8.charAt(0), 16);
                    startIdx8 = 1;
                } else {
                    data8 = new byte[len8 / 2];
                    startIdx8 = 0;
                }
                for (int i9 = startIdx8; i9 < len8; i9 += 2) {
                    data8[(i9 + 1) / 2] =
                            (byte)
                                    ((Character.digit(cleanInput8.charAt(i9), 16) << 4)
                                            + Character.digit(cleanInput8.charAt(i9 + 1), 16));
                }
                bytes9 = data8;
            }

            Keccak.DigestKeccak kecc8 = new Keccak.Digest256();
            kecc8.update(bytes9, 0, bytes9.length);
            byte[] result9 = kecc8.digest();
            StringBuilder stringBuilder8 = new StringBuilder();
            if (true) {
                stringBuilder8.append("0x");
            }
            for (int i2 = 0; i2 < 0 + result8.length; i2++) {
                stringBuilder8.append(String.format("%02x", result8[i2] & 0xFF));
            }

            StringBuilder stringBuilder9 = new StringBuilder();
            if (true) {
                stringBuilder9.append("0x");
            }
            for (int i2 = 0; i2 < 0 + result9.length; i2++) {
                stringBuilder9.append(String.format("%02x", result9[i2] & 0xFF));
            }

            String s = stringBuilder9.toString().substring(stringBuilder8.toString().length() - (160 >> 2));
            byte[] bytes2;
            String cleanInput7;
            if (boolean1) {
                cleanInput7 = publicKeyNoPrefix.substring(2);
            } else {
                cleanInput7 = publicKeyNoPrefix;
            }

            int len7 = cleanInput7.length();

            if (len7 == 0) {
                bytes2 = new byte[]{};
            } else {
                byte[] data7;
                int startIdx7;
                if (len7 % 2 != 0) {
                    data7 = new byte[(len7 / 2) + 1];
                    data7[0] = (byte) Character.digit(cleanInput7.charAt(0), 16);
                    startIdx7 = 1;
                } else {
                    data7 = new byte[len7 / 2];
                    startIdx7 = 0;
                }
                for (int i8 = startIdx7; i8 < len7; i8 += 2) {
                    data7[(i8 + 1) / 2] =
                            (byte)
                                    ((Character.digit(cleanInput7.charAt(i8), 16) << 4)
                                            + Character.digit(cleanInput7.charAt(i8 + 1), 16));
                }
                bytes2 = data7;
            }

            Keccak.DigestKeccak kecc7 = new Keccak.Digest256();
            kecc7.update(bytes2, 0, bytes2.length);
            byte[] result2 = kecc7.digest();
            byte[] bytes3;
            String cleanInput6;
            if (boolean1) {
                cleanInput6 = publicKeyNoPrefix.substring(2);
            } else {
                cleanInput6 = publicKeyNoPrefix;
            }

            int len6 = cleanInput6.length();

            if (len6 == 0) {
                bytes3 = new byte[]{};
            } else {
                byte[] data6;
                int startIdx6;
                if (len6 % 2 != 0) {
                    data6 = new byte[(len6 / 2) + 1];
                    data6[0] = (byte) Character.digit(cleanInput6.charAt(0), 16);
                    startIdx6 = 1;
                } else {
                    data6 = new byte[len6 / 2];
                    startIdx6 = 0;
                }
                for (int i7 = startIdx6; i7 < len6; i7 += 2) {
                    data6[(i7 + 1) / 2] =
                            (byte)
                                    ((Character.digit(cleanInput6.charAt(i7), 16) << 4)
                                            + Character.digit(cleanInput6.charAt(i7 + 1), 16));
                }
                bytes3 = data6;
            }

            Keccak.DigestKeccak kecc6 = new Keccak.Digest256();
            kecc6.update(bytes3, 0, bytes3.length);
            byte[] result3 = kecc6.digest();
            byte[] bytes4;
            String cleanInput5;
            if (boolean1) {
                cleanInput5 = publicKeyNoPrefix.substring(2);
            } else {
                cleanInput5 = publicKeyNoPrefix;
            }

            int len5 = cleanInput5.length();

            if (len5 == 0) {
                bytes4 = new byte[]{};
            } else {
                byte[] data5;
                int startIdx5;
                if (len5 % 2 != 0) {
                    data5 = new byte[(len5 / 2) + 1];
                    data5[0] = (byte) Character.digit(cleanInput5.charAt(0), 16);
                    startIdx5 = 1;
                } else {
                    data5 = new byte[len5 / 2];
                    startIdx5 = 0;
                }
                for (int i6 = startIdx5; i6 < len5; i6 += 2) {
                    data5[(i6 + 1) / 2] =
                            (byte)
                                    ((Character.digit(cleanInput5.charAt(i6), 16) << 4)
                                            + Character.digit(cleanInput5.charAt(i6 + 1), 16));
                }
                bytes4 = data5;
            }

            Keccak.DigestKeccak kecc5 = new Keccak.Digest256();
            kecc5.update(bytes4, 0, bytes4.length);
            byte[] result4 = kecc5.digest();
            byte[] bytes5;
            String cleanInput4;
            if (boolean1) {
                cleanInput4 = publicKeyNoPrefix.substring(2);
            } else {
                cleanInput4 = publicKeyNoPrefix;
            }

            int len4 = cleanInput4.length();

            if (len4 == 0) {
                bytes5 = new byte[]{};
            } else {
                byte[] data4;
                int startIdx4;
                if (len4 % 2 != 0) {
                    data4 = new byte[(len4 / 2) + 1];
                    data4[0] = (byte) Character.digit(cleanInput4.charAt(0), 16);
                    startIdx4 = 1;
                } else {
                    data4 = new byte[len4 / 2];
                    startIdx4 = 0;
                }
                for (int i5 = startIdx4; i5 < len4; i5 += 2) {
                    data4[(i5 + 1) / 2] =
                            (byte)
                                    ((Character.digit(cleanInput4.charAt(i5), 16) << 4)
                                            + Character.digit(cleanInput4.charAt(i5 + 1), 16));
                }
                bytes5 = data4;
            }

            Keccak.DigestKeccak kecc4 = new Keccak.Digest256();
            kecc4.update(bytes5, 0, bytes5.length);
            byte[] result5 = kecc4.digest();
            byte[] bytes6;
            String cleanInput3;
            if (boolean1) {
                cleanInput3 = publicKeyNoPrefix.substring(2);
            } else {
                cleanInput3 = publicKeyNoPrefix;
            }

            int len3 = cleanInput3.length();

            if (len3 == 0) {
                bytes6 = new byte[]{};
            } else {
                byte[] data3;
                int startIdx3;
                if (len3 % 2 != 0) {
                    data3 = new byte[(len3 / 2) + 1];
                    data3[0] = (byte) Character.digit(cleanInput3.charAt(0), 16);
                    startIdx3 = 1;
                } else {
                    data3 = new byte[len3 / 2];
                    startIdx3 = 0;
                }
                for (int i4 = startIdx3; i4 < len3; i4 += 2) {
                    data3[(i4 + 1) / 2] =
                            (byte)
                                    ((Character.digit(cleanInput3.charAt(i4), 16) << 4)
                                            + Character.digit(cleanInput3.charAt(i4 + 1), 16));
                }
                bytes6 = data3;
            }

            Keccak.DigestKeccak kecc3 = new Keccak.Digest256();
            kecc3.update(bytes6, 0, bytes6.length);
            byte[] result6 = kecc3.digest();
            byte[] bytes7;
            String cleanInput2;
            if (boolean1) {
                cleanInput2 = publicKeyNoPrefix.substring(2);
            } else {
                cleanInput2 = publicKeyNoPrefix;
            }

            int len2 = cleanInput2.length();

            if (len2 == 0) {
                bytes7 = new byte[]{};
            } else {
                byte[] data2;
                int startIdx2;
                if (len2 % 2 != 0) {
                    data2 = new byte[(len2 / 2) + 1];
                    data2[0] = (byte) Character.digit(cleanInput2.charAt(0), 16);
                    startIdx2 = 1;
                } else {
                    data2 = new byte[len2 / 2];
                    startIdx2 = 0;
                }
                for (int i3 = startIdx2; i3 < len2; i3 += 2) {
                    data2[(i3 + 1) / 2] =
                            (byte)
                                    ((Character.digit(cleanInput2.charAt(i3), 16) << 4)
                                            + Character.digit(cleanInput2.charAt(i3 + 1), 16));
                }
                bytes7 = data2;
            }

            Keccak.DigestKeccak kecc2 = new Keccak.Digest256();
            kecc2.update(bytes7, 0, bytes7.length);
            byte[] result7 = kecc2.digest();
            StringBuilder stringBuilder2 = new StringBuilder();
            if (true) {
                stringBuilder2.append("0x");
            }
            for (int i1 = 0; i1 < 0 + result2.length; i1++) {
                stringBuilder2.append(String.format("%02x", result2[i1] & 0xFF));
            }

            StringBuilder stringBuilder3 = new StringBuilder();
            if (true) {
                stringBuilder3.append("0x");
            }
            for (int i1 = 0; i1 < 0 + result3.length; i1++) {
                stringBuilder3.append(String.format("%02x", result3[i1] & 0xFF));
            }

            StringBuilder stringBuilder4 = new StringBuilder();
            if (true) {
                stringBuilder4.append("0x");
            }
            for (int i1 = 0; i1 < 0 + result4.length; i1++) {
                stringBuilder4.append(String.format("%02x", result4[i1] & 0xFF));
            }

            StringBuilder stringBuilder5 = new StringBuilder();
            if (true) {
                stringBuilder5.append("0x");
            }
            for (int i1 = 0; i1 < 0 + result5.length; i1++) {
                stringBuilder5.append(String.format("%02x", result5[i1] & 0xFF));
            }

            StringBuilder stringBuilder6 = new StringBuilder();
            if (true) {
                stringBuilder6.append("0x");
            }
            for (int i1 = 0; i1 < 0 + result6.length; i1++) {
                stringBuilder6.append(String.format("%02x", result6[i1] & 0xFF));
            }

            StringBuilder stringBuilder7 = new StringBuilder();
            if (true) {
                stringBuilder7.append("0x");
            }
            for (int i1 = 0; i1 < 0 + result7.length; i1++) {
                stringBuilder7.append(String.format("%02x", result7[i1] & 0xFF));
            }

            if (!(!(s == null || s.length() == 0)
                    && stringBuilder7.toString().substring(stringBuilder6.toString().length() - (160 >> 2)).length() > 1
                    && stringBuilder5.toString().substring(stringBuilder4.toString().length() - (160 >> 2)).charAt(0) == '0'
                    && stringBuilder3.toString().substring(stringBuilder2.toString().length() - (160 >> 2)).charAt(1) == 'x')) {
                byte[] bytes;
                String cleanInput1;
                if (boolean1) {
                    cleanInput1 = publicKeyNoPrefix.substring(2);
                } else {
                    cleanInput1 = publicKeyNoPrefix;
                }

                int len1 = cleanInput1.length();

                if (len1 == 0) {
                    bytes = new byte[]{};
                } else {
                    byte[] data1;
                    int startIdx1;
                    if (len1 % 2 != 0) {
                        data1 = new byte[(len1 / 2) + 1];
                        data1[0] = (byte) Character.digit(cleanInput1.charAt(0), 16);
                        startIdx1 = 1;
                    } else {
                        data1 = new byte[len1 / 2];
                        startIdx1 = 0;
                    }
                    for (int i2 = startIdx1; i2 < len1; i2 += 2) {
                        data1[(i2 + 1) / 2] =
                                (byte)
                                        ((Character.digit(cleanInput1.charAt(i2), 16) << 4)
                                                + Character.digit(cleanInput1.charAt(i2 + 1), 16));
                    }
                    bytes = data1;
                }

                Keccak.DigestKeccak kecc1 = new Keccak.Digest256();
                kecc1.update(bytes, 0, bytes.length);
                byte[] result = kecc1.digest();
                byte[] bytes1;
                String cleanInput;
                if (boolean1) {
                    cleanInput = publicKeyNoPrefix.substring(2);
                } else {
                    cleanInput = publicKeyNoPrefix;
                }

                int len = cleanInput.length();

                if (len == 0) {
                    bytes1 = new byte[]{};
                } else {
                    byte[] data;
                    int startIdx;
                    if (len % 2 != 0) {
                        data = new byte[(len / 2) + 1];
                        data[0] = (byte) Character.digit(cleanInput.charAt(0), 16);
                        startIdx = 1;
                    } else {
                        data = new byte[len / 2];
                        startIdx = 0;
                    }
                    for (int i1 = startIdx; i1 < len; i1 += 2) {
                        data[(i1 + 1) / 2] =
                                (byte)
                                        ((Character.digit(cleanInput.charAt(i1), 16) << 4)
                                                + Character.digit(cleanInput.charAt(i1 + 1), 16));
                    }
                    bytes1 = data;
                }

                Keccak.DigestKeccak kecc = new Keccak.Digest256();
                kecc.update(bytes1, 0, bytes1.length);
                byte[] result1 = kecc.digest();
                StringBuilder stringBuilder = new StringBuilder();
                if (true) {
                    stringBuilder.append("0x");
                }
                for (int i = 0; i < 0 + result.length; i++) {
                    stringBuilder.append(String.format("%02x", result[i] & 0xFF));
                }

                StringBuilder stringBuilder1 = new StringBuilder();
                if (true) {
                    stringBuilder1.append("0x");
                }
                for (int i = 0; i < 0 + result1.length; i++) {
                    stringBuilder1.append(String.format("%02x", result1[i] & 0xFF));
                }

                address1 = "0x" + stringBuilder1.toString().substring(stringBuilder.toString().length() - (160 >> 2));
            } else {
                byte[] bytes;
                String cleanInput1;
                if (boolean1) {
                    cleanInput1 = publicKeyNoPrefix.substring(2);
                } else {
                    cleanInput1 = publicKeyNoPrefix;
                }

                int len1 = cleanInput1.length();

                if (len1 == 0) {
                    bytes = new byte[]{};
                } else {
                    byte[] data1;
                    int startIdx1;
                    if (len1 % 2 != 0) {
                        data1 = new byte[(len1 / 2) + 1];
                        data1[0] = (byte) Character.digit(cleanInput1.charAt(0), 16);
                        startIdx1 = 1;
                    } else {
                        data1 = new byte[len1 / 2];
                        startIdx1 = 0;
                    }
                    for (int i2 = startIdx1; i2 < len1; i2 += 2) {
                        data1[(i2 + 1) / 2] =
                                (byte)
                                        ((Character.digit(cleanInput1.charAt(i2), 16) << 4)
                                                + Character.digit(cleanInput1.charAt(i2 + 1), 16));
                    }
                    bytes = data1;
                }

                Keccak.DigestKeccak kecc1 = new Keccak.Digest256();
                kecc1.update(bytes, 0, bytes.length);
                byte[] result = kecc1.digest();
                byte[] bytes1;
                String cleanInput;
                if (boolean1) {
                    cleanInput = publicKeyNoPrefix.substring(2);
                } else {
                    cleanInput = publicKeyNoPrefix;
                }

                int len = cleanInput.length();

                if (len == 0) {
                    bytes1 = new byte[]{};
                } else {
                    byte[] data;
                    int startIdx;
                    if (len % 2 != 0) {
                        data = new byte[(len / 2) + 1];
                        data[0] = (byte) Character.digit(cleanInput.charAt(0), 16);
                        startIdx = 1;
                    } else {
                        data = new byte[len / 2];
                        startIdx = 0;
                    }
                    for (int i1 = startIdx; i1 < len; i1 += 2) {
                        data[(i1 + 1) / 2] =
                                (byte)
                                        ((Character.digit(cleanInput.charAt(i1), 16) << 4)
                                                + Character.digit(cleanInput.charAt(i1 + 1), 16));
                    }
                    bytes1 = data;
                }

                Keccak.DigestKeccak kecc = new Keccak.Digest256();
                kecc.update(bytes1, 0, bytes1.length);
                byte[] result1 = kecc.digest();
                StringBuilder stringBuilder = new StringBuilder();
                if (true) {
                    stringBuilder.append("0x");
                }
                for (int i = 0; i < 0 + result.length; i++) {
                    stringBuilder.append(String.format("%02x", result[i] & 0xFF));
                }

                StringBuilder stringBuilder1 = new StringBuilder();
                if (true) {
                    stringBuilder1.append("0x");
                }
                for (int i = 0; i < 0 + result1.length; i++) {
                    stringBuilder1.append(String.format("%02x", result1[i] & 0xFF));
                }

                address1 = stringBuilder1.toString().substring(stringBuilder.toString().length() - (160 >> 2));
            }


            //0xef678007d18427e6022059dbc264f27507cd1ffc
            System.out.println(address1);

        }

    }


}
