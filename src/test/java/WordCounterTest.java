import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {

    WordCounter wc = new WordCounter();

    @Test
    public void testEmptyString(String count) {
        Assertions.assertEquals(wc.countWords(""), 0);
    }


}
