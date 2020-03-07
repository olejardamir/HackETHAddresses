package Keys;
  class Mod {




	  static void invert(int[] x, int[] z) {
        int len = 8;


		int[] z2 = new int[len];
		System.arraycopy(x, 0, z2, 0, len);
		int[] a = new int[len];
        a[0] = 1;
        int ac = (z2[0] & 1) != 0 ? 0 : inversionStep(z2, len, a, 0);

		int[] z1 = new int[len];
		System.arraycopy(SecP256K1Field.P, 0, z1, 0, len);
		int[] b = new int[len];
        for (int bc = 0, uvLen = len;;) {
			while (z2[uvLen - 1] == 0 && z1[uvLen - 1] == 0)
				--uvLen;
			if (Nat.gte(uvLen, z2, z1)) {
				Nat.subFrom(uvLen, z1, z2);
				ac += Nat.subFrom(len, b, a) - bc;
				ac = inversionStep(z2, uvLen, a, ac);
				if (Nat.isOne(uvLen, z2)) {
					if (ac < 0)
						Nat.add(8, a, z);
					else
						System.arraycopy(a, 0, z, 0, 8);
					return;
				}
			} else {
				Nat.subFrom(uvLen, z2, z1);
				bc += Nat.subFrom(len, a, b) - ac;
				bc = inversionStep(z1, uvLen, b, bc);
				if (Nat.isOne(uvLen, z1)) {
					if (bc < 0)
						Nat.add(8, b, z);
					else
						System.arraycopy(b, 0, z, 0, 8);
					return;
				}
			}
		}
    }


	private static int inversionStep(int[] u, int uLen, int[] x, int xc) {
		int x1 = u[0];


		int count1 = 0;
		for (; (x1 & 1) == 0; ++count1)
			x1 >>>= 1;
		int len = 8, count = 0, zeroes = count1;
		if (zeroes > 0) {
			int c = 0;

			for (int i = uLen; --i >= 0;) {
				int next = u[i];
				u[i] = c << -zeroes | next >>> zeroes;
				c = next;
			}
			count += zeroes;
		}
		for (int i = 0; i < count; ++i) {
			if ((x[0] & 1) != 0)
				xc += xc < 0 ? Nat.addTo(len, SecP256K1Field.P, x) : Nat.subFrom(len, SecP256K1Field.P, x);
			int c = xc;
			for (int i1 = len; --i1 >= 0;) {
				int next = x[i1];
				x[i1] = c << 31 | next >>> 1;
				c = next;
			}
		}
		return xc;
	}

}
