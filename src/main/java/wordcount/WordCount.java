package wordcount;

import wordcount.counterofwords.CounterOfWordsImpl;
import wordcount.inputreader.ConsoleInputReader;
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
        OutputPrinter outputPrinter = new ConsoleOutputPrinter();
        inputReader = new ConsoleInputReader(outputPrinter);
        FileReader fileReader = new StopWordsReader();
        List<String> stopWords = fileReader.raed();
        counterOfWords = new CounterOfWordsImpl(stopWords);
        resultPrinter = new ConsoleResultPrinter(outputPrinter);

        run();
    }
}
