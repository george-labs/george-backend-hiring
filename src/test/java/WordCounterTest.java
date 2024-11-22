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

    @Test
    void countWords_withIllegalCharacter() {
        String helloWorld = "Hello World! 123 !";
        int result = wordCounter.countWords(helloWorld);
        Assertions.assertEquals(1, result);
    }

    @Test
    void countWords_null(){
        Assertions.assertThrows(NullPointerException.class, () -> wordCounter.countWords(null));
    }

}