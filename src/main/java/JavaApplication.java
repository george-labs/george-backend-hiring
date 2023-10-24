import factory.WordsCountProcessorFactory;
import processor.WordCountProcessor;
import view.UI;
import view.impl.CommandLineUI;

public class JavaApplication {

    public static void main(String[] args) {
        WordCountProcessor wordCountProcessor = WordsCountProcessorFactory.createFrom(args);

        UI commandLineUI = new CommandLineUI(wordCountProcessor);
        commandLineUI.countWords();
    }

}
