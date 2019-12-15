// 
// Decompiled by Procyon v0.5.36
// 

public class ASN1ObjectIdentifier
{
    private final String identifier;
    
    public ASN1ObjectIdentifier(final String identifier) {
        this.identifier = identifier;
    }
    
    private ASN1ObjectIdentifier(final ASN1ObjectIdentifier oid, final String branchID) {
        this.identifier = oid.getId() + "." + branchID;
    }
    
    private String getId() {
        return this.identifier;
    }
    
    public ASN1ObjectIdentifier branch(final String branchID) {
        return new ASN1ObjectIdentifier(this, branchID);
    }
    
    @Override
    public int hashCode() {
        return this.identifier.hashCode();
    }
}
