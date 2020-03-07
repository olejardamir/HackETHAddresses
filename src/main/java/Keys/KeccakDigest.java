package Keys;

class KeccakDigest {
    private static final long[] KeccakRoundConstants = new long[]{ 0x0000000000000001L, 0x0000000000008082L,
            0x800000000000808aL, 0x8000000080008000L, 0x000000000000808bL, 0x0000000080000001L, 0x8000000080008081L,
            0x8000000000008009L, 0x000000000000008aL, 0x0000000000000088L, 0x0000000080008009L, 0x000000008000000aL,
            0x000000008000808bL, 0x800000000000008bL, 0x8000000000008089L, 0x8000000000008003L, 0x8000000000008002L,
            0x8000000000000080L, 0x000000000000800aL, 0x800000008000000aL, 0x8000000080008081L, 0x8000000000008080L,
            0x0000000080000001L, 0x8000000080008008L };

    private final long[] state = new long[25];
    private final byte[] dataQueue = new byte[192];
    private int rate;
    private int bitsInQueue;
    private int fixedOutputLength;
    private boolean squeezing;

    public KeccakDigest(int bitLength)
    {
        init(bitLength);
    }

    public KeccakDigest(KeccakDigest source)
    {
        System.arraycopy(source.state, 0, this.state, 0, source.state.length);
        System.arraycopy(source.dataQueue, 0, this.dataQueue, 0, source.dataQueue.length);
        this.rate = source.rate;
        this.bitsInQueue = source.bitsInQueue;
        this.fixedOutputLength = source.fixedOutputLength;
        this.squeezing = source.squeezing;
    }

    public int getDigestSize()
    {
        return fixedOutputLength / 8;
    }



    public void update(byte[] in, int inOff, int len)
    {
        absorb(in, inOff, len);
    }

    public void doFinal(byte[] out, int outOff)
    {
        squeeze(out, outOff, fixedOutputLength);

        reset();

        getDigestSize();
    }

    private void reset()
    {
        init(fixedOutputLength);
    }

    private void init(int bitLength)
    {
        switch (bitLength)
        {
            case 128:
            case 224:
            case 256:
            case 288:
            case 384:
            case 512:
                initSponge(1600 - (bitLength << 1));
                break;
            default:

        }
    }

    private void initSponge(int rate)
    {


        this.rate = rate;
        for (int i = 0; i < state.length; ++i)
			state[i] = 0L;
        for (int i = 0; i < this.dataQueue.length; ++i)
			this.dataQueue[i] = (byte) 0;
        this.bitsInQueue = 0;
        this.squeezing = false;
        this.fixedOutputLength = (1600 - rate) / 2;
    }

    private void absorb(byte[] data, int off, int len)
    {


        int bytesInQueue = bitsInQueue >> 3, rateBytes = rate >> 3;
        for (int count = 0; count < len;)
			if (bytesInQueue == 0 && count <= (len - rateBytes))
				do {
					KeccakAbsorb(data, off + count);
					count += rateBytes;
				} while (count <= (len - rateBytes));
			else {
				int partialBlock = Math.min(rateBytes - bytesInQueue, len - count);
				System.arraycopy(data, off + count, dataQueue, bytesInQueue, partialBlock);
				bytesInQueue += partialBlock;
				count += partialBlock;
				if (bytesInQueue == rateBytes) {
					KeccakAbsorb(dataQueue, 0);
					bytesInQueue = 0;
				}
			}

        bitsInQueue = bytesInQueue << 3;
    }

    private void padAndSwitchToSqueezingPhase()
    {
		dataQueue[bitsInQueue >> 3] |= (byte) (1L << (bitsInQueue & 7));
		if (++bitsInQueue == rate) {
			KeccakAbsorb(dataQueue, 0);
			bitsInQueue = 0;
		}
		int full = bitsInQueue >> 6, partial = bitsInQueue & 63, off = 0;
		for (int i = 0; i < full; ++i) {
			state[i] ^= Pack.littleEndianToLong(dataQueue, off);
			off += 8;
		}
		if (partial > 0)
			state[full] ^= Pack.littleEndianToLong(dataQueue, off) & (1L << partial) - 1L;
		state[(rate - 1) >> 6] ^= (1L << 63);
		KeccakPermutation();
		KeccakExtract();
		bitsInQueue = rate;
		squeezing = true;
	}

    private void squeeze(byte[] output, int offset, long outputLength)
    {
        if (!squeezing)
			padAndSwitchToSqueezingPhase();

        for (long i = 0; i < outputLength;) {
			if (bitsInQueue == 0) {
				KeccakPermutation();
				KeccakExtract();
				bitsInQueue = rate;
			}
			int partialBlock = (int) Math.min((long) bitsInQueue, outputLength - i);
			System.arraycopy(dataQueue, (rate - bitsInQueue) / 8, output, offset + (int) (i / 8), partialBlock / 8);
			bitsInQueue -= partialBlock;
			i += partialBlock;
		}
    }

    private void KeccakAbsorb(byte[] data, int off)
    {
        int count = rate >> 6;
        for (int i = 0; i < count; ++i)
        {
            state[i] ^= Pack.littleEndianToLong(data, off);
            off += 8;
        }

        KeccakPermutation();
    }

    private void KeccakExtract()
    {
        Pack.longToLittleEndian(state, 0, rate >> 6, dataQueue, 0);
    }

    private void KeccakPermutation()
    {
        long[] A = state;

        long a00 = A[0], a01 = A[1], a02 = A[2], a03 = A[3], a04 = A[4], a05 = A[5], a06 = A[6], a07 = A[7], a08 = A[8],
				a09 = A[9], a10 = A[10], a11 = A[11], a12 = A[12], a13 = A[13], a14 = A[14], a15 = A[15], a16 = A[16],
				a17 = A[17], a18 = A[18], a19 = A[19], a20 = A[20], a21 = A[21], a22 = A[22], a23 = A[23], a24 = A[24];
        for (int i = 0; i < 24; ++i)
        {
            
            long c0 = a00 ^ a05 ^ a10 ^ a15 ^ a20, c1 = a01 ^ a06 ^ a11 ^ a16 ^ a21, c2 = a02 ^ a07 ^ a12 ^ a17 ^ a22,
					c3 = a03 ^ a08 ^ a13 ^ a18 ^ a23, c4 = a04 ^ a09 ^ a14 ^ a19 ^ a24, d1 = c4 ^ (c1 << 1 | c1 >>> 63),
					d2 = c0 ^ (c2 << 1 | c2 >>> 63), d3 = c1 ^ (c3 << 1 | c3 >>> 63), d4 = c2 ^ (c4 << 1 | c4 >>> 63),
					d0 = c3 ^ (c0 << 1 | c0 >>> 63);
            a00 ^= d1; a05 ^= d1; a10 ^= d1; a15 ^= d1; a20 ^= d1;
            a01 ^= d2; a06 ^= d2; a11 ^= d2; a16 ^= d2; a21 ^= d2;
            a02 ^= d3; a07 ^= d3; a12 ^= d3; a17 ^= d3; a22 ^= d3;
            a03 ^= d4; a08 ^= d4; a13 ^= d4; a18 ^= d4; a23 ^= d4;
            a04 ^= d0; a09 ^= d0; a14 ^= d0; a19 ^= d0; a24 ^= d0;

            
            c1  = a01 <<  1 | a01 >>> 63;
            a01 = a06 << 44 | a06 >>> 20;
            a06 = a09 << 20 | a09 >>> 44;
            a09 = a22 << 61 | a22 >>>  3;
            a22 = a14 << 39 | a14 >>> 25;
            a14 = a20 << 18 | a20 >>> 46;
            a20 = a02 << 62 | a02 >>>  2;
            a02 = a12 << 43 | a12 >>> 21;
            a12 = a13 << 25 | a13 >>> 39;
            a13 = a19 <<  8 | a19 >>> 56;
            a19 = a23 << 56 | a23 >>>  8;
            a23 = a15 << 41 | a15 >>> 23;
            a15 = a04 << 27 | a04 >>> 37;
            a04 = a24 << 14 | a24 >>> 50;
            a24 = a21 <<  2 | a21 >>> 62;
            a21 = a08 << 55 | a08 >>>  9;
            a08 = a16 << 45 | a16 >>> 19;
            a16 = a05 << 36 | a05 >>> 28;
            a05 = a03 << 28 | a03 >>> 36;
            a03 = a18 << 21 | a18 >>> 43;
            a18 = a17 << 15 | a17 >>> 49;
            a17 = a11 << 10 | a11 >>> 54;
            a11 = a07 <<  6 | a07 >>> 58;
            a07 = a10 <<  3 | a10 >>> 61;
            a10 = c1;

            
            c0 = a00 ^ (a02 & ~a01);
            c1 = a01 ^ (a03 & ~a02);
            a02 ^= a04 & ~a03;
            a03 ^= a00 & ~a04;
            a04 ^= a01 & ~a00;
            a00 = c0;
            a01 = c1;

            c0 = a05 ^ (a07 & ~a06);
            c1 = a06 ^ (a08 & ~a07);
            a07 ^= a09 & ~a08;
            a08 ^= a05 & ~a09;
            a09 ^= a06 & ~a05;
            a05 = c0;
            a06 = c1;

            c0 = a10 ^ (a12 & ~a11);
            c1 = a11 ^ (a13 & ~a12);
            a12 ^= a14 & ~a13;
            a13 ^= a10 & ~a14;
            a14 ^= a11 & ~a10;
            a10 = c0;
            a11 = c1;

            c0 = a15 ^ (a17 & ~a16);
            c1 = a16 ^ (a18 & ~a17);
            a17 ^= a19 & ~a18;
            a18 ^= a15 & ~a19;
            a19 ^= a16 & ~a15;
            a15 = c0;
            a16 = c1;

            c0 = a20 ^ (a22 & ~a21);
            c1 = a21 ^ (a23 & ~a22);
            a22 ^= a24 & ~a23;
            a23 ^= a20 & ~a24;
            a24 ^= a21 & ~a20;
            a20 = c0;
            a21 = c1;

            
            a00 ^= KeccakRoundConstants[i];
        }

        A[ 0] = a00; A[ 1] = a01; A[ 2] = a02; A[ 3] = a03; A[ 4] = a04;
        A[ 5] = a05; A[ 6] = a06; A[ 7] = a07; A[ 8] = a08; A[ 9] = a09;
        A[10] = a10; A[11] = a11; A[12] = a12; A[13] = a13; A[14] = a14;
        A[15] = a15; A[16] = a16; A[17] = a17; A[18] = a18; A[19] = a19;
        A[20] = a20; A[21] = a21; A[22] = a22; A[23] = a23; A[24] = a24;
    }
}
