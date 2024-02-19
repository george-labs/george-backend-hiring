import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ExampleWithUserInput extends ExampleBase {

    public ExampleWithUserInput(InputStream input, PrintStream output) {
        super(input, output);
    }

    @Override
    protected String readInput() {
        Scanner scanner = new Scanner(getInput());
        return scanner.nextLine();
    }
}
