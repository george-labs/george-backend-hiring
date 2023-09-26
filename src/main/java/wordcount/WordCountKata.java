package wordcount;

import file.FileHandler;
import input.UserInputHandler;

public class WordCountKata {

    private final UserInputHandler userInputHandler;
    private final FileHandler fileHandler;
    private final WordExtractor wordExtractor;

    public WordCountKata(UserInputHandler userInputHandler, FileHandler fileHandler, WordExtractor wordExtractor) {
        this.userInputHandler = userInputHandler;
        this.fileHandler = fileHandler;
        this.wordExtractor = wordExtractor;
    }

    public int countWords(String stopWordsFileName) {
        String stopWordsInput = fileHandler.readFileToString(stopWordsFileName);
        var stopWords = wordExtractor.getWords(stopWordsInput);

        String inputText = userInputHandler.readUserInput(System.in);

        var wordsToCount = wordExtractor.getWords(inputText);

        return new WordCounter(stopWords).countNumberOfWords(wordsToCount);
    }
}
