package wordcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WordCounter {

    public long countWords(String text) {
        List<String> words = splitText(text);
        return words.stream()
                .filter(this::isValidWord)
                .count();
    }

    private List<String> splitText(String text) {
        String[] words = text.split("[\\s.?!,]+");
        return List.of(words);
    }

    private boolean isValidWord(String word) {
        List<String> stopWords = getStopWords();
        return word.matches("[a-zA-Z]+") && !stopWords.contains(word);
    }

    private List<String> getStopWords() {
        Path path = Paths.get("stopwords.txt");
        try {
            return Files.readAllLines(path);
        } catch (IOException ex) {
            throw new RuntimeException("Error reading stopwords.txt");
        }
    }

}
