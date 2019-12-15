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


            return (BCMessageDigest)super.clone();
        }
    }


}
