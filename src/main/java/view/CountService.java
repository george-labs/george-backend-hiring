package view;

public class CountService {

    public static final String MATCH_ONLY_WORD_REGEX = "^[a-zA-Z]+$";

    public CountService() {
    }

    public int getWordsCount(String input) {
        String[] words = input.split(" ");

        return getValidWordCount(words);
    }

    private int getValidWordCount(String[] words) {
        int validWordCount = 0;

        for (String word: words) {
            if(isRealWord(word)) {
                validWordCount++;
            }
        }
        return validWordCount;
    }

    private boolean isRealWord(String word) {
        return word.matches(MATCH_ONLY_WORD_REGEX);
    }
}
