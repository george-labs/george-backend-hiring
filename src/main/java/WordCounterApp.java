import input.ConsoleScanner;
import input.InputReader;
import reporter.ResultReporter;
import reporter.SimpleStringReporter;
import wordcounter.WordCounter;

import java.util.Scanner;

public class WordCounterApp {


    InputReader inputReader;
    WordCounter wordCounter;
    ResultReporter resultReporter;

    public WordCounterApp() {
        this.inputReader = new InputReader(new ConsoleScanner(new Scanner(System.in)));
        this.wordCounter = new WordCounter();
        this.resultReporter = new ResultReporter(new SimpleStringReporter());
    }

    public String run(){
        String inputLine = inputReader.getInput();
        int wordCount = wordCounter.countWords(inputLine);
        return resultReporter.report(wordCount);
    }

}
