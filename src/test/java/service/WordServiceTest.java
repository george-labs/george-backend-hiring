package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.stop_word.IStopWordProvider;
import service.stop_word.IStopWordService;
import service.stop_word.StopWordProvider;
import service.stop_word.StopWordService;

public class WordServiceTest {
    IStopWordProvider stopWordProvider = new StopWordProvider();

    private final IStopWordService stopWordService = new StopWordService(stopWordProvider);
    private final IWordService wordService = new WordService(stopWordService);

    @Test
    public void testSimpleWordInStopList() {
        Assertions.assertFalse(wordService.isWordForCount("one"));
    }

    @Test
    public void testWordWithDotInStopList() {
        Assertions.assertFalse(wordService.isWordForCount("one."));
    }
    @Test
    public void testWordWithDot() {
        Assertions.assertTrue(wordService.isWordForCount("second."));
    }

}
