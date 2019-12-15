import java.math.BigInteger;

// 
// Decompiled by Procyon v0.5.36
// 

public class FiniteFields
{
    static final PrimeField GF_2;
    private static final PrimeField GF_3;
    
    public static PrimeField getPrimeField(final BigInteger a) {
        final int i = a.bitLength();
        if (a.signum() > 0 && i >= 2) {
            if (i < 3) {
                switch (a.intValue()) {
                    case 3: {
                        return FiniteFields.GF_3;
                    }
                    case 2: {
                        return FiniteFields.GF_2;
                    }
                }
            }
            return new PrimeField(a);
        }
        return null;
    }
    
    static {
        GF_2 = new PrimeField(BigInteger.valueOf(2L));
        GF_3 = new PrimeField(BigInteger.valueOf(3L));
    }
}
