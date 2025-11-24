package counter.filter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

/**
 * Checks if words allowed are based on file on disk.
 */
public class FileStopWordsFilter implements StopWordsFilter {

    private final Path stopWordsFile;
    private List<String> stopWords;

    public FileStopWordsFilter(final Path stopWordsFile) {
        this.stopWordsFile = stopWordsFile;
        initialize();
    }

    private void initialize() {
        try (Stream<String> lines = Files.lines(stopWordsFile)) {
            stopWords = lines.toList();
        } catch (IOException e) {
            System.err.println("Could not read file with stop words" + e.getMessage());
            //log.error("Could not read file with stop words", e);
            throw new IllegalArgumentException("Could not read file", e);
        }
    }

    @Override
    public boolean isAllowed(String word) {
        if (word == null || word.isEmpty()) {
            return true;
        }
        return !stopWords.contains(word.toLowerCase());
    }
}
