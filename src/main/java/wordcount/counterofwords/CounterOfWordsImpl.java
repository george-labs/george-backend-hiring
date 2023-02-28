package wordcount.counterofwords;

import wordcount.CounterOfWords;

public class CounterOfWordsImpl implements CounterOfWords {

    @Override
    public Integer count(String input) {
        return input.split("[^a-z,A-Z]").length;
    }
}
