package com.erste.mm.service;

import com.erste.mm.component.StopWordsReader;
import com.erste.mm.model.Word;

import java.util.Arrays;
import java.util.List;

public class WordService {

    public static List<Word> countWords(String input) {
        return Arrays.stream(input.split(" "))
                .map(Word::new)
                .filter(Word::isLetteredWord)
                .toList();
    }

    public static long countWordsCount(String wordsInput, String stopWordsFileName) {
        List<Word> words = countWords(wordsInput);
        List<String> stopWords = StopWordsReader.readStopWords(stopWordsFileName);

        return countOnlyNonStoppedWords(words, stopWords);
    }

    public static long countOnlyNonStoppedWords(List<Word> words, List<String> stoppedWords) {
        return words.stream()
                .filter(q -> !stoppedWords.contains(q.getTextualWord()))
                .count();
    }

}
