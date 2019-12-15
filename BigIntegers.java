import java.math.BigInteger;

// 
// Decompiled by Procyon v0.5.36
// 

final class BigIntegers
{
    public static byte[] asUnsignedByteArray(final BigInteger value) {
        return value.toByteArray();
    }
    
    public static BigInteger fromUnsignedByteArray(final byte[] buf, final int off, final int length) {
        byte[] mag = buf;
        if (off != 0 || length != buf.length) {
            mag = new byte[length];
            System.arraycopy(buf, off, mag, 0, length);
        }
        return new BigInteger(1, mag);
    }
}
