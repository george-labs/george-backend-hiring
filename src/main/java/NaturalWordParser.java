import java.util.Arrays;
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

        long uniqueWords = getStreamOfValidWords(possibleWords)
                .distinct()
                .count();

        long allWords = getStreamOfValidWords(possibleWords).count();

        double averageWordLength = getStreamOfValidWords(possibleWords)
                .mapToDouble(w -> (double) w.length())
                .average()
                .orElse(0);

        return new AnalysisResult((int) allWords, (int) uniqueWords, averageWordLength);
    }

    protected boolean validateWord(String word) {
        return word.matches(WORD_DEFINITION);
    }

    private Stream<String> getStreamOfValidWords(String[] possibleWords) {
        return Arrays.stream(possibleWords)
                .filter(this::validateWord);
    }

}
