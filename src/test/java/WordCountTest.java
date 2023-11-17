import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class WordCountTest {

    @Test
    public void testWithNumbers() throws IOException {

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
    public void testWithOneStopWords() throws IOException {

        int actual = WordCount.wordCount("The  sun is beautiful");

        Assertions.assertEquals(4, actual);
    }
    @Test
    public void testWithOneStopWords2() throws IOException {

        int actual = WordCount.wordCount("the  sun is beautiful");

        Assertions.assertEquals(3, actual);
    }






}
