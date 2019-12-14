interface SECObjectIdentifiers
{
    ASN1ObjectIdentifier ellipticCurve = new ASN1ObjectIdentifier("1.3.132.0");
    ASN1ObjectIdentifier secp256k1 = ellipticCurve.branch("10");

}
