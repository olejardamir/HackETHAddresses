import Generator.PKGenerator;
import Keys.PublicFromPrivate;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class Usage {

    public static void main(String[] args) throws Exception {

        PKGenerator pkGenerator = new PKGenerator();
        PublicFromPrivate publicFromPrivate = new PublicFromPrivate();


        // You need this constant defined!
        String gPoint = "04"+"79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798"+"483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8";

        File file = new File("data/test.txt");

        for(int t=0;t<10000;t++) {

            //generate some random private key
            String privateKey = pkGenerator.generateRandomPK();

            //turn private into public, the full length, no 0x ! 64 chars
            String publicKey = publicFromPrivate.getPublicNonFormat(privateKey, gPoint);


            FileUtils.write(file,privateKey+","+publicKey+"\n",true);


        }

    }



}
