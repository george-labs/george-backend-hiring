package bl;

import bl.model.WordStats;
import bl.providers.StopWordsMockProvider;
import bl.services.WordCountService;
import bl.services.WordCountServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordStatsServiceImplTest {

    @Test
    public void testNullInput() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of()));
        WordStats count = countService.countWords(null);

        assertEquals(0, count.getTotal());
        assertEquals(0, count.getUnique());
    }

    @Test
    public void testWordCount() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "this is a TEST-string.";
        WordStats count = countService.countWords(input);

        assertEquals(4, count.getTotal());
        assertEquals(4, count.getUnique());
    }

    @Test
    public void testUniqueWords() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "unique words count words count";
        WordStats count = countService.countWords(input);

        assertEquals(5, count.getTotal());
        assertEquals(3, count.getUnique());
    }

    @Test
    public void testWordCountWithStopWords() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of("the", "a", "on", "off")));

        String input = "testing test with a stop words 123 on test";
        WordStats count = countService.countWords(input);

        assertEquals(6, count.getTotal());
        assertEquals(5, count.getUnique());
    }

    @Test
    public void testAverageWordLength() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "abc abc efgh efgh";
        WordStats count = countService.countWords(input);

        assertEquals(3.5, count.getAverage());
    }
}
