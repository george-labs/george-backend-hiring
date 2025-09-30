import cli.ConsoleManager;
import cli.ConsoleManagerImpl;
import processor.StopWordsProvider;
import processor.StopWordsProviderImpl;
import processor.TextProcessor;
import processor.TextProcessorImpl;

import java.io.IOException;

public class JavaApplication {

    final ConsoleManager consoleManager;
    final StopWordsProvider stopWordsProvider;
    final TextProcessor processor;

    public JavaApplication() {
        this.consoleManager = new ConsoleManagerImpl();
        this.stopWordsProvider = new StopWordsProviderImpl();
        this.processor = new TextProcessorImpl(stopWordsProvider);
    }

    public JavaApplication(final ConsoleManager consoleManager, final StopWordsProvider stopWordsProvider, final TextProcessor processor) {
        this.consoleManager = consoleManager;
        this.stopWordsProvider = stopWordsProvider;
        this.processor = processor;
    }

    public void run() {
        stopWordsProvider.init();
        final String text = consoleManager.printPromptAndReadInput();
        final long wordCount = processor.countWords(text);

        consoleManager.printNumberOfWords(wordCount);
    }

    public static void main(final String[] args) throws IOException {
        new JavaApplication().run();
    }

}
