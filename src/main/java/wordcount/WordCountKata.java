package wordcount;

import file.FileHandler;
import input.InputReaderFactory;
import text.TextAnalytics;
import text.WordExtractor;

public class WordCountKata {

    private final FileHandler fileHandler;
    private final WordExtractor wordExtractor;
    private final InputReaderFactory inputReaderFactory;

    public WordCountKata(FileHandler fileHandler, WordExtractor wordExtractor, InputReaderFactory inputReaderFactory) {
        this.fileHandler = fileHandler;
        this.wordExtractor = wordExtractor;
        this.inputReaderFactory = inputReaderFactory;
    }

    public TextAnalytics getTextAnalytics(String[] args, String stopWordsFileName) {
        String stopWordsInput = fileHandler.readFileToString(stopWordsFileName);
        var stopWords = wordExtractor.getWords(stopWordsInput);

        String inputText = inputReaderFactory.createInputReader(args).getInputText();

        var wordsToCount = wordExtractor.getWords(inputText);

        return new TextAnalyzer(stopWords).analyzeWords(wordsToCount);
    }
}
