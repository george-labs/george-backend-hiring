import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter {

    private final Pattern allowedCharacters = Pattern.compile("[a-zA-Z]*");

    public long countWords(String input, List<String> ignoredWords) {
        if (input == null) {
            return 0;
        }
        return Arrays.stream(input.split(" "))
                .filter(s -> !s.isEmpty())
                .filter(s -> allowedCharacters.matcher(s).matches())
                .filter(s -> !ignoredWords.contains(s))
                .count();
    }
}
