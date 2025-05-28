package service;

import utils.MockTextFileReader;

import java.util.Set;

public class MockNullStopWordsService extends StopWordsService {

    public MockNullStopWordsService() {
        super(new MockTextFileReader(""));
    }

    @Override
    public Set<String> getStopWords(String stopWordsFile) {
        return null;
    }
}
