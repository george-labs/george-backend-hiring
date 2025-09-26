import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WordCountService implements WordCount {

    private final FileReader fileReader;

    public WordCountService(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public int countWords(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] words = splitAndTrimInput(input);

        Set<String> stopWords;

        try {
            stopWords = fileReader.getStopWords();
        } catch (Exception exception) {
            stopWords = new HashSet<>();
        }

        return countWordsWithoutStopWords(words, stopWords);
    }

    private int countWordsWithoutStopWords(String[] words, Set<String> stopWords) {

        return (int) Arrays.stream(words)
            .filter(Objects::nonNull)
            .filter(word -> !word.isEmpty())
            .filter(word -> !stopWords.contains(word))
            .count();
    }

    private String[] splitAndTrimInput(String input) {
        return input.trim().toLowerCase().split("[^a-zA-Z]+");
    }
}
