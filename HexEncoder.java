import java.io.OutputStream;

// 
// Decompiled by Procyon v0.5.36
// 

public class HexEncoder
{
    private final byte[] encodingTable;
    private final byte[] decodingTable;
    
    private void initialiseDecodingTable() {
        for (int i = 0; i < this.decodingTable.length; ++i) {
            this.decodingTable[i] = -1;
        }
        for (int i = 0; i < this.encodingTable.length; ++i) {
            this.decodingTable[this.encodingTable[i]] = (byte)i;
        }
        this.decodingTable[65] = this.decodingTable[97];
        this.decodingTable[66] = this.decodingTable[98];
        this.decodingTable[67] = this.decodingTable[99];
        this.decodingTable[68] = this.decodingTable[100];
        this.decodingTable[69] = this.decodingTable[101];
        this.decodingTable[70] = this.decodingTable[102];
    }
    
    public HexEncoder() {
        this.encodingTable = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
        this.decodingTable = new byte[128];
        this.initialiseDecodingTable();
    }
    
    private static boolean ignore(final char c) {
        return c == '\n' || c == '\r' || c == '\t' || c == ' ';
    }
    
    public void decode(final String data, final OutputStream out) throws Exception {
        int end = data.length();
        int i = 0;
        while (i < end) {
            while (i < end && ignore(data.charAt(i))) {
                ++i;
            }
            byte b1 = this.decodingTable[data.charAt(i++)];
            final byte b2 = this.decodingTable[data.charAt(i++)];
            out.write(b1 << 4 | b2);
        }
    }
}
