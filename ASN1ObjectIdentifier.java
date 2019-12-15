
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;



public class ASN1ObjectIdentifier
        extends ASN1Object {
    private final String identifier;

    private byte[] body;

    
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






    private synchronized byte[] getBody()
    {
        if (body == null)
        {
            ByteArrayOutputStream bOut = new ByteArrayOutputStream();

 
            body = bOut.toByteArray();
        }

        return body;
    }




    public int hashCode()
    {
        return identifier.hashCode();
    }



    public String toString()
    {
        return getId();
    }


    public final boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }

        return false;
    }

    public ASN1Primitive toASN1Primitive()
    {
        return null;
    }


}
