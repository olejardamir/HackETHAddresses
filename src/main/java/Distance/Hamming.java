package Distance;

import java.util.HashMap;

public class Hamming {

    private HashMap<Character, Integer> map = new HashMap<>();

    public Hamming(){
        for(int t=0;t<16;t++){
            if(t==10){map.put('a',t);}
            else if(t==11){map.put('b',t);}
            else if(t==12){map.put('c',t);}
            else if(t==13){map.put('d',t);}
            else if(t==14){map.put('e',t);}
            else if(t==15){map.put('f',t);}
            else{
                map.put((""+t).charAt(0),t);
            }
        }
    }
    //greater the value, smaller the distance!
    public double evaluateDistance(String a, String b){
        double ret = 0;
        for(int t=0;t<a.length();t++){
            Character ca = a.charAt(t);
            Character cb = b.charAt(t);
            int vala = map.get(ca);
            int valb = map.get(cb);
            ret += 16 * t - (double) Math.abs(vala - valb) * t; //position is very important !
        }
        return ret;
    }



}
