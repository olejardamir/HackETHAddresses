package Keys;
import java.io.BufferedReader;
import java.io.FileReader;

public class testAll {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("data/out3_big.csv"));
        String line;
        int t=0;
		String decodeString = "04"+"79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798"+"483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8";

		while((line=reader.readLine())!=null)
			try {
				String[] sp = line.split(",");
				PublicFromPrivate publicFromPrivate = new PublicFromPrivate();
				String stringBuilder7 = publicFromPrivate.getPublicNonFormat(sp[1],decodeString);
				if (sp[0].equals(stringBuilder7)) {
					System.out.println(line + "\t" + stringBuilder7+"\t"+sp[0]);
					t++;
				}
			} catch (Exception ignored) {
			}
        reader.close();
        System.out.println(t);


    }



}
