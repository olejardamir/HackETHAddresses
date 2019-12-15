import java.math.BigInteger;
import java.util.Hashtable;

public abstract class ECCurve {
   private PrimeField field;
   ECFieldElement a;
   ECFieldElement b;
   BigInteger order;
   int coord = 0;
   private FixedPointCombMultiplier multiplier = null;

   public ECCurve() {
      super();
   }

   ECCurve(PrimeField field) {
      super();
      this.field = field;
   }

   public abstract int getFieldSize();

   public abstract ECFieldElement fromBigInteger(BigInteger var1);

   public synchronized ECCurve.Config configure() {
      return new ECCurve.Config(this.coord);
   }

   private ECPoint validatePoint(BigInteger x, BigInteger y) {
      return this.createPoint(x, y);
   }

   private ECPoint createPoint(BigInteger x, BigInteger y) {
      return this.createPoint(x, y, false);
   }

   public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression) {
      return this.createRawPoint(this.fromBigInteger(x), this.fromBigInteger(y), withCompression);
   }

   protected abstract ECCurve cloneCurve() throws Exception;

   protected abstract ECPoint createRawPoint(ECFieldElement var1, ECFieldElement var2, boolean var3);

   public FixedPointPreCompInfo precompute(ECPoint point, String name, PreCompCallback callback) {
      Hashtable table = point.preCompTable;
      if (null == table) {
         Hashtable preCompTable = new Hashtable(4);
         point.preCompTable = preCompTable;
         table = preCompTable;
      }

      FixedPointPreCompInfo existing = (FixedPointPreCompInfo)table.get(name);
      FixedPointPreCompInfo result = callback.precompute(existing);
      if (result != existing) {
         table.put(name, result);
      }

      return result;
   }

   public ECPoint importPoint(ECPoint p) {
      if (this == p.getCurve()) {
         return p;
      } else if (p.isInfinity()) {
         return this.getInfinity();
      } else {
         p = p.normalize();
         return this.createPoint(p.getXCoord().toBigInteger(), p.getYCoord().toBigInteger(), p.withCompression);
      }
   }

   public void normalizeAll(ECPoint[] points) {
      this.normalizeAll(points, points.length);
   }

   private void normalizeAll(ECPoint[] points, int len) {
      switch(this.getCoordinateSystem()) {
      default:
         ECFieldElement[] zs = new ECFieldElement[len];
         int[] indices = new int[len];
         int count = 0;
         int j = 0;

         for(; j < len; ++j) {
            ECPoint p = points[j];
            if (null != p && p.isNormalized()) {
               zs[count] = p.getZCoord(0);
               indices[count++] = j;
            }
         }

         if (count != 0) {
            ECAlgorithms.montgomeryTrick(zs, 0, count);

            for(j = 0; j < count; ++j) {
               int index = indices[j];
               points[index] = points[index].normalize(zs[j]);
            }

         }
      }
   }

   public abstract ECPoint getInfinity();

   public PrimeField getField() {
      return this.field;
   }

   public ECFieldElement getA() {
      return this.a;
   }

   public ECFieldElement getB() {
      return this.b;
   }

   public BigInteger getOrder() {
      return this.order;
   }

   public int getCoordinateSystem() {
      return this.coord;
   }

   protected abstract ECPoint decompressPoint(int var1, BigInteger var2);

   public ECPoint decodePoint(byte[] encoded) {
      ECPoint p = null;
      int expectedLength = (this.getFieldSize() + 7) / 8;
      byte type = encoded[0];
      BigInteger Y;
      switch(type) {
      case 0:
         p = this.getInfinity();
      case 1:
      case 5:
      default:
         break;
      case 2:
      case 3:
         int yTilde = type & 1;
         Y = BigIntegers.fromUnsignedByteArray(encoded, 1, expectedLength);
         p = this.decompressPoint(yTilde, Y);
         break;
      case 4:
      case 6:
      case 7:
         BigInteger X2 = BigIntegers.fromUnsignedByteArray(encoded, 1, expectedLength);
         Y = BigIntegers.fromUnsignedByteArray(encoded, 1 + expectedLength, expectedLength);
         p = this.validatePoint(X2, Y);
      }

      return p;
   }

   public ECLookupTable createCacheSafeLookupTable(ECPoint[] points, int off, final int len) {
      final int FE_BYTES = this.getFieldSize() + 7 >>> 3;
      final byte[] table = new byte[len * FE_BYTES * 2];
      int pos = 0;

      for(int i = 0; i < len; ++i) {
         ECPoint p = points[off + i];
         byte[] px = p.getRawXCoord().toBigInteger().toByteArray();
         byte[] py = p.getRawYCoord().toBigInteger().toByteArray();
         int pxStart = px.length > FE_BYTES ? 1 : 0;
         int pxLen = px.length - pxStart;
         int pyStart = py.length > FE_BYTES ? 1 : 0;
         int pyLen = py.length - pyStart;
         System.arraycopy(px, pxStart, table, pos + FE_BYTES - pxLen, pxLen);
         pos += FE_BYTES;
         System.arraycopy(py, pyStart, table, pos + FE_BYTES - pyLen, pyLen);
         pos += FE_BYTES;
      }

      return new ECLookupTable() {
         public int getSize() {
            return len;
         }

         public ECPoint lookup(int index) {
            byte[] x = new byte[FE_BYTES];
            byte[] y = new byte[FE_BYTES];
            int pos = 0;

            for(int i = 0; i < len; ++i) {
               int MASK = (i ^ index) - 1 >> 31;

               for(int j = 0; j < FE_BYTES; ++j) {
                  x[j] ^= (byte)(table[pos + j] & MASK);
                  y[j] ^= (byte)(table[pos + FE_BYTES + j] & MASK);
               }

               pos += FE_BYTES * 2;
            }

            return ECCurve.this.createRawPoint(ECCurve.this.fromBigInteger(new BigInteger(1, x)), ECCurve.this.fromBigInteger(new BigInteger(1, y)), false);
         }
      };
   }

   public boolean equals(ECCurve other) {
      return this == other || null != other && this.getField().equals(other.getField()) && this.getA().toBigInteger().equals(other.getA().toBigInteger()) && this.getB().toBigInteger().equals(other.getB().toBigInteger());
   }

   public boolean equals(Object obj) {
      return this == obj || obj instanceof ECCurve && this.equals((ECCurve)obj);
   }

   public int hashCode() {
      return this.getField().hashCode() ^ Integer.rotateLeft(this.getA().toBigInteger().hashCode(), 8) ^ Integer.rotateLeft(this.getB().toBigInteger().hashCode(), 16);
   }

   public class Config {
      final int coord;

      Config(int coord) {
         super();
         this.coord = coord;
      }

      public ECCurve.Config setEndomorphism() {
         return this;
      }

      public ECCurve create() throws Exception {
         ECCurve c = ECCurve.this.cloneCurve();
         c.coord = this.coord;
         c.multiplier = ECCurve.this.multiplier;
         return c;
      }
   }
}
