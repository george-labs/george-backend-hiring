package wordcount;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter {
    public int countNumberOfWords(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        var pattern = Pattern.compile("\\w+");
        var matcher = pattern.matcher(input);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words.size();
    }
}
