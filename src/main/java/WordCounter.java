import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class WordCounter {

    private final static String REGEX = "[\\-a-zA-Z]+";

    public WordCounter() {
    }

    public WordCountInfo getWordCountInfo(String input, List<String> stopWords) {

        if (input == null || input.isBlank()) {
            return new WordCountInfo(0, 0, 0);
        }

        int counter = 0;
        int totalLength = 0;
        Set<String> uniqueWords = new HashSet<>();
        Pattern pattern = Pattern.compile(REGEX);

        String[] words = input.split("[.?!\\s]");
        for (String word : words) {
            if (pattern.matcher(word).matches() && !stopWords.contains(word)) {
                counter++;
                uniqueWords.add(word);
                totalLength += word.length();
            }
        }
        double averageLength = (double) totalLength/counter;
        return new WordCountInfo(counter, uniqueWords.size(), averageLength);
    }
}
