import textProcessing.ConsoleLineReader;
import textProcessing.LineProcessor;
import textProcessing.LineReader;
import textProcessing.WordFetcher;
import wordFilter.AlphabeticWordFilter;
import wordsStats.WordCounter;

import java.util.Scanner;

public class JavaApplication {

    static public void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LineReader lineReader = new ConsoleLineReader(scanner);
        LineProcessor lineProcessor = new LineProcessor().addFilter(new AlphabeticWordFilter());
        WordFetcher wordFetcher = new WordFetcher(lineReader, lineProcessor);

        WordCounter wordCounter = new WordCounter(wordFetcher);
        System.out.print("Number of words: " + wordCounter.getCount());
    }
}
