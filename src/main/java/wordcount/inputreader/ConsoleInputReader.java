package wordcount.inputreader;

import wordcount.OutputPrinter;

import java.util.Scanner;

public class ConsoleInputReader implements wordcount.InputReader {

    OutputPrinter outputPrinter;

    public ConsoleInputReader(OutputPrinter outputPrinter) {
        this.outputPrinter = outputPrinter;
    }

    @Override
    public String readInput() {
        outputPrinter.print("Number of words: ");
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }
}
