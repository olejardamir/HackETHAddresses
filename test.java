import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

import java.math.BigInteger;
import java.util.Optional;

import static java.lang.System.arraycopy;
import static java.lang.System.out;
import static java.util.Objects.requireNonNull;

public class test {

    public static void main(String[] args){

        {
            String privatekey = "a392604efc2fad9c0b3da43b5f698a2e3f270f170d859912be0d54742275c5f6";

            boolean changed7 = false;
            char[] chars7 = "secp256k1".toCharArray();

            for (int i18 = 0; i18 != chars7.length; i18++)
            {
                char ch7 = chars7[i18];
                if ('A' <= ch7 && 'Z' >= ch7)
                {
                    changed7 = true;
                    chars7[i18] = (char)(ch7 - 'A' + 'a');
                }
            }

            String result18;
            if (changed7)
            {
                result18 = new String(chars7);
            } else {
                result18 = "secp256k1";
            }

            X9ECParametersHolder holder4 = (X9ECParametersHolder) CustomNamedCurves.nameToCurve.get(result18);
            String result17;
            boolean changed6 = false;
            char[] chars6 = "secp256k1".toCharArray();

            for (int i17 = 0; i17 != chars6.length; i17++)
            {
                char ch6 = chars6[i17];
                if ('A' <= ch6 && 'Z' >= ch6)
                {
                    changed6 = true;
                    chars6[i17] = (char)(ch6 - 'A' + 'a');
                }
            }

            if (changed6)
            {
                result17 = new String(chars6);
            } else {
                result17 = "secp256k1";
            }

            X9ECParametersHolder holder5 = (X9ECParametersHolder) CustomNamedCurves.nameToCurve.get(result17);
            String result16;
            boolean changed5 = false;
            char[] chars5 = "secp256k1".toCharArray();

            for (int i16 = 0; i16 != chars5.length; i16++)
            {
                char ch5 = chars5[i16];
                if ('A' <= ch5 && 'Z' >= ch5)
                {
                    changed5 = true;
                    chars5[i16] = (char)(ch5 - 'A' + 'a');
                }
            }

            if (changed5)
            {
                result16 = new String(chars5);
            } else {
                result16 = "secp256k1";
            }

            X9ECParametersHolder holder6 = (X9ECParametersHolder) CustomNamedCurves.nameToCurve.get(result16);
            String result15;
            boolean changed4 = false;
            char[] chars4 = "secp256k1".toCharArray();

            for (int i15 = 0; i15 != chars4.length; i15++)
            {
                char ch4 = chars4[i15];
                if ('A' <= ch4 && 'Z' >= ch4)
                {
                    changed4 = true;
                    chars4[i15] = (char)(ch4 - 'A' + 'a');
                }
            }

            if (changed4)
            {
                result15 = new String(chars4);
            } else {
                result15 = "secp256k1";
            }

            X9ECParametersHolder holder7 = (X9ECParametersHolder) CustomNamedCurves.nameToCurve.get(result15);
            BigInteger privKey = new BigInteger(privatekey, 16);
            if (privKey.bitLength() > new ECDomainParameters((requireNonNull(Optional.ofNullable(holder7).map(X9ECParametersHolder::getParameters).orElse(null))).getCurve(), (requireNonNull(holder6 == null ? null : holder6.getParameters())).getG(), (requireNonNull(holder5 == null ? null : holder5.getParameters())).getN(), (requireNonNull((holder4 == null) ? null : holder4.getParameters())).getH(), null).getN().bitLength()) {
                String result3;
                boolean changed3 = false;
                char[] chars3 = "secp256k1".toCharArray();

                for (int i3 = 0; i3 != chars3.length; i3++)
                {
                    char ch3 = chars3[i3];
                    if ('A' <= ch3 && 'Z' >= ch3)
                    {
                        changed3 = true;
                        chars3[i3] = (char)(ch3 - 'A' + 'a');
                    }
                }

                if (changed3)
                {
                    result3 = new String(chars3);
                } else {
                    result3 = "secp256k1";
                }

                X9ECParametersHolder holder = (X9ECParametersHolder) CustomNamedCurves.nameToCurve.get(result3);
                String result2;
                boolean changed2 = false;
                char[] chars2 = "secp256k1".toCharArray();

                for (int i2 = 0; i2 != chars2.length; i2++)
                {
                    char ch2 = chars2[i2];
                    if ('A' <= ch2 && 'Z' >= ch2)
                    {
                        changed2 = true;
                        chars2[i2] = (char)(ch2 - 'A' + 'a');
                    }
                }

                if (changed2)
                {
                    result2 = new String(chars2);
                } else {
                    result2 = "secp256k1";
                }

                X9ECParametersHolder holder1 = (X9ECParametersHolder) CustomNamedCurves.nameToCurve.get(result2);
                String result1;
                boolean changed1 = false;
                char[] chars1 = "secp256k1".toCharArray();

                for (int i1 = 0; i1 != chars1.length; i1++)
                {
                    char ch1 = chars1[i1];
                    if ('A' <= ch1 && 'Z' >= ch1)
                    {
                        changed1 = true;
                        chars1[i1] = (char)(ch1 - 'A' + 'a');
                    }
                }

                if (changed1)
                {
                    result1 = new String(chars1);
                } else {
                    result1 = "secp256k1";
                }

                X9ECParametersHolder holder2 = (X9ECParametersHolder) CustomNamedCurves.nameToCurve.get(result1);
                String result;
                boolean changed = false;
                char[] chars = "secp256k1".toCharArray();

                for (int i = 0; i != chars.length; i++)
                {
                    char ch = chars[i];
                    if ('A' <= ch && 'Z' >= ch)
                    {
                        changed = true;
                        chars[i] = (char)(ch - 'A' + 'a');
                    }
                }

                if (changed)
                {
                    result = new String(chars);
                } else {
                    result = "secp256k1";
                }

                X9ECParametersHolder holder3 = (X9ECParametersHolder) CustomNamedCurves.nameToCurve.get(result);
                privKey = privKey.mod(new ECDomainParameters(((holder3 == null) ? null : holder3.getParameters()).getCurve(), (holder2 == null ? null : holder2.getParameters()).getG(), (holder1 == null ? null : holder1.getParameters()).getN(), (holder == null ? null : holder.getParameters()).getH(), null).getN());
            }
            String result14;
            boolean changed3 = false;
            char[] chars3 = "secp256k1".toCharArray();

            for (int i14 = 0; i14 != chars3.length; i14++)
            {
                char ch3 = chars3[i14];
                if ('A' <= ch3 && 'Z' >= ch3)
                {
                    changed3 = true;
                    chars3[i14] = (char)(ch3 - 'A' + 'a');
                }
            }

            if (changed3)
            {
                result14 = new String(chars3);
            } else {
                result14 = "secp256k1";
            }

            X9ECParametersHolder holder = (X9ECParametersHolder) CustomNamedCurves.nameToCurve.get(result14);
            String result13;
            boolean changed2 = false;
            char[] chars2 = "secp256k1".toCharArray();

            for (int i13 = 0; i13 != chars2.length; i13++)
            {
                char ch2 = chars2[i13];
                if ('A' <= ch2 && 'Z' >= ch2)
                {
                    changed2 = true;
                    chars2[i13] = (char)(ch2 - 'A' + 'a');
                }
            }

            if (changed2)
            {
                result13 = new String(chars2);
            } else {
                result13 = "secp256k1";
            }

            X9ECParametersHolder holder1 = (X9ECParametersHolder) CustomNamedCurves.nameToCurve.get(result13);
            String result12;
            boolean changed1 = false;
            char[] chars1 = "secp256k1".toCharArray();

            for (int i12 = 0; i12 != chars1.length; i12++)
            {
                char ch1 = chars1[i12];
                if ('A' <= ch1 && 'Z' >= ch1)
                {
                    changed1 = true;
                    chars1[i12] = (char)(ch1 - 'A' + 'a');
                }
            }

            if (changed1)
            {
                result12 = new String(chars1);
            } else {
                result12 = "secp256k1";
            }

            X9ECParametersHolder holder2 = (X9ECParametersHolder) CustomNamedCurves.nameToCurve.get(result12);
            String result11;
            boolean changed = false;
            char[] chars = "secp256k1".toCharArray();

            for (int i11 = 0; i11 != chars.length; i11++)
            {
                char ch = chars[i11];
                if ('A' <= ch && 'Z' >= ch)
                {
                    changed = true;
                    chars[i11] = (char)(ch - 'A' + 'a');
                }
            }

            if (changed)
            {
                result11 = new String(chars);
            } else {
                result11 = "secp256k1";
            }

            X9ECParametersHolder holder3 = (X9ECParametersHolder) CustomNamedCurves.nameToCurve.get(result11);
            ECPoint point;
            point = new FixedPointCombMultiplier().multiply(new ECDomainParameters((holder3 == null ? null : holder3.getParameters()).getCurve(), (holder2 == null ? null : holder2.getParameters()).getG(), (holder1 == null ? null : holder1.getParameters()).getN(), (holder == null ? null : holder.getParameters()).getH(), null).getG(), privKey);

            int newLength = point.getEncoded(false).length - 1;
            if (newLength < 0)
                throw new IllegalArgumentException(1 + " > " + point.getEncoded(false).length);
            byte[] copy = new byte[newLength];
            arraycopy(point.getEncoded(false), 1, copy, 0,
                    Math.min(point.getEncoded(false).length - 1, newLength));
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

            input = "0x" + result10;
            if (input.length() == 0 || (input.length() <= 1) || (input.charAt(0) != '0') || (input.charAt(1) != 'x')) {
                publicKeyNoPrefix = input;
            } else {
                publicKeyNoPrefix = input.substring(2);
            }

            if (publicKeyNoPrefix.length() < 64 << 1) {
                publicKeyNoPrefix =
                        new String(new char[(64 << 1) - publicKeyNoPrefix.length()]).replace("\0", String.valueOf('0'))
                                + publicKeyNoPrefix;
            }
            String address1;
            byte[] bytes8;
            String cleanInput9;
            final boolean boolean1;
            if (publicKeyNoPrefix.length() == 0) {
                boolean1 = false;
            } else {
                boolean1 = publicKeyNoPrefix.length() > 1 && publicKeyNoPrefix.charAt(0) == '0' && publicKeyNoPrefix.charAt(1) == 'x';
            }
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

            new Keccak.Digest256().update(bytes8, 0, bytes8.length);
            byte[] result8 = new Keccak.Digest256().digest();
            String cleanInput8;
            if (boolean1) {
                cleanInput8 = publicKeyNoPrefix.substring(2);
            } else {
                cleanInput8 = publicKeyNoPrefix;
            }

            int len8 = cleanInput8.length();

            byte[] bytes9;
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
            stringBuilder8.append("0x");
            for (byte b7 : result8) {
                stringBuilder8.append(String.format("%02x", b7 & 0xFF));
            }

            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder9.append("0x");
            for (byte b6 : result9) {
                stringBuilder9.append(String.format("%02x", b6 & 0xFF));
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
            stringBuilder7.append("0x");
            for (byte element : result7) {
                stringBuilder7.append(String.format("%02x", element & 0xFF));
            }

            if (!(!(s.length() == 0) && (stringBuilder7.toString().substring(stringBuilder6.toString().length() - (160 >> 2)).length() > 1) && (stringBuilder5.toString().substring(stringBuilder4.toString().length() - (160 >> 2)).charAt(0) == '0') && (stringBuilder3.toString().substring(stringBuilder2.toString().length() - (160 >> 2)).charAt(1) == 'x'))) {
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
                stringBuilder.append("0x");
                for (byte item : result) {
                    stringBuilder.append(String.format("%02x", item & 0xFF));
                }

                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("0x");
                for (byte b : result1) {
                    stringBuilder1.append(String.format("%02x", b & 0xFF));
                }

                address1 = "0x" + stringBuilder1.toString().substring(stringBuilder.toString().length() - (160 >> 2));
            } else {
                byte[] bytes;
                String cleanInput1 = boolean1 ? publicKeyNoPrefix.substring(2) : publicKeyNoPrefix;

                int len1 = cleanInput1.length();

                switch (len1) {
                    case 0:
                        bytes = new byte[]{};
                        break;
                    default:
                        byte[] data1;
                        int startIdx1;
                        switch (len1 % 2) {
                            case 0:
                                data1 = new byte[len1 / 2];
                                startIdx1 = 0;
                                break;
                            default:
                                data1 = new byte[(len1 / 2) + 1];
                                data1[0] = (byte) Character.digit(cleanInput1.charAt(0), 16);
                                startIdx1 = 1;
                                break;
                        }
                        for (int i2 = startIdx1; i2 < len1; i2 += 2) {
                            data1[(i2 + 1) / 2] =
                                    (byte)
                                            ((Character.digit(cleanInput1.charAt(i2), 16) << 4)
                                                    + Character.digit(cleanInput1.charAt(i2 + 1), 16));
                        }
                        bytes = data1;
                        break;
                }

                Keccak.DigestKeccak kecc1 = new Keccak.Digest256();
                kecc1.update(bytes, 0, bytes.length);
                byte[] result = kecc1.digest();
                byte[] bytes1;
                String cleanInput = cleanInput1;

                int len = cleanInput.length();

                switch (len) {
                    case 0:
                        bytes1 = new byte[]{};
                        break;
                    default:
                        byte[] data;
                        int startIdx;
                        switch (len % 2) {
                            case 0:
                                data = new byte[len / 2];
                                startIdx = 0;
                                break;
                            default:
                                data = new byte[(len / 2) + 1];
                                data[0] = (byte) Character.digit(cleanInput.charAt(0), 16);
                                startIdx = 1;
                                break;
                        }
                        for (int i1 = startIdx; i1 < len; i1 += 2) {
                            data[(i1 + 1) / 2] =
                                    (byte)
                                            ((Character.digit(cleanInput.charAt(i1), 16) << 4)
                                                    + Character.digit(cleanInput.charAt(i1 + 1), 16));
                        }
                        bytes1 = data;
                        break;
                }

                Keccak.DigestKeccak kecc = new Keccak.Digest256();
                kecc.update(bytes1, 0, bytes1.length);
                byte[] result1 = kecc.digest();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("0x");
                for (byte item : result) {
                    stringBuilder.append(String.format("%02x", item & 0xFF));
                }

                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("0x");
                for (byte b : result1) {
                    stringBuilder1.append(String.format("%02x", b & 0xFF));
                }

                address1 = stringBuilder1.toString().substring(stringBuilder.toString().length() - (160 >> 2));
            }


            //0xef678007d18427e6022059dbc264f27507cd1ffc
            out.println(address1);

        }

    }


}
