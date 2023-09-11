import service.*;

public class JavaApplication {

    public static void main(String[] args) {
        ITextService textService = new SystemTextService();
        ICountService countService = new WordCountService(new WordService());
        IWriteService writeService = new SystemWriteService();
        WordCountApplication application = new WordCountApplication(textService, countService, writeService);
        application.countWords();
    }
}
