package process;

import read.Reader;

import java.io.IOException;
import java.util.stream.Stream;

public class WordCounter implements Counter {

    private WordFilter wordFilter;

    public WordCounter(WordFilter wordFilter) {
        this.wordFilter = wordFilter;
    }

    @Override
    public int count() throws IOException {
        Stream<String> filter = wordFilter.filter();

        return (int) filter.count();
    }

}
