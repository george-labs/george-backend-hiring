package counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {
    private Set<String> stopWords;

    public WordCounter() {
        this.stopWords = new HashSet<>();
    }

    public int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");

        return (int) Arrays.stream(words)
                .filter(word -> word.matches("[a-zA-z]+") && !stopWords.contains(word.toLowerCase()))
                .count();
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
