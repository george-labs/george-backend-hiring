import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountingWordsTest {

    @Test
    public void countingWords(){

        Words words = new Words();

        assertEquals(0, words.countingWordsOnlyLetter("test"));

    }
}
