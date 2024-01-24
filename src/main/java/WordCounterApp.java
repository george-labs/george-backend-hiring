import processors.WordCounterEngine;
import processors.WordCounterManager;
import providers.*;
import rules.IRule;
import rules.OnlyLetterRule;
import rules.StopWordsRule;
import utils.Constants;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordCounterApp {


    public static void main(String[] args) throws IOException {
        ICustomPrinter customPrinter = new ConsolePrinter();
        IDataProvider consoleInputDataProvider = new ConsoleInputDataProvider();
        IDataProvider fileInputDataProvider = new FileInputDataProvider(Constants.STOP_WORDS_LIST_FILE);

        WordsPrinter printer = new WordsPrinter(customPrinter);
        printer.enterText();
        String sentence = consoleInputDataProvider.getData();

        IRule onlyLettersRule = new OnlyLetterRule();
        String[] stopWords = fileInputDataProvider.getData().split(Constants.REGEX);
        IRule stopWordsRule = new StopWordsRule(new HashSet<>(Arrays.asList(stopWords)));
        List<IRule> rulesList = new ArrayList<>();
        rulesList.add(onlyLettersRule);
        rulesList.add(stopWordsRule);
        WordCounterManager manager = new WordCounterManager(new WordCounterEngine(rulesList));
        int numberOfWords = manager.process(sentence);

        printer.result(numberOfWords);
    }

}
