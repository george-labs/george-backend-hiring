package processor;

import java.util.Set;

public interface StopWordsProvider {

    void init(final String stopWordsResourcePath);

    Set<String> getStopWords();
}
