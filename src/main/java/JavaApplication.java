import service.*;

public class JavaApplication {


    public static void main(String[] args) {
        ITextService textService = new SystemTextService();
        StopWordService stopWordService = new StopWordService(new StopWordProvider());
        ICountService countService = new WordCountService(new WordService(stopWordService));
        IWriteService writeService = new SystemWriteService();
        WordCountApplication application = new WordCountApplication(textService, countService, writeService);
        application.countWords();
    }
}
