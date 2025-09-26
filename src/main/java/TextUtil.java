import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class TextUtil {

    private final static String REGEX_PATTERN = "[^a-zA-Z]+";


    public TextUtil() {
    }

    public static List<String> getTrimmedAndSplitedWords(String input) {

        if (input == null) {
            return new ArrayList<>();
        }

        return Arrays
            .stream(trimAndSplitWord(input))
            .collect(Collectors.toList());
    }

    public static String[] trimAndSplitWord(String inputText) {
        return inputText.trim().toLowerCase().split(REGEX_PATTERN);
    }
}
