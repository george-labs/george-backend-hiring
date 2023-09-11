package service;

import domain.CountResult;

import java.util.HashSet;
import java.util.Set;

public class CountService implements ICountService {
    private static final String DELIMITER_REGEXP = "[ -]";
    private final IWordService wordService;

    public CountService(IWordService wordService) {
        this.wordService = wordService;
    }

    @Override
    public CountResult countWordsInString(String string) {
        if (string == null || string.length() == 0) {
            return new CountResult(0, 0);
        }
        String[] split = string.split(DELIMITER_REGEXP);

        int count = 0;
        Set<String> uniqueWords = new HashSet<>();
        for (String str : split) {
            if (wordService.isWordForCount(str)) {
                count++;
                uniqueWords.add(str.toLowerCase());
            }
        }
        return new CountResult(count, uniqueWords.size());
    }
}
