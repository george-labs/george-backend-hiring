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
                .flatMap(q -> Stream.of(q.split(" ")))
                .map(Word::new)
                .filter(Word::isLetteredWord)
                .toList();
    }

    static List<Word> filterWords(String input) {
        return filterWords(Arrays.asList(input.split(" ")));
    }

    public static UniqueCount countWordsWithoutStoppedWords(List<String> stringWords, String stopWordsFileName) {
        String string = String.join(" ", stringWords);

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
                .sorted()
                .toList();

        long uniqueCount = countDistinctWords(list);
        double averageLength = countAverageLength(list);

        List<String> stringWords = list.stream()
                .map(Word::getTextualWord)
                .toList();

        return new UniqueCount(list.size(), uniqueCount, averageLength, stringWords);
    }

    static long countDistinctWords(List<Word> words) {
        return words.stream()
                .distinct()
                .count();
    }

    static double countAverageLength(List<Word> words) {
        return words.stream()
                .map(Word::getTextualWord)
                .map(String::length)
                .mapToDouble(q -> q)
                .average()
                .orElseThrow();
    }

}
