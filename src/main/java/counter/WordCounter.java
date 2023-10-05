package counter;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {

    private final Set<String> stopWords;

    public WordCounter(String stopWordsString) {
        this.stopWords = Arrays.stream(stopWordsString.split(",")).collect(Collectors.toSet());
    }

    public CounterResult process(String input) {
        List<String> filteredWords = this.filterWords(input);
        int numberOfWords = filteredWords.size();

        Set<String> uniqueWords = new HashSet<>(filteredWords);
        int numberOfUniqueWords = uniqueWords.size();

        double averageWordLength = filteredWords.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);

        return new CounterResult(filteredWords, numberOfWords, numberOfUniqueWords, averageWordLength);
    }

    private List<String> filterWords(String input) {
        List<String> words = Arrays.stream(input.split("\\s"))
                .sorted((word1, word2) -> word2.toLowerCase().compareTo(word1.toLowerCase()))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return words.stream()
                .filter(word -> Pattern.matches("^[a-zA-Z-]+[.!,]?$", word))
                .filter(word -> !stopWords.contains(word))
                .collect(Collectors.toList());
    }
}
