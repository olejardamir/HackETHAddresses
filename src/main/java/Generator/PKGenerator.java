package Generator;

import it.unimi.dsi.util.XorShift1024StarRandom;

import java.util.Random;

public class PKGenerator {
//    private char[] alph = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	private char[] alph = {'0','1','2','3','4','5'}; //shortened for collisions
    private Random rnd = new Random();
    int l = 0;
    char[] key = new char[64];
    final XorShift1024StarRandom random = new XorShift1024StarRandom();

    public  PKGenerator(){
        for(int t=0;t<64;t++){key[t]='0';}
        l = alph.length;
    }

    public String generateRandomPK() {
        String ret = "";
        int pos = random.nextInt(64);
        int chr = random.nextInt(l);
        key[pos]=alph[chr];
        return getString();
    }

    private String getString(){
        String ret = "";
        for(int t=0;t<64;t++){
            ret = ret+key[t];
        }
        return ret;
    }


}
