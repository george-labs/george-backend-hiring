package service;

public class WordCountService implements ICountService {
    private static final String DELIMITER = " ";
    private final IWordService wordService;

    public WordCountService(IWordService wordService) {
        this.wordService = wordService;
    }

    @Override
    public int countWordsInString(String string) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        String[] split = string.split(DELIMITER);
        int count = 0;
        for (String str : split) {
            if (wordService.isWord(str)) {
                count++;
            }
        }
        return count;
    }
}
