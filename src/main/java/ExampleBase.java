import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class ExampleBase implements Example {

    private final InputStream input;
    private final PrintStream output;

    private final WordCounter counter = new WordCounter(new StopWordsImpl("stopwords.txt"));

    public ExampleBase(InputStream input, PrintStream output) {
        if (input == null) {
            throw new IllegalArgumentException("Input stream cannot be null");
        }
        if (output == null) {
            throw new IllegalArgumentException("Output stream cannot be null");
        }

        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        output.print("Enter text: ");
        String text = readInput();
        int wordCount = counter.count(text);
        output.print("Number of words: " + wordCount);
    }

    protected abstract String readInput();

    protected InputStream getInput() {
        return input;
    }

    protected PrintStream getOutput() {
        return output;
    }
}
