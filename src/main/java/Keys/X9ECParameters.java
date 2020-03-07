package Keys;



class X9ECParameters {

    private final X9ECPoint g;


    X9ECParameters(
            X9ECPoint g)
    {
        this.g = g;

    }

    public ECPoint getG() {
        return g.getPoint();
    }







}
