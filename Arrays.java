// 
// Decompiled by Procyon v0.5.36
// 

final class Arrays
{
    public static byte[] clone(final byte[] data) {
        if (data == null) {
            return null;
        }
        final byte[] copy = new byte[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);
        return copy;
    }
}
