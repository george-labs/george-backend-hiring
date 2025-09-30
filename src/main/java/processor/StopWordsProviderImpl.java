package processor;

import exception.StopWordsProviderException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static utils.Constants.STOP_WORDS_PROVIDER_EXCEPTION_MSG;

public class StopWordsProviderImpl implements StopWordsProvider {

    private Set<String> skipWords = new HashSet<>();

    public void init(final String stopWordsResourcePath) {
        skipWords = new String(readResource(stopWordsResourcePath))
                .lines()
                .collect(Collectors.toSet());
    }

    private byte[] readResource(final String name) {
        try {
            return this.getClass().getResourceAsStream(name).readAllBytes();
        } catch (Exception ex) {
            throw new StopWordsProviderException(STOP_WORDS_PROVIDER_EXCEPTION_MSG, ex);
        }
    }

    public Set<String> getStopWords() {
        return skipWords;
    }

}
