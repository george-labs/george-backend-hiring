package wordcounter;

import wordcounter.input.InputReader;
import wordcounter.model.WordCountDto;
import wordcounter.service.WordCounterService;

public class WordCounterApplication {

    private final InputReader inputReader;
    private final WordCounterService wordCounterService;
    private final ResultPrinter resultPrinter;

    public WordCounterApplication(InputReader inputReader, WordCounterService wordCounterService, ResultPrinter resultPrinter) {
        this.inputReader = inputReader;
        this.wordCounterService = wordCounterService;
        this.resultPrinter = resultPrinter;
    }

    public void run() {
        String text = inputReader.readInput();
        WordCountDto wordCount = wordCounterService.countWords(text);
        resultPrinter.printWordCount(wordCount);
    }


}
