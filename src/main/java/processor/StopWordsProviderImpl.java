package processor;

import exception.ApplicationException;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static utils.Constants.STOPWORDS_RESOURCE_PATH;

public class StopWordsProviderImpl implements StopWordsProvider {

    private Set<String> skipWords = new HashSet<>();

    public void init() {
        skipWords = new String(readResource(STOPWORDS_RESOURCE_PATH))
                .lines()
                .collect(Collectors.toSet());
    }

    private byte[] readResource(final String name) {
        try {
            return this.getClass().getResourceAsStream(name).readAllBytes();
        } catch (IOException ex) {
            throw new ApplicationException("Can't read file", ex);
        }
    }

    public Set<String> getStopWords() {
        return skipWords;
    }

}
