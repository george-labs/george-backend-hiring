import integration.*;
import integration.factory.TextProviderFactory;
import service.*;
import service.stop_word.IStopWordService;
import service.stop_word.StopWordProvider;
import service.stop_word.StopWordService;

public class WordCountApplication {

    public static void main(String[] args) {
        ITextProvider textProvider = TextProviderFactory.getTextProvider(args);
        IStopWordService stopWordService = new StopWordService(new StopWordProvider());
        ICountService countService = new CountService(new WordService(stopWordService));
        IWriteService writeService = new SystemWriteService();

        IWordCountService application = new WordCountService(textProvider, countService, writeService);
        application.countWords();
    }
}
