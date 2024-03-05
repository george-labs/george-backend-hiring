package bl.providers;

import java.util.Set;

public class StopWordsMockProvider implements StopWordsProvider {

    private final Set<String> words;

    public StopWordsMockProvider(Set<String> words) {
        this.words = words;
    }

    @Override
    public Set<String> getStopWords() {
        return words;
    }
}
