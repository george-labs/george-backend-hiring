import java.io.*;
import java.util.Arrays;
import java.util.List;

public class WordCount {
    private static WordCount INSTANCE = null;
    private final static String WORD_LETTER_PATTERN = "[a-zA-Z]+";
    private final static String WHITESPACE_PATTERN = "\\s+";
    private final static String STOPWORDS_FILENAME = "stopwords.txt";

    private WordCount() {
    }

    public static synchronized WordCount getInstance() {
        if (INSTANCE == null) INSTANCE = new WordCount();
        return INSTANCE;
    }

    private boolean containsOnlyLetters(String[] wordArray) {
        return Arrays.stream(wordArray).allMatch(word -> word.matches(WORD_LETTER_PATTERN));
    }

    public long countText(String text) {
        if (text.isEmpty()) return 0;
        String[] wordArray = text.split(WHITESPACE_PATTERN);
        if (!containsOnlyLetters(wordArray)) {
            throw new IllegalArgumentException("Text containing non allowed characters");
        }
        try {
            List<String> stopWords = WordFileReader.loadFileIntoList(STOPWORDS_FILENAME);
            return Arrays.stream(wordArray).filter(word -> !stopWords.contains(word)).count();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage() + STOPWORDS_FILENAME);
        }
        return wordArray.length;
    }
}
