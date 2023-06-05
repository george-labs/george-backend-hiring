import java.util.List;
import java.util.regex.Pattern;

public class WordCounter {

    private final static String REGEX = "[a-zA-Z]+";

    public WordCounter() {
    }

    public int getCountOfWords(String input, List<String> stopWords) {

        if (input == null || input.isBlank()) {
            return 0;
        }

        int counter = 0;
        Pattern pattern = Pattern.compile(REGEX);

        String[] words = input.split("[\\-.?!\\s]");
        for (String word : words) {
            if (pattern.matcher(word).matches() && !stopWords.contains(word)) {
                counter++;
            }
        }
        return counter;
    }
}
