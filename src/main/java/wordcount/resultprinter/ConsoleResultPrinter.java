package wordcount.resultprinter;

import wordcount.OutputPrinter;
import wordcount.ResultPrinter;

public class ConsoleResultPrinter implements ResultPrinter {

    OutputPrinter outputPrinter;

    public ConsoleResultPrinter(OutputPrinter outputPrinter) {
        this.outputPrinter = outputPrinter;
    }

    @Override
    public void printResult(Integer result) {
        outputPrinter.print("Number of words: ");
        outputPrinter.print(result.toString());
    }
}
