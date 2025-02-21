package sk.erste.wordcountkata;

import sk.erste.wordcountkata.filter.StopWordFilter;

import java.io.FileNotFoundException;

public class WordKata {

    private final InputTextReader inputTextReader;

    public WordKata(InputTextReader inputTextReader) {
        this.inputTextReader = inputTextReader;
    }

    public int countWords() throws FileNotFoundException {
        String text = inputTextReader.getInputText();

        StopWordFilter stopWordFilter = new StopWordFilter("stopwords.txt");

        WordCounter wordCounter = new WordCounter(stopWordFilter);

        return wordCounter.countWords(text);
    }
}
