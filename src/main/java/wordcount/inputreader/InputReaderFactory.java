package wordcount.inputreader;

import wordcount.InputReader;
import wordcount.OutputPrinter;

public class InputReaderFactory {

    private final OutputPrinter outputPrinter;

    public InputReaderFactory(OutputPrinter outputPrinter) {
        this.outputPrinter = outputPrinter;
    }

    public InputReader create(String filename) {
        if (filename == null) {
            return new ConsoleInputReader(outputPrinter);
        }
        return new InputFileReader(filename);
    }
}
