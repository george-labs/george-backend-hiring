package sourceprovider;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleTextProvider implements TextProvider {

    private InputStream inputStream;
    private PrintStream outputStream;

    public ConsoleTextProvider() {
        inputStream = System.in;
        outputStream = System.out;
    }

    protected ConsoleTextProvider(InputStream inputStream, PrintStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    public String provide() {
        outputStream.println("Enter text: ");
        Scanner scanner = new Scanner(inputStream);

        return scanner.nextLine();
    }
}
