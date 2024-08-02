package service;

import dto.WordsNumbersDto;

import java.util.*;

public class WordsCounter {

    private final String ENGLISH_WORD_REGEXP = "^[A-Za-z]+(?:[-'][A-Za-z]+)*[.?!]?$";

    public WordsCounter() {
    }

    public WordsNumbersDto countWords(String text) {
        return countWords(text, List.of());
    }

    public WordsNumbersDto countWords(String text, List<String> stoppedWords) {
        List<String> words = prepareWords(text, stoppedWords);

        WordsNumbersDto wordsNumbersDto = new WordsNumbersDto();
        wordsNumbersDto.setNumberOfWords(words.size());

        Set<String> uniqueWords = new HashSet<>(words);
        wordsNumbersDto.setUniqueNumberOfWords(uniqueWords.size());

        wordsNumbersDto.setAverageLength(countAverageNumberOfLength(words));

        return wordsNumbersDto;
    }

    private double countAverageNumberOfLength(List<String> words) {
        return words.stream()
                .mapToDouble(String::length)
                .average()
                .orElse(0);
    }

    private List<String> prepareWords(String text, List<String> stoppedWords) {
        if (text == null || text.isBlank()) {
            return List.of();
        }
        String[] words = text.split("\\s+");

        List<String> convertedWordsToLowerCase = convertStoppedWordsToLowerCase(stoppedWords);

        return Arrays.stream(words)
                .filter(word -> isAWord(word) && !isStoppedWord(convertedWordsToLowerCase, word))
                .toList();
    }

    private List<String> convertStoppedWordsToLowerCase(List<String> stoppedWords) {
        List<String> convertedWordsToLowerCase;
        if (stoppedWords != null) {
            convertedWordsToLowerCase = stoppedWords.stream().map(String::toLowerCase).toList();
        } else {
            convertedWordsToLowerCase = null;
        }
        return convertedWordsToLowerCase;
    }

    private boolean isAWord(String word) {
        return word.matches(ENGLISH_WORD_REGEXP);
    }

    private boolean isStoppedWord(List<String> stoppedWords, String word) {
        return stoppedWords != null && stoppedWords.contains(word.toLowerCase());
    }

}
