package wordcount.counterofwords;

import wordcount.CounterOfWords;

import java.util.Arrays;
import java.util.List;

public class CounterOfWordsImpl implements CounterOfWords {

    List<String> stopWords;

    public CounterOfWordsImpl(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public Long count(String input) {
        return Arrays.stream(input.split("[^a-z,A-Z]"))
                .filter(w -> !stopWords.contains(w))
                .count();
    }
}
