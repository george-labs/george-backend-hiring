import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {

    @Test
    public void  testBasic(){
        String input = "Mary had a little lamb";

        long result = new WordCounter(input).get();

        Assertions.assertEquals(5, result);
    }


    @Test
    public void  testNumberNotAWord(){
        String input = "Mary had a 5 lambs";

        long result = new WordCounter(input).get();

        Assertions.assertEquals(result, 4);
    }

    @Test
    public void  testNoWords(){
        String input = "";

        long result = new WordCounter(input).get();

        Assertions.assertEquals(result, 0);
    }

    @Test
    public void  testWordsWithNumbersIgnored(){
        String input = "M4ry h4s five lambs";

        long result = new WordCounter(input).get();

        Assertions.assertEquals(result, 2);
    }
}
