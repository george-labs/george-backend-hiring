package input;

import java.io.IOException;
import java.util.Set;

public interface StopWordsProvider {

    Set<String> getStopWords(String fileName) throws IOException;
}
