package wordcount;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCounter {
    private final Set<String> stopWords;

    public WordCounter() {
        stopWords = Set.of();
    }

    public WordCounter(List<String> stopWords) {
        this.stopWords = new HashSet<>(stopWords);
    }

    public TextAnalytics countNumberOfWords(Collection<String> words) {
        if (words == null) {
            return new TextAnalytics();
        }
        var filteredWords = getFilteredWords(words);
        int count = filteredWords.size();
        int uniqueCount = new HashSet<>(filteredWords).size();
        return new TextAnalytics(count, uniqueCount);
    }

    public List<String> getFilteredWords(Collection<String> words) {
        return words.stream()
                .filter(word -> ! stopWords.contains(word))
                .collect(Collectors.toList());
    }
}
