import java.io.IOException;

public interface ASN1SetParser extends ASN1Encodable {
   ASN1Primitive getLoadedObject() throws IOException;
}
