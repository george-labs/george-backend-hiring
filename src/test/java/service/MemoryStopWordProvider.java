package service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MemoryStopWordProvider implements IStopWordProvider {
    private final Set<String> stopWords;

    public MemoryStopWordProvider(String... words) {
        stopWords = new HashSet<>(Arrays.asList(words));
    }

    @Override
    public Set<String> getStopWords() {
        return stopWords;
    }
}
