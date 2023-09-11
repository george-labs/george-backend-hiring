package service;

import integration.ITextProvider;
import integration.IWriteService;

public class WordCountService implements IWordCountService {
    private final ITextProvider textService;
    private final ICountService countService;
    private final IWriteService writeService;

    public WordCountService(ITextProvider textService, ICountService countService, IWriteService writeService) {
        this.textService = textService;
        this.countService = countService;
        this.writeService = writeService;
    }

    @Override
    public void countWords() {
        int count = countService.countWordsInString(textService.getString());
        writeService.writeWordCount(count);
    }
}
