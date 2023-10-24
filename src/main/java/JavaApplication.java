import repository.StopWordsRepository;
import repository.impl.StopWordsFileRepositoryImpl;
import service.Fetcher;
import service.Filter;
import service.Parser;
import service.Presenter;
import service.WordCountProcessor;
import service.impl.FetcherImpl;
import service.impl.ParserImpl;
import service.impl.PresenterImpl;
import service.impl.StopWordsFilterImpl;
import service.impl.WordCountProcessorImpl;
import view.UI;
import view.impl.CommandLineUI;

public class JavaApplication {


    public static void main(String[] args) {
        Fetcher fetcher = new FetcherImpl();
        Parser parser = new ParserImpl();
        StopWordsRepository stopWordsRepository = new StopWordsFileRepositoryImpl();
        Filter stopWordsFilter = new StopWordsFilterImpl(stopWordsRepository);
        Presenter presenter = new PresenterImpl();
        WordCountProcessor processor = new WordCountProcessorImpl(fetcher, parser, presenter, stopWordsFilter);

        UI commandLineUI = new CommandLineUI(processor);
        commandLineUI.countWords();
    }

}
