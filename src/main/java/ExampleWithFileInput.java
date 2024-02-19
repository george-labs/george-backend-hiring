import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ExampleWithFileInput extends ExampleBase {

    public ExampleWithFileInput(InputStream input, PrintStream output) {
        super(input, output);
    }

    @Override
    protected String readInput() {
        try {
            return new String(getInput().readAllBytes());
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read input stream", e);
        }
    }
}
