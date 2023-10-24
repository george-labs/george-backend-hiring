import factory.FilterFactory;
import processor.WordCountProcessor;
import processor.impl.WordCountProcessorImpl;
import service.Fetcher;
import service.Filter;
import service.Parser;
import service.Presenter;
import service.impl.FetcherImpl;
import service.impl.ParserImpl;
import service.impl.PresenterImpl;
import view.UI;
import view.impl.CommandLineUI;

public class JavaApplication {

    private final static String STOP_WORDS_FILENAME = "stopwords.txt";

    public static void main(String[] args) {
        Fetcher fetcher = new FetcherImpl();
        Parser parser = new ParserImpl();
        Filter stopWordsFilter = FilterFactory.createWith(STOP_WORDS_FILENAME);
        Presenter presenter = new PresenterImpl();
        WordCountProcessor processor = new WordCountProcessorImpl(fetcher, parser, presenter, stopWordsFilter);

        UI commandLineUI = new CommandLineUI(processor);
        commandLineUI.countWords();
    }

}
