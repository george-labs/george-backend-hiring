package input;

import java.io.Closeable;

public interface InputSource extends Closeable {
    String getInput();
}
