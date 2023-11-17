import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class JavaApplicationTest {

    @Test
    public void testWithNumbers() {

       int actual = WordCount.wordCount("I have 2  apples");

        Assertions.assertEquals(3, actual);
    }
    @Test
    public void testWithLetters() {

        int actual = WordCount.wordCount("I have UU apples");

        Assertions.assertEquals(4, actual);
    }
    @Test
    public void testWithSigns() {

        int actual = WordCount.wordCount("I have &  *");

        Assertions.assertEquals(2, actual);
    }
    @Test
    public void testWithEmpty() {

        int actual = WordCount.wordCount(" ");

        Assertions.assertEquals(0, actual);
    }





}
