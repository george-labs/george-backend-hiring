import java.util.Arrays;
import java.util.regex.Pattern;

public class WordCounter {

    private static final String REGEX = "[a-zA-Z]+";
    private static final String WORD_DELIMITER = " ";
    private static Pattern pattern = Pattern.compile(REGEX);

    public long count(String sentence) {
        String[] words = splitSentence(sentence);
        return countWords(words);
    }

    private static long countWords(String[] words) {
        return Arrays.stream(words)
                .filter(word -> pattern.matcher(word).matches())
                .count();
    }

    private String[] splitSentence(String sentence) {
        return sentence.split(WORD_DELIMITER);
    }
}
