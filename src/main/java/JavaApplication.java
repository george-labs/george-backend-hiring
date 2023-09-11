import service.*;

public class JavaApplication {
    private static final String DELIMITER = " ";

    public static void main(String[] args) {
        ITextService textService = new SystemTextService();
        ICountService countService = new WordCountService();
        IWriteService writeService = new SystemWriteService();
        WordCountApplication application = new WordCountApplication(textService, countService, writeService, DELIMITER);
        application.countWords();
    }
}
