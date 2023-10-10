package wordcounter;

import wordcounter.reader.ConsoleLineReader;
import wordcounter.reader.WordsFileReader;
import wordcounter.validator.EuropeanWordValidator;
import wordcounter.validator.FileStopListValidator;

public class JavaApplication {
    private static final String STOPLIST_FILE_NAME= "stopwords.txt";

    public static void main(String[] args) {
        StringProvider stringProvider = new StringProvider();
        WordsFileReader stopWordsFileReader = new WordsFileReader(STOPLIST_FILE_NAME);
        WordValidator validator = new EuropeanWordValidator();
        FileStopListValidator fileStopListValidator = new FileStopListValidator();
        WordCounter counter = new OneSpaceWordCounter(validator, stopWordsFileReader, fileStopListValidator);
        WordReader consoleLineReader = new ConsoleLineReader();

        String fileName = consoleLineReader.readWords();

        String stringFromInput = stringProvider.getStringFromInput(consoleLineReader, fileName);

        System.out.println("Number of words: " + counter.countWords(stringFromInput) + " unique: "  + counter.countUniqueWords(stringFromInput));
    }
}
