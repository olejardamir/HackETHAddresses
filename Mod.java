abstract class Mod {


    public static void invert(int[] p, int[] x, int[] z) {
        int len = p.length;


		int[] z2 = new int[len];
		System.arraycopy(x, 0, z2, 0, len);
		int[] a = Nat.create(len);
        a[0] = 1;
        int ac = (z2[0] & 1) != 0 ? 0 : inversionStep(p, z2, len, a, 0);

		int[] z1 = new int[len];
		System.arraycopy(p, 0, z1, 0, len);
		int[] b = Nat.create(len);
        for (int bc = 0, uvLen = len;;) {
			while (z2[uvLen - 1] == 0 && z1[uvLen - 1] == 0)
				--uvLen;
			if (Nat.gte(uvLen, z2, z1)) {
				Nat.subFrom(uvLen, z1, z2);
				ac += Nat.subFrom(len, b, a) - bc;
				ac = inversionStep(p, z2, uvLen, a, ac);
				boolean result = true;
				if (z2[0] != 1)
					result = false;
				else {
					for (int i = 1; i < uvLen; ++i)
						if (z2[i] != 0) {
							result = false;
							break;
						}
				}
				if (result) {
					inversionResult(p, ac, a, z);
					return;
				}
			} else {
				Nat.subFrom(uvLen, z2, z1);
				bc += Nat.subFrom(len, a, b) - ac;
				bc = inversionStep(p, z1, uvLen, b, bc);
				boolean result = true;
				if (z1[0] != 1)
					result = false;
				else {
					for (int i = 1; i < uvLen; ++i)
						if (z1[i] != 0) {
							result = false;
							break;
						}
				}
				if (result) {
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
