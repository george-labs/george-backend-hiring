package wordcount;

import file.FileHandler;
import input.InputReaderFactory;

public class WordCountKata {

    private final FileHandler fileHandler;
    private final WordExtractor wordExtractor;
    private final InputReaderFactory inputReaderFactory;

    public WordCountKata(FileHandler fileHandler, WordExtractor wordExtractor, InputReaderFactory inputReaderFactory) {
        this.fileHandler = fileHandler;
        this.wordExtractor = wordExtractor;
        this.inputReaderFactory = inputReaderFactory;
    }

    public TextAnalytics countWords(String[] args, String stopWordsFileName) {
        String stopWordsInput = fileHandler.readFileToString(stopWordsFileName);
        var stopWords = wordExtractor.getWords(stopWordsInput);

        String inputText = inputReaderFactory.createInputReader(args).getInputText();

        var wordsToCount = wordExtractor.getWords(inputText);

        return new WordCounter(stopWords).countNumberOfWords(wordsToCount);
    }
}
