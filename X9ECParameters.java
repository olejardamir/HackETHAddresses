


public class X9ECParameters {

     private final ECCurve             curve;
    private final X9ECPoint g;




    public X9ECParameters(
            ECCurve curve,
            X9ECPoint g )
    {
        this.curve = curve;
        this.g = g;






    }

    public ECCurve getCurve()
    {
        return curve;
    }

    public ECPoint getG() {
        return g.getPoint();
    }







}
