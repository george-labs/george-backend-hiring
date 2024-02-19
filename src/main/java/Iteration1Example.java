import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Iteration1Example {

    private final InputStream input;
    private final PrintStream output;

    private final WordCounter counter = new WordCounter();

    public Iteration1Example(InputStream input, PrintStream output) {
        if (input == null) {
            throw new IllegalArgumentException("Input stream cannot be null");
        }
        if (output == null) {
            throw new IllegalArgumentException("Output stream cannot be null");
        }

        this.input = input;
        this.output = output;
    }

    public void run() {
        output.print("Enter text: ");
        String text = readInput();
        int wordCount = counter.count(text);
        output.print("Number of words: " + wordCount);
    }

    private String readInput() {
        Scanner scanner = new Scanner(input);
        return scanner.nextLine();
    }
}
