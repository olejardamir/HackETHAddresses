package Keys;

import java.io.Serializable;
import java.math.BigInteger;

public class PublicFromPrivate implements Serializable {

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
        FixedPointCombMultiplier m1 = new FixedPointCombMultiplier();
        BigInteger i1 = new BigInteger(privatekey, 16);

        X9ECParameters p7 = CustomNamedCurves.getByName(decodeString);
        ECPoint p6 = p7.getG();
        ECPoint p1 = m1.multiply(p6, i1);


        ECPoint normed = p1.normalize();

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
        kecc.update(data, 0, data.length);

        for (byte b : kecc.digest())
            stringBuilder1.append(String.format("%02x", b & 0xFF));

        return stringBuilder1;
    }


}
