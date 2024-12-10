package com.erste.mm.service;

import com.erste.mm.component.FileReader;
import com.erste.mm.model.UniqueCount;
import com.erste.mm.model.Word;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordService {

    static List<Word> filterWords(List<String> input) {
        return input.stream()
                .flatMap(q -> Stream.of(q.split(" "))
                        .flatMap(p -> Stream.of(p.split("-")))
                )
                .map(Word::new)
                .filter(Word::isLetteredWord)
                .toList();
    }

    static List<Word> filterWords(String input) {
        return filterWords(Arrays.asList(input.split(" ")));
    }

    public static UniqueCount countWordsWithoutStoppedWords(List<String> stringWords, String stopWordsFileName) {
        String string = stringWords.stream()
                .collect(Collectors.joining(" "));

        return countWordsWithoutStoppedWords(string, stopWordsFileName);
    }

    public static UniqueCount countWordsWithoutStoppedWords(String wordsInput, String stopWordsFileName) {
        List<Word> words = filterWords(wordsInput);
        List<String> stopWords = FileReader.readBuildInStopWords(stopWordsFileName);

        return countOnlyNonStoppedWords(words, stopWords);
    }

    static UniqueCount countOnlyNonStoppedWords(List<Word> words, List<String> stoppedWords) {
        List<Word> list = words.stream()
                .filter(q -> !stoppedWords.contains(q.getTextualWord()))
                .toList();

        long uniqueCount = list.stream()
                .distinct()
                .count();

        return new UniqueCount(list.size(), uniqueCount);
    }

}
