import cli.ConsoleManager;
import cli.ConsoleManagerImpl;
import processor.StopWordsProvider;
import processor.StopWordsProviderImpl;
import processor.TextProcessor;
import processor.TextProcessorImpl;

import java.io.IOException;
import java.util.Set;

import static utils.Constants.ROOT;
import static utils.Constants.STOPWORDS_RESOURCE_PATH;

public class JavaApplication {

    final private ConsoleManager consoleManager;
    final private StopWordsProvider stopWordsProvider;
    final private TextProcessor processor;

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
        new JavaApplication().run(args);
    }

    public void run(final String[] args) {
        String fileName = (args.length == 0)
                ? consoleManager.printFileNamePromptAndReadInput()
                : args[0];

        stopWordsProvider.init(ROOT + fileName);
        final String text = consoleManager.printTextPromptAndReadInput();
        final Set<String> stopWords = stopWordsProvider.getStopWords();
        final long wordCount = processor.countWords(text, stopWords);

        consoleManager.printNumberOfWords(wordCount);
    }

}
