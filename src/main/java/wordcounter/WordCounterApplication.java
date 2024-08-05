package wordcounter;

import wordcounter.input.InputReader;

public class WordCounterApplication {

    private final InputReader inputReader;
    private final WordCounter wordCounter;
    private final ResultPrinter resultPrinter;

    public WordCounterApplication(InputReader inputReader, WordCounter wordCounter, ResultPrinter resultPrinter) {
        this.inputReader = inputReader;
        this.wordCounter = wordCounter;
        this.resultPrinter = resultPrinter;
    }

    public void run() {
        String text = inputReader.readInput();
        long wordCount = wordCounter.countWords(text);
        resultPrinter.printWordCount(wordCount);
    }


}
