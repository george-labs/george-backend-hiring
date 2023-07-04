import java.util.Arrays;
import java.util.List;

public class Sentence implements SentenceWordsCounting {

    StopWords stopWords;

    public Sentence(StopWords stopWords) {
        this.stopWords = stopWords;
    }

    public static final String EMPTY_SPACES_REGEX = "\\s+";
    private static final String LETTER_REGEX = "^[a-zA-Z]*$";

    @Override
    public long countingWordsOnlyLetter(String sentence) {
        return Arrays.stream(sentence.split(EMPTY_SPACES_REGEX))
                .filter(word -> word.matches(LETTER_REGEX)
                        && !word.equals("")
                        && !stopWords.getStopWords().contains(word))
                .count();
    }
}
