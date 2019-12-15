import java.util.Hashtable;

public abstract class ECPoint {
   private static final ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];
   final ECCurve curve;
   final ECFieldElement x;
   final ECFieldElement y;
   final ECFieldElement[] zs;
   boolean withCompression;
   Hashtable preCompTable;

   ECPoint(ECCurve curve, ECFieldElement x, ECFieldElement y) {
      this(curve, x, y, getInitialZCoords(curve));
   }

   ECPoint(ECCurve curve, ECFieldElement x, ECFieldElement y, ECFieldElement[] zs) {
      super();
      this.preCompTable = null;
      this.curve = curve;
      this.x = x;
      this.y = y;
      this.zs = zs;
   }

   private static ECFieldElement[] getInitialZCoords(ECCurve curve) {
      int coord = null == curve ? 0 : curve.getCoordinateSystem();
      switch(coord) {
      case 0:
      case 5:
         return EMPTY_ZS;
      default:
         ECFieldElement one = curve.fromBigInteger(ECFieldElement.ONE);
         switch(coord) {
         case 1:
         case 2:
         case 6:
            return new ECFieldElement[]{one};
         case 3:
            return new ECFieldElement[]{one, one, one};
         case 4:
            return new ECFieldElement[]{one, curve.getA()};
         case 5:
         default:
            return null;
         }
      }
   }

   public ECCurve getCurve() {
      return this.curve;
   }

   int getCurveCoordinateSystem() {
      return null == this.curve ? 0 : this.curve.getCoordinateSystem();
   }

   public ECFieldElement getXCoord() {
      return this.x;
   }

   public ECFieldElement getYCoord() {
      return this.y;
   }

   public ECFieldElement getZCoord(int index) {
      return index >= 0 && index < this.zs.length ? this.zs[index] : null;
   }

   public final ECFieldElement getRawXCoord() {
      return this.x;
   }

   public final ECFieldElement getRawYCoord() {
      return this.y;
   }

   public boolean isNormalized() {
      int coord = this.getCurveCoordinateSystem();
      return coord != 0 && coord != 5 && !this.isInfinity() && !this.zs[0].isOne();
   }

   public ECPoint normalize() {
      if (this.isInfinity()) {
         return this;
      } else {
         switch(this.getCurveCoordinateSystem()) {
         case 0:
         case 5:
            return this;
         default:
            ECFieldElement Z1 = this.getZCoord(0);
            return Z1.isOne() ? this : this.normalize(Z1.invert());
         }
      }
   }

   ECPoint normalize(ECFieldElement zInv) {
      switch(this.getCurveCoordinateSystem()) {
      case 1:
      case 6:
         return this.createScaledPoint(zInv, zInv);
      case 2:
      case 3:
      case 4:
         ECFieldElement zInv2 = zInv.square();
         ECFieldElement zInv3 = zInv2.multiply(zInv);
         return this.createScaledPoint(zInv2, zInv3);
      case 5:
      default:
         return null;
      }
   }

   private ECPoint createScaledPoint(ECFieldElement sx, ECFieldElement sy) {
      return this.getCurve().createRawPoint(this.getRawXCoord().multiply(sx), this.getRawYCoord().multiply(sy), this.withCompression);
   }

   public boolean isInfinity() {
      return this.x == null || this.y == null || this.zs.length > 0 && this.zs[0].isZero();
   }

   public boolean equals(ECPoint other) {
      if (null == other) {
         return false;
      } else {
         ECCurve c1 = this.getCurve();
         ECCurve c2 = other.getCurve();
         boolean n1 = null == c1;
         boolean n2 = null == c2;
         boolean i1 = this.isInfinity();
         boolean i2 = other.isInfinity();
         if (!i1 && !i2) {
            ECPoint p1 = this;
            ECPoint p2 = other;
            if (n1) {
               p2 = other.normalize();
            } else if (n2) {
               p1 = this.normalize();
            } else {
               if (!c1.equals(c2)) {
                  return false;
               }

               ECPoint[] points = new ECPoint[]{this, c1.importPoint(other)};
               c1.normalizeAll(points);
               p1 = points[0];
               p2 = points[1];
            }

            return p1.getXCoord().equals(p2.getXCoord()) && p1.getYCoord().equals(p2.getYCoord());
         } else {
            return i1 && i2 && (n1 || n2 || c1.equals(c2));
         }
      }
   }

   public boolean equals(Object other) {
      return other == this || other instanceof ECPoint && this.equals((ECPoint)other);
   }

   public int hashCode() {
      ECCurve c = this.getCurve();
      int hc = null == c ? 0 : ~c.hashCode();
      if (!this.isInfinity()) {
         ECPoint p = this.normalize();

         assert p != null;

         hc ^= p.getXCoord().hashCode() * 17;
         hc ^= p.getYCoord().hashCode() * 257;
      }

      return hc;
   }

   public String toString() {
      if (this.isInfinity()) {
         return "INF";
      } else {
         StringBuilder sb = new StringBuilder();
         sb.append('(');
         sb.append(this.getRawXCoord());
         sb.append(',');
         sb.append(this.getRawYCoord());
         ECFieldElement[] var2 = this.zs;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            ECFieldElement z = var2[var4];
            sb.append(',');
            sb.append(z);
         }

         sb.append(')');
         return sb.toString();
      }
   }

   public byte[] getEncoded(boolean compressed) {
      if (this.isInfinity()) {
         return new byte[1];
      } else {
         ECPoint normed = this.normalize();
         byte[] X = normed.getXCoord().getEncoded();
         byte[] Y;
         if (compressed) {
            Y = new byte[X.length + 1];
            Y[0] = 2;
            System.arraycopy(X, 0, Y, 1, X.length);
            return Y;
         } else {
            Y = normed.getYCoord().getEncoded();
            byte[] PO2 = new byte[X.length + Y.length + 1];
            PO2[0] = 4;
            System.arraycopy(X, 0, PO2, 1, X.length);
            System.arraycopy(Y, 0, PO2, X.length + 1, Y.length);
            return PO2;
         }
      }
   }

   public abstract ECPoint add(ECPoint var1);

   public abstract ECPoint negate();

   public abstract ECPoint subtract(ECPoint var1);

   public ECPoint timesPow2(int e) {
      ECPoint p = this;

      while(true) {
         --e;
         if (e < 0) {
            return p;
         }

         p = p.twice();
      }
   }

   public abstract ECPoint twice();

   public ECPoint twicePlus(ECPoint b) {
      return this.twice().add(b);
   }
}
