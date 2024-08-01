package com.george.interview.counter.model;

import java.util.Set;

public record CountResult(int wordCount, int uniqueWords,
                          double avgWordLength, Set<String> indexedWords) {

}
