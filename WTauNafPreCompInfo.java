
public class WTauNafPreCompInfo implements PreCompInfo
{

    protected ECPoint.AbstractF2m[] preComp = null;

    public ECPoint.AbstractF2m[] getPreComp()
    {
        return preComp;
    }

    public void setPreComp(ECPoint.AbstractF2m[] preComp)
    {
        this.preComp = preComp;
    }
}
