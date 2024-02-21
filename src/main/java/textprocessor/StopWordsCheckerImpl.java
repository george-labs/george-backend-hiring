package textprocessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class StopWordsCheckerImpl implements StopWordsChecker {
    private String stopWordsFilePath;

    private Set<String> stopWords = null;

    public StopWordsCheckerImpl(String stopWordsFilePath) {
        this.stopWordsFilePath = stopWordsFilePath;
    }

    @Override
    public boolean isStopWord(String word) {
        try {
            if (stopWords == null) {
                readStopWords();
            }

            return stopWords.contains(word);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readStopWords() throws IOException {
        stopWords = new HashSet<>(Files.readAllLines(Paths.get(stopWordsFilePath)));
    }
}
