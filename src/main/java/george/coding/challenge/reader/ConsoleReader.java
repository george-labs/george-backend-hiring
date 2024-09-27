package george.coding.challenge.reader;

import george.coding.challenge.Consts;

import java.io.Closeable;
import java.util.Scanner;

public class ConsoleReader implements TextReader, Closeable {

    private final Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public ConsoleReader() {
        this(new Scanner(System.in));
    }

    @Override
    public String read() {
        System.out.println(Consts.PROMPT_TEXT);
        return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
