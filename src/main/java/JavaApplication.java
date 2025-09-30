import cli.ConsoleManager;
import cli.ConsoleManagerImpl;
import processor.StopWordsProvider;
import processor.StopWordsProviderImpl;
import processor.TextProcessor;
import processor.TextProcessorImpl;

import java.io.IOException;
import java.util.Set;

import static utils.Constants.STOPWORDS_RESOURCE_PATH;

public class JavaApplication {

    final ConsoleManager consoleManager;
    final StopWordsProvider stopWordsProvider;
    final TextProcessor processor;

    public JavaApplication() {
        this.consoleManager = new ConsoleManagerImpl();
        this.stopWordsProvider = new StopWordsProviderImpl();
        this.processor = new TextProcessorImpl();
    }

    public JavaApplication(final ConsoleManager consoleManager, final StopWordsProvider stopWordsProvider, final TextProcessor processor) {
        this.consoleManager = consoleManager;
        this.stopWordsProvider = stopWordsProvider;
        this.processor = processor;
    }

    public static void main(final String[] args) throws IOException {
        new JavaApplication().run();
    }

    public void run() {
        stopWordsProvider.init(STOPWORDS_RESOURCE_PATH);
        final String text = consoleManager.printPromptAndReadInput();
        final Set<String> stopWords = stopWordsProvider.getStopWords();
        final long wordCount = processor.countWords(text, stopWords);

        consoleManager.printNumberOfWords(wordCount);
    }

}
