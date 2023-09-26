package wordcount;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordExtractor {
    public List<String> getWords(String text) {
        if (text == null || text.isBlank()) {
            return List.of();
        }
        var matcher = getWordPattern(text);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    private static Matcher getWordPattern(String text) {
        var pattern = Pattern.compile("\\w+");
        return pattern.matcher(text);
    }
}
