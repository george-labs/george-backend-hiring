package george.coding.challenge.printer;

import george.coding.challenge.Constants;
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
        printStream.println(String.format(Constants.RESULT_TEXT, result.wordCount(), result.uniqueWordCount()));
    }
}
