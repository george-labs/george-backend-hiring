package input;

import java.io.IOException;
import java.util.Collection;

public interface WordsProvider {

    Collection<String> getWords(String fileName) throws IOException;
}
