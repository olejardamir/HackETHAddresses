import java.security.MessageDigest;

class BCMessageDigest
        extends MessageDigest
{
    ExtendedDigest digest;

    BCMessageDigest(
            ExtendedDigest digest)
    {
        super(digest.getAlgorithmName());

        this.digest = digest;
    }

    public void engineReset()
    {
        digest.reset();
    }

    public void engineUpdate(
            byte    input)
    {
        digest.update(input);
    }

    public void engineUpdate(
            byte[]  input,
            int     offset,
            int     len)
    {
        digest.update(input, offset, len);
    }

    public byte[] engineDigest()
    {
        byte[]  digestBytes = new byte[digest.getDigestSize()];

        digest.doFinal(digestBytes, 0);

        return digestBytes;
    }
}
