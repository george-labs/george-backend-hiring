package service;

import java.util.Arrays;
import java.util.List;

public class WordsCounter {

    public WordsCounter() {
    }

    public long countWords(String text) {
        return countWords(text, List.of());
    }

    public long countWords(String text, List<String> stoppedWords) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        String[] words = text.split("\\s+");

        List<String> convertedWordsToLowerCase = convertStoppedWordsToLowerCase(stoppedWords);

        return Arrays.stream(words)
                .filter(word -> isAWord(word) && !isStoppedWord(convertedWordsToLowerCase, word))
                .count();
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
