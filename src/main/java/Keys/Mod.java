package Keys;

class Mod {
    static void invert(int[] x, int[] z) {
        int len = 8;

        int[] z2 = new int[len];
        System.arraycopy(x, 0, z2, 0, len);
        int[] a = new int[len];
        a[0] = 1;
        int x11 = z2[0], count11 = 0;
        for (; (x11 & 1) == 0; ++count11) {
			x11 >>>= 1;
		}
        int ac = (z2[0] & 1) != 0 ? 0 : getXc(a, 0, getCount3(z2, len, count11));

        int[] z1 = new int[len];
        System.arraycopy(SecP256K1Field.P, 0, z1, 0, len);
        extracted8(z, len, z2, a, ac, z1, new int[len]);
    }

	private static void extracted8(int[] z, int len, int[] z2, int[] a, int ac, int[] z1, int[] b) {
		for (int bc = 0, uvLen = len; ; ) {
            int uvLen1 = uvLen;
            while (z2[uvLen1 - 1] == 0 && z1[uvLen1 - 1] == 0) {
				--uvLen1;
			}
            uvLen = uvLen1;
            if (Nat.gte(uvLen, z2, z1)) {
				ac = extracted4(z, len, z2, a, ac, z1, b, bc, uvLen);
			} 
            else {
				bc = extracted7(len, z2, a, ac, z1, b, bc, uvLen);
				if (q2(z, z1, b, bc, uvLen)) {
					return;
				}
			}
        }
	}

	private static int extracted7(int len, int[] z2, int[] a, int ac, int[] z1, int[] b, int bc, int uvLen) {
		int bc1 = bc;
		Nat.subFrom(uvLen, z2, z1);
		bc1 += Nat.subFrom(len, a, b) - ac;
		return getXc(b, bc1, getCount3(z1, uvLen, extracted6(z1)));
	}

	private static int extracted6(int[] z1) {
		int x1 = z1[0], count1 = 0;
		for (; (x1 & 1) == 0; ++count1) {
			x1 >>>= 1;
		}
		return count1;
	}

	private static int extracted4(int[] z, int len, int[] z2, int[] a, int ac, int[] z1, int[] b, int bc, int uvLen) {
		int ac1 = ac, bc1 = ac1;
		Nat.subFrom(uvLen, z1, z2);
		bc1 += Nat.subFrom(len, b, a) - bc;
		ac1 = getXc(a, bc1, getCount3(z2, uvLen, extracted(z2, 0)));
		extract1(z, z2, a, uvLen, ac1);
		return ac1;
	}

	private static int extracted(int[] z2, int count1) {
		for (int x1 = z2[0]; (x1 & 1) == 0; ++count1) {
			x1 >>>= 1;
		}
		return count1;
	}

    private static void extract1(int[] z, int[] z2, int[] a, int uvLen, int ac1) {
        if (Nat.isOne(uvLen, z2)) {
            if (ac1 < 0) {
                Nat.add(a, z);
            } else {
                System.arraycopy(a, 0, z, 0, 8);
            }
        }
    }

    private static boolean q2(int[] z, int[] z1, int[] b, int bc, int uvLen) {
        if (!Nat.isOne(uvLen, z1)) {
			return false;
		}
        if (bc < 0) {
			Nat.add(b, z);
		} else {
			System.arraycopy(b, 0, z, 0, 8);
		}
        return true;
    }

    private static int getCount3(int[] u, int uLen, int zeroes) {
        if (zeroes <= 0) {
			return 0;
		}
        for (int i2 = -zeroes, c = 0, i1 = uLen; --i1 >= 0; ) {
            int next = u[i1];
            u[i1] = (c << i2) | (next >>> zeroes);
            c = next;
        }
        return zeroes;
    }

    private static int getXc(int[] x, int xc, int count) {

        for (int i = 0; i < count; ++i) {
            int xc1 = xc;
            if ((x[0] & 1) != 0) {
				xc1 += xc1 < 0 ? Nat.addTo(8, SecP256K1Field.P, x) : Nat.subFrom(8, SecP256K1Field.P, x);
			}
            xc = xc1;
            extracted11(x, xc);
        }
 
        return xc;
    }

	private static void extracted11(int[] x, int xc) {
		for (int c = xc, i1 = 8; --i1 >= 0; ) {
		    int next = x[i1];
		    x[i1] = (c << 31) | (next >>> 1);
		    c = next;
		}
	}
}
