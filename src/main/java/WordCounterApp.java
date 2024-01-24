import processors.WordCounterEngine;
import processors.WordCounterManager;
import providers.*;

public class WordCounterApp {

    public static void main(String[] args) {
        ICustomPrinter customPrinter = new ConsolePrinter();
        IDataProvider dataProvider = new ConsoleInputDataProvider();

        WordsPrinter printer = new WordsPrinter(customPrinter);
        printer.enterText();
        String sentence = dataProvider.getData();

        WordCounterManager manager = new WordCounterManager(new WordCounterEngine());
        int numberOfWords = manager.process(sentence);

        printer.result(numberOfWords);
    }

}
