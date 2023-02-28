package wordcount;

import wordcount.counterofwords.CounterOfWordsImpl;
import wordcount.inputreader.ConsoleInputReader;
import wordcount.printer.ConsoleOutputPrinter;
import wordcount.resultprinter.ConsoleResultPrinter;

public class WordCount {

    private static InputReader inputReader;
    private static CounterOfWords counterOfWords;
    private static ResultPrinter resultPrinter;

    public static void run() {
        resultPrinter.printResult(counterOfWords.count(inputReader.readInput()));
    }

    public static void main(String[] args) {
        OutputPrinter outputPrinter = new ConsoleOutputPrinter();
        inputReader = new ConsoleInputReader(outputPrinter);
        counterOfWords = new CounterOfWordsImpl();
        resultPrinter = new ConsoleResultPrinter(outputPrinter);

        run();
    }
}
