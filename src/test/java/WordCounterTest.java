import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {

    @Test
    public void getCountOfWords_emptyInput () {
        String emptyInput = "";

        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(emptyInput);

        Assertions.assertEquals(0, result);
    }
}
