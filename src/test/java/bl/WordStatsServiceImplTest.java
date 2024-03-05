package bl;

import bl.model.WordStats;
import bl.providers.StopWordsMockProvider;
import bl.services.WordCountService;
import bl.services.WordCountServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordStatsServiceImplTest {

    @Test
    public void testNullInput() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of()));
        WordStats stats = countService.countWords(null, false);

        assertEquals(0, stats.getTotal());
        assertEquals(0, stats.getUnique());
    }

    @Test
    public void testWordCount() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "this is a TEST-string.";
        WordStats stats = countService.countWords(input, false);

        assertEquals(4, stats.getTotal());
        assertEquals(4, stats.getUnique());
    }

    @Test
    public void testUniqueWords() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "unique words count words count";
        WordStats stats = countService.countWords(input, false);

        assertEquals(5, stats.getTotal());
        assertEquals(3, stats.getUnique());
    }

    @Test
    public void testWordCountWithStopWords() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of("the", "a", "on", "off")));

        String input = "testing test with a stop words 123 on test";
        WordStats stats = countService.countWords(input, false);

        assertEquals(6, stats.getTotal());
        assertEquals(5, stats.getUnique());
    }

    @Test
    public void testAverageWordLength() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "abc abc efgh efgh";
        WordStats stats = countService.countWords(input, false);

        assertEquals(3.5, stats.getAverage());
    }

    @Test
    public void testCreateIndex() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "ccc Aaa bbb";
        WordStats stats = countService.countWords(input, true);

        assertEquals(List.of("Aaa", "bbb", "ccc"), stats.getIndex());
    }
}
