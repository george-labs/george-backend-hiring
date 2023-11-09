package textProcessing;

import java.util.Scanner;

public class ConsoleLineReader implements LineReader {
    private final Scanner source;
    private boolean lineRead = false;

    public ConsoleLineReader(Scanner source) {
        this.source = source;
    }

    public String getLine() {
        if(lineRead) {
            return null;
        }
        lineRead = true;
        System.out.print("Enter text: ");
        return source.nextLine();
    }
}
