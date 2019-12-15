
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;



public class ASN1ObjectIdentifier
        extends ASN1Primitive
{
    private final String identifier;

    private byte[] body;

    
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

    private void writeField(
            ByteArrayOutputStream out,
            long fieldValue)
    {
        byte[] result = new byte[9];
        int pos = 8;
        result[pos] = (byte)((int)fieldValue & 0x7f);
        while (fieldValue >= (1L << 7))
        {
            fieldValue >>= 7;
            result[--pos] = (byte)((int)fieldValue & 0x7f | 0x80);
        }
        out.write(result, pos, 9 - pos);
    }

    private void writeField(
            ByteArrayOutputStream out,
            BigInteger fieldValue)
    {
        int byteCount = (fieldValue.bitLength() + 6) / 7;
        if (byteCount == 0)
        {
            out.write(0);
        }
        else
        {
            BigInteger tmpValue = fieldValue;
            byte[] tmp = new byte[byteCount];
            for (int i = byteCount - 1; i >= 0; i--)
            {
                tmp[i] = (byte)((tmpValue.intValue() & 0x7f) | 0x80);
                tmpValue = tmpValue.shiftRight(7);
            }
            tmp[byteCount - 1] &= 0x7f;
            out.write(tmp, 0, tmp.length);
        }
    }

    private void doOutput(ByteArrayOutputStream aOut)
    {
        OIDTokenizer tok = new OIDTokenizer(identifier);
        int first = Integer.parseInt(tok.nextToken()) * 40;

        String secondToken = tok.nextToken();
        if (secondToken.length() <= 18)
        {
            writeField(aOut, first + Long.parseLong(secondToken));
        }
        else
        {
            writeField(aOut, new BigInteger(secondToken).add(BigInteger.valueOf(first)));
        }

        while (tok.hasMoreTokens())
        {
            String token = tok.nextToken();
            if (token.length() <= 18)
            {
                writeField(aOut, Long.parseLong(token));
            }
            else
            {
                writeField(aOut, new BigInteger(token));
            }
        }
    }

    private synchronized byte[] getBody()
    {
        if (body == null)
        {
            ByteArrayOutputStream bOut = new ByteArrayOutputStream();

            doOutput(bOut);

            body = bOut.toByteArray();
        }

        return body;
    }

    int encodedLength() {
        int length = getBody().length;

        return 1 + StreamUtil.calculateBodyLength(length) + length;
    }

    void encode(
            ASN1OutputStream out)
            throws Exception
    {
        byte[] enc = getBody();

        out.write(ASN1InputStream.OBJECT_IDENTIFIER);
        out.writeLength(enc.length);
        out.write(enc);
    }

    public int hashCode()
    {
        return identifier.hashCode();
    }

    boolean asn1Equals(
            ASN1Primitive o)
    {
        if (o == this)
        {
            return true;
        }

        if (!(o instanceof ASN1ObjectIdentifier))
        {
            return false;
        }

        return identifier.equals(((ASN1ObjectIdentifier)o).identifier);
    }

    public String toString()
    {
        return getId();
    }






}
