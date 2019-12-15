public class ASN1ObjectIdentifier {
    private final String identifier;


    
    public ASN1ObjectIdentifier(
            String identifier)
    {


        this.identifier = identifier;
    }

    
    private ASN1ObjectIdentifier(ASN1ObjectIdentifier oid, String branchID)
    {

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





    public ASN1OctetString toASN1Primitive()
    {
        return null;
    }


    public boolean equals(
            Object  o)
    {
        if (this == o)
        {
            return true;
        }

        if (!(o instanceof ASN1ObjectIdentifier))
        {
            return false;
        }

        ASN1ObjectIdentifier other = (ASN1ObjectIdentifier)o;

        return this.toASN1Primitive().equals(other.toASN1Primitive());
    }


}
