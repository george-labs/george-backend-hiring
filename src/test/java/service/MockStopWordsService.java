package service;

import utils.MockTextFileReader;

import java.util.Set;

public class MockStopWordsService extends StopWordsService {

    public MockStopWordsService() {
        super(new MockTextFileReader(""));
    }

    @Override
    public Set<String> getStopWords(String stopWordsFile) {
        return Set.of("a", "the", "on");
    }
}
