package services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StopWordsService {

    private final Set<String> stopWords;

    public StopWordsService(String stopWordsFilename) {
        this.stopWords = loadStopWords(stopWordsFilename);
    }

    public Set<String> getStopWords() {
        return stopWords;
    }

    /**
     * Loads the stop words from the stopwords file.
     * An assumption is made that the letter case of stopwords is irrelevant.
     * This means that if the file contains the word 'the',
     * then none of the following words will be counted: 'the', 'The', and 'THE'.
     *
     * @param stopWordsFilename the filename of the stop words file
     * @return a set of stop words
     * @throws RuntimeException if an error occurs while loading the stop words
     */
    private Set<String> loadStopWords(String stopWordsFilename) {
        Set<String> stopWordsInternal = new HashSet<>();

        if (stopWordsFilename == null || stopWordsFilename.isEmpty()) {
            return stopWordsInternal;
        }

        try {
            URL stopWordsURL = getClass().getResource(stopWordsFilename);
            if (stopWordsURL != null) {
                Path stopwordsPath = Path.of(stopWordsURL.toURI());
                try (Stream<String> lines = Files.lines(stopwordsPath)) {
                    lines.map(String::toLowerCase)
                            .forEach(stopWordsInternal::add);
                }
            } else {
                System.out.println("No stop words file found.");
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return stopWordsInternal;
    }
}
