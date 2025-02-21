package sk.erste.wordcountkata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StopWordFilter {
    private final static String STOP_WORDS_DIR = "stopwords";

    private final List<String> stopWords = new ArrayList<>();

    public StopWordFilter(String filename) throws IllegalArgumentException {
        try {
            File file = new File(STOP_WORDS_DIR, filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (!data.isEmpty()) {
                    stopWords.add(data);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found: " + filename);
        }
    }

    public List<String> getStopWords() {
        return stopWords;
    }

    public boolean isStopWord(String word) {
        return stopWords.contains(word);
    }
}
