import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Stream;

public class NaturalWordParser implements WordParser {

    private static final String DELIMITER = " ";
    private static final String WORD_DEFINITION = "[a-zA-Z\\-]+";

    @Override
    public AnalysisResult countWords(String input) {
        if (input == null) {
            throw new IllegalStateException("Input string must not be null");
        }

        String[] possibleWords = input.split(DELIMITER);

        long uniqueWords = Arrays.stream(possibleWords)
                .filter(this::validateWord)
                .distinct()
                .count();

        long allWords = Arrays.stream(possibleWords)
                .filter(this::validateWord)
                .count();

        return new AnalysisResult((int) allWords, (int) uniqueWords);
    }

    protected boolean validateWord(String word) {
        return word.matches(WORD_DEFINITION);
    }
}
