package service;

import utils.MockTextFileReader;

import java.util.Collections;
import java.util.Set;

public class MockEmptyStopWordsService extends StopWordsService {

    public MockEmptyStopWordsService() {
        super(new MockTextFileReader(""));
    }

    @Override
    public Set<String> getStopWords(String stopWordsFile) {
        return Collections.emptySet();
    }
}
