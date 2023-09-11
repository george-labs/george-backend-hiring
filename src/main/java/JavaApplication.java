import integration.*;
import service.*;
import service.stop_word.StopWordProvider;
import service.stop_word.StopWordService;

public class JavaApplication {


    public static void main(String[] args) {
        ITextProvider textProvider = TextProviderFactory.getTextProvider(args);
        StopWordService stopWordService = new StopWordService(new StopWordProvider());
        ICountService countService = new WordCountService(new WordService(stopWordService));
        IWriteService writeService = new SystemWriteService();
        WordCountApplication application = new WordCountApplication(textProvider, countService, writeService);
        application.countWords();
    }
}
