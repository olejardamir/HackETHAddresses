import Generator.PKGenerator;
import Keys.PublicFromPrivate;

public class Usage {

    public static void main(String[] args) throws Exception {
        String decodeString = "04"+"79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798"+"483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8";

        PKGenerator pkGenerator = new PKGenerator();
        PublicFromPrivate publicFromPrivate = new PublicFromPrivate(decodeString);


        //generate some random private key
        String privateKey = pkGenerator.generateRandomPK();

        //turn private into public, the full length, no 0x ! 64 chars
        String publicKey = publicFromPrivate.getPublicNonFormat(privateKey, decodeString);

        //turn private into public 0x key 40 chars
        String publicKey_0x = publicFromPrivate.getPublicFromPrivate(privateKey, decodeString);

        System.out.println(publicKey);
        System.out.println(publicKey_0x);


    }



}
