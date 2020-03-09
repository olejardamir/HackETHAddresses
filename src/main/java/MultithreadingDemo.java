import Generator.PKGenerator;
import Keys.PublicFromPrivate;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Java code for thread creation by extending
// the Thread class 
class MultithreadingDemo extends Thread
{
    public void run()
    {
        while(true) {
            try {

                List<String> addresses = loadAddresses();

                String decodeString = "0479BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798"
                        + "483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8";

                PKGenerator pkGenerator = new PKGenerator();
                PublicFromPrivate publicFromPrivate = new PublicFromPrivate(decodeString);
                while(true) {
                    String rnduuid = java.util.UUID.randomUUID().toString();
                    File tmp = new File("temporary/" + rnduuid + ".csv");
                    BufferedWriter write = new BufferedWriter(new FileWriter(tmp));
                    for (int f = 100000, t = 0; t < f; ++t) {
                        String privateKey = pkGenerator.generateRandomPK();
                        String publick = publicFromPrivate.getPublicFromPrivate(privateKey);
                        write.write(publick + "," + privateKey + "\n");
                    }
                    write.close();
                    checkAddresses(addresses, tmp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




    private static void checkAddresses(List<String> addresses, File file) throws IOException {
            BufferedReader read = new BufferedReader(new FileReader(file));
            String l = "";
            while((l=read.readLine())!=null){
				String sp[] = l.split(",");
				if (arrContainsAddr(addresses, sp[0])) {
					System.out.println(sp[0] + "," + sp[1]);
					FileUtils.write(new File("YOUWON.txt"), sp[0] + "," + sp[1]+"\n",true);
				}
			}
            read.close();
            FileUtils.forceDelete(file);
    }



    private static boolean arrContainsAddr(List<String> addresses, String address) {
    	for(String s:addresses) {
    		if(confirmAddress(s, address)) {return true;}
    	}
    	return false;
    }


    private static boolean confirmAddress(String addrA,String addrB) {
    	int l = addrA.length();
    	for(int t=0;t<l;++t) {
    		if(addrA.charAt(t)!=addrB.charAt(t)) return false;
    	}
    	return true;
    }



    private static List<String> loadAddresses() throws IOException {
        //load the addresses and check separately in this thread!
        BufferedReader reader = new BufferedReader(new FileReader("data/addresses.txt"));
        List<String> addresses = new ArrayList<>();
        String l = "";
        while((l=reader.readLine())!=null){
            addresses.add(l);
        }

        reader.close();
        return addresses;
    }




} 