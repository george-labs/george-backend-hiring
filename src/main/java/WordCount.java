import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordCount {
    private static WordCount INSTANCE = null;
    private final static String WORD_LETTER_PATTERN = "[a-zA-Z]+";
    private final static String WHITESPACE_PATTERN = "\\s+";
    private final static String STOPWORDS_FILENAME = "stopwords.txt";

    private WordCount() {}

    public static synchronized WordCount getInstance() {
        if (INSTANCE == null) INSTANCE = new WordCount();
        return INSTANCE;
    }

    private boolean containsOnlyLetters(String[] wordArray) {
        for (String word : wordArray) {
            if (!word.matches(WORD_LETTER_PATTERN)) {
                return false;
            }
        }
        return true;
    }

    protected List<String> loadFileIntoList(String filename) {
        List<String> fileItems = new ArrayList<>();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
            if (inputStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = reader.readLine();
                while(line != null) {
                    fileItems.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } else {
                System.out.println("stopwords file not found");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return fileItems;
    }

    public long countText(String text) {
        if(text.isEmpty()) return 0;
        String[] wordArray = text.split(WHITESPACE_PATTERN);
        if(!containsOnlyLetters(wordArray)) {
            throw new IllegalArgumentException("Text containing non allowed characters");
        }
        List<String> stopWords = loadFileIntoList(STOPWORDS_FILENAME);
        return Arrays.stream(wordArray).filter(word -> !stopWords.contains(word)).count();
    }
}
