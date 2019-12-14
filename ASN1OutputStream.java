
import java.io.IOException;
import java.io.OutputStream;

/**
 * Stream that produces output based on the default encoding for the passed in objects.
 */
class ASN1OutputStream
{
    private final OutputStream os;

    public ASN1OutputStream(
            OutputStream    os)
    {
        this.os = os;
    }

    void writeLength(
            int length)
            throws Exception
    {
        if (length > 127)
        {
            int size = 1;
            int val = length;

            while ((val >>>= 8) != 0)
            {
                size++;
            }

            write((byte)(size | 0x80));

            for (int i = (size - 1) * 8; i >= 0; i -= 8)
            {
                write((byte)(length >> i));
            }
        }
        else
        {
            write((byte)length);
        }
    }

    void write(int b)
            throws Exception
    {
        os.write(b);
    }

    void write(byte[] bytes)
            throws Exception
    {
        os.write(bytes);
    }

    void writeEncoded(
            int     tag,
            byte[]  bytes)
            throws Exception
    {
        write(tag);
        writeLength(bytes.length);
        write(bytes);
    }

    public void writeObject(
            ASN1Encodable obj)
            throws Exception
    {
        if (obj != null)
        {
            obj.toASN1Primitive().encode(this);
        }
        else
        {
            throw new IOException("null object detected");
        }
    }

    ASN1OutputStream getDERSubStream()
    {
        return new DEROutputStream(os);
    }

    ASN1OutputStream getDLSubStream()
    {
        return new DLOutputStream(os);
    }

}
