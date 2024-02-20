import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordCounter {

    public long countWords(String someText) {
        List<String> stopWords = getStopWords();
        long count = 0;
        String[] words = someText.split("[\\s\\.,]");
        for (String word : words) {
            if (!stopWords.contains(word) && word.matches("[a-zA-Z]+")) {
                count++;
            }
        }
        return count;
    }

    public List<String> getStopWords() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("stopwords.txt");
        try {
            String text = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            return Arrays.asList(text.split("\\s"));
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
