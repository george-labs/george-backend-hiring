import java.util.Arrays;

public class WordUtil {

    private static final String VALID_PATTERN = "[a-zA-Z]+";
    private static final String SEPARATOR = " ";

    private WordUtil() {

    }

    public static long getWordsCount(String text) {
        String[] splitText = text.split(SEPARATOR);
        return Arrays
                .stream(splitText)
                .filter(word -> word.matches(VALID_PATTERN))
                .count();
    }

}
