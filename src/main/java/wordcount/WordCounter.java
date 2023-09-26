package wordcount;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordCounter {
    private final Set<String> stopWords;

    public WordCounter() {
        stopWords = Set.of();
    }

    public WordCounter(List<String> stopWords) {
        this.stopWords = new HashSet<>(stopWords);
    }

    public int countNumberOfWords(Collection<String> words) {
        if (words == null) {
            return 0;
        }
        int count = 0;
        for (String word : words) {
            if (! stopWords.contains(word)) {
                count++;
            }
        }
        return count;
    }
}
