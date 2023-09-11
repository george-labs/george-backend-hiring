package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCountServiceTest {

    ICountService service = new WordCountService();

    @Test
    public void testEmptyStringCount() {
        String str = "";
        String delimiter = " ";
        Assertions.assertEquals(0, service.countWordsInString(str, delimiter));
    }

    @Test
    public void testStringWithoutDelimiters() {
        String str = "somethinglong";
        String delimiter = " ";
        Assertions.assertEquals(1, service.countWordsInString(str, delimiter));
    }

    @Test
    public void testStringWithDelimiters() {
        String str = "something long in this string";
        String delimiter = " ";
        Assertions.assertEquals(5, service.countWordsInString(str, delimiter));
    }

    @Test
    public void testDelimiter() {
        String str = "something long in this string";
        String delimiter = "_";
        Assertions.assertEquals(1, service.countWordsInString(str, delimiter));
    }
}
