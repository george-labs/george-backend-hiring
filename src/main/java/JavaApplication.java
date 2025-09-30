import cli.ConsoleManager;
import cli.ConsoleManagerImpl;
import processor.TextProcessor;
import processor.TextProcessorImpl;

public class JavaApplication {

    final ConsoleManager consoleManager;
    final TextProcessor processor;

    public JavaApplication() {
        this.consoleManager = new ConsoleManagerImpl();
        this.processor = new TextProcessorImpl();
    }

    public JavaApplication(ConsoleManager consoleManager, TextProcessor processor) {
        this.consoleManager = consoleManager;
        this.processor = processor;
    }

    public void run() {
        final String text = consoleManager.printPromptAndReadInput();
        final long wordCount = processor.countWords(text);

        consoleManager.printNumberOfWords(wordCount);
    }

    public static void main(final String[] args) {
        new JavaApplication().run();
    }

}
