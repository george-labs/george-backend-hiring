package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.stop_word.IStopWordService;
import service.stop_word.StopWordProvider;
import service.stop_word.StopWordService;

public class StopWordServiceTest {

    private final IStopWordService stopWordService = new StopWordService(new StopWordProvider());

    @Test
    public void testStopWords() {
        Assertions.assertTrue(stopWordService.isStopWord("one"));
        Assertions.assertTrue(stopWordService.isStopWord("two"));
        Assertions.assertFalse(stopWordService.isStopWord("five"));
    }

}
