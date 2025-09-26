import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WordCountService implements WordCount {

    private static final String STOP_WORDS_FILE_NAME = "stopwords.txt";
    private final FileReader fileReader;

    public WordCountService(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public int countWords(List<String> inputWords) {

        if (inputWords == null || inputWords.isEmpty()) {
            return 0;
        }

        List<String> stopWords;

        try {
            stopWords = fileReader.getWordsFromFile(STOP_WORDS_FILE_NAME);
        } catch (Exception exception) {
            stopWords = new ArrayList<>();
        }

        return countWordsWithoutStopWords(inputWords, stopWords);
    }

    private int countWordsWithoutStopWords(List<String> words, List<String> stopWords) {

        return (int) words.stream()
            .filter(Objects::nonNull)
            .filter(word -> !word.isEmpty())
            .filter(word -> !stopWords.contains(word))
            .count();
    }
}
