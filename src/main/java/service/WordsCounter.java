package service;

import java.util.Arrays;

public class WordsCounter {

    public WordsCounter() {
    }

    public long countWords(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        String[] words = text.split("\\s+");

        return Arrays.stream(words).filter(this::isAWord).count();
    }

    private boolean isAWord(String word) {
        return word.matches("[a-zA-Z]+");
    }

}
