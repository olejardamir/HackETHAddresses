abstract interface SECObjectIdentifiers {
    final public static ASN1ObjectIdentifier ellipticCurve;
    final public static ASN1ObjectIdentifier secp256k1;
    
    static {
        ellipticCurve = new ASN1ObjectIdentifier((String)None);
        secp256k1 = ellipticCurve.branch((String)None);
    }
}
