package sk.erste.wordcountkata;

import sk.erste.wordcountkata.WordCounter.WordCountStat;
import sk.erste.wordcountkata.filter.StopWordFilter;

import java.io.FileNotFoundException;

public class JavaApplication {

    public static void main(String[] args) {
        String filename = null;
        if (args.length > 0) {
            filename = args[0];
        }

        InputTextReader inputTextReader = new InputTextReader(filename);
        String text;
        try {
            text = inputTextReader.getInputText();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }

        StopWordFilter stopWordFilter = new StopWordFilter("stopwords.txt");

        WordCounter wordCounter = new WordCounter(stopWordFilter);
        WordCounterOutputFormatter formatter = new WordCounterOutputFormatter();

        WordCountStat wordCountStat = wordCounter.countWords(text);
        System.out.println(formatter.formatOutput(wordCountStat));
    }
}
