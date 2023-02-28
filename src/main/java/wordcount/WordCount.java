package wordcount;

import wordcount.counterofwords.CounterOfWordsImpl;
import wordcount.inputreader.InputReaderFactory;
import wordcount.printer.ConsoleOutputPrinter;
import wordcount.resultprinter.ConsoleResultPrinter;
import wordcount.stopwordsreader.StopWordsReader;

import java.util.List;

public class WordCount {

    private static InputReader inputReader;
    private static CounterOfWords counterOfWords;
    private static ResultPrinter resultPrinter;

    public static void run() {
        resultPrinter.printResult(counterOfWords.count(inputReader.readInput()));
    }

    public static void main(String[] args) {

        if (args.length > 1) {
            throw new CriticalAppException("Error. Only one argument supported");
        }

        String filename = null;
        if (args.length == 1) {
            filename = args[0];
        }

        OutputPrinter outputPrinter = new ConsoleOutputPrinter();
        InputReaderFactory inputReaderFactory = new InputReaderFactory(outputPrinter);
        inputReader = inputReaderFactory.create(filename);
        FileReader fileReader = new StopWordsReader();
        List<String> stopWords = fileReader.raed();
        counterOfWords = new CounterOfWordsImpl(stopWords);
        resultPrinter = new ConsoleResultPrinter(outputPrinter);

        run();
    }
}
