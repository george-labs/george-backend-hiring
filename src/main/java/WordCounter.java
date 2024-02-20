import java.util.Arrays;

public class WordCounter {

    public long countWords(String someText) {
        long count = 0;
        String[] words = someText.split("[\\s\\.,]");
        for (String word : words) {
            if (word.matches("[a-zA-Z]+")) {
                count++;
            }
        }

        return count;
    }

}
