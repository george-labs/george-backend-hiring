package service.counting.words;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.StopWordsProvider;
import service.input.reader.InputReaderService;

import java.util.List;

class CountingWordsTest {

    @Test
    public void givenRightTextTest() {
        String text = "Mary had a little lamb";
        CountingWordsServiceImpl countingWordsServiceImpl = new CountingWordsServiceImpl(mockEmptyStopWordsProvider(), mockConsoleReaderService(text));

        var result = countingWordsServiceImpl.countNumberOfWords();

        Assertions.assertEquals(5, result);
    }


    @Test
    public void givenWrongTextTest() {
        String text = "text1 Strin.g Te!st";
        CountingWordsServiceImpl countingWordsServiceImpl = new CountingWordsServiceImpl(mockEmptyStopWordsProvider(), mockConsoleReaderService(text));

        var result = countingWordsServiceImpl.countNumberOfWords();

        Assertions.assertEquals(0, result);
    }

    @Test
    public void givenNullTest() {
        String text = null;
        CountingWordsServiceImpl countingWordsServiceImpl = new CountingWordsServiceImpl(mockEmptyStopWordsProvider(), mockConsoleReaderService(text));

        var result = countingWordsServiceImpl.countNumberOfWords();

        Assertions.assertEquals(0, result);
    }

    @Test
    public void givenEmptyText() {
        String text = "";
        CountingWordsServiceImpl countingWordsServiceImpl = new CountingWordsServiceImpl(mockEmptyStopWordsProvider(), mockConsoleReaderService(text));

        var result = countingWordsServiceImpl.countNumberOfWords();

        Assertions.assertEquals(0, result);
    }

    @Test
    public void givenRightTextWithStopWordsTest() {
        String text = "Mary had a little lamb";
        CountingWordsServiceImpl countingWordsServiceImpl = new CountingWordsServiceImpl(mockStopWordsProvider(), mockConsoleReaderService(text));

        var result = countingWordsServiceImpl.countNumberOfWords();

        Assertions.assertEquals(4, result);
    }

    private InputReaderService mockConsoleReaderService(String response){
        return () -> response;
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