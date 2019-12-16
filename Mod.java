abstract class Mod {


    public static void invert(int[] p, int[] x, int[] z) {
        int len = p.length;


        int[] u = Nat.copy(len, x), a = Nat.create(len);
        a[0] = 1;
        int ac = (u[0] & 1) != 0 ? 0 : inversionStep(p, u, len, a, 0);

        int[] v = Nat.copy(len, p), b = Nat.create(len);
        for (int bc = 0, uvLen = len;;) {
			while (u[uvLen - 1] == 0 && v[uvLen - 1] == 0)
				--uvLen;
			if (Nat.gte(uvLen, u, v)) {
				Nat.subFrom(uvLen, v, u);
				ac += Nat.subFrom(len, b, a) - bc;
				ac = inversionStep(p, u, uvLen, a, ac);
				if (Nat.isOne(uvLen, u)) {
					inversionResult(p, ac, a, z);
					return;
				}
			} else {
				Nat.subFrom(uvLen, u, v);
				bc += Nat.subFrom(len, a, b) - ac;
				bc = inversionStep(p, v, uvLen, b, bc);
				if (Nat.isOne(uvLen, v)) {
					inversionResult(p, bc, b, z);
					return;
				}
			}
		}
    }


    private static void inversionResult(int[] p, int ac, int[] a, int[] z) {
        if (ac < 0)
			Nat.add(p.length, a, p, z);
		else
			System.arraycopy(a, 0, z, 0, p.length);
    }

    private static int inversionStep(int[] p, int[] u, int uLen, int[] x, int xc) {
		int len = p.length, count = 0, zeroes = getTrailingZeroes(u[0]);
		if (zeroes > 0) {
			Nat.shiftDownBits(uLen, u, zeroes, 0);
			count += zeroes;
		}
		for (int i = 0; i < count; ++i) {
			if ((x[0] & 1) != 0)
				xc += xc < 0 ? Nat.addTo(len, p, x) : Nat.subFrom(len, p, x);
			Nat.shiftDownBit(len, x, xc);
		}
		return xc;
	}

    private static int getTrailingZeroes(int x) {


        int count = 0;
        for (; (x & 1) == 0; ++count)
			x >>>= 1;
        return count;
    }
}
