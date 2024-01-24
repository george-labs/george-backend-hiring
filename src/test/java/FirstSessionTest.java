import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class FirstSessionTest {
    @Test
    public void wordCounter(){

        String[] words = {"word"};
        Assertions.assertEquals(1, WordCounterUtility.wordCounter(words));

        String[] word2 = {"word", "word"};
        Assertions.assertEquals(2, WordCounterUtility.wordCounter(word2));

        String[] word0 = {"word."};
        Assertions.assertEquals(0, WordCounterUtility.wordCounter(word0));

    }

    @Test
    public void wordSplitter(){
        String[] word2 = {"word", "word"};
        Assertions.assertEquals(0, Arrays.compare(word2, WordCounterUtility.senteceSplitter("word word", " ")));

        String[] word = {"word", "word."};
        Assertions.assertEquals(1, Arrays.compare(word, WordCounterUtility.senteceSplitter("word word", " ")));
    }
}
