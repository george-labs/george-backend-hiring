package stopwords;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordsReaderImpl implements StopWordsReader {

    private final StopWordsReaderConfiguration stopWordsReaderConfiguration;

    public StopWordsReaderImpl(final StopWordsReaderConfiguration stopWordsReaderConfiguration) {
        this.stopWordsReaderConfiguration = stopWordsReaderConfiguration;
    }

    @Override
    public Set<String> getStopWordsList() {
        final URL stopWordsResourceUrl = getStopWordsResourceUrl();

        try {
            final File stopWordsFile = new File(stopWordsResourceUrl.toURI());

            final List<String> stopWords = Files.readAllLines(stopWordsFile.toPath(), StandardCharsets.UTF_8);

            return stopWords
                    .stream()
                    .collect(Collectors.toUnmodifiableSet());
        } catch (IOException | URISyntaxException e) {

            throw new StopWordsException("There was an error while reading the black list file", e);
        }
    }

    private URL getStopWordsResourceUrl() {
        final String stopWordsFileName = stopWordsReaderConfiguration.getStopWordsFileName();

        final ClassLoader classLoader = getClass().getClassLoader();
        final URL resource = classLoader.getResource(stopWordsFileName);

        if (resource == null) {
            throw new StopWordsException(String.format("File '%s' not found", stopWordsFileName));
        }

        return resource;
    }
}
