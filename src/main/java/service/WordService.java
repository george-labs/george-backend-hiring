package service;

public class WordService implements IWordService {
    public static final String LETTER_WORD_PATTERN = "[a-zA-Z]+";

    @Override
    public boolean isWord(String str) {
        return str.matches(LETTER_WORD_PATTERN);
    }
}
