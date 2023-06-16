package process;

import exception.IterationException;
import model.WordCountModel;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter implements Counter {

    private WordFilter wordFilter;

    public WordCounter(WordFilter wordFilter) {
        this.wordFilter = wordFilter;
    }

    @Override
    public WordCountModel count() throws IOException, IterationException {
        Stream<String> filteredStreams = wordFilter.filter();
        List<String> filteredWords = filteredStreams.collect(Collectors.toList());

        int uniqueWordsCount = new HashSet<>(filteredWords)
                .size();

        return new WordCountModel(filteredWords.size(), uniqueWordsCount);
    }

}
