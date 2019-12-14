abstract public class ECFieldElement$AbstractF2m extends ECFieldElement {
    public ECFieldElement$AbstractF2m() {
    }
    
    public int trace() {
        int i = this.getFieldSize();
        ECFieldElement a = this;
        ECFieldElement a0 = this;
        int i0 = 1;
        for(; i0 < i; i0 = i0 + 1) {
            a = a.square();
            a0 = a0.add(a);
        }
        if (a0.isZero()) {
            return 0;
        }
        if (!a0.isOne()) {
            throw new IllegalStateException((String)None);
        }
        return 1;
    }
}
