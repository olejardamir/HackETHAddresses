package Generator;

import java.util.Random;

public class PKGenerator {
    private String[] alph = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
    private Random rnd = new Random();
    int l = 0;

    public  PKGenerator(){
        l = alph.length;
    }

    public String generateRandomPK() {
        String ret = "";
        for(int t=0;t<64;t++){
            ret = ret+alph[rnd.nextInt(l)];
        }
        return ret;
    }
}
