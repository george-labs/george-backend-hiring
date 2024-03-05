package bl;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordCountServiceImplTest {

    @Test
    public void testWordCount() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "this is a test STRING wIth a inval1d  w+rds and + characters\nand new line";
        long count = countService.countWords(input);

        assertEquals(12, count);
    }

    @Test
    public void testWordCountWithStopWords() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of("the", "a", "on", "off")));

        String input = "testing test with a stop words 123 on test";
        long count = countService.countWords(input);

        assertEquals(6, count);
    }
}
