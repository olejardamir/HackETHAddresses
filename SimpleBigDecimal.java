
import java.math.BigInteger;

class SimpleBigDecimal
 {

    private final BigInteger bigInt;
    private final int scale;


    public static SimpleBigDecimal getInstance(BigInteger value, int scale)
    {
        return new SimpleBigDecimal(value.shiftLeft(scale), scale);
    }


    public SimpleBigDecimal(BigInteger bigInt, int scale)
    {
        if (scale < 0)
        {
            throw new IllegalArgumentException("scale may not be negative");
        }

        this.bigInt = bigInt;
        this.scale = scale;
    }

    private void checkScale(SimpleBigDecimal b)
    {
        if (scale != b.scale)
        {
            throw new IllegalArgumentException("Only SimpleBigDecimal of " +
                    "same scale allowed in arithmetic operations");
        }
    }

    private SimpleBigDecimal adjustScale(int newScale)
    {
        if (newScale < 0)
        {
            throw new IllegalArgumentException("scale may not be negative");
        }

        if (newScale == scale)
        {
            return this;
        }

        return new SimpleBigDecimal(bigInt.shiftLeft(newScale - scale),
                newScale);
    }

    public SimpleBigDecimal add(SimpleBigDecimal b)
    {
        checkScale(b);
        return new SimpleBigDecimal(bigInt.add(b.bigInt), scale);
    }

    public SimpleBigDecimal add(BigInteger b)
    {
        return new SimpleBigDecimal(bigInt.add(b.shiftLeft(scale)), scale);
    }

    private SimpleBigDecimal negate()
    {
        return new SimpleBigDecimal(bigInt.negate(), scale);
    }

    public SimpleBigDecimal subtract(SimpleBigDecimal b)
    {
        return add(b.negate());
    }

    public SimpleBigDecimal subtract(BigInteger b)
    {
        return new SimpleBigDecimal(bigInt.subtract(b.shiftLeft(scale)),
                scale);
    }

    public SimpleBigDecimal multiply(SimpleBigDecimal b)
    {
        checkScale(b);
        return new SimpleBigDecimal(bigInt.multiply(b.bigInt), scale + scale);
    }

    public SimpleBigDecimal multiply(BigInteger b)
    {
        return new SimpleBigDecimal(bigInt.multiply(b), scale);
    }

    public int compareTo(BigInteger val)
    {
        return bigInt.compareTo(val.shiftLeft(scale));
    }

    private BigInteger floor()
    {
        return bigInt.shiftRight(scale);
    }

    public BigInteger round()
    {
        SimpleBigDecimal oneHalf = new SimpleBigDecimal(ECConstants.ONE, 1);
        return add(oneHalf.adjustScale(scale)).floor();
    }

    public int getScale()
    {
        return scale;
    }

    public String toString()
    {
        if (scale == 0)
        {
            return bigInt.toString();
        }

        BigInteger floorBigInt = floor();

        BigInteger fract = bigInt.subtract(floorBigInt.shiftLeft(scale));
        if (bigInt.signum() == -1)
        {
            fract = ECConstants.ONE.shiftLeft(scale).subtract(fract);
        }

        if ((floorBigInt.signum() == -1) && (!(fract.equals(ECConstants.ZERO))))
        {
            floorBigInt = floorBigInt.add(ECConstants.ONE);
        }
        String leftOfPoint = floorBigInt.toString();

        char[] fractCharArr = new char[scale];
        String fractStr = fract.toString(2);
        int fractLen = fractStr.length();
        int zeroes = scale - fractLen;
        for (int i = 0; i < zeroes; i++)
        {
            fractCharArr[i] = '0';
        }
        for (int j = 0; j < fractLen; j++)
        {
            fractCharArr[zeroes + j] = fractStr.charAt(j);
        }
        String rightOfPoint = new String(fractCharArr);

        return leftOfPoint + "." +
                rightOfPoint;
    }

    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (!(o instanceof SimpleBigDecimal))
        {
            return false;
        }

        SimpleBigDecimal other = (SimpleBigDecimal)o;
        return ((bigInt.equals(other.bigInt)) && (scale == other.scale));
    }

    public int hashCode()
    {
        return bigInt.hashCode() ^ scale;
    }

}
