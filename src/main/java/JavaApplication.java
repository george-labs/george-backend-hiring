import service.*;
import service.integration.ITextService;
import service.integration.IWriteService;
import service.integration.SystemTextService;
import service.integration.SystemWriteService;
import service.stop_word.StopWordProvider;
import service.stop_word.StopWordService;

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
