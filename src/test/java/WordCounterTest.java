import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.WordCounterService;

public class WordCounterTest {

    @Test
    public void shouldCountWordsTest() {
        String testText = "This is my first iteration test.";
        int count = WordCounterService.wordCounter(testText);
        Assertions.assertEquals(6, count);
    }
}
