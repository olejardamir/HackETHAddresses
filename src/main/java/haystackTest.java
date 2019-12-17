import Distance.NeedleHaystack;

public class haystackTest {
public static void main(String[] args) throws Exception {

    NeedleHaystack needleHaystack = new NeedleHaystack();
    String desiredPub = "0xf4a2eff88a408ff4c4550148151c33c93442619e";
    double distance = 0;

    while(true) {
        String[] data = needleHaystack.findNextBest(desiredPub, distance);
        String pk = data[0];
        String pub = data[1];
        distance = Double.parseDouble(data[2]);
        System.out.println(pub + "\t" + pk + "\t" + distance);
    }

}

}



