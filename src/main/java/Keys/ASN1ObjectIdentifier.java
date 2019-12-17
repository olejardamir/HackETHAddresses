package Keys;
public class ASN1ObjectIdentifier {
    private final String identifier;

    public ASN1ObjectIdentifier(
            String identifier) {
        this.identifier = identifier;
    }


    public ASN1ObjectIdentifier(ASN1ObjectIdentifier oid, String branchID) {

        this.identifier = oid.identifier + "." + branchID;
    }




}
