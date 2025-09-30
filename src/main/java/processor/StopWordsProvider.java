package processor;

import java.io.IOException;
import java.util.Set;

public interface StopWordsProvider {

    void init();

    Set<String> getStopWords();
}
