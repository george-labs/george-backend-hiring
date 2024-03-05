package bl;

import bl.model.WordStats;
import bl.providers.StopWordsMockProvider;
import bl.services.WordStatsService;
import bl.services.WordStatsServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordStatsServiceImplTest {

    @Test
    public void testNullInput() {
        WordStatsService countService = new WordStatsServiceImpl(new StopWordsMockProvider(Set.of()));
        WordStats stats = countService.countWords(null, false);

        assertEquals(0, stats.getTotal());
        assertEquals(0, stats.getUnique());
    }

    @Test
    public void testWordCount() {
        WordStatsService countService = new WordStatsServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "this is a TEST-string.";
        WordStats stats = countService.countWords(input, false);

        assertEquals(4, stats.getTotal());
        assertEquals(4, stats.getUnique());
    }

    @Test
    public void testWordCountForEmptyList() {
        WordStatsService countService = new WordStatsServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "123";
        WordStats stats = countService.countWords(input, true);

        assertEquals(0, stats.getTotal());
        assertEquals(0, stats.getUnique());
        assertEquals(0.0, stats.getAverage());
        assertTrue(stats.getIndex().isEmpty());
    }

    @Test
    public void testUniqueWords() {
        WordStatsService countService = new WordStatsServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "unique words count words count";
        WordStats stats = countService.countWords(input, false);

        assertEquals(5, stats.getTotal());
        assertEquals(3, stats.getUnique());
    }

    @Test
    public void testWordCountWithStopWords() {
        WordStatsService countService = new WordStatsServiceImpl(new StopWordsMockProvider(Set.of("the", "a", "on", "off")));

        String input = "testing test with a stop words 123 on test";
        WordStats stats = countService.countWords(input, false);

        assertEquals(6, stats.getTotal());
        assertEquals(5, stats.getUnique());
    }

    @Test
    public void testAverageWordLength() {
        WordStatsService countService = new WordStatsServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "abc abc efgh efgh";
        WordStats stats = countService.countWords(input, false);

        assertEquals(3.5, stats.getAverage());
    }

    @Test
    public void testCreateIndex() {
        WordStatsService countService = new WordStatsServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "ccc Aaa bbb";
        WordStats stats = countService.countWords(input, true);

        assertEquals(List.of("Aaa", "bbb", "ccc"), stats.getIndex());
    }
}
