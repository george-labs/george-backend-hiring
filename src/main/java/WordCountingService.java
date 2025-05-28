import java.util.Arrays;

public class WordCountingService {

    public long countWords(String text) {
        if(text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        var words = text.split("\\s+");
        return Arrays.stream(words).filter(word -> word.matches("[a-zA-Z]+")).count();
    }

}
