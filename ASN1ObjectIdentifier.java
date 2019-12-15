public class ASN1ObjectIdentifier
        extends ASN1Object {
    private final String identifier;


    
    public ASN1ObjectIdentifier(
            String identifier)
    {
        super();


        this.identifier = identifier;
    }

    
    private ASN1ObjectIdentifier(ASN1ObjectIdentifier oid, String branchID)
    {
        super();

        this.identifier = oid.getId() + "." + branchID;
    }

    
    private String getId()
    {
        return identifier;
    }

    
    public ASN1ObjectIdentifier branch(String branchID)
    {
        return new ASN1ObjectIdentifier(this, branchID);
    }




    public int hashCode()
    {
        return identifier.hashCode();
    }





    public ASN1Primitive toASN1Primitive()
    {
        return null;
    }


}
