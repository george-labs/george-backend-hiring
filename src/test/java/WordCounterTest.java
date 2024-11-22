import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordCounterTest {

    WordCounter wordCounter = new WordCounter();

    @Test
    void countWords() {
        String helloWorld = "Hello World";
        int result = wordCounter.countWords(helloWorld);
        Assertions.assertEquals(2, result);


    }
}