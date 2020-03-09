package Keys;

class KeccakDigest {
    private static final long[] KeccakRoundConstants = new long[]{0x0000000000000001L, 0x0000000000008082L,
            0x800000000000808aL, 0x8000000080008000L, 0x000000000000808bL, 0x0000000080000001L, 0x8000000080008081L,
            0x8000000000008009L, 0x000000000000008aL, 0x0000000000000088L, 0x0000000080008009L, 0x000000008000000aL,
            0x000000008000808bL, 0x800000000000008bL, 0x8000000000008089L, 0x8000000000008003L, 0x8000000000008002L,
            0x8000000000000080L, 0x000000000000800aL, 0x800000008000000aL, 0x8000000080008081L, 0x8000000000008080L,
            0x0000000080000001L, 0x8000000080008008L};

    private final long[] state = new long[25];
    private final byte[] dataQueue = new byte[192];
    private int rate;
    private int bitsInQueue;
    private int fixedOutputLength;
    private boolean squeezing;

    KeccakDigest() {
        extrcv(256, 512);
    }



    void update(byte[] in, int len) {
        int bytesInQueue = bitsInQueue >> 3, rateBytes = rate >> 3;
        for (int count = 0; count < len; ) {
            if (bytesInQueue == 0 && count <= len - rateBytes) {
                count = getCount1(in, len, rateBytes, count);
            } else {
                int partialBlock = Math.min(rateBytes - bytesInQueue, len - count);
                System.arraycopy(in, count, dataQueue, bytesInQueue, partialBlock);
                bytesInQueue += partialBlock;
                count += partialBlock;
                bytesInQueue = getBytesInQueue(bytesInQueue, rateBytes);
            }
        }

        bitsInQueue = bytesInQueue << 3;
    }

    private int getCount1(byte[] in, int len, int rateBytes, int count) {
        do {
            count = getCount(in, rateBytes, count);
        } while (count <= len - rateBytes);
        return count;
    }

    private int getBytesInQueue(int bytesInQueue, int rateBytes) {
        if (reftt(bytesInQueue != rateBytes)) return bytesInQueue;
        extrFor(dataQueue, 0);
		exctrc(state);
		return 0;
    }

    private void exctrc(long[] a) {
        for (int i = 0; i < 24; ++i) {
            a[0] ^= KeccakRoundConstants[i];
        }
    }

    private int getCount(byte[] in, int rateBytes, int count) {
        extrFor(in, count);
        exctrc(state);
        return count + rateBytes;
    }

    private void extrFor(byte[] in, int count) {
        for (int off1 = count, count1 = rate >> 6, i = 0; i < count1; ++i) {
            int off11 = off1 + 4, off2 = off1;
            state[i] ^= (((in[off2] & 0xff) | ((in[++off2] & 0xff) << 8) | ((in[++off2] & 0xff) << 16)
                    | (in[++off2] << 24)) & 0xffffffffL)
                    | ((((in[off11] & 0xff) | ((in[++off11] & 0xff) << 8) | ((in[++off11] & 0xff) << 16)
                    | (in[++off11] << 24)) & 0xffffffffL) << 32);
            off1 += 8;
        }
    }

    void doFinal(byte[] out) {
        sqeez();
        extrctg(out);
        extrcv(fixedOutputLength, fixedOutputLength << 1);

    }

    private void extrcv(int fixedOutputLength, int i2) {
        this.rate = 1600 - (fixedOutputLength << 1);
        mthf();
        reft();
        this.bitsInQueue = 0;
        this.squeezing = false;
        this.fixedOutputLength = i2 / 2;
    }

    private void reft() {
        for (int i = 0; i < this.dataQueue.length; ++i) {
			this.dataQueue[i] = 0;
		}
    }

    private void mthf() {
        for (int i = 0; i < state.length; ++i) {
			state[i] = 0L;
		}
    }

    private void sqeez() {
        if (reftt(squeezing)) return;
        dataQueue[bitsInQueue >> 3] |= (byte) (1L << (bitsInQueue & 7));
        meth4();
        int full = bitsInQueue >> 6;
        methj(full, bitsInQueue & 63, getOff(full, 0));
        state[rate - 1 >> 6] ^= 1L << 63;
		extrc3(state);
		extractFor();
		bitsInQueue = rate;
		squeezing = true;
    }

    private boolean reftt(boolean squeezing) {
		return squeezing;
	}

    private void methj(int full, int partial, int off) {
        if (reftt(partial <= 0)) return;
        int off1 = off + 4, off2 = off;
		state[full] ^= ((((dataQueue[off2] & 0xff) | ((dataQueue[++off2] & 0xff) << 8)
				| ((dataQueue[++off2] & 0xff) << 16) | (dataQueue[++off2] << 24)) & 0xffffffffL)
				| ((((dataQueue[off1] & 0xff) | ((dataQueue[++off1] & 0xff) << 8) | ((dataQueue[++off1] & 0xff) << 16)
						| (dataQueue[++off1] << 24)) & 0xffffffffL) << 32))
				& (1L << partial) - 1L;
    }

    private void meth4() {
        if (rfty()) return;
        extrFor(dataQueue, 0);
		exctrc(state);
		bitsInQueue = 0;
    }

    private boolean rfty() {
		return ++bitsInQueue != rate;
	}

    private int getOff(int full, int off) {
        for (int i = 0; i < full; ++i) {
            int off1 = off + 4, off2 = off;
            state[i] ^= (((dataQueue[off2] & 0xff) | ((dataQueue[++off2] & 0xff) << 8)
                    | ((dataQueue[++off2] & 0xff) << 16) | (dataQueue[++off2] << 24)) & 0xffffffffL)
                    | ((((dataQueue[off1] & 0xff) | ((dataQueue[++off1] & 0xff) << 8)
                            | ((dataQueue[++off1] & 0xff) << 16) | (dataQueue[++off1] << 24)) & 0xffffffffL) << 32);
            off += 8;
        }
        return off;
    }

    private void extrctg(byte[] out) {
        for (long i = 0; i < fixedOutputLength; ) {
            meth1();
            int partialBlock = (int) Math.min( bitsInQueue,  fixedOutputLength - i);
            System.arraycopy(dataQueue, (rate - bitsInQueue) / 8, out, (int) (i / 8), partialBlock / 8);
            bitsInQueue -= partialBlock;
            i += partialBlock;
        }
    }

    private void meth1() {
        if (reftt(bitsInQueue != 0)) return;
        exctrc(state);
		extractFor();
		bitsInQueue = rate;
    }

    private void extrc3(long[] a) {
        for (int i = 0; i < 24; ++i) {
            eMs(a, a[0] ^ a[5] ^ a[10] ^ a[15] ^ a[20], a[1] ^ a[6] ^ a[11] ^ a[16] ^ a[21], a[2] ^ a[7] ^ a[12] ^ a[17] ^ a[22], a[3] ^ a[8] ^ a[13] ^ a[18] ^ a[23], a[4] ^ a[9] ^ a[14] ^ a[19] ^ a[24]);
            a[0] ^= KeccakRoundConstants[i];
        }
    }

    private void eMs(long[] a, long c0, long c1, long c2, long c3, long c4) {
        extractM1(a, c4 ^ ((c1 << 1) | (c1 >>> 63)), c0 ^ ((c2 << 1) | (c2 >>> 63)), c1 ^ ((c3 << 1) | (c3 >>> 63)), c2 ^ ((c4 << 1) | (c4 >>> 63)), c3 ^ ((c0 << 1) | (c0 >>> 63)));
        extractM2(a);
        eM4(a, 0, 2, 1, 3, 4);
        eM4(a, 5, 7, 6, 8, 9);
        eM4(a, 10, 12, 11, 13, 14);
        eM4(a, 15, 17, 16, 18, 19);
        eM4(a, 20, 22, 21, 23, 24);
    }

    private void eM4(long[] a, int i2, int i3, int i4, int i5, int i6) {
        long c0 = a[i2] ^ (a[i3] & ~a[i4]), c1 = a[i4] ^ (a[i5] & ~a[i3]);
        a[i3] ^= a[i6] & ~a[i5];
        a[i5] ^= a[i2] & ~a[i6];
        a[i6] ^= a[i4] & ~a[i2];
        a[i2] = c0;
        a[i4] = c1;
    }

    private void extractM2(long[] a) {
        long c1 = (a[1] << 1) | (a[1] >>> 63);
        a[1] = (a[6] << 44) | (a[6] >>> 20);
        a[6] = (a[9] << 20) | (a[9] >>> 44);
        a[9] = (a[22] << 61) | (a[22] >>> 3);
        a[22] = (a[14] << 39) | (a[14] >>> 25);
        a[14] = (a[20] << 18) | (a[20] >>> 46);
        a[20] = (a[2] << 62) | (a[2] >>> 2);
        a[2] = (a[12] << 43) | (a[12] >>> 21);
        a[12] = (a[13] << 25) | (a[13] >>> 39);
        a[13] = (a[19] << 8) | (a[19] >>> 56);
        a[19] = (a[23] << 56) | (a[23] >>> 8);
        a[23] = (a[15] << 41) | (a[15] >>> 23);
        a[15] = (a[4] << 27) | (a[4] >>> 37);
        a[4] = (a[24] << 14) | (a[24] >>> 50);
        a[24] = (a[21] << 2) | (a[21] >>> 62);
        a[21] = (a[8] << 55) | (a[8] >>> 9);
        a[8] = (a[16] << 45) | (a[16] >>> 19);
        a[16] = (a[5] << 36) | (a[5] >>> 28);
        a[5] = (a[3] << 28) | (a[3] >>> 36);
        a[3] = (a[18] << 21) | (a[18] >>> 43);
        a[18] = (a[17] << 15) | (a[17] >>> 49);
        a[17] = (a[11] << 10) | (a[11] >>> 54);
        a[11] = (a[7] << 6) | (a[7] >>> 58);
        a[7] = (a[10] << 3) | (a[10] >>> 61);
        a[10] = c1;
    }

    private void extractM1(long[] a, long d1, long d2, long d3, long d4, long d0) {
        a[0] ^= d1;
        a[5] ^= d1;
        a[10] ^= d1;
        a[15] ^= d1;
        a[20] ^= d1;
        a[1] ^= d2;
        a[6] ^= d2;
        a[11] ^= d2;
        a[16] ^= d2;
        a[21] ^= d2;
        a[2] ^= d3;
        a[7] ^= d3;
        a[12] ^= d3;
        a[17] ^= d3;
        a[22] ^= d3;
        a[3] ^= d4;
        a[8] ^= d4;
        a[13] ^= d4;
        a[18] ^= d4;
        a[23] ^= d4;
        a[4] ^= d0;
        a[9] ^= d0;
        a[14] ^= d0;
        a[19] ^= d0;
        a[24] ^= d0;
    }

    private void extractFor() {
        for (int bsOff = 0, i1 = 0; i1 < rate >> 6; ++i1) {
            int off2 = bsOff;
            dataQueue[off2++] = (byte) (int) (state[i1] & 0xffffffffL);
            dataQueue[off2++] = (byte) ((int) (state[i1] & 0xffffffffL) >>> 8);
            dataQueue[off2++] = (byte) ((int) (state[i1] & 0xffffffffL) >>> 16);
            dataQueue[off2] = (byte) ((int) (state[i1] & 0xffffffffL) >>> 24);
            int off1 = bsOff + 4;
            dataQueue[off1++] = (byte) (int) (state[i1] >>> 32);
            dataQueue[off1++] = (byte) ((int) (state[i1] >>> 32) >>> 8);
            dataQueue[off1++] = (byte) ((int) (state[i1] >>> 32) >>> 16);
            dataQueue[off1] = (byte) ((int) (state[i1] >>> 32) >>> 24);
            bsOff += 8;
        }
    }
 }
