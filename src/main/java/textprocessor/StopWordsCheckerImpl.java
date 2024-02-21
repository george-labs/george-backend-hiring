package textprocessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class StopWordsCheckerImpl implements StopWordsChecker {
    private String stopWordsFilePath;

    private Set<String> stopWords = null;

    public StopWordsCheckerImpl(String stopWordsFilePath) {
        this.stopWordsFilePath = stopWordsFilePath;
    }

    @Override
    public boolean isStopWord(String word) {
        try {
            if (word == null) {
                return false;
            }

            if (stopWords == null) {
                readStopWords();
            }

            return stopWords.contains(word.toLowerCase());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readStopWords() throws IOException {
        stopWords = Files.readAllLines(Paths.get(stopWordsFilePath)).stream().map(String::toLowerCase).collect(toSet());
    }
}
