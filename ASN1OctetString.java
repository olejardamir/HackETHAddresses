// 
// Decompiled by Procyon v0.5.36
// 

public class ASN1OctetString
{
    byte[] string;
    
    ASN1OctetString(final byte[] string) {
        this.string = string;
    }
    
    public byte[] getOctets() {
        return this.string;
    }
}
