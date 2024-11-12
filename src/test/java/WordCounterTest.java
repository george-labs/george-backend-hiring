import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.WordCounterService;

public class WordCounterTest {

    @Test
    public void shouldNotCountsWordWithSpecialCharacterTest() {

        String testText = "This is my first iteration test.";
        int count = WordCounterService.wordCounter(testText);
        Assertions.assertEquals(5, count);
    }

    @Test
    public void shouldNotCountWordsWithNumbersTest() {
        String testText = "This is my 1st iteration test";
        int count = WordCounterService.wordCounter(testText);
        Assertions.assertEquals(5, count);
    }


}
