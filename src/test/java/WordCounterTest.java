import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    void testWordCount(){
        var result = new WordCounter().countWords("Mary had a little lamb");
        Assertions.assertEquals(5, result);
    }

    @Test
    void testREmptyString(){
        var result = new WordCounter().countWords("");
        Assertions.assertEquals(0, result);
    }
}