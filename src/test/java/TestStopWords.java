import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStopWords {

    StopWordReader stopWordReader = new StopWordReader();

    @Test
    public void stringWithStopWord() throws IOException {

        String inputString = "Mary had a little lamb";
        int expectedNumber = 4;
        String stopWordPath = "src/test/resources/stopWordFiles/stopwords.txt";

        testWordCountFromGivenInput(inputString, expectedNumber, stopWordPath);
    }

    @Test
    public void stringOnlyStopWords() throws IOException {

        String inputString = "a on";
        int expectedNumber = 0;
        String stopWordPath = "src/test/resources/stopWordFiles/stopwords.txt";

        testWordCountFromGivenInput(inputString, expectedNumber, stopWordPath);
    }

    @Test
    public void combineTwoStopWordsIntoOne() throws IOException {

        String inputString = "aon";
        int expectedNumber = 1;
        String stopWordPath = "src/test/resources/stopWordFiles/stopwords.txt";

        testWordCountFromGivenInput(inputString, expectedNumber, stopWordPath);
    }

    @Test
    public void noStopWords() throws IOException {

        String inputString = "The House";
        int expectedNumber = 2;
        String stopWordPath = "src/test/resources/stopWordFiles/stopwords.txt";

        testWordCountFromGivenInput(inputString, expectedNumber, stopWordPath);
    }

    @Test
    public void testWithEmptyStopWordFile() throws IOException {

        String inputString = "Mary had a little lamb";
        int expectedNumber = 5;
        String stopWordPath = "src/test/resources/stopWordFiles/emptyStopWordFile.txt";

        testWordCountFromGivenInput(inputString, expectedNumber, stopWordPath);
    }

    @Test
    public void testWithCapitalizedStopWords() throws  IOException {
        String inputString = "Mary had a little lamb or a chicken";
        int expectedNumber = 7;
        String stopWordPath = "src/test/resources/stopWordFiles/capitalizedStopWordFile.txt";

        testWordCountFromGivenInput(inputString, expectedNumber, stopWordPath);

    }

    private void testWordCountFromGivenInput(String inputString, int expectedNum, String stopWordPath) throws IOException {
        Set<String> stopWords = stopWordReader.readStopWordsFromFile(stopWordPath);
        WordCounter wordCounter = new WordCounterImpl(stopWords);

        int numberOfWords = wordCounter.countWords(inputString);
        assertEquals(expectedNum, numberOfWords);
    }


}
