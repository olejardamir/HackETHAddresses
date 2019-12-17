package Distance;

import Keys.PublicFromPrivate;

import java.util.HashMap;
import java.util.Random;

public class NeedleHaystack {

    private PublicFromPrivate publicFromPrivate = new PublicFromPrivate();
    private Random rnd = new Random();
    private Hamming hamming = new Hamming();

    private HashMap<Integer, Character> map = new HashMap<>();

    public NeedleHaystack(){
        for(int t=0;t<16;t++){
            if(t==10){map.put(t,'a');}
            else if(t==11){map.put(t,'b');}
            else if(t==12){map.put(t,'c');}
            else if(t==13){map.put(t,'d');}
            else if(t==14){map.put(t,'e');}
            else if(t==15){map.put(t,'f');}

            else{
                map.put(t,(""+t).charAt(0));
            }
        }
    }


    public String[] findNextBest(String desiredPubKey, double currentBestDistance) throws Exception {
        String[] ret = new String[3]; //PK, PUB, DISTANCE
        if(desiredPubKey.startsWith("0x")){desiredPubKey=desiredPubKey.substring(2);}

        while(true) {
            String rndKey = generateRandomPK();
            String pub = publicFromPrivate.getPublicFromPrivate(rndKey);
            if(pub.startsWith("0x")){pub=pub.substring(2);}


            double distance = hamming.evaluateDistance(pub, desiredPubKey);
            if (distance > currentBestDistance) {
                ret[0] = rndKey;
                ret[1] = pub;
                ret[2] = "" + distance;
                return ret;
            }
        }
     }

    private String generateRandomPK(){
        String ret = "";
        for(int t=0;t<64;t++){
            ret = ret +map.get(rnd.nextInt(16));
        }
        return ret;
    }




}
