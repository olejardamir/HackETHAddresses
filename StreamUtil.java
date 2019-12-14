class StreamUtil
{

    static int calculateBodyLength(int i) {
        int i0;
        if (i <= 127) {
            i0 = 1;
        } else {
            int i1 = 1;
            while(true) {
                int i2 = i >>> 8;
                if (i2 == 0) {
                    break;
                }
                i1 = i1 + 1;
                i = i2;
            }
            int i3 = (i1 - 1) * 8;
            i0 = 1;
            for(; i3 >= 0; i3 = i3 + -8) {
                i0 = i0 + 1;
            }
        }
        return i0;
    }

}
