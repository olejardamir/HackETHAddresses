
public class ScaleXPointMap implements ECPointMap
{
    private final ECFieldElement scale;

    public ScaleXPointMap(ECFieldElement scale)
    {
        this.scale = scale;
    }

}
