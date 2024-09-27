package george.coding.challenge.printer;

import george.coding.challenge.Consts;
import george.coding.challenge.job.Result;

import java.io.PrintStream;

public class ConsolePrinter implements Printer {

    private final PrintStream printStream;

    public ConsolePrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public ConsolePrinter() {
        this(System.out);
    }

    @Override
    public void print(Result result) {
        printStream.printf((Consts.RESULT_TEXT) + "%n", result.wordCount());
    }
}
