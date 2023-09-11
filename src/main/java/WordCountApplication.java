import service.*;

public class WordCountApplication {
    private final String delimiter;
    private final ITextService textService;
    private final ICountService countService;
    private final IWriteService writeService;

    public WordCountApplication(ITextService textService, ICountService countService, IWriteService writeService, String delimiter) {
        this.textService = textService;
        this.countService = countService;
        this.writeService = writeService;
        this.delimiter = delimiter;
    }

    public void countWords() {
        int count = countService.countWordsInString(textService.getString(), delimiter);
        writeService.writeWordCount(count);
    }
}
