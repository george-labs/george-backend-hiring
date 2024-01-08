import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class WordCounterTest {

    @Test
    public void testBasic() {
        String input = "Mary had a little lamb";

        long result = new WordCounter().count(input);

        Assertions.assertEquals(4, result);
    }


    @Test
    public void testNumberNotAWord() {
        String input = "Mary had a 5 lambs";

        long result = new WordCounter().count(input);

        Assertions.assertEquals(result, 3);
    }

    @Test
    public void testNoWords() {
        String input = "";

        long result = new WordCounter().count(input);

        Assertions.assertEquals(result, 0);
    }

    @Test
    public void testWordsWithNumbersIgnored() {
        String input = "M4ry h4s five lambs";

        long result = new WordCounter().count(input);

        Assertions.assertEquals(result, 2);
    }


    @Test
    public void testStopWordsAreIgnored() {
        String input = "random the text something a on off";

        long result = new WordCounter().count(input);

        Assertions.assertEquals(result, 3);
    }
}
