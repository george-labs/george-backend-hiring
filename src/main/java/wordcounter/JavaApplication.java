package wordcounter;

import wordcounter.reader.ConsoleLineReader;
import wordcounter.reader.WordsFileReader;
import wordcounter.validator.EuropeanWordValidator;
import wordcounter.validator.FileStopListValidator;

public class JavaApplication {
    private static final String STOPLIST_FILE_NAME= "stopwords.txt";

    public static void main(String[] args) {
        WordsFileReader stopWordsFileReader = new WordsFileReader(STOPLIST_FILE_NAME);
        WordValidator validator = new EuropeanWordValidator();
        FileStopListValidator fileStopListValidator = new FileStopListValidator();
        WordReader consoleLineReader = new ConsoleLineReader();

        String fileName = consoleLineReader.readWords();
        WordsFileReader fileReader = new WordsFileReader(fileName);
        WordCounter counter = new OneSpaceWordCounter(validator, stopWordsFileReader, fileStopListValidator);
        String s = fileReader.readWords();
        if(s == null || s.isBlank()) s = consoleLineReader.readWords();

        System.out.println("Number of words: " + counter.countWords(s));
    }
}
