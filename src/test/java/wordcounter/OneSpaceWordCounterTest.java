package wordcounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wordcounter.reader.WordsFileReader;
import wordcounter.validator.EuropeanWordValidator;
import wordcounter.validator.FileStopListValidator;

class OneSpaceWordCounterTest {
    WordCounter counter;
    WordValidator validator;
    WordsFileReader fileReader;
    FileStopListValidator fileStopListValidator;
    private static final String STOPLIST_FILE_NAME= "stopwords.txt";

    @BeforeEach
    void setup(){
        validator = new EuropeanWordValidator();
        fileReader = new WordsFileReader(STOPLIST_FILE_NAME);
        fileStopListValidator = new FileStopListValidator();

        counter = new OneSpaceWordCounter(validator, fileReader, fileStopListValidator);
    }
    @Test
    void countWords() {
        long count = counter.countWords("asd 123 bb b23 -*/-*/ sss");
        Assertions.assertEquals(3, count);

        count = counter.countWords(" -----");
        Assertions.assertEquals(0, count);

        count = counter.countWords("  ");
        Assertions.assertEquals(0, count);

        count = counter.countWords("𡨸漢 cat 123 ---");
        Assertions.assertEquals(1, count);

        count = counter.countWords("𡨸漢  cat  123 ---");
        Assertions.assertEquals(1, count);
    }

    @Test
    void countWordsNotOnStopList() {
        long count = counter.countWords("the a on off");
        Assertions.assertEquals(0, count);

        count = counter.countWords("the a on off hat");
        Assertions.assertEquals(1, count);
    }
}