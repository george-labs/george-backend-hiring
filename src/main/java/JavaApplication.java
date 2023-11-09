import dictionary.Dictionary;
import textProcessing.*;
import wordFilter.AlphabeticWordFilter;
import wordFilter.StopWordFilter;
import wordsStats.WordCounter;
import wordsStats.WordOperation;
import wordsStats.WordUnique;
import wordsStats.WordsStas;

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

        WordOperation wordCount = new WordCounter();
        WordOperation wordUnique = new WordUnique();
        WordsStas wordStats = new WordsStas(wordFetcher).addOperation(wordCount).addOperation(wordUnique);
        wordStats.generateStats();
        System.out.print(wordStats.collectStatsSummary());
    }
}
