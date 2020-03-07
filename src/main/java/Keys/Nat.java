package Keys;


  class Nat
{
    private static final long M = 4294967295L;

      static void add(int len, int[] x, int[] z)
    {
        long c = 0;
        for (int i = 0; i < len; ++i)
        {
            c += (x[i] & M) + (SecP256K1Field.P[i] & M);
            z[i] = (int)c;
            c >>>= 32;
        }
    }

      static void add33To(int x, int[] z)
    {
        long c = (x & M) + (z[0] & M);
        z[0] = (int)c;
        c >>>= 32;
        c += (z[1] & M) + 1L;
        z[1] = (int)c;
        c >>>= 32;
        if (c != 0)
            for (int i = 2; i < 8; ++i)
                if (++z[i] != 0)
                    return;
    }

      static int addTo(int len, int[] x, int[] z)
    {
        long c = 0;
        for (int i = 0; i < len; ++i)
        {
            c += (x[i] & M) + (z[i] & M);
            z[i] = (int)c;
            c >>>= 32;
        }
        return (int)c;
    }


      static boolean gte(int len, int[] x, int[] y)
    {
        for (int i = len - 1; i >= 0; --i)
        {
            int x_i = x[i] ^ Integer.MIN_VALUE, y_i = y[i] ^ Integer.MIN_VALUE;
            if (x_i < y_i)
                return false;
            if (x_i > y_i)
                return true;
        }
        return true;
    }


      static boolean isOne(int len, int[] x)
    {
        if (x[0] != 1)
			return false;
        for (int i = 1; i < len; ++i)
			if (x[i] != 0)
				return false;
        return true;
    }


      static void sub33From(int[] z)
    {
        long c = (z[0] & M) - (977 & M);
        z[0] = (int)c;
        c >>= 32;
        c += (z[1] & M) - 1;
        z[1] = (int)c;
        c >>= 32;
        if (c != 0)
            for (int i = 2; i < 8; ++i)
                if (--z[i] != -1) {
                    return;
                }
    }

      static int subFrom(int len, int[] x, int[] z)
    {
        long c = 0;
        for (int i = 0; i < len; ++i)
        {
            c += (z[i] & M) - (x[i] & M);
            z[i] = (int)c;
            c >>= 32;
        }
        return (int)c;
    }



}
