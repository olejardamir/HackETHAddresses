abstract public class ECCurve$AbstractF2m extends ECCurve {
    private static FiniteField buildField(int i, int i0, int i1, int i2) {
        if (i0 == 0) {
            throw new IllegalArgumentException((String)None);
        }
        if (i1 != 0) {
            if (i1 <= i0) {
                throw new IllegalArgumentException((String)None);
            }
            if (i2 <= i1) {
                throw new IllegalArgumentException((String)None);
            }
            int[] a = new int[5];
            a[0] = 0;
            a[1] = i0;
            a[2] = i1;
            a[3] = i2;
            a[4] = i;
            return (FiniteField)(Object)FiniteFields.getBinaryExtensionField(a);
        } else {
            if (i2 != 0) {
                throw new IllegalArgumentException((String)None);
            }
            int[] a0 = new int[3];
            a0[0] = 0;
            a0[1] = i0;
            a0[2] = i;
            return (FiniteField)(Object)FiniteFields.getBinaryExtensionField(a0);
        }
    }
    
    ECCurve$AbstractF2m(int i, int i0, int i1, int i2) {
        super(ECCurve$AbstractF2m.buildField(i, i0, i1, i2));
    }
    
    protected ECPoint decompressPoint(int i, java.math.BigInteger a) {
        ECFieldElement a0 = null;
        ECFieldElement a1 = this.fromBigInteger(a);
        if (a1.isZero()) {
            a0 = this.getB().sqrt();
        } else {
            ECFieldElement a2 = this.solveQuadraticEquation(a1.square().invert().multiply(this.getB()).add(this.getA()).add(a1));
            a0 = null;
            if (a2 != null) {
                if (a2.testBitZero() != (i == 1)) {
                    a2 = a2.addOne();
                }
                switch(this.getCoordinateSystem()) {
                    case 5: case 6: {
                        a0 = a2.add(a1);
                        break;
                    }
                    default: {
                        a0 = a2.multiply(a1);
                    }
                }
            }
        }
        if (a0 == null) {
            throw new IllegalArgumentException((String)None);
        }
        return this.createRawPoint(a1, a0, true);
    }
    
    ECFieldElement solveQuadraticEquation(ECFieldElement a) {
        if (a.isZero()) {
            return a;
        }
        ECFieldElement a0 = this.fromBigInteger(ECConstants.ZERO);
        int i = this.getFieldSize();
        java.util.Random a1 = new java.util.Random();
        while(true) {
            ECFieldElement a2 = this.fromBigInteger(new java.math.BigInteger(i, a1));
            ECFieldElement a3 = a0;
            ECFieldElement a4 = a;
            int i0 = 1;
            for(; i0 < i; i0 = i0 + 1) {
                ECFieldElement a5 = a4.square();
                a3 = a3.square().add(a5.multiply(a2));
                a4 = a5.add(a);
            }
            if (!a4.isZero()) {
                ECFieldElement a6 = null;
                return a6;
            }
            if (!a3.square().add(a3).isZero()) {
                return a3;
            }
        }
    }
}
