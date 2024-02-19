import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class WordProcessorWithUserInput extends WordProcessorBase {

    public WordProcessorWithUserInput(InputStream input, PrintStream output) {
        super(input, output);
    }

    @Override
    protected void requestInput() {
        getOutput().print("Enter text: ");
    }

    @Override
    protected String readInput() {
        Scanner scanner = new Scanner(getInput());
        return scanner.nextLine();
    }
}
