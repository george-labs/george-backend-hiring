package counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {
    private final String REGEX = "[^a-zA-Z]+";

    private long numberOfUniqueWords;
    private long numberOfWords;

    private Set<String> stopWords;

    public WordCounter() {
        this.stopWords = new HashSet<>();
    }

    public String getREGEX() {
        return REGEX;
    }

    public long getNumberOfUniqueWords() {
        return numberOfUniqueWords;
    }

    public long getNumberOfWords() {
        return numberOfWords;
    }

    public Set<String> getStopWords() {
        return stopWords;
    }

    public void countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            numberOfWords = 0;
            return;
        }
        String[] words = text.split("\\s+");
        // count the number of words
        List<String> filteredWords = Arrays.stream(words)
                .filter(word -> !word.matches(REGEX) &&  !stopWords.contains(word.toLowerCase()))
                .collect(Collectors.toList());

        // Count the unique words
        numberOfUniqueWords = filteredWords
                .stream()
                .distinct()
                .count();
        numberOfWords = filteredWords.size();

        System.out.println("Number of words: " + numberOfWords + " unique: " + numberOfUniqueWords);

    }

    public void loadStopWords() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("stopwords.txt");
        if (is == null) {
            throw new IOException("Stopwords file not found");
        }
        Stream<String> stream = new BufferedReader(new InputStreamReader(is)).lines();
        stopWords = stream
                .map(String::trim)
                .collect(Collectors.toSet());
    }

}
