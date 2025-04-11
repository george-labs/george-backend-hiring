package service.counter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter implements Counter {

    @Override
    public long countWords(String text) {
        // This should already be checked
        if (text == null || text.isBlank()) {
           return 0;
        }

        // Create desired pattern to match each word
        Pattern pattern = Pattern.compile("[a-zA-Z]+");

        // Split array by each word
        List<String> textList = Arrays.asList(text.split(" "));

        // Return count for applied pattern
        return textList.stream().filter(word -> pattern.matcher(word).matches()).count();
    }
}
