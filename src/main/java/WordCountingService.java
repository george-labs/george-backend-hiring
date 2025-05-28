import java.util.Arrays;
import java.util.Set;

public class WordCountingService {

    public long countWords(String text, Set<String> stopWords) {
        if(text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if(stopWords == null) {
            throw new IllegalArgumentException("Stop words cannot be null");
        }

        var words = text.split("\\s+");
        return Arrays.stream(words)
                .filter(word -> word.matches("[a-zA-Z]+"))
                .filter( word -> !stopWords.contains(word.toLowerCase()))
                .count();
    }

}
