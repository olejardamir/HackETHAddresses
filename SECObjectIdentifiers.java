/**
 * Certicom object identifiers
 * <pre>
 *  ellipticCurve OBJECT IDENTIFIER ::= {
 *        iso(1) identified-organization(3) certicom(132) curve(0)
 *  }
 *  secg-scheme OBJECT IDENTIFIER ::= {
 *     iso(1) identified-organization(3) certicom(132) schemes(1) }
 * </pre>
 */
interface SECObjectIdentifiers
{
    /** Base OID: 1.3.132.0 */
    ASN1ObjectIdentifier ellipticCurve = new ASN1ObjectIdentifier("1.3.132.0");

    /**  secp256k1 OID: 1.3.132.0.10 */
    ASN1ObjectIdentifier secp256k1 = ellipticCurve.branch("10");

}
