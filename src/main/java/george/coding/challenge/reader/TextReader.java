package george.coding.challenge.reader;

import java.io.Closeable;
import java.io.IOException;

public interface TextReader extends Closeable {
    String read() throws IOException;
}
