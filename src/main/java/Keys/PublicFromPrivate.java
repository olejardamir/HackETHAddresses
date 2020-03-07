package Keys;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.math.BigInteger;

public class PublicFromPrivate implements Serializable {

    private static final HexEncoder encoder = new HexEncoder();
    private X9ECPoint G;
    private KeccakDigest kecc;


    public PublicFromPrivate(String decodeString) throws Exception {
        ECCurve curve = new SecP256K1Curve().configure().create();
        G = new X9ECPoint(curve, decode(decodeString));
        kecc = new KeccakDigest();
    }

    private static byte[] decode(String data) throws Exception {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();


        encoder.decode(data, bOut);


        return bOut.toByteArray();
    }

    public String getPublicFromPrivate(String privatekey) {
        String ret = getPublicNonFormat(privatekey);
        ret = ret.substring(ret.length() - 40);
        return ("0x") + ret;
    }

    public String getPublicNonFormat(String privatekey) {
        byte[] encoded = extracted1(privatekey);
        byte[] copy = new byte[64];

        System.arraycopy(encoded, 1, copy, 0, 64);
        String result10 = new BigInteger(1, copy).toString(16);

        if (result10.length() < 64 << 1) {
            String qq = String.valueOf(new char[(64 << 1) - result10.length()]).replace("\0", "0");
            result10 = qq + result10;
        }

        return duplicate2(result10).toString();
    }


    private byte[] extracted1(String privatekey) {
        BigInteger i1 = new BigInteger(privatekey, 16);


        ECPoint p6 = G.getPoint();
        BigInteger k1 = i1.abs();

        ECCurve c = p6.curve;
        BigInteger order = c.order;
        int size = order != null ? order.bitLength() : c.getFieldSize() + 1;


        FixedPointPreCompInfo info = FixedPointUtil.precompute(p6);
        ECLookupTable lookupTable = info.getLookupTable();
        int width = info.getWidth(), d = (size + width - 1) / width;

        ECPoint R = c.getInfinity();

        int fullComb = d * width;


        int[] z = new int[(fullComb + 31) >> 5];
        for (int i11 = 0; k1.signum() != 0; ) {
            z[i11++] = k1.intValue();
            k1 = k1.shiftRight(32);
        }

        for (int top = fullComb - 1, i = 0; i < d; ++i) {
            int secretIndex = 0;
            for (int j = top - i; j >= 0; j -= d) {
                int secretBit = z[j >>> 5] >>> (j & 0x1F);
                secretIndex ^= secretBit >>> 1;
                secretIndex <<= 1;
                secretIndex ^= secretBit;
            }
            R = R.twicePlus(lookupTable.lookup(secretIndex));
        }

        ECPoint positive = R.add(info.getOffset());


        ECPoint ecPoint = (i1.signum() > 0 ? positive : positive.negate());
        ECFieldElement Z1 = (0 >= ecPoint.zs.length) ? null : ecPoint.zs[0];
        ECPoint normed = (Z1 != null ? Z1.toBigInteger().bitLength() : 0) == 1 ? (i1.signum() > 0 ? positive : positive.negate())
                : (i1.signum() > 0 ? positive : positive.negate()).normalize(Z1 != null ? Z1.invert() : null);

        byte[] X = normed.x.getEncoded();


        byte[] Y = normed.y.getEncoded(), PO = new byte[X.length + Y.length + 1];

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

        StringBuilder stringBuilder1 = new StringBuilder();


        kecc.update(data, data.length);

        byte[] digestBytes = new byte[kecc.getDigestSize()];
        kecc.doFinal(digestBytes);
        for (byte b : digestBytes)
            stringBuilder1.append(String.format("%02x", b & 0xFF));

        return stringBuilder1;
    }


}
