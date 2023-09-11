package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StopWordServiceTest {

    private final IStopWordService stopWordService = new StopWordService(new MemoryStopWordProvider("one", "two"));

    @Test
    public void testStopWords() {
        Assertions.assertTrue(stopWordService.isStopWord("one"));
        Assertions.assertTrue(stopWordService.isStopWord("two"));
        Assertions.assertFalse(stopWordService.isStopWord("three"));
    }

}
