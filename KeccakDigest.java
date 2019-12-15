class KeccakDigest {
   private static final long[] KeccakRoundConstants = new long[]{1L, 32898L, -9223372036854742902L, -9223372034707259392L, 32907L, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138L, 136L, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778L, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};
   private final long[] state = new long[25];
   private final byte[] dataQueue = new byte[192];
   private int rate;
   private int bitsInQueue;
   private int fixedOutputLength;
   private boolean squeezing;

   public KeccakDigest(int bitLength) {
      super();
      this.init(bitLength);
   }

   public String getAlgorithmName() {
      return "Keccak-" + this.fixedOutputLength;
   }

   public int getDigestSize() {
      return this.fixedOutputLength / 8;
   }

   public void update(byte[] in, int inOff, int len) {
      this.absorb(in, inOff, len);
   }

   public void doFinal(byte[] out, int outOff) {
      this.squeeze(out, outOff, (long)this.fixedOutputLength);
      this.reset();
      this.getDigestSize();
   }

   private void reset() {
      this.init(this.fixedOutputLength);
   }

   private void init(int bitLength) {
      switch(bitLength) {
      case 128:
      case 224:
      case 256:
      case 288:
      case 384:
      case 512:
         this.initSponge(1600 - (bitLength << 1));
      default:
      }
   }

   private void initSponge(int rate) {
      this.rate = rate;

      for(int i = 0; i < this.state.length; ++i) {
         this.state[i] = 0L;
      }

      this.bitsInQueue = 0;
      this.squeezing = false;
      this.fixedOutputLength = (1600 - rate) / 2;
   }

   private void absorb(byte[] data, int off, int len) {
      int bytesInQueue = this.bitsInQueue >> 3;
      int rateBytes = this.rate >> 3;
      int count = 0;


         while(count < len) {
               int partialBlock = Math.min(rateBytes - bytesInQueue, len - count);
               System.arraycopy(data, off + count, this.dataQueue, bytesInQueue, partialBlock);
               bytesInQueue += partialBlock;
               if (bytesInQueue == rateBytes) {
                  bytesInQueue = 0;
               }
         this.bitsInQueue = bytesInQueue << 3;
         return;
      }
   }

   private void padAndSwitchToSqueezingPhase() {
      byte[] dataQueue = this.dataQueue;
      int n = this.bitsInQueue >> 3;
      dataQueue[n] |= (byte)((int)(1L << (this.bitsInQueue & 7)));
      if (++this.bitsInQueue == this.rate) {
         this.bitsInQueue = 0;
      }

      int full = this.bitsInQueue >> 6;
      int partial = this.bitsInQueue & 63;
      int off = 0;

      int n4;
      long[] var10000;
      for(n4 = 0; n4 < full; ++n4) {
         var10000 = this.state;
         var10000[n4] ^= Pack.littleEndianToLong(this.dataQueue, off);
         off += 8;
      }

      if (partial > 0) {
         long mask = (1L << partial) - 1L;
         var10000 = this.state;
         var10000[full] ^= Pack.littleEndianToLong(this.dataQueue, off) & mask;
      }

      n4 = this.rate - 1 >> 6;
      var10000 = this.state;
      var10000[n4] ^= Long.MIN_VALUE;
      this.KeccakPermutation();
      this.KeccakExtract();
      this.bitsInQueue = this.rate;
      this.squeezing = true;
   }

   private void squeeze(byte[] output, int offset, long outputLength) {
      if (!this.squeezing) {
         this.padAndSwitchToSqueezingPhase();
      }

      int partialBlock;
      for(long i = 0L; i < outputLength; i += (long)partialBlock) {
         if (this.bitsInQueue == 0) {
            this.KeccakPermutation();
            this.KeccakExtract();
            this.bitsInQueue = this.rate;
         }

         partialBlock = (int)Math.min((long)this.bitsInQueue, outputLength - i);
         System.arraycopy(this.dataQueue, (this.rate - this.bitsInQueue) / 8, output, offset + (int)(i / 8L), partialBlock / 8);
         this.bitsInQueue -= partialBlock;
      }

   }

   private void KeccakExtract() {
      Pack.longToLittleEndian(this.state, 0, this.rate >> 6, this.dataQueue, 0);
   }

   private void KeccakPermutation() {
      long[] A = this.state;
      long a00 = A[0];
      long a2 = A[1];
      long a3 = A[2];
      long a4 = A[3];
      long a5 = A[4];
      long a6 = A[5];
      long a7 = A[6];
      long a8 = A[7];
      long a9 = A[8];
      long a10 = A[9];
      long a11 = A[10];
      long a12 = A[11];
      long a13 = A[12];
      long a14 = A[13];
      long a15 = A[14];
      long a16 = A[15];
      long a17 = A[16];
      long a18 = A[17];
      long a19 = A[18];
      long a20 = A[19];
      long a21 = A[20];
      long a22 = A[21];
      long a23 = A[22];
      long a24 = A[23];
      long a25 = A[24];

      for(int i = 0; i < 24; ++i) {
         long c0 = a00 ^ a6 ^ a11 ^ a16 ^ a21;
         long c2 = a2 ^ a7 ^ a12 ^ a17 ^ a22;
         long c3 = a3 ^ a8 ^ a13 ^ a18 ^ a23;
         long c4 = a4 ^ a9 ^ a14 ^ a19 ^ a24;
         long c5 = a5 ^ a10 ^ a15 ^ a20 ^ a25;
         long d1 = (c2 << 1 | c2 >>> 63) ^ c5;
         long d2 = (c3 << 1 | c3 >>> 63) ^ c0;
         long d3 = (c4 << 1 | c4 >>> 63) ^ c2;
         long d4 = (c5 << 1 | c5 >>> 63) ^ c3;
         long d5 = (c0 << 1 | c0 >>> 63) ^ c4;
         a00 ^= d1;
         a6 ^= d1;
         a11 ^= d1;
         a16 ^= d1;
         a21 ^= d1;
         a2 ^= d2;
         a7 ^= d2;
         a12 ^= d2;
         a17 ^= d2;
         a22 ^= d2;
         a3 ^= d3;
         a8 ^= d3;
         a13 ^= d3;
         a18 ^= d3;
         a23 ^= d3;
         a4 ^= d4;
         a9 ^= d4;
         a14 ^= d4;
         a19 ^= d4;
         a24 ^= d4;
         a5 ^= d5;
         a10 ^= d5;
         a15 ^= d5;
         a20 ^= d5;
         a25 ^= d5;
         c2 = a2 << 1 | a2 >>> 63;
         a2 = a7 << 44 | a7 >>> 20;
         a7 = a10 << 20 | a10 >>> 44;
         a10 = a23 << 61 | a23 >>> 3;
         a23 = a15 << 39 | a15 >>> 25;
         a15 = a21 << 18 | a21 >>> 46;
         a21 = a3 << 62 | a3 >>> 2;
         a3 = a13 << 43 | a13 >>> 21;
         a13 = a14 << 25 | a14 >>> 39;
         a14 = a20 << 8 | a20 >>> 56;
         a20 = a24 << 56 | a24 >>> 8;
         a24 = a16 << 41 | a16 >>> 23;
         a16 = a5 << 27 | a5 >>> 37;
         a5 = a25 << 14 | a25 >>> 50;
         a25 = a22 << 2 | a22 >>> 62;
         a22 = a9 << 55 | a9 >>> 9;
         a9 = a17 << 45 | a17 >>> 19;
         a17 = a6 << 36 | a6 >>> 28;
         a6 = a4 << 28 | a4 >>> 36;
         a4 = a19 << 21 | a19 >>> 43;
         a19 = a18 << 15 | a18 >>> 49;
         a18 = a12 << 10 | a12 >>> 54;
         a12 = a8 << 6 | a8 >>> 58;
         a8 = a11 << 3 | a11 >>> 61;
         a11 = c2;
         c0 = a00 ^ ~a2 & a3;
         c2 = a2 ^ ~a3 & a4;
         a3 ^= ~a4 & a5;
         a4 ^= ~a5 & a00;
         a5 ^= ~a00 & a2;
         a00 = c0;
         a2 = c2;
         c0 = a6 ^ ~a7 & a8;
         c2 = a7 ^ ~a8 & a9;
         a8 ^= ~a9 & a10;
         a9 ^= ~a10 & a6;
         a10 ^= ~a6 & a7;
         a6 = c0;
         a7 = c2;
         c0 = a11 ^ ~a12 & a13;
         c2 = a12 ^ ~a13 & a14;
         a13 ^= ~a14 & a15;
         a14 ^= ~a15 & a11;
         a15 ^= ~a11 & a12;
         a11 = c0;
         a12 = c2;
         c0 = a16 ^ ~a17 & a18;
         c2 = a17 ^ ~a18 & a19;
         a18 ^= ~a19 & a20;
         a19 ^= ~a20 & a16;
         a20 ^= ~a16 & a17;
         a16 = c0;
         a17 = c2;
         c0 = a21 ^ ~a22 & a23;
         c2 = a22 ^ ~a23 & a24;
         a23 ^= ~a24 & a25;
         a24 ^= ~a25 & a21;
         a25 ^= ~a21 & a22;
         a21 = c0;
         a22 = c2;
         a00 ^= KeccakRoundConstants[i];
      }

      A[0] = a00;
      A[1] = a2;
      A[2] = a3;
      A[3] = a4;
      A[4] = a5;
      A[5] = a6;
      A[6] = a7;
      A[7] = a8;
      A[8] = a9;
      A[9] = a10;
      A[10] = a11;
      A[11] = a12;
      A[12] = a13;
      A[13] = a14;
      A[14] = a15;
      A[15] = a16;
      A[16] = a17;
      A[17] = a18;
      A[18] = a19;
      A[19] = a20;
      A[20] = a21;
      A[21] = a22;
      A[22] = a23;
      A[23] = a24;
      A[24] = a25;
   }
}
