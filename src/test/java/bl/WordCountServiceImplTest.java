package bl;

import bl.model.WordCount;
import bl.providers.StopWordsMockProvider;
import bl.services.WordCountService;
import bl.services.WordCountServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordCountServiceImplTest {

    @Test
    public void testNullInput() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of()));
        WordCount count = countService.countWords(null);

        assertEquals(0, count.getTotal());
        assertEquals(0, count.getUnique());
    }

    @Test
    public void testWordCount() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "this is a TEST-string.";
        WordCount count = countService.countWords(input);

        assertEquals(4, count.getTotal());
        assertEquals(4, count.getUnique());
    }

    @Test
    public void testUniqueWords() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of()));

        String input = "unique words count words count";
        WordCount count = countService.countWords(input);

        assertEquals(5, count.getTotal());
        assertEquals(3, count.getUnique());
    }

    @Test
    public void testWordCountWithStopWords() {
        WordCountService countService = new WordCountServiceImpl(new StopWordsMockProvider(Set.of("the", "a", "on", "off")));

        String input = "testing test with a stop words 123 on test";
        WordCount count = countService.countWords(input);

        assertEquals(6, count.getTotal());
        assertEquals(5, count.getUnique());
    }
}
