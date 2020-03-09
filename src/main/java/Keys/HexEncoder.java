package Keys;

import java.io.IOException;
import java.io.OutputStream;

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
        for (int i = 0; i < decodingTable.length; ++i) {
            decodingTable[i] = (byte) 0xff;
        }

        for (int i = 0; i < encodingTable.length; ++i) {
            decodingTable[encodingTable[i]] = (byte) i;
        }

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
        extracted0(data, out, extracted9(data, data.length()));
    }

	private int extracted9(String data, int end) {
		for (char c = data.charAt(end - 1); end > 0; --end) {
			if (c != '\n' && c != '\r' && c != '\t' && c != ' ') {
				break;
			}
		}
		return end;
	}

	private void extracted0(String data, OutputStream out, int end) throws IOException {
		byte b1, b2;
		for (int i = 0; i < end; ) {
            b1 = decodingTable[data.charAt(i++)];
            b2 = decodingTable[data.charAt(i++)];
            out.write(b2 | (b1 << 4));
        }
	}
}
