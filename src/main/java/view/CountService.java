package view;

import java.util.List;

public class CountService {

    public static final String MATCH_ONLY_WORD_REGEX = "^[a-zA-Z]+$";

    public CountService() {
    }

    public int getWordsCount(String input, List<String> stopWords) {
        String[] words = input.split(" ");

        return getValidWordCount(words, stopWords);
    }

    private int getValidWordCount(String[] words, List<String> stopWords) {
        int validWordCount = 0;

        for (String word: words) {
            if(isRealWord(word) && isNotStopWord(word, stopWords)) {
                validWordCount++;
            }
        }
        return validWordCount;
    }

    private boolean isRealWord(String word) {
        return word.matches(MATCH_ONLY_WORD_REGEX);
    }

    private boolean isNotStopWord(String word, List<String> stopWords) {
        return stopWords.stream().noneMatch(s -> s.equals(word));
    }
}
