import java.io.BufferedReader;
import java.io.FileReader;

public class testAll {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("data/big.csv"));
        String line;
        int t=0;
        while((line=reader.readLine())!=null)
			try {
				String[] sp = line.split(",");
				PublicFromPrivate publicFromPrivate = new PublicFromPrivate();
				String stringBuilder7 = publicFromPrivate.getPublicFromPrivate(sp[1]);
				System.out.println(stringBuilder7+"\t"+sp[0]);
				if (stringBuilder7.equals(sp[0])) {
					System.out.println(line + "\t" + stringBuilder7);
					t++;
				}
			} catch (Exception ignored) {
			}
        reader.close();
        System.out.println(t);


    }



}
