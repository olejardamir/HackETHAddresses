
interface X9ObjectIdentifiers
{
    /** Base OID: 1.2.840.10045 */
    ASN1ObjectIdentifier ansi_X9_62 = new ASN1ObjectIdentifier("1.2.840.10045");

    /** OID: 1.2.840.10045.1 */
    ASN1ObjectIdentifier id_fieldType = ansi_X9_62.branch("1");

    /** OID: 1.2.840.10045.1.1 */
    ASN1ObjectIdentifier prime_field = id_fieldType.branch("1");

    /** OID: 1.2.840.10045.1.2 */
    ASN1ObjectIdentifier characteristic_two_field = id_fieldType.branch("2");

    /** OID: 1.2.840.10045.1.2.3.2 */
    ASN1ObjectIdentifier tpBasis = characteristic_two_field.branch("3.2");

    /** OID: 1.2.840.10045.1.2.3.3 */
    ASN1ObjectIdentifier ppBasis = characteristic_two_field.branch("3.3");

    ASN1ObjectIdentifier ellipticCurve = ansi_X9_62.branch("3");


}
