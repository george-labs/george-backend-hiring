package textProcessing;

import java.util.Scanner;

public class ConsoleLineReader implements LineReader{
    private final Scanner source;

    public ConsoleLineReader(Scanner source) {
        this.source = source;
    }

    public String getLine() {
        System.out.print("Enter text: ");
        return source.nextLine();
    }
}
