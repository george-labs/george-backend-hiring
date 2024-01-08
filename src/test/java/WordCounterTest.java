import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {

    @Test
    public void  testBasic(){
        String input = "Mary had a little lamb";

        WordCounter wordCounter = new WordCounter(input);
        long result = wordCounter.get();

        Assertions.assertEquals(5, result);
    }


    @Test
    public void  testNumberNotAWord(){
        String input = "Mary had a 5 lambs";

        WordCounter wordCounter = new WordCounter(input);
        long result = wordCounter.get();

        Assertions.assertEquals(result, 4);
    }

    @Test
    public void  testNoWords(){
        String input = "";

        WordCounter wordCounter = new WordCounter(input);
        long result = wordCounter.get();

        Assertions.assertEquals(result, 0);
    }

    @Test
    public void  testWordsWithNumbersIgnored(){
        String input = "M4ry h4s five lambs";

        WordCounter wordCounter = new WordCounter(input);
        long result = wordCounter.get();

        Assertions.assertEquals(result, 2);
    }
}
