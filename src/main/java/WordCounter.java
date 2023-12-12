import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private static final String REGEX = "[a-zA-Z]";
    private static final String WORD_DELIMITER = " ";
    private static Pattern pattern = Pattern.compile(REGEX);

    public int count(String sentence) {
        String[] words = splitSentence(sentence);

        Matcher matcher = pattern.matcher(sentence);

    }

    private String[] splitSentence(String sentence) {
        return sentence.split(WORD_DELIMITER);
    }


}
