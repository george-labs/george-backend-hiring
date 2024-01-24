import processors.WordCounterEngine;
import processors.WordCounterManager;
import providers.*;
import rules.IRule;
import rules.OnlyLetterRule;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordCounterApp {

    public static void main(String[] args) throws IOException {
        ICustomPrinter customPrinter = new ConsolePrinter();
        IDataProvider dataProvider = new ConsoleInputDataProvider();
       // IDataProvider

        WordsPrinter printer = new WordsPrinter(customPrinter);
        printer.enterText();
        String sentence = dataProvider.getData();

        IRule onlyLettersRule = new OnlyLetterRule();
        //IRule stopWordsRule = new StopWordsRule()
        List<IRule> rulesList = new ArrayList<>();
        rulesList.add(onlyLettersRule);

        WordCounterManager manager = new WordCounterManager(new WordCounterEngine(rulesList));
        int numberOfWords = manager.process(sentence);

        printer.result(numberOfWords);
    }

}
