import service.*;

public class WordCountApplication {
    private final ITextService textService;
    private final ICountService countService;
    private final IWriteService writeService;

    public WordCountApplication(ITextService textService, ICountService countService, IWriteService writeService) {
        this.textService = textService;
        this.countService = countService;
        this.writeService = writeService;
    }

    public void countWords() {
        int count = countService.countWordsInString(textService.getString());
        writeService.writeWordCount(count);
    }
}
