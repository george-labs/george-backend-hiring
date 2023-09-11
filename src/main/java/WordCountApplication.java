import service.*;
import integration.ITextProvider;
import integration.IWriteService;

public class WordCountApplication {
    private final ITextProvider textService;
    private final ICountService countService;
    private final IWriteService writeService;

    public WordCountApplication(ITextProvider textService, ICountService countService, IWriteService writeService) {
        this.textService = textService;
        this.countService = countService;
        this.writeService = writeService;
    }

    public void countWords() {
        int count = countService.countWordsInString(textService.getString());
        writeService.writeWordCount(count);
    }
}
