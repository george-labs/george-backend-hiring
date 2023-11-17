import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class WordCountTest {

    private WordCount  wordCount;

    @BeforeEach
    void init() {

        wordCount = new WordCount("stopWordsFileName");
    }

    @Test
    public void testWithNumbers() throws IOException {

        WordCount  wordCount = new WordCount(stopWordsFileName);

       int actual = WordCount.wordCount("I have 2  apples");

        Assertions.assertEquals(3, actual);
    }

    @Test
    public void testWithMix() throws IOException {

        int actual = WordCount.wordCount("I have222 two apples");

        Assertions.assertEquals(3, actual);
    }
    @Test
    public void testWithLetters() throws IOException {

        int actual = WordCount.wordCount("I have UU apples");

        Assertions.assertEquals(4, actual);
    }
    @Test
    public void testWithSigns() throws IOException {

        int actual = WordCount.wordCount("I have &  *");

        Assertions.assertEquals(2, actual);
    }
    @Test
    public void testWithEmpty() throws IOException {

        int actual = WordCount.wordCount(" ");

        Assertions.assertEquals(0, actual);
    }

    @Test
    public void testWithoutStopWords() throws IOException {

        int actual = WordCount.wordCount("The  sun is beautiful");

        Assertions.assertEquals(4, actual);
    }
    @Test
    public void testWithOneStopWord() throws IOException {

        int actual = WordCount.wordCount("the  sun is beautiful");

        Assertions.assertEquals(3, actual);
    }

    @Test
    public void testWithTwoStopWords() throws IOException {

        int actual = WordCount.wordCount("a radio is off");

        Assertions.assertEquals(2, actual);
    }







}
