import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WordCounter {

    public Counter countWords(String someText) {
        List<String> stopWords = getStopWords();
        Set<String> usedWords = new HashSet<>();
        long count = 0;
        long uniqueCount = 0;
        String[] words = someText.split("[\\s\\.,]");
        for (String word : words) {
            if (!stopWords.contains(word) && word.matches("[a-zA-Z]+")) {
                if (!usedWords.contains(word)) {
                    uniqueCount++;
                    usedWords.add(word);
                }
                count++;
            }
        }
        return new Counter(count, uniqueCount);
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

    public Counter countWordsFromFile(String filename) {
        String text = loadTextFromFile(filename);
        return countWords(text);

    }

    private String loadTextFromFile(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filename);
        try {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

}
