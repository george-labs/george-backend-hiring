package process;

import java.io.IOException;
import java.util.stream.Stream;

public interface WordFilter {

    public Stream<String> filter() throws IOException;
}
