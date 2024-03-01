package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.StopWordsProvider;
import service.console.reader.ConsoleReaderService;
import service.counting.words.CountingWordsServiceImpl;

import java.util.List;

class CountingWordsTest {

    @Test
    public void givenRightTextTest() {
        CountingWordsServiceImpl countingWordsServiceImpl = new CountingWordsServiceImpl(mockEmptyStopWordsProvider());
        String text = "Mary had a little lamb";

        var result = countingWordsServiceImpl.countNumberOfWords(text);

        Assertions.assertEquals(5, result);
    }


    @Test
    public void givenWrongTextTest() {
        CountingWordsServiceImpl countingWordsServiceImpl = new CountingWordsServiceImpl(mockEmptyStopWordsProvider());
        String text = "text1 Strin.g Te!st";

        var result = countingWordsServiceImpl.countNumberOfWords(text);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void givenNullTest() {
        CountingWordsServiceImpl countingWordsServiceImpl = new CountingWordsServiceImpl(mockEmptyStopWordsProvider());
        String text = null;

        var result = countingWordsServiceImpl.countNumberOfWords(text);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void givenEmptyText() {
        CountingWordsServiceImpl countingWordsServiceImpl = new CountingWordsServiceImpl(mockEmptyStopWordsProvider());
        String text = "";

        var result = countingWordsServiceImpl.countNumberOfWords(text);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void givenRightTextWithStopWordsTest() {
        CountingWordsServiceImpl countingWordsServiceImpl = new CountingWordsServiceImpl(mockStopWordsProvider());
        String text = "Mary had a little lamb";

        var result = countingWordsServiceImpl.countNumberOfWords(text);

        Assertions.assertEquals(4, result);
    }

    private ConsoleReaderService mockStopWordsProvider(){
        return new ConsoleReaderService() {
            @Override
            public String getNextLine() {
                return null;
            }
        }
    }

    private StopWordsProvider mockStopWordsProvider(){
        return () -> List.of(
                "the",
                "a",
                "on",
                "off"
        );
    }

    private StopWordsProvider mockEmptyStopWordsProvider(){
        return List::of;
    }

}