import java.util.Scanner;

public class WordCounterApp {


    InputReader inputReader;
    WordCounter wordCounter;
    CountReporter countReporter;

    public WordCounterApp() {
        this.inputReader = new InputReader(new ConsoleScanner(new Scanner(System.in)));
        this.wordCounter = new WordCounter();
        this.countReporter = new CountReporter();
    }

    public void run(){
        String inputLine = inputReader.getInput();
        int wordCount = wordCounter.countWords(inputLine);
        countReporter.report(wordCount);
    }

}
