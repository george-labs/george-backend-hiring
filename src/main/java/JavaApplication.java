import cli.ConsoleManager;
import cli.ConsoleManagerImpl;
import processor.TextProcessor;
import processor.TextProcessorImpl;

public class JavaApplication {

    public static void main(final String[] args) {
        final ConsoleManager consoleManager = new ConsoleManagerImpl();
        final TextProcessor processor = new TextProcessorImpl();

        final String text = consoleManager.printPromptAndReadInput();
        final long wordCount = processor.countWords(text);

        consoleManager.printNumberOfWords(wordCount);
    }

}
