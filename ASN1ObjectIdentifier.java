public class ASN1ObjectIdentifier {
    private final String identifier;

    public ASN1ObjectIdentifier(
            String identifier) {


        this.identifier = identifier;
    }


    private ASN1ObjectIdentifier(ASN1ObjectIdentifier oid, String branchID) {

        this.identifier = oid.getId() + "." + branchID;
    }


    private String getId() {
        return identifier;
    }


    public ASN1ObjectIdentifier branch(String branchID) {
        return new ASN1ObjectIdentifier(this, branchID);
    }


    public int hashCode() {
        return identifier.hashCode();
    }


}
