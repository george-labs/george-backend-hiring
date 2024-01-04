package com.example.utils.predicates;

import java.util.List;
import java.util.function.Predicate;

public class IsStopWord implements Predicate<String> {
    protected List<String> stopWords;

    public IsStopWord(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public boolean test(String word) {
        return stopWords.contains(word);
    }
}
