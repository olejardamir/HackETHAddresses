/**
 * Class for describing an ECPoint as a DER object.
 */
public class X9ECPoint
        extends ASN1Object
{
    private final ASN1OctetString encoding;

    private ECCurve c;
    private ECPoint p;



    public X9ECPoint(
            ECCurve          c,
            byte[]           encoding)
    {
        this.c = c;
        this.encoding = new DEROctetString(Arrays.clone(encoding));
    }



    public synchronized ECPoint getPoint() throws CloneNotSupportedException {
        if (p == null)
        {
            p = c.decodePoint(encoding.getOctets()).normalize();
        }

        return p;
    }


    public ASN1Primitive toASN1Primitive()
    {
        return encoding;
    }
}
