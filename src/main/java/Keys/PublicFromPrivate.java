package Keys;

import java.io.Serializable;
import java.math.BigInteger;

public class PublicFromPrivate implements Serializable {
    public String getPublicFromPrivate(String privatekey, String decodeString) throws Exception {

        String ret = getPublicNonFormat(privatekey, decodeString);
        ret = ret.substring(ret.length()-40);

        return ("0x")+ret;
    }

    public String getPublicNonFormat(String privatekey, String decodeString) throws Exception {
        byte[] encoded = extracted1(privatekey,  decodeString);
        byte[] copy = new byte[64];

        System.arraycopy(encoded, 1, copy, 0,64);
        String result10 = new BigInteger(1, copy).toString(16);



        if (result10.length() < 64 << 1) {
            String qq = String.valueOf(new char[(64 << 1) - result10.length()]).replace("\0","0");
            result10 = qq + result10;
        }


        return duplicate2(result10).toString();
    }


    private byte[] extracted1(String privatekey, String decodeString) throws Exception {
        BigInteger i1 = new BigInteger(privatekey, 16);

        ECCurve curve = new SecP256K1Curve().configure().setEndomorphism().create();
        X9ECPoint G = new X9ECPoint(curve, Hex.decode(decodeString));
        X9ECParameters p7 = new X9ECParameters(G);
        ECPoint p6 = p7.getG();
        BigInteger k1 = i1.abs();

        ECCurve c = p6.getCurve();
        BigInteger order = c.order;
        int size = order != null ? order.bitLength() : c.getFieldSize() + 1;


        FixedPointPreCompInfo info = FixedPointUtil.precompute(p6);
        ECLookupTable lookupTable = info.getLookupTable();
        int width = info.getWidth(), d = (size + width - 1) / width;

        ECPoint R = c.getInfinity();

        int fullComb = d * width;


        int[] z = new int[(fullComb + 31) >> 5];
        for (int i11 = 0; k1.signum() != 0;) {
            z[i11++] = k1.intValue();
            k1 = k1.shiftRight(32);
        }
        int[] K = z;

        for (int top = fullComb - 1, i = 0; i < d; ++i) {
			int secretIndex = 0;
			for (int j = top - i; j >= 0; j -= d) {
				int secretBit = K[j >>> 5] >>> (j & 0x1F);
				secretIndex ^= secretBit >>> 1;
				secretIndex <<= 1;
				secretIndex ^= secretBit;
			}
			R = R.twicePlus(lookupTable.lookup(secretIndex));
		}

        ECPoint positive = R.add(info.getOffset());
        ECPoint p11 = (i1.signum() > 0 ? positive : positive.negate());


        ECPoint p1 = p11;


        ECFieldElement Z1 = p1.getZCoord(0);
        ECPoint normed = Z1.toBigInteger().bitLength() == 1 ? p1 : p1.normalize(Z1.invert());

        byte[] X = normed.getXCoord().getEncoded();


        byte[] Y = normed.getYCoord().getEncoded(), PO = new byte[X.length + Y.length + 1];

        PO[0] = 0x04;
        System.arraycopy(X, 0, PO, 1, X.length);
        System.arraycopy(Y, 0, PO, X.length + 1, Y.length);
        return PO;
    }





    private StringBuilder duplicate2(String publicKeyNoPrefix) {

        byte[] data = new byte[publicKeyNoPrefix.length() / 2];

        for (int i1 = 0; i1 < publicKeyNoPrefix.length(); i1 += 2)
            data[(i1 + 1) / 2] = (byte) ((Character.digit(publicKeyNoPrefix.charAt(i1), 16) << 4)
                    + Character.digit(publicKeyNoPrefix.charAt(i1 + 1), 16));

        return duplicate4(data);
    }

    private StringBuilder duplicate4(byte[] data) {
        StringBuilder stringBuilder1 = new StringBuilder();

        Keccak.Digest256 kecc = new Keccak.Digest256();
        kecc.digest.update(data, 0, data.length);

        byte[] digestBytes = new byte[kecc.digest.getDigestSize()];
        kecc.digest.doFinal(digestBytes, 0);
        for (byte b : digestBytes)
            stringBuilder1.append(String.format("%02x", b & 0xFF));

        return stringBuilder1;
    }


}
