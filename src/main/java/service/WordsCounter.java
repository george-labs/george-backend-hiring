package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordsCounter {

    public WordsCounter() {
    }

    public long countWords(String text) {
        return countWords(text, List.of());
    }

    public long countWords(String text, List<String> stoppedWords) {
        List<String> words = prepareWords(text, stoppedWords);
        return words.stream().count();
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
        return word.matches("[a-zA-Z]+");
    }

    private boolean isStoppedWord(List<String> stoppedWords, String word) {
        return stoppedWords != null && stoppedWords.contains(word.toLowerCase());
    }

}
