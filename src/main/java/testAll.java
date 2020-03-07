import Keys.PublicFromPrivate;

import java.io.BufferedReader;
import java.io.FileReader;

public class testAll {

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new FileReader("data/test.txt"));
		String line;
		int t=0;
		String decodeString = "04"+"79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798"+"483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8";
		PublicFromPrivate publicFromPrivate = new PublicFromPrivate(decodeString);
		while((line=reader.readLine())!=null)
			try {
				String[] sp = line.split(",");
				String stringBuilder7 = publicFromPrivate.getPublicNonFormat(sp[0]);
				System.out.println(stringBuilder7);

				if (!sp[1].equals(stringBuilder7)) {
					t++;
					System.out.println("ERROR!");
				}

			} catch (Exception ignored) {
			}
		reader.close();
		System.out.println(t);


	}



}
