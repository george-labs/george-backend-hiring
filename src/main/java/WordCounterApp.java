import processors.WordCounterEngine;
import processors.WordCounterManager;
import providers.ConsolePrinter;
import providers.ICustomPrinter;
import providers.WordsPrinter;

import java.util.Scanner;

public class WordCounterApp {

    public static void main(String[] args) {
        ICustomPrinter customPrinter = new ConsolePrinter();
        WordsPrinter printer = new WordsPrinter(customPrinter);
        printer.enterText();

        //FIXME: I would use here better OOD solution
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();

        WordCounterManager manager = new WordCounterManager(new WordCounterEngine(), printer);
        int numberOfWords = manager.process(sentence);

        printer.result(numberOfWords);
    }

}
