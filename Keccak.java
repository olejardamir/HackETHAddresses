class Keccak
{
    private Keccak()
    {

    }

    static public class Digest256
            extends BCMessageDigest implements Cloneable {
        public Digest256()
        {
            super(new KeccakDigest(256));
        }

        public Object clone()
                throws CloneNotSupportedException
        {
            BCMessageDigest d = (BCMessageDigest)super.clone();
            d.digest = new KeccakDigest((KeccakDigest)digest);

            return d;
        }
    }


}
