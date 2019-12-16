import java.io.BufferedReader;
import java.io.FileReader;

public class testAll {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("/home/cocka/Desktop/workspace/hackETH/data/out3_big.csv"));
        String line;
        while((line=reader.readLine())!=null){
            try {
                String[] sp = line.split(",");

                PublicFromPrivate publicFromPrivate = new PublicFromPrivate();
                String stringBuilder7 = publicFromPrivate.getPublicFromPrivate(sp[1]);

                if (!("0x"+sp[0].substring(24)).equals(stringBuilder7)) {
                    System.out.println(line + "\t" + stringBuilder7);
                    //System.out.println("ERROR");
                }
            }catch (Exception ignored){}


        }
        reader.close();



    }



}
