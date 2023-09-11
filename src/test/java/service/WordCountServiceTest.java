package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCountServiceTest {
    MemoryStopWordProvider stopWordProvider = new MemoryStopWordProvider("one");
    ICountService service = new WordCountService(new WordService(new StopWordService(stopWordProvider)));


    @Test
    public void testEmptyStringCount() {
        String str = "";
        Assertions.assertEquals(0, service.countWordsInString(str));
    }

    @Test
    public void testStringWithoutDelimiters() {
        String str = "somethinglong";
        Assertions.assertEquals(1, service.countWordsInString(str));
    }

    @Test
    public void testStringWithDelimiters() {
        String str = "something long in this string";
        Assertions.assertEquals(5, service.countWordsInString(str));
    }

    @Test
    public void testOtherSymbols() {
        String str = "something123 543 long in this string00";
        Assertions.assertEquals(3, service.countWordsInString(str));
    }

    @Test
    public void testAllOtherSymbols() {
        String str = "234 555 9876";
        Assertions.assertEquals(0, service.countWordsInString(str));
    }

    @Test
    public void testOtherSymbols2() {
        String str = " qwe$$rty    @555fasd sdfg98sdf76!   rfvtgb  ";
        Assertions.assertEquals(1, service.countWordsInString(str));
    }
    @Test
    public void testStopWord() {
        String str = "one two three";
        Assertions.assertEquals(2, service.countWordsInString(str));
    }

}
