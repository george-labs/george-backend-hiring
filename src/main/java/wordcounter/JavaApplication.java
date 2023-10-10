package wordcounter;

import wordcounter.reader.ConsoleLineReader;
import wordcounter.reader.StopWordsFileReader;
import wordcounter.validator.EuropeanWordValidator;
import wordcounter.validator.FileStopListValidator;

public class JavaApplication {

    public static void main(String[] args) {
        WordValidator validator = new EuropeanWordValidator();
        StopWordsFileReader fileReader = new StopWordsFileReader();
        FileStopListValidator fileStopListValidator = new FileStopListValidator();
        WordCounter counter = new OneSpaceWordCounter(validator, fileReader, fileStopListValidator);
        LineReader reader = new ConsoleLineReader();

        String s = reader.readLine();

        System.out.println(counter.countWords(s));
    }
}
