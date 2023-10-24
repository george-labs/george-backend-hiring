import service.Fetcher;
import service.Parser;
import service.Presenter;
import service.WordCountProcessor;
import service.impl.FetcherImpl;
import service.impl.ParserImpl;
import service.impl.PresenterImpl;
import service.impl.WordCountProcessorImpl;
import view.UI;
import view.impl.CommandLineUI;

public class JavaApplication {


    public static void main(String[] args) {
        Fetcher fetcher = new FetcherImpl();
        Parser parser = new ParserImpl();
        Presenter presenter = new PresenterImpl();
        WordCountProcessor processor = new WordCountProcessorImpl(fetcher, parser, presenter);

        UI commandLineUI = new CommandLineUI(processor);
        commandLineUI.countWords();
    }
    //Where data come from
    // UI -> responsible for UI
    //Core:
    // Validator -> to check the commandline structure
    // Fetcher -> to get the data
    // Parser -> to count the words
    // Presenter -> create the output
    //Where data go after
    //  Outputer -> the class responsible for output the data
}
