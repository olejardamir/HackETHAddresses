class Keccak
{
    private Keccak()
    {

    }

    static public class DigestKeccak
            extends BCMessageDigest
            implements Cloneable
    {
        DigestKeccak()
        {
            super(new KeccakDigest(256));
        }

        public Object clone()
                throws CloneNotSupportedException
        {
            BCMessageDigest d = (BCMessageDigest)super.clone();
            d.digest = new KeccakDigest(digest);

            return d;
        }
    }

    static public class Digest256
            extends DigestKeccak
    {
        public Digest256()
        {
            super();
        }
    }


}
