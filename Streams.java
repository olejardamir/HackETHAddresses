final class Streams {

    public static int readFully(java.io.InputStream a, byte[] a0) throws Exception {
        return Streams.readFully(a, a0, a0.length);
    }

    private static int readFully(java.io.InputStream a, byte[] a0, int i) throws Exception {
        int i0 = 0;
        while(true) {
            if (i0 < i) {
                int i1 = a.read(a0, i0, i - i0);
                if (i1 >= 0) {
                    i0 = i0 + i1;
                    continue;
                }
            }
            return i0;
        }
    }
}