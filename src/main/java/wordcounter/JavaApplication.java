package wordcounter;

import wordcounter.reader.ConsoleLineReader;
import wordcounter.reader.WordsFileReader;
import wordcounter.validator.EuropeanWordValidator;
import wordcounter.validator.FileStopListValidator;

public class JavaApplication {
    private static final String STOPLIST_FILE_NAME= "stopwords.txt";

    public static void main(String[] args) {
        WordValidator validator = new EuropeanWordValidator();
        FileStopListValidator fileStopListValidator = new FileStopListValidator();
        WordReader reader = new ConsoleLineReader();

        String fileName = reader.readWords();
        WordsFileReader fileReader = new WordsFileReader(fileName);
        WordsFileReader stopWordsfileReader = new WordsFileReader(STOPLIST_FILE_NAME);
        WordCounter counter = new OneSpaceWordCounter(validator, stopWordsfileReader, fileStopListValidator);
        String s = fileReader.readWords();
        if(s == null || s.isBlank()) s = reader.readWords();

        System.out.println(counter.countWords(s));
    }
}
