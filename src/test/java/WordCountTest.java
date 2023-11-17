import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class WordCountTest {

    private WordCount  wordCount;

    @BeforeEach
    void init() {

        wordCount = new WordCount("stopWords.txt");
    }

    @Test
    public void testWithNumbers() throws IOException {



       int actual = wordCount.getWordsCount("I have 2  apples");

        Assertions.assertEquals(3, actual);
    }

    @Test
    public void testWithMix() throws IOException {

        int actual = wordCount.getWordsCount("I have222 two apples");

        Assertions.assertEquals(3, actual);
    }
    @Test
    public void testWithLetters() throws IOException {

        int actual = wordCount.getWordsCount("I have UU apples");

        Assertions.assertEquals(4, actual);
    }
    @Test
    public void testWithSigns() throws IOException {

        int actual = wordCount.getWordsCount("I have &  *");

        Assertions.assertEquals(2, actual);
    }
    @Test
    public void testWithEmpty() throws IOException {

        int actual = wordCount.getWordsCount(" ");

        Assertions.assertEquals(0, actual);
    }

    @Test
    public void testWithoutStopWords() throws IOException {

        int actual = wordCount.getWordsCount("The  sun is beautiful");

        Assertions.assertEquals(4, actual);
    }
    @Test
    public void testWithOneStopWord() throws IOException {

        int actual = wordCount.getWordsCount("the  sun is beautiful");

        Assertions.assertEquals(3, actual);
    }

    @Test
    public void testWithTwoStopWords() throws IOException {

        int actual = wordCount.getWordsCount("a radio is off");

        Assertions.assertEquals(2, actual);
    }

    @Test
    public void testWithWrongStopFileName() throws IOException {

        WordCount wordCount2 = new WordCount("stoWords.txt");

        int actual = wordCount2.getWordsCount("a radio is off");

        Assertions.assertEquals(4, actual);
    }





}
