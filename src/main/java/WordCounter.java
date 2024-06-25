import java.util.Arrays;
import java.util.regex.Pattern;

public class WordCounter {

    public long countWords(String input) {

        var pattern = Pattern.compile("[a-zA-Z]+");

        return Arrays.stream(splitInput(input))
                .filter(item -> pattern.matcher(item).matches())
                .count();
    }

    private String[] splitInput(String inputStr) {
        return inputStr.split("\\s+");
    }
}
