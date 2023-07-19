import java.util.Arrays;

public class WordCounter {

    public long countWords(String input) {
        if (input == null) {
            return 0;
        }

        String[] words = input.split("\\s");
        return Arrays.stream(words)
                .filter(s -> !s.equals(""))
                .filter(s -> s.matches("\\b[a-zA-Z]*\\b"))
                .count();
    }
}
