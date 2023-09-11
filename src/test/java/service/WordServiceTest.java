package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordServiceTest {
    MemoryStopWordProvider stopWordProvider = new MemoryStopWordProvider("one");

    private final IStopWordService stopWordService = new StopWordService(stopWordProvider);
    private final IWordService wordService = new WordService(stopWordService);

    @Test
    public void testWordForCount() {
        Assertions.assertFalse(wordService.isWordForCount("one"));
    }
}
