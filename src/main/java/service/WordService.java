package service;

import service.stop_word.IStopWordService;

public class WordService implements IWordService {

    public static final String LETTER_WORD_PATTERN = "[a-zA-Z]+";
    private final IStopWordService stopWordService;

    public WordService(IStopWordService stopWordService) {
        this.stopWordService = stopWordService;
    }

    @Override
    public boolean isWordForCount(String str) {
        if (str.endsWith(".")) {
            str = str.substring(0, str.length() - 1);
        }
        return str.matches(LETTER_WORD_PATTERN) && !stopWordService.isStopWord(str);
    }
}
