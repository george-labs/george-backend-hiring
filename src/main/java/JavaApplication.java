import dictionary.Dictionary;
import textProcessing.*;
import wordFilter.AlphabeticWordFilter;
import wordFilter.StopWordFilter;
import wordsStats.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JavaApplication {

    static public void main(String[] args) throws FileNotFoundException {

        LineReader lineReader;
        if(args.length > 0) {
            Scanner scanner = new Scanner(new File(args[0]));
            lineReader = new FileLineReader(scanner);
        } else {
            Scanner scanner = new Scanner(System.in);
            lineReader = new ConsoleLineReader(scanner);
        }

        LineReader stopWordReader = new FileLineReader(new Scanner(new File("stopwords.txt")));
        Dictionary stopWordsDict = new Dictionary(stopWordReader);
        LineProcessor lineProcessor = new LineProcessor().addFilter(new AlphabeticWordFilter()).addFilter(new StopWordFilter(stopWordsDict));
        WordFetcher wordFetcher = new WordFetcher(lineReader, lineProcessor);

        wordsStas wordStats = new wordsStas(wordFetcher).addOperation(new WordCounter()).addOperation(new WordUnique()).addOperation(new WordAverage());
        wordStats.generateStats();
        System.out.print(wordStats.collectStatsSummary());
    }
}
