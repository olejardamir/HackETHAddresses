package Keys;

import java.io.OutputStream;

//checkpoint clean
class HexEncoder {
    private final byte[] encodingTable =
            {
                    (byte) '0', (byte) '1', (byte) '2', (byte) '3', (byte) '4', (byte) '5', (byte) '6', (byte) '7',
                    (byte) '8', (byte) '9', (byte) 'a', (byte) 'b', (byte) 'c', (byte) 'd', (byte) 'e', (byte) 'f'
            };


    private final byte[] decodingTable = new byte[128];

    HexEncoder() {
        initialiseDecodingTable();
    }

    private void initialiseDecodingTable() {
        for (int i = 0; i < decodingTable.length; ++i)
            decodingTable[i] = (byte) 0xff;

        for (int i = 0; i < encodingTable.length; ++i)
            decodingTable[encodingTable[i]] = (byte) i;

        decodingTable['A'] = decodingTable['a'];
        decodingTable['B'] = decodingTable['b'];
        decodingTable['C'] = decodingTable['c'];
        decodingTable['D'] = decodingTable['d'];
        decodingTable['E'] = decodingTable['e'];
        decodingTable['F'] = decodingTable['f'];
    }

    void decode(
            String data,
            OutputStream out)
            throws Exception {
        byte b1, b2;

        int end = data.length();

        char c = data.charAt(end - 1);
        for (; end > 0; --end)
            if (!(c == '\n' || c == '\r' || c == '\t' || c == ' '))
                break;

        for (int i = 0; i < end; ) {
            char c1 = data.charAt(i);
            while (i < end && (c1 == '\n' || c1 == '\r' || c1 == '\t' || c1 == ' '))
                ++i;
            b1 = decodingTable[data.charAt(i++)];
            c = data.charAt(i);
            while (i < end && (c == '\n' || c == '\r' || c == '\t' || c == ' '))
                ++i;
            b2 = decodingTable[data.charAt(i++)];
            out.write(b2 | b1 << 4);
        }

    }
}
