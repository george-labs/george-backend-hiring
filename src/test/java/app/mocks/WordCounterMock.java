package app.mocks;

import app.WordCounter;

public class WordCounterMock implements WordCounter {

    private final long result;

    public WordCounterMock(long result) {
        this.result = result;
    }

    @Override
    public long countWords(String inputString) {
        return result;
    }

}
