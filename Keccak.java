class Keccak
{
    private Keccak()
    {

    }

    static public class DigestKeccak
            extends BCMessageDigest
            implements Cloneable
    {
        DigestKeccak(int size)
        {
            super(new KeccakDigest(size));
        }

        public Object clone()
                throws CloneNotSupportedException
        {
            BCMessageDigest d = (BCMessageDigest)super.clone();
            d.digest = new KeccakDigest((KeccakDigest)digest);

            return d;
        }
    }

    static public class Digest256
            extends DigestKeccak
    {
        public Digest256()
        {
            super(256);
        }
    }


}
