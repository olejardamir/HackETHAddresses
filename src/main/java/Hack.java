import Generator.PKGenerator;
import Keys.PublicFromPrivate;

public class Hack {

    public static void main(String[] args) throws Exception {

        PKGenerator pkGenerator = new PKGenerator();
        PublicFromPrivate publicFromPrivate = new PublicFromPrivate();


        // You need this constant defined!
        String gPoint = "04"+"79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798"+"483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8";

        long start = System.nanoTime();
        int f=1000;
        for(int t=0;t<f;t++) {
            //generate some random private key
            String privateKey = pkGenerator.generateRandomPK();

            //turn private into public, the full length, no 0x ! 64 chars
            String publicKey = publicFromPrivate.getPublicNonFormat(privateKey, gPoint);
        }
        long end = System.nanoTime();
        System.out.println("It took: "+(end-start)+" nanoseconds for "+f+" keys");


    }

}
