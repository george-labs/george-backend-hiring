import java.util.Arrays;

public class WordCounter {
    public static int countWords(String text) {
        return (int)Arrays.stream(text.split("\\s"))
                .filter(WordCounter::isValidWord)
                .count();
    }

    private static boolean isValidWord(String word) {
        return word.matches("[a-zA-Z]+");
    }
}
