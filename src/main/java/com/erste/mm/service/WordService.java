package com.erste.mm.service;

import com.erste.mm.component.FileReader;
import com.erste.mm.model.Word;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordService {

    static List<Word> countWords(List<String> input) {
        return input.stream()
                .flatMap(q -> Stream.of(q.split(" ")))
                .map(Word::new)
                .filter(Word::isLetteredWord)
                .toList();
    }

    static List<Word> countWords(String input) {
        return countWords(Arrays.asList(input.split(" ")));
    }

    public static long countWordsWithoutStoppedWords(List<String> stringWords, String stopWordsFileName) {
        String string = stringWords.stream()
                .collect(Collectors.joining(" "));

        return countWordsWithoutStoppedWords(string, stopWordsFileName);
    }

    public static long countWordsWithoutStoppedWords(String wordsInput, String stopWordsFileName) {
        List<Word> words = countWords(wordsInput);
        List<String> stopWords = FileReader.readBuildInStopWords(stopWordsFileName);

        return countOnlyNonStoppedWords(words, stopWords);
    }

    static long countOnlyNonStoppedWords(List<Word> words, List<String> stoppedWords) {
        return words.stream()
                .filter(q -> !stoppedWords.contains(q.getTextualWord()))
                .count();
    }

}
