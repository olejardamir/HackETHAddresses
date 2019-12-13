
public class ScaleXPointMap implements ECPointMap
{
    private final ECFieldElement scale;

    public ScaleXPointMap(ECFieldElement scale)
    {
        this.scale = scale;
    }

    public ECPoint map(ECPoint p) throws CloneNotSupportedException {
        return p.scaleX(scale);
    }
}
