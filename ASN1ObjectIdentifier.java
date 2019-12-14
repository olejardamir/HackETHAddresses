
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;


/**
 * Class representing the ASN.1 OBJECT IDENTIFIER type.
 */
public class ASN1ObjectIdentifier
        extends ASN1Primitive
{
    private final String identifier;

    private byte[] body;

    /**
     * Create an OID based on the passed in String.
     *
     * @param identifier a string representation of an OID.
     */
    public ASN1ObjectIdentifier(
            String identifier)
    {
        if (identifier == null)
        {
            throw new IllegalArgumentException("'identifier' cannot be null");
        }
        if (!isValidIdentifier(identifier))
        {
            throw new IllegalArgumentException("string " + identifier + " not an OID");
        }

        this.identifier = identifier;
    }

    /**
     * Create an OID that creates a branch under the current one.
     *
     * @param branchID node numbers for the new branch.
     * @return the OID for the new created branch.
     */
    private ASN1ObjectIdentifier(ASN1ObjectIdentifier oid, String branchID)
    {
        if (!isValidBranchID(branchID, 0))
        {
            throw new IllegalArgumentException("string " + branchID + " not a valid OID branch");
        }

        this.identifier = oid.getId() + "." + branchID;
    }

    /**
     * Return the OID as a string.
     *
     * @return the string representation of the OID carried by this object.
     */
    private String getId()
    {
        return identifier;
    }

    /**
     * Return an OID that creates a branch under the current one.
     *
     * @param branchID node numbers for the new branch.
     * @return the OID for the new created branch.
     */
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

    private static boolean isValidBranchID(
            String branchID, int start)
    {
        boolean periodAllowed = false;

        int pos = branchID.length();
        while (--pos >= start)
        {
            char ch = branchID.charAt(pos);

            // TODO Leading zeroes?
            if ('0' <= ch && ch <= '9')
            {
                periodAllowed = true;
                continue;
            }

            if (ch == '.')
            {
                if (!periodAllowed)
                {
                    return false;
                }

                periodAllowed = false;
                continue;
            }

            return false;
        }

        return periodAllowed;
    }

    private static boolean isValidIdentifier(
            String identifier)
    {
        if (identifier.length() < 3 || identifier.charAt(1) != '.')
        {
            return false;
        }

        char first = identifier.charAt(0);
        if (first < '0' || first > '2')
        {
            return false;
        }

        return isValidBranchID(identifier, 2);
    }

}
