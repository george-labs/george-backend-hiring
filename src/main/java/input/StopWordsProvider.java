package input;

import java.nio.file.NoSuchFileException;
import java.util.Set;

public interface StopWordsProvider {

    Set<String> getStopWords(String filename) throws NoSuchFileException;

}
